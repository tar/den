package ru.spbstu.jdb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.spbstu.jdb.model.dao.ClientDao;
import ru.spbstu.jdb.model.dao.SaleDao;
import ru.spbstu.jdb.model.entities.Sale;

@Controller
@RequestMapping(value = "/sales")
public class SalesController {

	@Autowired
	SaleDao _salesDao;
	@Autowired
	ClientDao _clientDao;

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView getSales() {
		ModelAndView mav = new ModelAndView("sales");
		mav.addObject("sales", _salesDao.findAllSales());
		mav.addObject("clients", _clientDao.findAllClients());
		mav.addObject("sellers", _clientDao.findAllSellers());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	String addClient(@RequestParam(value = "clientId") int clientId, @RequestParam(value = "sellerId") int sellerId,
			@RequestParam(value = "vin") String vin, @RequestParam(value = "price") int price) {
		Sale sale = new Sale(clientId, sellerId, price, vin);
		_salesDao.addSale(sale);
		return "redirect:/sales";
	}
}
