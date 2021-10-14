package com.pngabo.hotelWebApi.model.entities;

import com.pngabo.hotelWebApi.model.TypeChambre;
import lombok.*;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

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
    private TypeChambre type;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double prix;
}