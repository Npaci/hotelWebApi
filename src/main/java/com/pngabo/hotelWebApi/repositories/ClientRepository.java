package com.pngabo.hotelWebApi.repositories;

import com.pngabo.hotelWebApi.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
