package ru.spbstu.jdb.model.entities;

import java.util.Date;

/**
 * Entity class for clients table. Describes one row
 * 
 * @author Den
 * 
 */
public class Client {
	private int _id;
	private String _email;
	private String _lastName;
	private String _firstName;
	private String _patronymic;
	private String _address;
	private String _pase;
	private String _phone;
	private Date _birthday;

	public Client() {
	}

	public Client(int id, String lastName, String firstName, String patronymic, String address, String pase,
			String phone, Date birthday, String email) {
		_id = id;
		_lastName = lastName;
		_firstName = firstName;
		_pase = pase;
		_patronymic = patronymic;
		_phone = phone;
		_birthday = birthday;
		_email = email;
		_address = address;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getPatronymic() {
		return _patronymic;
	}

	public void setPatronymic(String patronymic) {
		_patronymic = patronymic;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPase() {
		return _pase;
	}

	public void setPase(String pase) {
		_pase = pase;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

}
