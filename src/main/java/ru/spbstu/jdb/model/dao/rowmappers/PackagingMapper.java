package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Packaging;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class PackagingMapper implements RowMapper<Packaging> {

    @Override
    public Packaging mapRow(ResultSet rs, int rowNum) throws SQLException {
        Packaging pack = new Packaging();

        pack.setPackaging(rs.getString("Packaging"));
        pack.setModel(rs.getString("Model"));
        pack.setEngineVolume(rs.getInt("Engine_volume"));
        pack.setEngineType(rs.getString("Engine_type"));
        pack.setEnginePower(rs.getInt("Engine_power"));
        pack.setBodyType(rs.getString("Body_type"));
        pack.setWheelDrive(rs.getString("Wheel_drive"));
        pack.setTransmission("Transmission");
        pack.setAbs(rs.getBoolean("AntiBS"));
        pack.setAsr(rs.getBoolean("ASR"));
        pack.setBortComp(rs.getBoolean("On_board_computer"));
        pack.setRainSensor(rs.getBoolean("Rain_sensor"));
        pack.setLightSensor(rs.getBoolean("Light_sensor"));
        pack.setAir_conditioning_unit(rs.getString("Air_conditioning_unit"));
        pack.setCruiseControl(rs.getBoolean("Cruise_control"));
        pack.setXenonHeadlamps(rs.getBoolean("Xenon_headlamps"));
        pack.setAlloyWheels(rs.getBoolean("Alloy_wheels"));
        pack.setSunroof(rs.getBoolean("Sunroof"));
        pack.setMultimedia(rs.getString("Multimedia"));
        pack.setHeatedMirrors(rs.getBoolean("Heated_mirrors"));
        pack.setHeatedSeats(rs.getBoolean("Heated_seats"));
        pack.setHeadlightWasher(rs.getBoolean("Headlight_washer"));
        pack.setSecuritySystem(rs.getBoolean("Security_system"));
        pack.setParktronic(rs.getBoolean("Parktronic"));
        pack.setInterior(rs.getString("Interior"));
        pack.setPowerSteering(rs.getString("Power_steering"));
        pack.setCentralLock(rs.getBoolean("Central_lock"));
        pack.setPowerWindows(rs.getString("Power_windows"));
        return pack;
    }

}
