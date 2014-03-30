package com.seanpont.grandRounds;

import android.app.Application;
import android.util.Log;
import com.seanpont.grandRounds.api.Client;
import com.seanpont.grandRounds.api.FirebaseClient;
import com.seanpont.grandRounds.api.User;
import com.seanpont.grandRounds.db.DataStore;

public class GrandRoundsApplication extends Application {

    private static final String TAG = "GrandRoundsApplication";
    private DataStore _data;
    private Client    _client;

    @Override public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        _data = new DataStore(this);
        _client = new FirebaseClient();
    }

    public DataStore data() { return _data; }
    public Client client() { return _client; }

    public void signIn(String name, String email) {
        data().setUser(new User(name, email));
    }

    public void createPresentation(String presentationTitle) {

    }
}
