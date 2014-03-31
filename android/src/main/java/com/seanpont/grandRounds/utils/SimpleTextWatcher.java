package com.seanpont.grandRounds.utils;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class SimpleTextWatcher implements TextWatcher {
    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // noop
    }
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        // noop
    }
    @Override public void afterTextChanged(Editable s) {
        onChange(s.toString());
    }

    protected abstract void onChange(String s);
}
