package ru.spbstu.jdb.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.MakeMapper;
import ru.spbstu.jdb.model.entities.Make;

@Repository
public class MakeDao extends NamedParameterJdbcDaoSupport {

    Map<String, Make> _makes = new HashMap<String, Make>();

    @Autowired
    private MakeMapper _mapper;

    @PostConstruct
    void init() {
        for (Make make : findAllMakes()) {
            _makes.put(make.getMake(), make);
        }
    }

    public List<Make> findAllMakes() {
        return getJdbcTemplate().query("select * from Makes", _mapper);
    }

    public Map<String, Make> getMakes() {
        return _makes;
    }

}
