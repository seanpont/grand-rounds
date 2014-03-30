package com.seanpont.grandRounds;

import android.os.Bundle;
import android.view.View;
import com.seanpont.grandRounds.utils.TransitionUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findButtonById(R.id.main_btn_presenting).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (app().data().getUser() == null) {
                    startActivity(SignInActivity.newIntent(activity(), true));
                } else {
                    startActivity(CreatePresentationActivity.class);
                }
                TransitionUtils.overrideSlideTransition(activity());
            }
        });

        findButtonById(R.id.main_btn_attending).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

            }
        });
    }
}
