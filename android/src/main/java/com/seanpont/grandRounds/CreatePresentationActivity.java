package com.seanpont.grandRounds;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.seanpont.grandRounds.api.Presentation;
import com.seanpont.grandRounds.utils.TransitionUtils;

import static com.firebase.client.Firebase.CompletionListener;

/**
 *
 */
public class CreatePresentationActivity extends BaseActivity implements TextWatcher, View.OnClickListener {

    private EditText _title;
    private Button   _btn;
    private boolean  _creatingPresentation;

    @Override protected void onCreate(Bundle savedInstanceState) {
        hideActionBar();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create);

        _title = findEditTextById(R.id.create_presentation_title);
        _title.addTextChangedListener(this);

        _btn = findButtonById(R.id.create_submit);
        _btn.setOnClickListener(this);

    }

    // ===== TextWatcher ===============================================================================================

    String getPresentationTitle() { return _title.getText().toString(); }

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override public void afterTextChanged(Editable s) {
        _btn.setEnabled(!getPresentationTitle().isEmpty());
    }

    // ===== OnClickListener ===========================================================================================

    @Override public void onClick(View v) {
        final String presentationTitle = getPresentationTitle();
        if (presentationTitle.isEmpty() || _creatingPresentation) return;
        _creatingPresentation = true;
        createPresentation();
    }

    private void createPresentation() {
        final Presentation presentation = new Presentation();
        presentation.setPresenter(app().data().getUser());
        presentation.setTitle(getPresentationTitle());
        app().client().createPresentation(presentation, new CompletionListener() {
            @Override public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                app().data().setPresentation(presentation);
                startActivity(PreparePresentationActivity.class);
                TransitionUtils.overrideSlideTransition(activity());
            }
        });

    }
}
