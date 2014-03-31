package com.seanpont.grandRounds;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.seanpont.grandRounds.utils.TransitionUtils;

import static com.seanpont.grandRounds.utils.StringUtils.isValidEmail;

public class SignInActivity extends BaseActivity implements TextWatcher, View.OnClickListener {

    private static final String PRESENTING = "presenting";

    private TextView _nameView;
    private TextView _emailView;
    private Button   _submitBtn;
    private boolean  _isSubmitting;

    public static Intent newIntent(Context context, boolean presenting) {
        return new Intent(context, SignInActivity.class).putExtra(PRESENTING, presenting);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        _nameView = findTextViewById(R.id.sign_in_name);
        _emailView = findTextViewById(R.id.sign_in_email);
        _submitBtn = findButtonById(R.id.sign_in_submit);

        _nameView.addTextChangedListener(this);
        _emailView.addTextChangedListener(this);
        _submitBtn.setOnClickListener(this);

        findViewById(R.id.sign_in_privacy_policy).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showPrivacyPolicy();
            }
        });

        afterTextChanged(null);
    }
    @Override public void onBackPressed() {
        super.onBackPressed();
        TransitionUtils.overrideSlideBackTransition(this);
    }

    // ===== TextWatcher ===============================================================================================

    String getName() { return _nameView.getText().toString(); }
    String getEmail() { return _emailView.getText().toString(); }

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override public void afterTextChanged(Editable s) {
        if (!getName().isEmpty() &&
            isValidEmail(getEmail()) &&
            !_isSubmitting) {
            _submitBtn.setEnabled(true);
        } else {
            _submitBtn.setEnabled(false);
        }
    }

    // ===== OnClickListener ===========================================================================================

    @Override public void onClick(View v) {
        if (getName().isEmpty() || getEmail().isEmpty() || _isSubmitting) return;
        _isSubmitting = true;
        _submitBtn.setEnabled(false);

        app().signIn(getName(), getEmail());

        if (presenting()) {
            startActivity(CreatePresentationActivity.class);
            TransitionUtils.overrideSlideTransition(activity());
        } else {
            toast(R.id.not_yet_implemented);
        }
    }

    private boolean presenting() {
        return getIntent().getBooleanExtra(PRESENTING, false);
    }

    // ===== PRIVACY POLICY ============================================================================================

    private void showPrivacyPolicy() {
        dialog(R.string.privacy_policy_title, R.string.privacy_policy_body);
    }

}
