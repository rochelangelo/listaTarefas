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
import javax.swing.table.DefaultTableModel;
import model.Tarefa;
import view.InicioView;

/**
 *
 * @author r-r20
 */
public class TabelaController {
    private final InicioView view;

    public TabelaController(InicioView view) {
        this.view = view;
    }
    
    

    void preencheTab(ArrayList<Tarefa> tarefas) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaTodos().getModel();
        tableModel.setNumRows(0);
        
        for(Tarefa tarefa : tarefas){
            tableModel.addRow(new Object[]{
                tarefa.getDescricao(),
                tarefa.getData(),
                tarefa.isSituacao()
                
            });
        }
    }
    
    void preencherTabConcluidos(ArrayList<Tarefa> tarefas){
        DefaultTableModel tableModelcon = (DefaultTableModel) view.getTabelaConcluidos().getModel();
        tableModelcon.setNumRows(0);
        
        for(Tarefa tarefa : tarefas){
            tableModelcon.addRow(new Object[]{
                tarefa.getDescricao(),
                tarefa.getData()
            });
        }
    }
    
    void preencherTabPendentes(ArrayList<Tarefa> tarefas){
        DefaultTableModel tableModelpen = (DefaultTableModel) view.getTabelaPendentes().getModel();
        tableModelpen.setNumRows(0);
        
        for(Tarefa tarefa : tarefas){
            tableModelpen.addRow(new Object[]{
                tarefa.getDescricao(),
                tarefa.getData()
            });
        }
    }
    
    void deletarItem(int id){
        
    }
}
