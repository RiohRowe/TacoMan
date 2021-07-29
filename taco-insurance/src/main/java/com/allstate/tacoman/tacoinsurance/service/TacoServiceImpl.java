package com.allstate.tacoman.tacoinsurance.service;

import com.allstate.tacoman.tacoinsurance.dao.Taco;
import com.allstate.tacoman.tacoinsurance.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TacoServiceImpl implements TacoService{
    @Autowired
    private TacoRepository tacoRepo;


    @Override
    public Taco createTaco(Taco taco) {
        return tacoRepo.save(taco);
    }

    @Override
    public List<Taco> createTacos(List<Taco> tacos) {
       return tacoRepo.saveAll(tacos);
    }

    @Override
    public List<Taco> getAllTacos() {
        return tacoRepo.findAll(Sort.by("name"));
    }

    @Override
    public Taco getById(Long id) throws InstanceNotFoundException {
        Optional<Taco> optionalTaco = tacoRepo.findById(id);
        if(optionalTaco.isPresent()) {
            return optionalTaco.get();
        }
        else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public void deleteById(Long id) {
        tacoRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tacoRepo.deleteAll();
    }
}
