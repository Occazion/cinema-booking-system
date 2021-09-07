package com.kazanovskiy.cinema.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.Objects;
import java.util.Set;

import lombok.Data;


@Data
@Entity
public class Discount extends BaseEntity {

    private String title;

    private String description;

    private int percent;

    @OneToMany(mappedBy = "discount")
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;
        Discount discount = (Discount) o;
        return percent == discount.percent && Objects.equals(title, discount.title) && Objects.equals(description, discount.description) && Objects.equals(users, discount.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, percent, users);
    }
}
