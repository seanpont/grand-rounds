package com.seanpont.grandRounds.utils;

import android.app.Activity;
import com.seanpont.grandRounds.R;

public final class TransitionUtils {

    public static final String BACK_TRANSITION_KEY = "backTransition";

    public static final int DEFAULT = 0;
    public static final int SLIDE   = 1;
    public static final int PUSH    = 2;
    public static final int COMPOSE = 3;

    private TransitionUtils() {}

    public static void overridePushTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.shrink_fade_out_center);
    }

    public static void overridePopTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.grow_fade_in_center, R.anim.slide_out_to_right);
    }

    public static void overrideComposeTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.shrink_fade_out_center);
    }

    public static void overrideComposeBackTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.grow_fade_in_center, R.anim.slide_out_to_bottom);
    }


    public static void overrideSlideTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public static void overrideSlideBackTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public static void overrideBackTransition(Activity activity, int transitionType) {
        switch (transitionType) {
            case SLIDE:
                overrideSlideBackTransition(activity);
                break;
            case PUSH:
                overridePopTransition(activity);
                break;
            case COMPOSE:
                overrideComposeBackTransition(activity);
                break;
        }
    }

    public static void overrideNoTransition(Activity activity) {
        activity.overridePendingTransition(0, 0);
    }
}
