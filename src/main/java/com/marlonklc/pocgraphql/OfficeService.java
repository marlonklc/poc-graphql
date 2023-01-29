package com.marlonklc.pocgraphql;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
class AppoitmentService {
    Map<String, Appointment> appointments = new HashMap<>();

    Collection<Appointment> createAppointment(ZonedDateTime startAt, ZonedDateTime endsAt) {
        var newAppointment = new Appointment(UUID.randomUUID().toString(), startAt, endsAt);
        appointments.put(newAppointment.id(), newAppointment);
        return appointments.values();
    }

    Appointment getAppointmentById(String id) {
        return appointments.get(id);
    }
}

@Service
class CustomerService {
    Map<String, Customer> customers = new HashMap<>();

    Collection<Customer> createCustomer(String name, String appointmentId) {
        var newCustomer = new Customer(UUID.randomUUID().toString(), name, appointmentId);
        customers.put(newCustomer.id(), newCustomer);
        return customers.values();
    }

    Customer getCustomerById(String id) {
        return customers.get(id);
    }

    public Optional<Customer> findByAppointmentId(String id) {
        return customers.values().stream()
            .filter(customer -> customer.appointmentId().equals(id))
            .findFirst();
    }
}