package dev.ritik.movies.movie;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long ID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String rating;

    @Column
    private Integer downloads;
    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Movie(Long ID, String title, String description, String rating, Integer downloads) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.downloads = downloads;
    }


}
