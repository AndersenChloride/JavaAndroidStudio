package com.example.myapplication;

public class Movie {
    private String title;
    private int year;
    private int durationMin;

    private String author;
    private String genre;
    private String annotation;

    public Movie(String title, int year, int durationMin, String author, String genre, String annotation) {
        this.title = title;
        this.year = year;
        this.durationMin = durationMin;
        this.author = author;
        this.genre = genre;
        this.annotation = annotation;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
