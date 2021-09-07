package com.kazanovskiy.cinema.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Seat {

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    private Integer seat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat1 = (Seat) o;
        return Objects.equals(row, seat1.row) && Objects.equals(seat, seat1.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }
}
