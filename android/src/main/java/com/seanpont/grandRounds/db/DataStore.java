package com.seanpont.grandRounds.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.seanpont.grandRounds.api.Presentation;
import com.seanpont.grandRounds.api.User;

public class DataStore {

    private static final String NAME       = "name";
    private static final String EMAIL      = "email";
    private static final String PRESENTING = "presenting";
    private static final String ATTENDING  = "attending";

    private final SharedPreferences _preferences;
    private       User              _user;
    private       Presentation      _presentation;

    public DataStore(Context context) {
        _preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    // ===== USER ======================================================================================================

    public User getUser() {
        if (_user != null) {
            String name = _preferences.getString(NAME, null);
            String email = _preferences.getString(EMAIL, null);
            if (name != null && email != null) {
                _user = new User(name, email);
            }
        }
        return _user;
    }

    public void setUser(User user) {
        _preferences.edit()
                    .putString(NAME, user.getName())
                    .putString(EMAIL, user.getEmail())
                    .commit();
        _user = user;
    }

    public String getEmail() {
        return _user == null ? null : _user.getEmail();
    }

    public void setPresenting(String name) {
        _preferences.edit().putString(PRESENTING, name).commit();
    }
    public void setAttending(String name) { _preferences.edit().putString(ATTENDING, name).commit(); }

    public void setPresentation(Presentation presentation) {
        _presentation = presentation;
        if (_presentation.getPresenter().getEmail().equals(getEmail())) {
            setPresenting(presentation.getName());
        } else {
            setAttending(presentation.getName());
        }
    }
    public Presentation getPresentation() {
        return _presentation;
    }
}
