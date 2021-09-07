package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Film extends BaseEntity {

    private String title;
    private int duration;
    private String description;
    private String year;
    private String country;
    private int restriction;
    private String startFrom;

    @ManyToMany(mappedBy = "films")
    private Set<Actor> actors;

    @ManyToMany(mappedBy = "films")
    private Set<Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id.equals(film.id) && duration == film.duration && restriction == film.restriction && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(year, film.year) && Objects.equals(country, film.country) && Objects.equals(startFrom, film.startFrom) && Objects.equals(actors, film.actors) && Objects.equals(genres, film.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title, duration, description, year, country, restriction, startFrom, actors, genres);
    }
}
