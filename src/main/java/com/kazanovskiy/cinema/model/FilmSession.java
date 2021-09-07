package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
@Entity
public class FilmSession extends BaseEntity {

    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "filmSession")
    private Set<Ticket> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmSession)) return false;
        FilmSession that = (FilmSession) o;
        return Objects.equals(time, that.time) && Objects.equals(film, that.film) && Objects.equals(hall, that.hall) && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, film, hall, tickets);
    }
}
