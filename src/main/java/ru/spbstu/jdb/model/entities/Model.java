package ru.spbstu.jdb.model.entities;

public class Model {
    String _model;
    String _make;
    Make _makeEntity;

    public Model() {
    }

    public Model(String model, String brand) {
        _model = model;
        _make = brand;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        _model = model;
    }

    public String getMake() {
        return _make;
    }

    public void setMake(String make) {
        _make = make;
    }

    public void setMakeEntity(Make make) {
        _makeEntity=make;
    }
    public Make getMakeEntity() {
        return _makeEntity;
    }

}
