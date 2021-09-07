package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Objects;

import lombok.Data;


@Data
@Entity(name = "roww")
public class Row extends BaseEntity {
    private int rowIndex;

    private int seats;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Row)) return false;
        Row row = (Row) o;
        return rowIndex == row.rowIndex && seats == row.seats && Objects.equals(hall, row.hall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, seats, hall);
    }
}
