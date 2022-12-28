package com.java.assigment.repository;

import com.java.assigment.dto.request.TicketSearchRequest;
import com.java.assigment.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Ticket> searchTicket(TicketSearchRequest request) {
        List<Ticket> result = new ArrayList<>();
        StringBuilder query = createSearchQuery(request);
        entityManager.createQuery("SELECT t FROM Ticket t WHERE t.createdDate  =>" + request.getKeyWorld(), Ticket.class).;
        result = entityManager.createQuery(query.toString(), Ticket.class).getResultList();
        return result;
    }

    private StringBuilder createSearchQuery(TicketSearchRequest request) {
        StringBuilder result = new StringBuilder("SELECT t FROM Ticket t ");
        if (!request.getKeyWorld().isEmpty() ||
                !request.getDepartmentId().isEmpty() ||
                !request.getTo().toString().isEmpty() ||
                !request.getFrom().toString().isEmpty()) {
            result.append("WHERE ");
            if (!request.getKeyWorld().isEmpty()) {
                result.append("t.id = " + request.getKeyWorld());
            }
            if (!request.getDepartmentId().isEmpty()) {
                result.append("t.department.id = " + request.getDepartmentId());
            }
            if (!request.getFrom().toString().isEmpty() && !request.getTo().toString().isEmpty()) {
                result.append("t.createdDate >= " + request.getFrom());
                result.append("t.createdDate.id <= " + request.getTo());
            } else {
                if (!request.getTo().toString().isEmpty()) {
                    result.append("t.createdDate.id = " + request.getTo());
                }
                if (!request.getFrom().toString().isEmpty()) {
                    result.append("t.createdDate.id = " + request.getFrom());
                }
            }
        }
        return result;
    }
}
