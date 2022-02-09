/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author r-r20
 */
public class Tarefa {
    
    private int id;
    private String descricao;
    private Date data;
    private boolean flag;

    public Tarefa(int id, String descricao, Date data, boolean flag) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.flag = flag;
    }

    public Tarefa(String descricao, Date data, boolean flag) {
        this.descricao = descricao;
        this.data = data;
        this.flag = flag;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public String isSituacao(){
        if(flag){
            return "CONCLUIDO";
        }else{
            return "PENDENTE";
        }
    }
    
    
    
}
