package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Model;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class ModelMapper implements RowMapper<Model> {

    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
        Model model = new Model();
        model.setMake(rs.getString("Make"));
        model.setModel(rs.getString("Mpdel"));
        return model;
    }

}
