package com.seanpont.grandRounds.api;

import com.firebase.client.Firebase;

import static com.firebase.client.Firebase.CompletionListener;

public class FirebaseClient {

    private static final String TAG           = "FirebaseClient";
    private static final String BASE_URL      = "https://flickering-fire-933.firebaseio.com/";
    private static final String PRESENTATIONS = "presentations";
    private final Firebase _firebase;


    public FirebaseClient() {
        _firebase = new Firebase(BASE_URL);
    }

    /**
     * Create the presentation remotely and set the name of the presentation
     * @param presentation
     * @param callback
     */
    public void createPresentation(final Presentation presentation, final CompletionListener callback) {
        final Firebase presentationRef = _firebase.child(PRESENTATIONS).push();
        presentation.setName(presentationRef.getName());
        presentationRef.setValue(presentation, callback);
    }
}
