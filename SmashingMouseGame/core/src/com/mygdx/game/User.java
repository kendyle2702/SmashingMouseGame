package com.mygdx.game;


public class User {
    private String username;
    private int point;
    
    public User(String username, int point) {
        
        this.username = username;
        this.point = point;
        
    }

    public String getUsername() {
        return username;
    }

    public int getPoint() {
        return point;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
}
