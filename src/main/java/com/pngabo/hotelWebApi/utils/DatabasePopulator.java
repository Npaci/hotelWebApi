package com.pngabo.hotelWebApi.utils;

import com.pngabo.hotelWebApi.model.entities.Client;
import com.pngabo.hotelWebApi.repositories.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator implements InitializingBean {
    private ClientRepository repository;

    public DatabasePopulator(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ICI");
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
        repository.save(c1);
        repository.save(c2);
    }
}
