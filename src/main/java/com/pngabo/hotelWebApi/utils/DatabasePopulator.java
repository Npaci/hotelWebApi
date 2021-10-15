package com.pngabo.hotelWebApi.utils;

import com.pngabo.hotelWebApi.model.TypeChambre;
import com.pngabo.hotelWebApi.model.entities.Chambre;
import com.pngabo.hotelWebApi.model.entities.Client;
import com.pngabo.hotelWebApi.model.entities.Reservation;
import com.pngabo.hotelWebApi.model.entities.Utilisateur;
import com.pngabo.hotelWebApi.repositories.ChambreRepository;
import com.pngabo.hotelWebApi.repositories.ClientRepository;
import com.pngabo.hotelWebApi.repositories.ReservationRepository;
import com.pngabo.hotelWebApi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatabasePopulator implements InitializingBean {
    private final ClientRepository clRepository;
    private final ChambreRepository chRepository;
    private final ReservationRepository rRepository;
    private final UtilisateurRepository uReposiroty;
    private final PasswordEncoder encoder;

    public DatabasePopulator(ClientRepository repository, ChambreRepository chRepository, ReservationRepository rRepository, UtilisateurRepository uReposiroty,UtilisateurRepository uReposiroty1, PasswordEncoder encoder) {
        this.clRepository = repository;
        this.chRepository = chRepository;
        this.rRepository = rRepository;
        this.uReposiroty = uReposiroty1;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //region Client
        Client c1 = Client.builder()
                .id(0L)
                .nom("Terrieur")
                .prenom("Alex")
                .numTel("0490/851205")
                .build();

        Client c2 = Client.builder()
                .id(0L)
                .nom("Terrieur")
                .prenom("Alain")
                .numTel("0456/190287")
                .build();
        clRepository.save(c1);
        clRepository.save(c2);
        //endregion
        //region Chambre
        Chambre ch1 = Chambre.builder()
                .id(0L)
                .numero(1)
                .nbPlace(2)
                .type(TypeChambre.BASIQUE)
                .prix(TypeChambre.BASIQUE.prix)
                .build();

        Chambre ch2 = Chambre.builder()
                .id(0L)
                .numero(35)
                .nbPlace(3)
                .type(TypeChambre.PENTHOUSE)
                .prix(TypeChambre.PENTHOUSE.prix)
                .build();

        Chambre ch3 = Chambre.builder()
                .id(0L)
                .numero(10)
                .nbPlace(3)
                .type(TypeChambre.SUITE)
                .prix(TypeChambre.SUITE.prix)
                .build();
        chRepository.save(ch1);
        chRepository.save(ch2);
        chRepository.save(ch3);
        //endregion
        //region Reservation
        Reservation r1 = Reservation.builder()
                .id(0L)
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(2))
                .dejeune(true)
                .build();
        Reservation r2 = Reservation.builder()
                .id(0L)
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(1))
                .dejeune(false)
                .build();
        Reservation r3 = Reservation.builder()
                .id(0L)
                .dateDebut(LocalDate.now())
                .dateFin(LocalDate.now().plusDays(8))
                .dejeune(true)
                .build();
        rRepository.save(r1);
        rRepository.save(r2);
        rRepository.save(r3);
        //endregion
        //region region
        Utilisateur user1 = new Utilisateur();
        user1.setUsername("user");
        user1.setPassword(encoder.encode("pass"));
        user1.setRoles(List.of("USER"));
        user1.setEnabled(true);
        user1.setAccountNonExpired(true);
        user1.setCredentialsNonExpired(true);
        user1.setAccountNonLocked(true);
        Utilisateur user2 = new Utilisateur();
        user2.setUsername("admin");
        user2.setPassword(encoder.encode("pass"));
        user2.setRoles(List.of("ADMIN", "USER"));
        user2.setEnabled(true);
        user2.setAccountNonExpired(true);
        user2.setCredentialsNonExpired(true);
        user2.setAccountNonLocked(true);
        uReposiroty.save(user1);
        uReposiroty.save(user2);
    }
}
