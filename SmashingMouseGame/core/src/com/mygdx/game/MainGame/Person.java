package com.mygdx.game.MainGame;

public class Person {
    private int id;
    private String name;
    private String path1;
    private String path2;

    public Person(int id, String name, String path1, String path2) {
        this.id = id;
        this.name = name;
        this.path1 = path1;
        this.path2 = path2;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath1() {
        return path1;
    }

    public String getPath2() {
        return path2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }
    
}
