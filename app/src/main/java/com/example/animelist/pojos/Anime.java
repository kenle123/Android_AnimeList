package com.example.animelist.pojos;

public class Anime {
    private String name;
    private String rating;

    public Anime(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getAnimeName() {
        return name;
    }

    public void setAnimeName(String name) {
        this.name = name;
    }

    public String getAnimeRating() {
        return rating;
    }

    public void setAnimeRating(String rating) {
        this.rating = rating;
    }

    //hello
}
