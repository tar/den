package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Make;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class MakeMapper implements RowMapper<Make> {

    @Override
    public Make mapRow(ResultSet rs, int rowNum) throws SQLException {
        Make make = new Make();
        make.setCountry(rs.getString("Country"));
        make.setMake(rs.getString("Make"));
        return make;
    }

}
