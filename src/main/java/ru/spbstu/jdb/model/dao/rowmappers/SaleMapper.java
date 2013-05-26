package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Sale;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class SaleMapper implements RowMapper<Sale> {
	
	@Override
	public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sale sale = new Sale();
		sale.setId(rs.getInt("Contract_number"));
		sale.setClientId(rs.getInt("Client_id"));
		sale.setSellerId(rs.getInt("Seller_id"));
		sale.setDate(rs.getDate("Date_contr"));
		sale.setVin(rs.getString("VIN"));
		sale.setPrice(rs.getInt("Price"));
		return sale;
	}

}
