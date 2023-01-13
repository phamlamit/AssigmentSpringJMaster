package com.java.assigment.repository;

import com.java.assigment.dto.request.TicketSearchRequest;
import com.java.assigment.entity.Ticket;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Ticket> searchTicket(TicketSearchRequest request) {
        List<Ticket> result = new ArrayList<>();
        StringBuilder sql = createSearchQuery(request);
        System.out.println(sql.toString());
        Query query = entityManager.createNativeQuery(sql.toString(), Ticket.class);
        return query.getResultList();
    }

    private StringBuilder createSearchQuery(TicketSearchRequest request) {
        StringBuilder result = new StringBuilder("SELECT * FROM Ticket t ");
        if (StringUtils.isNotBlank(request.getKeyWorld()) ||
                request.getDepartmentId() != 0 ||
                request.getFrom() != null ||
                request.getTo() != null) {
            result.append("WHERE 1=1 ");
            if (!request.getKeyWorld().isEmpty()) {
                result.append(" AND ");

                result.append(" t.name_customer LIKE " + "'%").append(request.getKeyWorld()).append("%'").append(" OR t.phone_customer LIKE ").append("'%").append(request.getKeyWorld()).append("%'");
            }
            if (request.getDepartmentId() != 0) {
                result.append(" AND ");
                result.append("t.department_id = ").append(request.getDepartmentId());
            }
            if (request.getTo() != null && request.getFrom() != null) {
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                result.append(" AND ");
                result.append(" t.created_date >= " + "'").append(new Date(request.getTo().getTime())).append("'");
                result.append(" AND t.created_date <= " + "'").append(new Date(request.getFrom().getTime())).append("'");
            } else {
                if (request.getTo() != null) {
                    result.append(" AND ");
                    result.append(" t.created_date = " + "'").append(new Date(request.getTo().getTime())).append("'");
                }

                if (request.getFrom() != null) {
                    result.append(" AND ");
                    result.append(" t.created_date = " + "'").append(new Date(request.getFrom().getTime())).append("'");
                }
            }
        }
        return result;
    }
}
