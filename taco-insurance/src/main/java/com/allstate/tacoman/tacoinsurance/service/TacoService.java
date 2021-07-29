package com.allstate.tacoman.tacoinsurance.service;

import com.allstate.tacoman.tacoinsurance.dao.Taco;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface TacoService {

    public Taco createTaco(Taco taco);
    public List<Taco> createTacos(List<Taco> tacos);
    public List<Taco> getAllTacos();
    public Taco getById(Long id) throws InstanceNotFoundException;
    public void deleteById(Long id);
    public void deleteAll();
}
