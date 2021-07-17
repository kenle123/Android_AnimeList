package com.example.animelist.pojos;

public class Anime {
    private String name;
    private double rating;

    public Anime(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getAnimeName() {
        return name;
    }

    public void setAnimeName(String name) {
        this.name = name;
    }

    public double getAnimeRating() {
        return rating;
    }

    public void setAnimeRating(double rating) {
        this.rating = rating;
    }
}
