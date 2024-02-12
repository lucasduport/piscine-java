package fr.epita.assistants.cinematheque;

import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Cinematheque {

    public Stock<Movie> stock;
    private Logger logger;

    public Cinematheque()
    {
        stock = new ListStock<>();
        stock.property.addPropertyChangeListener(new Logger(System.out));
        stock.property.addPropertyChangeListener(new Counter());
    }
    public Cinematheque(PrintStream output)
    {
        var logger = new Logger(output);
        stock = new ListStock<>();
        stock.property.addPropertyChangeListener(logger);
        stock.property.addPropertyChangeListener(new Counter());
    }

    public boolean add(Movie movie)
    {
        return stock.add(movie);
    }
    public boolean remove(Movie movie)
    {
        return stock.remove(movie);
    }
    public boolean contains(Movie movie)
    {
        return stock.contains(movie);
    }
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        var l = stock.list();
        for (var s: l
             ) {
            b.append(s.toString()).append("\n");
        }
        return b.toString();
    }

    public boolean sortByTitle()
    {
        return stock.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
                    if (o1.getDirector().compareTo(o2.getDirector()) == 0)
                    {
                        if (o1.getRelease().isEqual(o2.getRelease()))
                        {
                            if (o1.getDuration().compareTo(o2.getDuration()) == 0)
                            {
                                return 0;
                            }
                            else
                                return o1.getDuration().compareTo(o2.getDuration());
                        }
                        else
                            return o1.getRelease().compareTo(o2.getRelease());
                    }
                    else
                    {
                        return o1.getDirector().compareTo(o2.getDirector());
                    }
                }
                else
                    return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    public void banDirector(String director)
    {
        var toRemove = stock.filter(
                m -> m.getDirector().equals(director)
        );
        for (var e: toRemove.list()
             ) {
            stock.remove(e);
        }
    }

    public Period datesAmplitude()
    {
        if (stock.list().size() <= 1)
            return Period.ZERO;

        LocalDate d1 = stock.list().stream().min(
                new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getRelease().compareTo(o2.getRelease());
                    }
                }
        ).get().getRelease();

        LocalDate d2 = stock.list().stream().max(
                new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getRelease().compareTo(o2.getRelease());
                    }
                }
        ).get().getRelease();
        return Period.between(d1, d2);
    }

    public Duration averageDuration()
    {
        long[] blk = new long[]{0, 0};
        stock.list().forEach(
                m -> {
                    blk[0] += m.getDuration().getSeconds();
                    blk[1] += 1;
                }
        );
        if (blk[1] == 0)
            return Duration.ZERO;
        long avg_sec = blk[0] / blk[1];
        return Duration.ofSeconds(avg_sec);
    }

}
