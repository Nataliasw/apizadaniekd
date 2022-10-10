package com.example.apizadaniekd.services;

import com.example.apizadaniekd.exceptions.ResourceNotFoundException;
import com.example.apizadaniekd.models.Song;
import com.example.apizadaniekd.models.SongDto;
import com.example.apizadaniekd.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    public List<Song> getAll(){
        return songRepository.getAll();

    }

    public Song get(Long id){
        return songRepository.get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
    public Song create(SongDto songDto){
        return songRepository.create(songDto);
    }

    public Song update(Long id,SongDto songDto){
        Song song =get(id);
        return songRepository.update(song,songDto);
    }

    public void delete(Long id){
        Song song = get(id);
        songRepository.delete(song);
    }
}
