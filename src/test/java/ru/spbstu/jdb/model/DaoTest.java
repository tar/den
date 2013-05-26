package ru.spbstu.jdb.model;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.spbstu.jdb.model.dao.ClientDao;
import ru.spbstu.jdb.model.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
@Transactional
public class DaoTest {

	@Autowired
	ClientDao _clientDao;

	@Test
	public void testClientDao() {
		List<Client> clients = _clientDao.findAllClients();
		System.out.println("clients in db = " + clients.size());
		_clientDao.addClient(new Client("test", "test", "testovich", "test", "test", "test", new Date(), "test", false));
		clients = _clientDao.findAllClients();
		System.out.println("clients in db = " + clients.size());
		for (Client client : clients) {
			System.out.println(client.getEmail());
		}
		_clientDao.removeClientById(1);
		clients = _clientDao.findAllClients();
		System.out.println("clients in db = " + clients.size());		
	}

}
