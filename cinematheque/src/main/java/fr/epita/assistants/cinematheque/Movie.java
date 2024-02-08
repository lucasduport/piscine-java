package fr.epita.assistants.cinematheque;

import java.time.Duration;
import java.time.LocalDate;

public class Movie {
    private String title;
    private String director;
    private LocalDate realease_date;
    private Duration duration;

    public Movie(String title, String director, LocalDate realease_date, Duration duration) {
        if (title == null || director == null ||
                realease_date == null || duration == null)
            throw new NullPointerException();
        this.title = title;
        this.director = director;
        this.realease_date = realease_date;
        this.duration = duration;

    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getRealease() {
        return realease_date;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Movie.class)
            return false;
        Movie m = (Movie) obj;
        return title.equals(m.title) &&
                director.equals(m.director) &&
                realease_date.equals(m.realease_date) &&
                duration.equals(m.duration);
    }

    @Override
    public String toString() {
        return ("Movie(title=" + title
                + ", director=" + director +
                ", release=" + realease_date +
                ", duration=" + duration + ")");
    }
}
