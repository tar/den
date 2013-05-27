package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.InsurSale;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class InsurSaleMapper implements RowMapper<InsurSale> {

    @Override
    public InsurSale mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsurSale ins = new InsurSale();
        ins.setContract(rs.getInt("Contract_number"));
        ins.setDate(rs.getDate("Date_contr"));
        ins.setSellerId(rs.getInt("Seller_Id"));
        ins.setClientId(rs.getInt("Client_Id"));
        ins.setVin(rs.getString("VIN"));
        ins.setInsurNumber(rs.getString("Insurance_number"));
        ins.setStart(rs.getDate("Start_ins"));
        ins.setEnd(rs.getDate("Stop_ins"));
        ins.setPrice(rs.getInt("Price"));
        return ins;
    }

}
