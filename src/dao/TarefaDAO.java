/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.ResultSet;
import model.Tarefa;

/**
 *
 * @author r-r20
 */
public class TarefaDAO {
    private final Connection connection;
    
    public TarefaDAO(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Tarefa tarefa) throws SQLException{
        String sql = "INSERT into tarefa(descricao, data, flag) VALUES(?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tarefa.getDescricao());
        statement.setDate(2, new Date(tarefa.getData().getTime()));
        statement.setBoolean(3, tarefa.isFlag());
        statement.execute();
    }
    
    public void update(Tarefa tarefa) throws SQLException{
        String sql = "UPDATE tarefa set descricao=?, data=? where id=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tarefa.getDescricao());
        statement.setDate(2, new Date(tarefa.getData().getTime()));
        statement.setInt(3, tarefa.getId());
        statement.execute();
    }
    
    public void insertUpdate(Tarefa tarefa) throws SQLException{
        if(tarefa.getId() > 0){
            update(tarefa);
        }else{
            insert(tarefa);
        }
    }
    
    public void delete (Tarefa tarefa) throws SQLException{
        String sql = "DELETE FROM tarefa where id=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tarefa.getId());
        statement.execute();
    }

    private ArrayList<Tarefa> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String Descricao = resultSet.getString("descricao");
            Date data = resultSet.getDate("data");
            boolean flag = resultSet.getBoolean("flag");
            
            Tarefa tarefaBd = new Tarefa(id, Descricao, data, flag);
            tarefas.add(tarefaBd);
        }
        
        return tarefas;
    }
    
    public Tarefa selectById(Tarefa tarefa) throws SQLException{
        String sql = "SELECT * FROM tarefa where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tarefa.getId());
        
        return pesquisa(statement).get(0);
    }
    
    public ArrayList<Tarefa> selectAll() throws SQLException{
        String sql = "SELECT * FROM tarefa";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }
    
    public ArrayList<Tarefa> selectByConcluidos() throws SQLException{
        String sql = "SELECT * FROM tarefa where flag=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setBoolean(1, true);
        
        return pesquisa(statement);
    }
    
    public ArrayList<Tarefa> selectByPendentes() throws SQLException{
        String sql = "SELECT * FROM tarefa where flag=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setBoolean(1, false);
        
        return pesquisa(statement);
    }
}
