package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
@Entity
public class Hall extends BaseEntity {

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "hall")
    private Set<Row> rows;

    @OneToMany(mappedBy = "hall")
    private Set<FilmSession> filmSessions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hall)) return false;
        Hall hall = (Hall) o;
        return Objects.equals(title, hall.title) && Objects.equals(description, hall.description) && Objects.equals(cinema, hall.cinema) && Objects.equals(rows, hall.rows) && Objects.equals(filmSessions, hall.filmSessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, cinema, rows, filmSessions);
    }
}
