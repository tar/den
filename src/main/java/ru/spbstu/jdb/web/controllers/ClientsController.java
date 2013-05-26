package ru.spbstu.jdb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.spbstu.jdb.model.dao.ClientDao;
import ru.spbstu.jdb.model.entities.Client;

@Controller
@RequestMapping(value = "/clients")
public class ClientsController {

	@Autowired
	ClientDao _clientDao;

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", _clientDao.findAll());
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	ModelAndView deleteClient(@PathVariable("id") int id) {
		_clientDao.removeClientById(id);
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", _clientDao.findAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	ModelAndView addClient(@RequestParam(value = "id") int id, @RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address, @RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "patronymic") String patronymic,
			@RequestParam(value = "phone") String phone, @RequestParam(value = "passport") String pase) {
		Client client = new Client(id, lastName, firstName, patronymic, address, pase, phone, null, email);
		_clientDao.addClient(client);
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", _clientDao.findAll());
		return mav;
	}
}
