package ru.spbstu.jdb.model.entities;

public class UserEntity implements Entity {

    private long _id;
    private long _roleId;
    private String _login;
    private String _firstName;
    private String _lastName;

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    public long getRoleId() {
        return _roleId;
    }

    public void setRoleId(long roleId) {
        _roleId = roleId;
    }

    public String getLogin() {
        return _login;
    }

    public void setLogin(String login) {
        _login = login;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
}
