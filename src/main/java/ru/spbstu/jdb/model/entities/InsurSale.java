package ru.spbstu.jdb.model.entities;

import java.util.Date;

public class InsurSale {
    int _contract;
    int _sellerId;
    int _clientId;
    int _price;
    String _vin;
    String _insurNumber;
    Date _date;
    Date _start;
    Date _end;
    
    public InsurSale(){
    }
    
    public InsurSale(int contract, int sellerId, int clientId, int price, String vin, String insurNumber, Date date,
            Date start, Date end) {
        super();
        _contract = contract;
        _sellerId = sellerId;
        _clientId = clientId;
        _price = price;
        _vin = vin;
        _insurNumber = insurNumber;
        _date = date;
        _start = start;
        _end = end;
    }

    public int getContract() {
        return _contract;
    }

    public void setContract(int contract) {
        _contract = contract;
    }

    public int getSellerId() {
        return _sellerId;
    }

    public void setSellerId(int sellerId) {
        _sellerId = sellerId;
    }

    public int getClientId() {
        return _clientId;
    }

    public void setClientId(int clientId) {
        _clientId = clientId;
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice(int price) {
        _price = price;
    }

    public String getVin() {
        return _vin;
    }

    public void setVin(String vin) {
        _vin = vin;
    }

    public String getInsurNumber() {
        return _insurNumber;
    }

    public void setInsurNumber(String insurNumber) {
        _insurNumber = insurNumber;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }

    public Date getStart() {
        return _start;
    }

    public void setStart(Date start) {
        _start = start;
    }

    public Date getEnd() {
        return _end;
    }

    public void setEnd(Date end) {
        _end = end;
    }

}
