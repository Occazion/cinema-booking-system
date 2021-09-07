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
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(tickets, user.tickets) && Objects.equals(discount, user.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, phone, password, email, tickets, discount);
    }
}
