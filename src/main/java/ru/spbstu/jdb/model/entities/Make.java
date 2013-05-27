package ru.spbstu.jdb.model.entities;

public class Make {
    String _make;
    String _country;

    public Make() {
    }

    public Make(String brand, String country) {
        _make = brand;
        _country = country;
    }

    public String getMake() {
        return _make;
    }

    public void setMake(String make) {
        _make = make;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

}
