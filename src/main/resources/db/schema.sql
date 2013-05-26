CONNECT '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
COMMIT;

DROP DATABASE '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
COMMIT;

CREATE DATABASE '/var/lib/firebird/2.1/data/Auto.fdb' user 'SYSDBA' password 'firebird';
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

    PRIMARY KEY (Client_Id),
    UNIQUE (Passport_number),
    UNIQUE (Telephone),
    UNIQUE (Email)
);
COMMIT;

CREATE TABLE Sellers
(
    Seller_Id int,    
    Last_name varchar (50),
    First_name varchar (50),
    Patronymic varchar (50),
    Birthdate date,
    Passport_number char (11),
    Address varchar (255),
    Telephone char (12),
    Email varchar (255),

    PRIMARY KEY (Seller_Id),
    UNIQUE (Passport_number),
    UNIQUE (Telephone),
    UNIQUE (Email)
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
    FOREIGN KEY (Seller_Id) REFERENCES Sellers (Seller_Id),
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
    FOREIGN KEY (Seller_Id) REFERENCES Sellers (Seller_Id),
    FOREIGN KEY (Client_Id) REFERENCES Clients (Client_Id),
    FOREIGN KEY (Insurance_number) REFERENCES Insurances (Insurance_number)
);
COMMIT;