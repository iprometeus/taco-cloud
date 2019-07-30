package com.springboot.prometeus.tacos.data;

import com.springboot.prometeus.tacos.domain.Taco;

public interface TacoRepository {

    Taco save(Taco design);
}