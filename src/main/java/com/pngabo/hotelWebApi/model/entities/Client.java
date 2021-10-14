package com.pngabo.hotelWebApi.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String numTel;
    @ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
    private List<String> moyenPayem;
}
