package com.example.saikumar.image_ka_bap;

public class Events {

    String image,eventname,branch;

    public Events()
    {

    }

    public Events(String image, String eventname, String branch) {
        this.image = image;
        this.eventname = eventname;
        this.branch = branch;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
