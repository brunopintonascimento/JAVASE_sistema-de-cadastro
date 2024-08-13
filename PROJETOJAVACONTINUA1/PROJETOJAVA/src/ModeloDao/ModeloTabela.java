/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bruno
 */
public class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas=null;
    private String[]colunas=null;
    
    public ModeloTabela(ArrayList lin,String [] col){
        setLinhas(lin);
        setColunas(col);
    }

    /**
     * @return the linha
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinhas(ArrayList linha) {
        this.linhas = linha;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
   public int getColumnCount(){
       return colunas.length;
       
   } 
    public int getRowCount(){
        return linhas.size();
        
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
        
        
    }
    public Object getValueAt(int numLin,int numCol){
        Object []linha=(Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
 }
