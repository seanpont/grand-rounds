package com.seanpont.grandRounds.api;

import java.util.List;

public class Presentation {

    public static final int STATE_PENDING = 0;
    public static final int STATE_IN_PROGRESS = 1;
    public static final int STATE_COMPLETE = 2;

    private int _state;
    private int _case;
    private User presenter;
    private List<User> attendees;

    public int getState() {
        return _state;
    }
    public void setState(int state) {
        _state = state;
    }
    public int getCase() {
        return _case;
    }
    public void setCase(int aCase) {
        _case = aCase;
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
}
