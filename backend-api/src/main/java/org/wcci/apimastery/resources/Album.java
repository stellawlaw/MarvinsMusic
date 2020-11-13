package org.wcci.apimastery.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Album {
    private String albumName;
    private String image;
    private String artist;
    private String recordLabel;
    @OneToMany
    private Set<Song> songs;

    @Id
    @GeneratedValue
    private Long id;

    protected Album(){}



    public Album(String albumName, String image, String artist, String recordLabel, Song...songs) {
        this.albumName = albumName;
        this.image = image;
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.songs = Set.of(songs);


    }


    public Long getId() { return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(albumName, album.albumName) &&
                Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumName, id);
    }
}
