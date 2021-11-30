package com.reto2.repository.crud;

import com.reto2.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GadgetInterface extends MongoRepository<Gadget, Integer> {

}
