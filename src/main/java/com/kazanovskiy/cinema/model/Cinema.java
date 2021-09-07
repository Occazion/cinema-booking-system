package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
@Entity

public class Cinema extends BaseEntity {

    private String title;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(title, cinema.title) && Objects.equals(address, cinema.address) && Objects.equals(phone, cinema.phone) && Objects.equals(email, cinema.email) && Objects.equals(halls, cinema.halls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address, phone, email, halls);
    }
}
