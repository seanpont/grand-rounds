package com.seanpont.grandRounds.api;

import java.util.List;

public class Presentation {

    public static final int STATE_INITIALIZING = 0;
    public static final int STATE_PENDING      = 1;
    public static final int STATE_STARTED      = 2;
    public static final int STATE_COMPLETE     = 3;

    private String     _name;
    private int        _state = STATE_INITIALIZING;
    private int        _currentCase = -1;
    private String     _title;
    private User       presenter;
    private List<Case> _cases;
    private List<User> attendees;

    public int getState() {
        return _state;
    }
    public void setState(int state) {
        _state = state;
    }
    public int getCurrentCase() {
        return _currentCase;
    }
    public void setCurrentCase(int currentCase) {
        _currentCase = currentCase;
    }
    public User getPresenter() {
        return presenter;
    }
    public void setPresenter(User presenter) {
        this.presenter = presenter;
    }
    public List<User> getAttendees() {
        return attendees;
    }
    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
    public void setTitle(String title) { _title = title; }
    public String getTitle() { return _title; }
    public void setName(String name) { _name = name; }
    public String getName() { return _name; }
    public void setCases(List<Case> cases) { _cases = cases; }
    public List<Case> getCases() { return _cases; }
}
