package ru.spbstu.jdb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.InsuranceMapper;
import ru.spbstu.jdb.model.entities.Insurance;

@Repository
public class InsuranceDao extends NamedParameterJdbcDaoSupport {

    @Autowired
    private InsuranceMapper _mapper;

    public List<Insurance> findAllInsurances() {
        return getJdbcTemplate().query("select * from Car_Sales order by Date_contr desc", _mapper);
    }

    public int addSale(Insurance ins) {
        return getJdbcTemplate().update(
                "insert intoInsurance (Insurance_number, Insurance_type, Insurance_company) values (?,?,?)",
                ins.getInsNum(), ins.getInsType(), ins.getInsCom());
    }

}
