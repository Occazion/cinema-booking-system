package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
@Entity
public class Genre extends BaseEntity {

    private String title;
    private String description;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Film> films;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(title, genre.title) && Objects.equals(description, genre.description) && Objects.equals(films, genre.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, films);
    }
}
