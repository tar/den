package ru.spbstu.jdb.model.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.spbstu.jdb.model.entities.Client;

/**
 * This class provides mapping result row to one entity instance
 * @author Den
 *
 */
@Component
public class ClientMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("Client_Id"));
		client.setEmail(rs.getString("Email"));
		client.setAddress(rs.getString("Address"));
		client.setLastName(rs.getString("Last_Name"));
		client.setFirstName(rs.getString("First_Name"));
		client.setPatronymic(rs.getString("Patronymic"));
		client.setBirthday(rs.getDate("Birthdate"));
		client.setPase(rs.getString("Passport_number"));
		client.setPhone(rs.getString("Telephone"));
		return client;
	}

}
