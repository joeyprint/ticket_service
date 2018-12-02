package me.wasin.joey.CloudNativeFinal.Controller;

import me.wasin.joey.CloudNativeFinal.Ticket.Ticket;
import me.wasin.joey.CloudNativeFinal.Ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> ticket_object = ticketService.getAllTicket();
        return new ResponseEntity<List<Ticket>>(ticket_object, HttpStatus.OK);
    }

    @GetMapping("/ticket/{ticket_id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(name = "ticket_id") long ticketId) {
        Ticket ticket_object = ticketService.getTicketById(ticketId);
        return new ResponseEntity<Ticket>(ticket_object, HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        Ticket ticket_object = ticketService.createTicket(ticket);
        return new ResponseEntity<Ticket>(ticket_object, HttpStatus.OK);
    }
}
