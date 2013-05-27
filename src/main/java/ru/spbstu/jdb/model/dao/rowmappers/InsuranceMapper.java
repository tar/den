package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Insurance;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class InsuranceMapper implements RowMapper<Insurance> {

    @Override
    public Insurance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Insurance ins = new Insurance();
        ins.setInsNum(rs.getString("Insurance_number"));
        ins.setInsType(rs.getString("Insurance_Type"));
        ins.setInsCom(rs.getString("Insurance_company"));
        return ins;
    }

}
