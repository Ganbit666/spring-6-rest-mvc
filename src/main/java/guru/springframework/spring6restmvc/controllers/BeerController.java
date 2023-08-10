package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
@RestController
public class BeerController {
    private final BeerServices bearServices;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers(){
        return bearServices.listBeers();
    }

    public Beer getBeerById(UUID id){

        log.debug("Get Beer by Id - in controller");

        return bearServices.getBeerById(id);
    }
}
