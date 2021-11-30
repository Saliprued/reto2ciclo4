package com.reto2.service;

import com.reto2.model.Gadget;
import com.reto2.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository repository;

    public List<Gadget> getAll() {
        return repository.getAll();
    }

    public Optional<Gadget> getGadget(Integer id) {
        return repository.getGadget(id);
    }

    public Gadget create(Gadget accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Gadget update(Gadget accesory) {

        if (accesory.getId() != null) {
            Optional<Gadget> accesoryDb = repository.getGadget(accesory.getId());
            if (accesoryDb.isPresent()) {

                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }

                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }

                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }

                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }

                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getGadget(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
