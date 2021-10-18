package com.pngabo.hotelWebApi.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate  dateFin;
    @Column(nullable = false)
    private boolean dejeune;

    @ManyToOne
    private Chambre chambre;

    @ManyToOne
    private Client client;
}

