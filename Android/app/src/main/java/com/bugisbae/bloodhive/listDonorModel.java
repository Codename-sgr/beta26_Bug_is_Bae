package com.bugisbae.bloodhive;

public class listDonorModel {

    String username;
    float bloodQuality;
    String bloodGrp;
    boolean isOK;

    public listDonorModel(String username, float bloodQuality, String bloodGrp, boolean isOK) {
        this.username = username;
        this.bloodQuality = bloodQuality;
        this.bloodGrp = bloodGrp;
        this.isOK = isOK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getBloodQuality() {
        return bloodQuality;
    }

    public void setBloodQuality(float bloodQuality) {
        this.bloodQuality = bloodQuality;
    }

    public String getBloodGrp() {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }

    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }
}
