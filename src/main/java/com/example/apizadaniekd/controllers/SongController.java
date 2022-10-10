package com.example.apizadaniekd.controllers;

import com.example.apizadaniekd.models.Song;
import com.example.apizadaniekd.models.SongDto;
import com.example.apizadaniekd.services.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@AllArgsConstructor
public class SongController {

    private final SongService songService;


    @GetMapping
    public List<Song> getAll() {
        return songService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Song> get(@PathVariable Long id){
       return ResponseEntity.ok(songService.get(id));
    }

    @PostMapping
    ResponseEntity<Song> create(@RequestBody SongDto songDto){
        Song song = songService.create(songDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(song);

    }

    @PutMapping("{id}")
    ResponseEntity<Song> update(@PathVariable Long id, @RequestBody SongDto songDto){
        return ResponseEntity.ok(songService.update(id,songDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Song> delete(@PathVariable Long id){
        songService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
