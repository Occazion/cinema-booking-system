package com.kazanovskiy.cinema.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Objects;

import lombok.Data;

@Data
@Entity
public class Ticket extends BaseEntity {


    @Embedded
    private Seat seat;

    private int price;

    @ManyToOne
    @JoinColumn(name = "film_session_id")
    private FilmSession filmSession;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && Objects.equals(seat, ticket.seat) && Objects.equals(filmSession, ticket.filmSession) && Objects.equals(user, ticket.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat, price, filmSession, user);
    }
}
