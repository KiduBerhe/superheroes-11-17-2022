package com.revature.dao;

import com.revature.model.Superhero;

import java.util.List;

public interface SuperHeroDao {
    // CRUD:
    Superhero save(Superhero superhero);

    List<Superhero> read();

    Superhero read(int id);

    Superhero update(Superhero superhero);

    void delete(int id);
}
