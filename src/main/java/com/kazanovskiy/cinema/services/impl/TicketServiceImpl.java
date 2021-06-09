package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Ticket;
import com.kazanovskiy.cinema.repository.TicketRepository;
import com.kazanovskiy.cinema.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Value("${page.size}")
    private Integer pageSize;

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Page<Ticket> findAll(Integer pageNumber) {
        return ticketRepository.findAll(PageRequest.of(pageNumber - 1, pageSize));
    }

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(new Ticket());
    }

    public void update(Ticket ticket) {
        ticketRepository.save(ticket);
    }

}
