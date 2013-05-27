CONNECT '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
COMMIT;

DROP DATABASE '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
COMMIT;

CREATE DATABASE '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird' DEFAULT CHARACTER SET UTF8;
COMMIT;

CONNECT '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
COMMIT;

CREATE TABLE Makes
(
    Make varchar (20),
    Country varchar (50),

    PRIMARY KEY (Make)
);
COMMIT;

CREATE TABLE Models
(
    Model varchar (30),
    Make varchar (20),	

    PRIMARY KEY (Model),
    FOREIGN KEY (Make) REFERENCES Makes (Make)
);
COMMIT;

CREATE TABLE Packagings
(
    Packaging varchar (50),
    Model varchar (30),
    Engine_volume int,
    Engine_power int,
    Engine_type varchar (30),
    Body_type varchar (20),
    Wheel_drive varchar (10),
    Transmission varchar (20),
    AntiBS char(1),
    ASR char(1),
    On_board_computer char(1),
    Rain_sensor char(1),
    Light_sensor char(1),
    Air_conditioning_unit varchar (30),
    Cruise_control char(1),
    Xenon_headlamps char(1),
    Alloy_wheels char(1),
    Sunroof char(1),
    Multimedia varchar (20),
    Heated_mirrors char(1),
    Heated_seats char(1),
    Headlight_washer char(1),
    Security_system char(1),
    Parktronic char(1),
    Interior varchar (20),
    Power_steering varchar (10),
    Central_lock char(1),
    Power_windows varchar (10),

    PRIMARY KEY (Packaging),
    FOREIGN KEY (Model) REFERENCES Models (Model)
);
COMMIT;

CREATE TABLE Cars
(
    VIN char (17),    
    Packaging varchar (50),
    Production_year int,
    Operational_kilometers int,
    Condition varchar (20),
    Owners int,
    Colour varchar (30),
    Interior_color varchar (20),
    Photo blob,

    PRIMARY KEY (VIN),
    FOREIGN KEY (Packaging) REFERENCES Packagings (Packaging)
);
COMMIT;

CREATE TABLE Clients 
(
    Client_Id int,    
    Last_name varchar (50),
    First_name varchar (50),
    Patronymic varchar (50),
    Birthdate date,
    Passport_number char (11),
    Address varchar (255),
    Telephone char (12),
    Email varchar (255),
    Seller int,

    PRIMARY KEY (Client_Id)
);
COMMIT;


CREATE TABLE Insurances
(
    Insurance_number varchar (50),
    Insurance_type varchar (50),
    Insurance_company varchar (255),

    PRIMARY KEY (Insurance_number)
);

CREATE TABLE Car_sales
(
    Contract_number int,
    Date_contr timestamp,
    Seller_Id int,
    Client_Id int,
    VIN char (17),
    Price int,
    
    PRIMARY KEY (Contract_number),
    FOREIGN KEY (VIN) REFERENCES Cars (VIN),
    FOREIGN KEY (Seller_Id) REFERENCES Clients (Client_Id),
    FOREIGN KEY (Client_Id) REFERENCES Clients (Client_Id)
);
COMMIT;

CREATE TABLE Insurance_sales
(
    Contract_number int,
    Date_contr timestamp,
    Seller_Id int,
    Client_Id int,
    VIN char (17),
    Insurance_number varchar (50),
    Start_ins date,
    Stop_ins date,
    Price int,
    
    PRIMARY KEY (Contract_number),
    UNIQUE (Insurance_number),
    FOREIGN KEY (VIN) REFERENCES Cars (VIN),
    FOREIGN KEY (Seller_Id) REFERENCES Clients (Client_Id),
    FOREIGN KEY (Client_Id) REFERENCES Clients (Client_Id),
    FOREIGN KEY (Insurance_number) REFERENCES Insurances (Insurance_number)
);
COMMIT;

CREATE VIEW FIND_CARS(
    VIN,
    MODEL)
AS
SELECT vin, model FROM cars, packagings WHERE
(cars.packaging = packagings.packaging) AND ((SELECT COUNT(contract_number)
FROM car_sales WHERE car_sales.vin = cars.vin) > 1  ) AND (model = 'PAJERO')
;
commit;

CREATE VIEW FIND_CLIENTS(
    CLIENT_ID,
    LAST_NAME,
    FIRST_NAME,
    C_CONTRACT_NUMBER)
AS
SELECT FIRST 5 client_id, last_name, first_name, COUNT(contract_number)
FROM clients, car_sales WHERE clients.client_id = car_sales.client_id
GROUP BY client_id, last_name, first_name ORDER BY COUNT(contract_number) DESC, client_id
;
commit;

SET TERM ^ ;
CREATE OR ALTER procedure DEL_CARS
as
BEGIN
    DELETE FROM car_sales WHERE car_sales.vin NOT IN
    (SELECT insurance_sales.vin FROM insurance_sales);
END^
SET TERM ; ^
commit;

SET TERM ^ ;
CREATE OR ALTER procedure COUNT_CAR
returns (
    OUT_VIN char(17),
    AVG_PRICE integer,
    OUT_COUNT integer,
    OUT_MIN_PRICE integer,
    OUT_MAX_PRICE integer)
as
BEGIN
FOR SELECT car_sales.vin,  COUNT (car_sales.vin),
MIN (car_sales.price), MAX (car_sales.price)
FROM car_sales
GROUP BY vin ORDER BY vin
INTO :out_vin, :out_count, :out_MIN_price, :out_MAX_price do
begin
avg_price=(out_max_price-out_min_price)/out_count;
SUSPEND;
end
END^
SET TERM ; ^
commit;

CREATE GENERATOR gen_contract_number;
SET generator gen_contract_number TO 200;

SET TERM ^ ;
CREATE OR ALTER TRIGGER INSERT_CAR_SALES FOR CAR_SALES
ACTIVE BEFORE INSERT POSITION 0
AS
BEGIN
    NEW.contract_number = GEN_ID(gen_contract_number, 1);
END
^
SET TERM ; ^
commit;

SET TERM ^ ;
CREATE OR ALTER TRIGGER DELETE_CAR FOR CARS
ACTIVE AFTER DELETE POSITION 0
AS
BEGIN
    DELETE FROM car_sales WHERE (car_sales.vin = OLD.vin);
END
^
SET TERM ; ^
commit;

CREATE EXCEPTION 
FIRST_EXCEPTION 'Отсутствует страховка! Добавление машины невозможно.';
commit;

SET TERM ^ ;
CREATE OR ALTER TRIGGER INSERT_CAR FOR CAR_SALES
ACTIVE BEFORE INSERT POSITION 0
AS
declare variable c_contract integer;
BEGIN
    SELECT count(insurance_sales.contract_number)
    from  car_sales, insurance_sales
    where new.seller_id = insurance_sales.seller_id
    and new.vin=insurance_sales.vin into :c_contract;

    if (c_contract=0)
    then
    exception first_exception;
END
^
SET TERM ; ^
commit;

SET TERM ^ ;
CREATE OR ALTER TRIGGER DELETE_INSURANCE FOR INSURANCE_SALES
ACTIVE BEFORE INSERT POSITION 0
AS
declare variable c_contract integer;
BEGIN
    SELECT count(insurance_sales.contract_number)
    from  insurance_sales  where insurance_sales.vin=NEW.vin
    into :c_contract;

    if (c_contract>0)
    then
    DELETE FROM insurance_sales WHERE insurance_sales.vin=NEW.vin;
END
^
SET TERM ; ^
COMMIT;
