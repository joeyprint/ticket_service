package me.wasin.joey.CloudNativeFinal.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(long ticketId) {
        return ticketRepository.findById(ticketId);
    }
}
