package com.seanpont.grandRounds;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.*;

public abstract class BaseActivity extends Activity {

    private static final String ALERT_FRAGMENT_TAG = "alert";
    /** Get the app */
    protected GrandRoundsApplication app() { return (GrandRoundsApplication) getApplication(); }

    /** Hide the action bar */
    protected void hideActionBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /** Returns this (helpful in anonymous inner classes) */
    protected Activity activity() { return this; }

    /** Too lazy to write the whole line out, eh? */
    public void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    // ===== VIEW HELPERS ==============================================================================================

    protected TextView findTextViewById(int viewId) { return (TextView) findViewById(viewId); }

    protected Button findButtonById(int viewId) { return (Button) findViewById(viewId); }

    protected EditText findEditTextById(int viewId) { return (EditText) findViewById(viewId); }

    protected ListView findListViewById(int viewId) { return (ListView) findViewById(viewId); }

    // ===== ALERTS ==============================================================================================

    public void toast(int stringId) {
        Toast toast = Toast.makeText(this, stringId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void dialog(final int title, final int message) {
        DialogFragment dialogFragment = new DialogFragment() {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity());
                builder.setTitle(title)
                       .setMessage(message)
                       .setPositiveButton(R.string.alert_OK, null);
                return builder.create();
            }
        };
        dialogFragment.show(getFragmentManager(), ALERT_FRAGMENT_TAG);
    }



}
