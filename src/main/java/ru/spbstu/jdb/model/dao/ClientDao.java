package ru.spbstu.jdb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ru.spbstu.jdb.model.dao.rowmappers.ClientMapper;
import ru.spbstu.jdb.model.dao.util.IdGenerator;
import ru.spbstu.jdb.model.entities.Client;

@Repository
public class ClientDao extends NamedParameterJdbcDaoSupport {
	
	
	private static final IdGenerator _idGen=new IdGenerator(100, 1);
	
	@Autowired
	private ClientMapper _clientMapper;

	public List<Client> findAllClients() {
		return getJdbcTemplate().query("select * from Clients where seller=0", _clientMapper);
	}

	public int addClient(Client cl) {
		return getJdbcTemplate().update(
				"insert into Clients " + "(Client_Id, Last_name, First_name, Patronymic, Birthdate, "
						+ "Passport_number, Address, Telephone, Email, seller) values (?,?,?,?,?,?,?,?,?,?)",
				_idGen.getNextId(), cl.getLastName(), cl.getFirstName(), cl.getPatronymic(), cl.getBirthday(), cl.getPase(),
				cl.getAddress(), cl.getPhone(), cl.getEmail(), cl.isSeller() ? 1 : 0);
	}

	public void removeClientById(int id) {
		getJdbcTemplate().update("delete from Clients where Client_Id=?", id);
	}

	public List<Client> findAllSellers() {
		return getJdbcTemplate().query("select * from Clients where seller=1", _clientMapper);
	}

}
