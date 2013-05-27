package ru.spbstu.jdb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.ModelMapper;
import ru.spbstu.jdb.model.entities.Model;

@Repository
public class ModelDao extends NamedParameterJdbcDaoSupport {

    @Autowired
    private ModelMapper _mapper;

    public List<Model> findAllModels() {
        return getJdbcTemplate().query("select * from Models", _mapper);
    }

}
