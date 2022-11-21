package com.revature;

import com.revature.dao.SuperHeroDao;
import com.revature.dao.SuperHeroDaoImpl;
import com.revature.model.Superhero;
import com.revature.service.SuperheroService;
import com.revature.util.DaoFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // use -1 as a placeholder for id:

        //save new Superhero
        //Superhero superhero = new Superhero("Superman", "Flying", 15, "Kryptonite", "D", "Krypton");
        //superheroService.save(superhero);

        //update superhero
        //Superhero superhero = new Superhero(1, "Superman", "Flying", 15, "Kryptonite", "D", "Krypton");
        //superheroService.update(superhero);

        //GetById superhero
        SuperheroService superheroService = new SuperheroService(DaoFactory.getSuperHeroDao());
        Superhero superhero = superheroService.getById(1);
        System.out.println(superhero);

        //GetAll superheroes
        List<Superhero> list = superheroService.getAll();
        for (Object hero : list){
            System.out.println(hero);
        }

        //delete a superhero
        //SuperheroService superheroService = new SuperheroService(DaoFactory.getSuperHeroDao());
        //superheroService.delete(1);

    }
}
