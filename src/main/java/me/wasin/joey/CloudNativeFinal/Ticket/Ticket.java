package me.wasin.joey.CloudNativeFinal.Ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.wasin.joey.CloudNativeFinal.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private double price;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tickets")
    @JsonIgnore
    private List<User> users;

    public Ticket(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Ticket() {
        super();
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getTicketId() {
        return ticketId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public List<User> getUsers() {
        return users;
    }
}
