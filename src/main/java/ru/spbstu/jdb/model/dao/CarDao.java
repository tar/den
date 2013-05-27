package ru.spbstu.jdb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.CarMapper;
import ru.spbstu.jdb.model.entities.Car;

@Repository
public class CarDao extends NamedParameterJdbcDaoSupport {

    @Autowired
    private CarMapper _mapper;

    public List<Car> findAllCars() {
        return getJdbcTemplate().query("select * from Cars", _mapper);
    }

}
