package ru.spbstu.jdb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ru.spbstu.jdb.model.dao.ClientDao;
import ru.spbstu.jdb.model.entities.Client;

@Controller
@RequestMapping(value = "/sellers")
public class SellersController {

	@Autowired
	ClientDao _clientDao;

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView getSellers() {
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", _clientDao.findAllSellers());
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	void deleteClient(@PathVariable("id") int id) {
		_clientDao.removeClientById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	String addClient(@RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address, @RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "patronymic") String patronymic,
			@RequestParam(value = "phone") String phone, @RequestParam(value = "passport") String pase) {
		Client client = new Client(lastName, firstName, patronymic, address, pase, phone, null, email, true);
		_clientDao.addClient(client);
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", _clientDao.findAllSellers());
		return "redirect:/sellers";
	}
}
