package com.pngabo.hotelWebApi.services;

import java.util.List;

public interface serviceCRUD<Entity, Form, ID>{
    List<Entity> getAll();
    Entity getOne(ID id);
    Entity insert(Form form);
    Entity delete(ID id);
    Entity update(Form form);
}
