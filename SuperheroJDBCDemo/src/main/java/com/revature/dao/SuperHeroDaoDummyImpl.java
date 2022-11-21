package com.revature.dao;

import com.revature.model.Superhero;

import java.util.List;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {

    @Override
    public Superhero save(Superhero superhero) {
        // simulate the auto_increment with some arbitrary id value:
        superhero.setId(45);
        return superhero;
    }

    @Override
    public List<Superhero> read() {
        return null;
    }

    @Override
    public Superhero read(int id) {
        return null;
    }

    @Override
    public Superhero update(Superhero superhero) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
