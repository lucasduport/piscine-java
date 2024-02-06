package fr.epita.assistants.streamstudent;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {

        return stream.filter(elt -> elt.getKey() <= 100 && elt.getKey() >= 0)
                .filter(elt -> (elt.getValue().matches(".*[.]{1}.*") ||
                        elt.getValue().matches(".*[_]{1}.*")));
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted(
                Comparator.comparing(Pair::getKey)
        );
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        ;
        return stream.map(
                elt -> new Pair<Integer, String>(elt.getKey(), elt.getValue().toLowerCase())
        );
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        Stream<Pair<Integer, String>> newStream = stream.sorted(
                Comparator.comparing(Pair::getKey)
        );
        List<Pair<Integer, String>> l = newStream.toList();
        int maxi = l.get(l.size() - 1).getKey();
        Stream<Pair<Integer, String>> s1 = l.stream();
        Stream<Pair<Integer, String>> s2 = s1.filter(
                elt -> elt.getKey() == maxi
        );
        return s2.sorted(Comparator.comparing(Pair::getValue)).findAny();

    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(
                elt -> {
                    if ((elt.getValue().matches("[m|M][a|A].*") ||
                            elt.getValue().matches("[L|l]*.*x")))
                        return new Pair<Integer, String>(elt.getKey() * 2 % 100, elt.getValue());
                    else
                        return elt;
                }
        );
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(
                elt ->
                {
                    return new Pair<Integer, String>(elt.getKey(), elt.getValue().substring(elt.getValue().length() / 2,
                            elt.getValue().length() - 1) + elt.getValue().substring(0, elt.getValue().length() / 2));
                }
        );
    }
}
