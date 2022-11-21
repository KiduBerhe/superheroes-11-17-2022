package com.revature.dao;

import com.revature.model.Superhero;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "insert into superheroes values(default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return superhero;
    }

    @Override
    public List<Superhero> read() {
        List<Superhero> superheroes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM superheroes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Superhero superhero = new Superhero();
                superhero.setId(resultSet.getInt("id"));
                superhero.setSuperhero_name(resultSet.getString("superhero_name"));
                superhero.setSuper_power(resultSet.getString("super_power"));
                superhero.setStrength(resultSet.getInt("strength"));
                superhero.setWeakness(resultSet.getString("weakness"));
                superhero.setFranchise(resultSet.getString("franchise"));
                superhero.setWorld(resultSet.getString("world"));

                superheroes.add(superhero);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return superheroes;
    }

    @Override
    public Superhero read(int id) {
        Superhero superhero = new Superhero();
        try {
            String sql = "SELECT * FROM superheroes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                superhero.setId(resultSet.getInt("id"));
                superhero.setSuperhero_name(resultSet.getString("superhero_name"));
                superhero.setSuper_power(resultSet.getString("super_power"));
                superhero.setStrength(resultSet.getInt("strength"));
                superhero.setWeakness(resultSet.getString("weakness"));
                superhero.setFranchise(resultSet.getString("franchise"));
                superhero.setWorld(resultSet.getString("world"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return superhero;
    }

    public Superhero getByStrength(int strength) {
        Superhero superhero = new Superhero();
        try {
            String sql = "SELECT * FROM superheroes WHERE strength = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, strength);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                superhero.setId(resultSet.getInt("id"));
                superhero.setSuperhero_name(resultSet.getString("superhero_name"));
                superhero.setSuper_power(resultSet.getString("super_power"));
                superhero.setStrength(resultSet.getInt("strength"));
                superhero.setWeakness(resultSet.getString("weakness"));
                superhero.setFranchise(resultSet.getString("franchise"));
                superhero.setWorld(resultSet.getString("world"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return superhero;
    }

    public Superhero getByPower(String power) {
        Superhero superhero = new Superhero();
        try {
            String sql = "SELECT * FROM superheroes WHERE super_power = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "super_power");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                superhero.setId(resultSet.getInt("id"));
                superhero.setSuperhero_name(resultSet.getString("superhero_name"));
                superhero.setSuper_power(resultSet.getString("super_power"));
                superhero.setStrength(resultSet.getInt("strength"));
                superhero.setWeakness(resultSet.getString("weakness"));
                superhero.setFranchise(resultSet.getString("franchise"));
                superhero.setWorld(resultSet.getString("world"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return superhero;
    }

    @Override
    public Superhero update(Superhero superhero) {
        try {
            String sql = "UPDATE superheroes SET superhero_name = ?, super_power = ?, strength = ?, weakness = ?, franchise = ?, world = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, superhero.getSuperhero_name());
            statement.setString(2, superhero.getSuper_power());
            statement.setInt(3, superhero.getStrength());
            statement.setString(4, superhero.getWeakness());
            statement.setString(5, superhero.getFranchise());
            statement.setString(6, superhero.getWorld());
            statement.setInt(7, superhero.getId());

            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return superhero;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM superheroes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}
