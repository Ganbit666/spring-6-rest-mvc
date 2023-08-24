package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entites.Beer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerNameTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer saveBeer = beerRepository.save(Beer
                    .builder()
                    .beerName("My Beer 01234567890123456789012345678901234567890123456789")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("123456")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer saveBeer = beerRepository.save(Beer
                .builder()
                .beerName("My Beer")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("11.99"))
                .build());

        // Must be. Because test is that fast is not check validation and this force slowing test and them checking validation entity
        beerRepository.flush();

        assertThat(saveBeer).isNotNull();
        assertThat(saveBeer.getId()).isNotNull();
    }
}