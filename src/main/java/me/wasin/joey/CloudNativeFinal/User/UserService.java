package me.wasin.joey.CloudNativeFinal.User;

import me.wasin.joey.CloudNativeFinal.Controller.RegisterController;
import me.wasin.joey.CloudNativeFinal.Ticket.Ticket;
import me.wasin.joey.CloudNativeFinal.Ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User purchaseTicket(HashMap registerDetail) {
        long userId = Long.valueOf((int) registerDetail.get("userId"));
        long ticketId = Long.valueOf((int) registerDetail.get("ticketId"));
        User user = userRepository.findById(userId);
        Ticket ticket = ticketRepository.findById(ticketId);
        user.getTickets().add(ticket);
        ticket.getUsers().add(user);
        return userRepository.save(user);
    }
}
