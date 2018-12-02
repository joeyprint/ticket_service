package me.wasin.joey.CloudNativeFinal.User;

import me.wasin.joey.CloudNativeFinal.Ticket.Ticket;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_ticket",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")}
    )
    private List<Ticket> tickets;

    public User() {
        super();
    }

    public User( String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
