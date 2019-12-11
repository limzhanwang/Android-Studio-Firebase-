package com.example.healthguidesystem;

public class status {

        private String name;
        private String usergender;
        private String userage;



    public  status(String name, String userage, String usergender){

        this.name = name;
        this.usergender = usergender;
        this.userage = userage;


    }




    public  String getName(){
        return name;
    }

    public String getUsergender() {
        return usergender;
    }

    public String getUserage() {
        return userage;
    }
}
