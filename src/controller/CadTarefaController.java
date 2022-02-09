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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Tarefa;
import view.FormCadTarefaView;
import view.InicioView;

/**
 *
 * @author r-r20
 */
public class CadTarefaController {
    private FormCadTarefaView view;
    private InicioView viewIncio;

    public CadTarefaController(FormCadTarefaView view, InicioView viewInicio) {
        this.view = view;
        this.viewIncio = viewInicio;
    }
    
    public void inserir() throws ParseException{
        String descricao = view.getTxtDescricacao().getText();
        String data = view.getTxtData().getText();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        
        Tarefa novaTarefa = new Tarefa(descricao, dataFormatada, false);
        
        try {
            Connection conexao = new Conexao().getConnection();
            TarefaDAO tarefaDAO = new TarefaDAO(conexao);
            tarefaDAO.insert(novaTarefa);
            view.setVisible(false);
            JOptionPane.showMessageDialog(view, "Tarefa Cadastrada");
            viewIncio.atualizaTabs();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Tarefa não Cadastrada");
        }
    }
}
