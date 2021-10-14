package com.pngabo.hotelWebApi.repositories;

import com.pngabo.hotelWebApi.model.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
