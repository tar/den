package ru.spbstu.jdb.model.entities;


/**
 * Entity class for clients table. Describes one row
 * 
 * @author Den
 * 
 */
public class Insurance {
    private String _insNum;
    private String _insType;
    private String _insCom;

    public Insurance() {
    }

    public Insurance(String insNum, String insType, String insCom) {
        super();
        this._insNum = insNum;
        this._insType = insType;
        this._insCom = insCom;
    }

    public String getInsNum() {
        return _insNum;
    }

    public void setInsNum(String insNum) {
        this._insNum = insNum;
    }

    public String getInsType() {
        return _insType;
    }

    public void setInsType(String insType) {
        this._insType = insType;
    }

    public String getInsCom() {
        return _insCom;
    }

    public void setInsCom(String insCom) {
        this._insCom = insCom;
    }

}
