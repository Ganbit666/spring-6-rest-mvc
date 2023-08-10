package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BearServicesImpl implements BearServices {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by Id - is service. Id: " + id.toString());

        return Beer.builder()
                .id(id)
                .version(1)
                .bearName("Galaxy Cat")
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createData(LocalDateTime.now())
                .updateData(LocalDateTime.now())
                .build();
    }
}
