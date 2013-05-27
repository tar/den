package ru.spbstu.jdb.model.entities;

public class Car {
    String _vin;
    String _packaging;
    String _condition;
    String _colour;
    String _interiorColor;
    int _productionYear;
    int _operationalKilometers;
    int _owners;
    byte[] _photo;
    
    public Car(){
    }
    
    public Car(String vin, String packaging, int productionYear, int operationalKilometers, String condition,
            int owners, String colour, String interiorColor, byte[] photo) {
        super();
        _vin = vin;
        _packaging = packaging;
        _productionYear = productionYear;
        _operationalKilometers = operationalKilometers;
        _condition = condition;
        _owners = owners;
        _colour = colour;
        _interiorColor = interiorColor;
        _photo = photo;
    }

    public String getVin() {
        return _vin;
    }

    public void setVin(String vin) {
        _vin = vin;
    }

    public String getPackaging() {
        return _packaging;
    }

    public void setPackaging(String packaging) {
        _packaging = packaging;
    }

    public int getProductionYear() {
        return _productionYear;
    }

    public void setProductionYear(int productionYear) {
        _productionYear = productionYear;
    }

    public int getOperationalKilometers() {
        return _operationalKilometers;
    }

    public void setOperationalKilometers(int operationalKilometers) {
        _operationalKilometers = operationalKilometers;
    }

    public String getCondition() {
        return _condition;
    }

    public void setCondition(String condition) {
        _condition = condition;
    }

    public int getOwners() {
        return _owners;
    }

    public void setOwners(int owners) {
        _owners = owners;
    }

    public String getColour() {
        return _colour;
    }

    public void setColour(String colour) {
        _colour = colour;
    }

    public String getInteriorColor() {
        return _interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        _interiorColor = interiorColor;
    }

    public byte[] getPhoto() {
        return _photo;
    }

    public void setPhoto(byte[] photo) {
        _photo = photo;
    }

}
