package com.seanpont.grandRounds.api;

import java.util.Map;

public class Case {

    private String              description;
    private String              diagnosis;
    private boolean             revealed;
    private Map<String, String> attendeeDiagnoses; // key=email, value=diagnosis

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public boolean isRevealed() {
        return revealed;
    }
    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
    public Map<String, String> getAttendeeDiagnoses() {
        return attendeeDiagnoses;
    }
    public void setAttendeeDiagnoses(Map<String, String> attendeeDiagnoses) {
        this.attendeeDiagnoses = attendeeDiagnoses;
    }
}
