package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerServices {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID id, Beer beer);

    void deleteById(UUID id);

    void patchBeerById(UUID beerId, Beer beer);
}
