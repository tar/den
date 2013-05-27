package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Car;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setVin(rs.getString("VIN"));
        car.setPackaging(rs.getString("Packaging"));
        car.setCondition(rs.getString("Condition"));
        car.setColour(rs.getString("Colour"));
        car.setInteriorColor(rs.getString("Interior_color"));
        car.setOperationalKilometers(rs.getInt("Operational_kilometers"));
        car.setOwners(rs.getInt("Owners"));
        car.setPhoto(rs.getBytes("Photo"));
        return car;
    }

}
