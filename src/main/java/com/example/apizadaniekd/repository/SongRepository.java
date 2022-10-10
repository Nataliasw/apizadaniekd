package com.example.apizadaniekd.repository;

import com.example.apizadaniekd.models.Song;
import com.example.apizadaniekd.models.SongDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SongRepository {

    static Long currentId = 5L;



    private List<Song> songs = new LinkedList<>(Arrays.asList(
        new Song(1L, "Yellow", "Coldplay", 2003),
            new Song(2L, "Thriller", "Micheal Jackson", 1882),
            new Song(3L, "Początek", "Męskie Granie Orkiestra", 2020),
            new Song(4L, "Master of Puppets", "Metallica", 1880)
    ));

    public List<Song> getAll() {
        return songs;
    }

    public Optional<Song> get(Long id) {
        return songs.stream().filter(song -> song.getId().equals(id)).findFirst();
    }

    public Song create(SongDto songDto){
        Song newSong = new Song(currentId++,songDto);
        songs.add(newSong);
        return newSong;
    }

    public Song update(Song song, SongDto songDto){
        song.setTitle(songDto.getTitle());
        song.setAuthor(songDto.getAuthor());
        song.setYear(songDto.getYear());
        return song;

    }

    public void delete(Song song){
        songs.remove(song);
    }
}
