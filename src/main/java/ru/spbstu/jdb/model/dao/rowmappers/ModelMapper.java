package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.dao.MakeDao;
import ru.spbstu.jdb.model.entities.Model;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class ModelMapper implements RowMapper<Model> {

    @Autowired
    private MakeDao _makeDao;

    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
        Model model = new Model();
        model.setMake(rs.getString("Make"));
        model.setModel(rs.getString("Mpdel"));
        model.setMakeEntity(_makeDao.getMakes().get(model.getMake()));
        return model;
    }

}
