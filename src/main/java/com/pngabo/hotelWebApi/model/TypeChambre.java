package com.pngabo.hotelWebApi.model;

public enum TypeChambre {
    BASIQUE (100),
    SUITE (350),
    PENTHOUSE (1000);

    double prix;

    TypeChambre(double prix) {
        this.prix = prix;
    }
}
