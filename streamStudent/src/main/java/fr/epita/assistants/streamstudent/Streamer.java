package fr.epita.assistants.streamstudent;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {

        return stream.
                filter(elt -> {
                     return (elt.getKey().compareTo(100) >= 0 && elt.getKey().compareTo(0) <= 0)
                             || (elt.getValue().matches("[^.]+[.][^.]+") ||
                            elt.getValue().matches("[^_]+_[^_]+"));
                });
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted(
                new Comparator<Pair<Integer, String>>() {
                    @Override
                    public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
                        if (!Objects.equals(o1.getKey(), o2.getKey()))
                            return o1.getKey().compareTo(o2.getKey());
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }
        );
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        ;
        return stream.map(
                elt -> {
                    if (elt.getValue().contains("ABCDEFGHIJKLMNOPQRSTUVWXYZ"))
                        return new Pair<Integer, String>(elt.getKey() / 2, elt.getValue().toLowerCase());
                    else
                        return new Pair<Integer, String>(elt.getKey(), elt.getValue().toLowerCase());
                }
        );
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        Stream<Pair<Integer, String>> newStream = stream.sorted(
                Comparator.comparing(Pair::getKey)
        );
        List<Pair<Integer, String>> l = newStream.toList();
        if (l.size() == 0)
            return Optional.empty();
        Integer maxi = l.get(l.size() - 1).getKey();
        Stream<Pair<Integer, String>> s1 = l.stream();
        Stream<Pair<Integer, String>> s2 = s1.filter(
                elt -> Objects.equals(elt.getKey(), maxi)
        );
        return s2.sorted(Comparator.comparing(Pair::getValue)).findAny();

    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(
                elt -> {
                    if ((elt.getValue().matches("[m|M][a|A].*") ||
                            elt.getValue().matches("[L|l].*[x|X]")))
                        return new Pair<Integer, String>(Math.min(elt.getKey() * 2, 100), elt.getValue());
                    else
                        return elt;
                }
        );
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(
                elt ->
                {
                    return new Pair<Integer, String>(elt.getKey(), elt.getValue().substring(elt.getValue().length() / 2
                    ) + elt.getValue().substring(0, elt.getValue().length() / 2));
                }
        );
    }
}
