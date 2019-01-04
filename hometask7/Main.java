package com.htp.hometask7;

public class Main {
    public static void main(String[] args) {


        Movie movie = new Movie();
        movie.firtsMethod();

        Movie.MovieCollection movieCollection = new Movie().new MovieCollection();
        movieCollection.monvieMethod("The Predator", "Shane Blake", "Action", "1:46:56");
        movieCollection.monvieMethod("Searching", "Anish Chahanti", "Thriller", "1:42:51");
        movieCollection.monvieMethod("The Equalizer 2", "Antuan Fucua", "Action", "2:01:11");
        movieCollection.monvieMethod("Alpha", "Albert Hughes", "Action", "1:36:30");
        movieCollection.monvieMethod("Miles 22", "Peter Berg", "Action", "1:34:25");
        movieCollection.monvieMethod("Mission: Impossible - Fallout", "Christopher McQuarrie", "Action", "2:27:25");


    }
}