package com.pngabo.hotelWebApi.repositories;

import com.pngabo.hotelWebApi.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
