package com.marlonklc.pocgraphql;

import java.time.ZonedDateTime;

record Appointment(String id, ZonedDateTime startsAt, ZonedDateTime endsAt) {
}

record Customer(String id, String name, String appointmentId) {
}

