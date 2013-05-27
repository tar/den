package ru.spbstu.jdb.model.entities;

public class Packaging {

    String _packaging;
    String _model;
    String _engineType;
    String _bodyType;
    String _wheelDrive;
    String _transmission;
    String _multimedia;
    String _interior;
    String _powerSteering;
    String _powerWindows;
    int _engineVolume;
    int _enginePower;
    boolean _abs;
    boolean _asr;
    boolean _bortComp;
    boolean _rainSensor;
    boolean _lightSensor;
    String _air_conditioning_unit;
    boolean _cruiseControl;
    boolean _xenonHeadlamps;
    boolean _alloyWheels;
    boolean _sunroof;
    boolean _heatedMirrors;
    boolean _heatedSeats;
    boolean _headlightWasher;
    boolean _securitySystem;
    boolean _parktronic;
    boolean _centralLock;

    public Packaging() {
    }

    public Packaging(String packaging, String model, int engineVolume, int enginePower, String engineType,
            String bodyType, String wheelDrive, String transmission, boolean abs, boolean asr, boolean bortComp,
            boolean rainSensor, boolean lightSensor, String air_conditioning_unit, boolean cruiseControl,
            boolean xenonHeadlamps, boolean alloyWheels, boolean sunroof, String multimedia, boolean heatedMirrors,
            boolean heatedSeats, boolean headlightWasher, boolean securitySystem, boolean parktronic, String interior,
            String powerSteering, boolean centralLock, String powerWindows) {
        super();
        _packaging = packaging;
        _model = model;
        _engineVolume = engineVolume;
        _enginePower = enginePower;
        _engineType = engineType;
        _bodyType = bodyType;
        _wheelDrive = wheelDrive;
        _transmission = transmission;
        _abs = abs;
        _asr = asr;
        _bortComp = bortComp;
        _rainSensor = rainSensor;
        _lightSensor = lightSensor;
        _air_conditioning_unit = air_conditioning_unit;
        _cruiseControl = cruiseControl;
        _xenonHeadlamps = xenonHeadlamps;
        _alloyWheels = alloyWheels;
        _sunroof = sunroof;
        _multimedia = multimedia;
        _heatedMirrors = heatedMirrors;
        _heatedSeats = heatedSeats;
        _headlightWasher = headlightWasher;
        _securitySystem = securitySystem;
        _parktronic = parktronic;
        _interior = interior;
        _powerSteering = powerSteering;
        _centralLock = centralLock;
        _powerWindows = powerWindows;
    }

    public String getPackaging() {
        return _packaging;
    }

    public void setPackaging(String packaging) {
        _packaging = packaging;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        _model = model;
    }

    public int getEngineVolume() {
        return _engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        _engineVolume = engineVolume;
    }

    public int getEnginePower() {
        return _enginePower;
    }

    public void setEnginePower(int enginePower) {
        _enginePower = enginePower;
    }

    public String getEngineType() {
        return _engineType;
    }

    public void setEngineType(String engineType) {
        _engineType = engineType;
    }

    public String getBodyType() {
        return _bodyType;
    }

    public void setBodyType(String bodyType) {
        _bodyType = bodyType;
    }

    public String getWheelDrive() {
        return _wheelDrive;
    }

    public void setWheelDrive(String wheelDrive) {
        _wheelDrive = wheelDrive;
    }

    public String getTransmission() {
        return _transmission;
    }

    public void setTransmission(String transmission) {
        _transmission = transmission;
    }

    public boolean isAbs() {
        return _abs;
    }

    public void setAbs(boolean abs) {
        _abs = abs;
    }

    public boolean isAsr() {
        return _asr;
    }

    public void setAsr(boolean asr) {
        _asr = asr;
    }

    public boolean isBortComp() {
        return _bortComp;
    }

    public void setBortComp(boolean bortComp) {
        _bortComp = bortComp;
    }

    public boolean isRainSensor() {
        return _rainSensor;
    }

    public void setRainSensor(boolean rainSensor) {
        _rainSensor = rainSensor;
    }

    public boolean isLightSensor() {
        return _lightSensor;
    }

    public void setLightSensor(boolean lightSensor) {
        _lightSensor = lightSensor;
    }

    public String isAir_conditioning_unit() {
        return _air_conditioning_unit;
    }

    public void setAir_conditioning_unit(String air_conditioning_unit) {
        _air_conditioning_unit = air_conditioning_unit;
    }

    public boolean isCruiseControl() {
        return _cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        _cruiseControl = cruiseControl;
    }

    public boolean isXenonHeadlamps() {
        return _xenonHeadlamps;
    }

    public void setXenonHeadlamps(boolean xenonHeadlamps) {
        _xenonHeadlamps = xenonHeadlamps;
    }

    public boolean isAlloyWheels() {
        return _alloyWheels;
    }

    public void setAlloyWheels(boolean alloyWheels) {
        _alloyWheels = alloyWheels;
    }

    public boolean isSunroof() {
        return _sunroof;
    }

    public void setSunroof(boolean sunroof) {
        _sunroof = sunroof;
    }

    public String getMultimedia() {
        return _multimedia;
    }

    public void setMultimedia(String multimedia) {
        _multimedia = multimedia;
    }

    public boolean isHeatedMirrors() {
        return _heatedMirrors;
    }

    public void setHeatedMirrors(boolean heatedMirrors) {
        _heatedMirrors = heatedMirrors;
    }

    public boolean isHeatedSeats() {
        return _heatedSeats;
    }

    public void setHeatedSeats(boolean heatedSeats) {
        _heatedSeats = heatedSeats;
    }

    public boolean isHeadlightWasher() {
        return _headlightWasher;
    }

    public void setHeadlightWasher(boolean headlightWasher) {
        _headlightWasher = headlightWasher;
    }

    public boolean isSecuritySystem() {
        return _securitySystem;
    }

    public void setSecuritySystem(boolean securitySystem) {
        _securitySystem = securitySystem;
    }

    public boolean isParktronic() {
        return _parktronic;
    }

    public void setParktronic(boolean parktronic) {
        _parktronic = parktronic;
    }

    public String getInterior() {
        return _interior;
    }

    public void setInterior(String interior) {
        _interior = interior;
    }

    public String getPowerSteering() {
        return _powerSteering;
    }

    public void setPowerSteering(String powerSteering) {
        _powerSteering = powerSteering;
    }

    public boolean isCentralLock() {
        return _centralLock;
    }

    public void setCentralLock(boolean centralLock) {
        _centralLock = centralLock;
    }

    public String getPowerWindows() {
        return _powerWindows;
    }

    public void setPowerWindows(String powerWindows) {
        _powerWindows = powerWindows;
    }

}
