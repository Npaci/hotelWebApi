package com.pngabo.hotelWebApi.model.entities;

import com.pngabo.hotelWebApi.model.TypeChambre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int nbPlace;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TypeChambre type;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double prix;

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;
}
