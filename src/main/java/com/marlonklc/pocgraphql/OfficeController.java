package com.marlonklc.pocgraphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.ZonedDateTime;
import java.util.Collection;

@Controller
public class OfficeController {

    @Autowired
    private AppoitmentService appoitmentService;

    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public Appointment getAppointmentById(@Argument String id) {
        return appoitmentService.getAppointmentById(id);
    }

    @MutationMapping
    public Collection<Appointment> createAppointment(@Argument ZonedDateTime startsAt, @Argument ZonedDateTime endsAt) {
        return appoitmentService.createAppointment(startsAt, endsAt);
    }

//    @QueryMapping
//    public Customer getCustomerById(@Argument String id) {
//        return customerService.getCustomerById(id);
//    }

    @MutationMapping
    public Collection<Customer> createCustomer(@Argument String name, @Argument String appointmentId) {
        return customerService.createCustomer(name, appointmentId);
    }

    @SchemaMapping
    public Customer customer(Appointment appointment) {
        System.out.println("chamou customer: " + appointment);
        return customerService.findByAppointmentId(appointment.id())
            .orElse(null);
    }
}
