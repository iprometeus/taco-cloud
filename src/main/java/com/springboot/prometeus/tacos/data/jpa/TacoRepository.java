package com.springboot.prometeus.tacos.data.jpa;

import com.springboot.prometeus.tacos.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}