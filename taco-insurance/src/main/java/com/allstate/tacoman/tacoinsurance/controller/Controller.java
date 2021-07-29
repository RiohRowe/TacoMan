package com.allstate.tacoman.tacoinsurance.controller;

import com.allstate.tacoman.tacoinsurance.dao.Taco;
import com.allstate.tacoman.tacoinsurance.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TacoService tacoService;

    @PostMapping("taco/create/single")
    public Taco createTaco(@RequestBody Taco taco) {
        return tacoService.createTaco(taco);
    }

    @PostMapping("taco/create/many")
    public List<Taco> createTacos(@RequestBody List<Taco> tacos) {
        return tacoService.createTacos(tacos);
    }

    @GetMapping("taco/getall")
    public List<Taco> getAllTacos() {
        return tacoService.getAllTacos();
    }
}
