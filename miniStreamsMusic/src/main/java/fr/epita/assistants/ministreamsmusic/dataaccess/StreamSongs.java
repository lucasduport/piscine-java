package fr.epita.assistants.ministreamsmusic.dataaccess;

import fr.epita.assistants.ministreamsmusic.data.Artist;
import fr.epita.assistants.ministreamsmusic.data.Song;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSongs {
    public static List<String> getOlderArtists(List<Song> songs)
    {
        return songs.stream()
                .filter( a -> a.getArtist().getAge() >= 30)
                .map(i -> i.getArtist().getSurname())
                .distinct()
                .limit(10).collect(Collectors.toList());
    }

    public static Integer getSumAges(List<Song> songs) {
        return songs.stream()
                .map (Song::getArtist)
                .distinct()
                .filter(
                        a -> a.getAge() >= 20
                ).mapToInt(Artist::getAge).sum();
    }

    public static List<String> getMusics(List<Song> songs)
    {
        return songs.stream()
                .filter(
                        i -> i
                        .getArtist()
                        .getName()
                        .matches(".*[an|aN|An|AN].*"))
                .limit(10)
                .map(Song::getName)
                .collect(Collectors.toList());
    }
}
