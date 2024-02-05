package fr.epita.assistants.streamstudent;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream)
    {
        stream.filter(elt -> elt.getKey() <= 100 && elt.getKey() >= 0)
                .filter(elt -> (elt.getValue().matches(".*[.]{1}.*") ||
                        elt.getValue().matches(".*[_]{1}.*") ));
        return stream;
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream)
    {
        stream.sorted(
                Comparator.comparing(Pair::getKey)
        );
        return stream;
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        stream.map(
                elt -> new Pair<Integer, String>(elt.getKey(), elt.getValue().toLowerCase())
        );
        return stream;
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream)
    {
        stream.sorted(
                Comparator.comparing(Pair::getKey)
        );
        //stream.filter(
         //       elt -> (elt.getKey() == stream.max(Comparator.comparing(Pair::getKey).get()))
        //)
        return stream.max(Comparator.comparing(Pair::getKey));
    }
}
