package com.bugisbae.bloodhive;

import java.util.ArrayList;

public class user {
    String user_id;
    String user_name;
    String email;
    String mobile;
    String gender;
    int weight;
    int height;
    int age;
    String BloodGroup;
    ArrayList<String> pastDiseases;
    boolean tatoos;
    int alcoholLevel;
    int smokingLevel;
    int haemoglobin;
    boolean sportsAndGym;
    int sleepLevel;
    boolean isOK=true;
    float qualityIndex=100;
    String imgUrl;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getQualityIndex() {
        return qualityIndex;
    }

    public void setQualityIndex(float qualityIndex) {
        this.qualityIndex = qualityIndex;
    }

    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }

    public String getLatAdd() {
        return latAdd;
    }

    public void setLatAdd(String latAdd) {
        this.latAdd = latAdd;
    }

    public String getLongAdd() {
        return longAdd;
    }

    public void setLongAdd(String longAdd) {
        this.longAdd = longAdd;
    }

    int heartRate;
    String latAdd;
    String longAdd;
    boolean activeDonor=false;


    public user(){

    }

    user(String user_id, String user_name, String email) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;

    }

    public user(String user_id, String user_name, String email, String mobile, String latAdd,String longAdd) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.mobile = mobile;
        this.latAdd = latAdd;
        this.longAdd=longAdd;
    }

    public user(String user_id, String user_name,String gender, String email,String mobile, String latAdd,String longAdd,int weight, int height, int age, String bloodGroup, ArrayList<String> pastDiseases, boolean tatoos, int alcoholLevel, int smokingLevel, int haemoglobin, boolean sportsAndGym, int sleepLevel, int heartRate,boolean activeDonor,String imgUrl) {
        this.user_id=user_id;
        this.user_name=user_name;
        this.email=email;
        this.gender=gender;
        this.mobile=mobile;
        this.latAdd = latAdd;
        this.longAdd=longAdd;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.BloodGroup = bloodGroup;
        this.pastDiseases = pastDiseases;
        this.tatoos = tatoos;
        this.alcoholLevel = alcoholLevel;
        this.smokingLevel = smokingLevel;
        this.haemoglobin = haemoglobin;
        this.sportsAndGym = sportsAndGym;
        this.sleepLevel = sleepLevel;
        this.heartRate = heartRate;
        this.activeDonor=activeDonor;
        this.imgUrl=imgUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public ArrayList<String> getPastDiseases() {
        return pastDiseases;
    }

    public void setPastDiseases(ArrayList<String> pastDiseases) {
        this.pastDiseases = pastDiseases;
    }

    public boolean isTatoos() {
        return tatoos;
    }

    public void setTatoos(boolean tatoos) {
        this.tatoos = tatoos;
    }

    public int getAlcoholLevel() {
        return alcoholLevel;
    }

    public void setAlcoholLevel(int alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public int getSmokingLevel() {
        return smokingLevel;
    }

    public void setSmokingLevel(int smokingLevel) {
        this.smokingLevel = smokingLevel;
    }

    public int getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(int haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public boolean isSportsAndGym() {
        return sportsAndGym;
    }

    public void setSportsAndGym(boolean sportsAndGym) {
        this.sportsAndGym = sportsAndGym;
    }

    public int getSleepLevel() {
        return sleepLevel;
    }

    public void setSleepLevel(int sleepLevel) {
        this.sleepLevel = sleepLevel;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }





    public boolean isActiveDonor() {
        return activeDonor;
    }

    public void setActiveDonor(boolean activeDonor) {
        this.activeDonor = activeDonor;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



}
