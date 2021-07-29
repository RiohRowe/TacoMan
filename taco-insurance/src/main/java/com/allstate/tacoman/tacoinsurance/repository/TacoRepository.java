package com.allstate.tacoman.tacoinsurance.repository;

import com.allstate.tacoman.tacoinsurance.dao.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
}
