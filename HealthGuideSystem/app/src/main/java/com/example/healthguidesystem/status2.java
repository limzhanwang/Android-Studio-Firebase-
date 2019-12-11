package com.example.healthguidesystem;

public class status2 {

    private String result;
    private String userweight;
    private String userheight;








    public  status2(String result, String userheight, String userweight){
        this.result = result;
        this.userweight = userweight;
        this.userheight = userheight;

    }


    public String getUserbmi() {
        return result;
    }
    public String getUserweight() {
        return userweight;
    }
    public String getUserheight() {
        return userheight;
    }















}
