package com.seanpont.grandRounds.api;

public class User {

    private String _name;
    private String _email;

    public User() {}

    public User(String name, String email) {
        _name = name;
        _email = email;
    }

    public String getName() { return _name; }
    public void setName(String name) { _name = name; }
    public String getEmail() { return _email; }
    public void setEmail(String email) { _email = email; }
}
