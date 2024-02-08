package fr.epita.assistants.cinematheque;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Cinematheque {

    private Stock<Movie> stock;
    private Logger logger;
    public Cinematheque()
    {
        stock = new ListStock<>();
    }
    public Cinematheque(PrintStream output)
    {
        stock = new ListStock<>();
        if (output == null)
            logger = new Logger(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        else
            logger = new Logger(output);

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
            b.append(s.toString());
        }
        return b.toString();
    }

    public boolean sortByTitle()
    {
        return stock.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
                    if (o1.getTitle().compareTo(o2.getTitle()) == 0)
                    {
                        if (o1.getRealease().compareTo(o2.getRealease()) == 0)
                        {
                            if (o1.getDuration().compareTo(o2.getDuration()) == 0)
                            {
                                return 0;
                            }
                            else
                                return o1.getDuration().compareTo(o2.getDuration());
                        }
                        else
                            return o1.getRealease().compareTo(o2.getRealease());
                    }
                    else
                    {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                }
                else
                    return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    public void banDirectors(String director)
    {
        stock = stock.filter(
                m -> m.getDirector().equals(director)
        );
    }

    public Period datesAmplitude()
    {
        Stock<Movie> s = stock.filter( i-> true);
        s.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getRealease().compareTo(o2.getRealease());
            }
        });
        if (s.list().size() < 2)
            return null;
        LocalDate d1 = s.list().stream()
                .findFirst().get().getRealease();

        LocalDate d2  = s.list().stream().skip(s.list().size() - 1)
                        .reduce((f, d) -> d).get().getRealease();
        return Period.between(d1, d2);
    }

    public Duration averageDuration()
    {
        long[] blk = new long[]{0, 0};
        stock.list().stream().map(
                m -> {
                    blk[0] += m.getDuration().getSeconds();
                    blk[1] += 1;
                    return m;
                }
        );
        if (blk[1] == 0)
            return Duration.ZERO;
        long avg_sec = blk[0] / blk[1];
        return Duration.ofSeconds(avg_sec);
    }

}
