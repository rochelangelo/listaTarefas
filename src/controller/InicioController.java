/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.TarefaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Tarefa;
import view.InicioView;

/**
 *
 * @author r-r20
 */
public class InicioController {
    
    private final InicioView view;
    private final TabelaController controller;

    public InicioController(InicioView view) {
        this.view = view;
        this.controller = new TabelaController(view);
    }
    
    public void atualizaTabTodos() throws SQLException{
        Connection conexao = new Conexao().getConnection();
        TarefaDAO tarefaDAO = new TarefaDAO(conexao);
        
        ArrayList<Tarefa> tarefas = tarefaDAO.selectAll();
        
        controller.preencheTab(tarefas);
    }
    
    public void atualizaTabConcluidos() throws SQLException{
        Connection conexao = new Conexao().getConnection();
        TarefaDAO tarefaDAO = new TarefaDAO(conexao);
        
        ArrayList<Tarefa> tarefas = tarefaDAO.selectByConcluidos();
        controller.preencherTabConcluidos(tarefas);
    }
    
    public void atualizaTabPendentes() throws SQLException{
        Connection conexao = new Conexao().getConnection();
        TarefaDAO tarefaDAO = new TarefaDAO(conexao);
        
        ArrayList<Tarefa> tarefas = tarefaDAO.selectByPendentes();
        
        controller.preencherTabPendentes(tarefas);
    }
    
    
}
