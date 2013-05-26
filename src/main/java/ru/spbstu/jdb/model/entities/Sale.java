package ru.spbstu.jdb.model.entities;

import java.util.Date;

/**
 * Entity class for car_salestable. Describes one row
 * 
 * @author Den
 * 
 */

public class Sale {
	private int _id;
	private int _clientId;
	private int _sellerId;
	private int _price;
	private String _vin;
	private Date _date;

	public Sale() {
	}
	
	public Sale(int clId, int selId, int price, String vin) {
		_clientId=clId;
		_sellerId=selId;
		_price=price;
		_vin=vin;
		_date = new Date();
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public int getClientId() {
		return _clientId;
	}

	public void setClientId(int clientId) {
		this._clientId = clientId;
	}

	public int getSellerId() {
		return _sellerId;
	}

	public void setSellerId(int sellerId) {
		this._sellerId = sellerId;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		this._price = price;
	}

	public String getVin() {
		return _vin;
	}

	public void setVin(String vin) {
		this._vin = vin;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		this._date = date;
	}

}
