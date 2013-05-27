package ru.spbstu.jdb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.SaleMapper;
import ru.spbstu.jdb.model.dao.util.IdGenerator;
import ru.spbstu.jdb.model.entities.Sale;

@Repository
public class InsurSaleDao extends NamedParameterJdbcDaoSupport {

	private static final IdGenerator _idGen = new IdGenerator(100, 1);

	@Autowired
	private SaleMapper _salesMapper;

	public List<Sale> findAllSales() {
		return getJdbcTemplate().query("select * from Car_Sales order by Date_contr desc", _salesMapper);
	}

	public int addSale(Sale sl) {
		return getJdbcTemplate().update(
				"insert into Car_Sales (Contract_number, Client_Id, Seller_Id, VIN, Date_contr, Price",
				_idGen.getNextId(), sl.getClientId(), sl.getSellerId(), sl.getVin(), sl.getDate(), sl.getPrice());
	}

}
