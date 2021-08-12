package com.example.animelist.pojos;

public class Anime {
    private String name;
    private String rating;
    private String episodeCount;

    public Anime(String name, String rating, String episodeCount) {
        this.name = name;
        this.rating = rating;
        this.episodeCount = episodeCount;
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

    public String getAnimeEpisodeCount() {return episodeCount;}

    public void setAnimeEpisodeCount(String episodeCount) {this.episodeCount = episodeCount;}

    //hello
}
