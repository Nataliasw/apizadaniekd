package com.example.apizadaniekd.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private Long id;
    private String title;
    private String author;
    private Integer year;

    public Song(Long id, SongDto songDto){
        this.id = id;
        this.title = songDto.getTitle();
        this.author = songDto.getAuthor();
        this.year = songDto.getYear();
    }

}
