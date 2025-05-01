package com.lospapus.apiRestProyect.domain.repository;

import com.lospapus.apiRestProyect.domain.model.Nota;

import java.util.List;

public interface NotaRepository {
    Nota save(Nota nota);
    List<Nota> findAll();
}
