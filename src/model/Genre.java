package model;

public enum Genre {
    Thriller("Thriller"), Art("Art"), Memoir("Memoir");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
