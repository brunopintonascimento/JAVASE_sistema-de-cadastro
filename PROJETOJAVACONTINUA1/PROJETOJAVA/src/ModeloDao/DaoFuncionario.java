/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConectaDB;
import ModeloBeans.BeansFuncionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class DaoFuncionario {
    ConectaDB conecta= new ConectaDB();
    BeansFuncionario func = new BeansFuncionario();
    
    public void Cadastra(BeansFuncionario func){
        conecta.Conexao();
        try {
            PreparedStatement pst =conecta.con.prepareStatement("insert into funcionario(nome_funcionario,cargo_funcionario,sexo_funcionario,"
       + "cpf_funcionario,rg_funcionario,cel_funcionario,tel_funcionario,login_funcionario,senha_funcionario)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,func.getNome());
             pst.setString(2,func.getCargo());
               pst.setString(3,func.getSexo());
                pst.setString(4,func.getLogin());
                pst.setInt(5,func.getCEL());
                 pst.setInt(6,func.getCPF());
                   pst.setInt(7,func.getRG());
                    pst.setInt(8,func.getTEL());
                     pst.setInt(9,func.getSenha());
                     pst.execute();
                     JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados!!\nErro:"+ex);        }
        conecta.desconecta();
        
      
    
}
    public BeansFuncionario buscaFuncionario(BeansFuncionario func){
        conecta.Conexao();
        conecta.executaSql("select * from funcionario where nome_funcionario like'%"+func.getPesquisa()+"%'");
        try {
            conecta.rs.first();
            func.setMatricula(conecta.rs.getInt("matricula_funcionario"));
            func.setNome(conecta.rs.getString("nome_funcionario"));
            func.setCPF(conecta.rs.getInt("cpf_funcionario"));
            func.setRG(conecta.rs.getInt("rg_funcionario"));
            func.setTEL(conecta.rs.getInt("tel_funcionario"));
            func.setCEL(conecta.rs.getInt("cel_funcionario"));
            func.setSenha(conecta.rs.getInt("senha_funcionario"));
            func.setCargo(conecta.rs.getString("cargo_funcionario"));
            func.setSexo(conecta.rs.getString("sexo_funcionario"));
            func.setLogin(conecta.rs.getString("login_funcionario"));
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar!!\nErro:"+ex); 
        }
        
        
        
        conecta.desconecta();
        return func;
        
        
    }
      public void Editar(BeansFuncionario func){
            conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("update funcionario set nome_funcionario=?,"
                    + "cargo_funcionario=?,login_funcionario=?,sexo_funcionario=?,cpf_funcionario =?,cel_funcionario=?,tel_funcionario=?,rg_funcionario =?,senha_funcionario=?where matricula_funcionario=?");
       pst.setString(1,func.getNome());
         pst.setString(2,func.getCargo());
               pst.setString(3,func.getSexo());
                pst.setString(4,func.getLogin());
                pst.setInt(5,func.getCEL());
                 pst.setInt(6,func.getCPF());
                   pst.setInt(7,func.getRG());
                   pst.setInt(8,func.getTEL());
                     pst.setInt(9,func.getSenha());
                     pst.setInt(10,func.getMatricula());
                      pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Alterado  com sucesso!");         
                     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não  Alterado !!/nErro:"+ex);
        }
            conecta.desconecta();
        }
      public void Excluir(BeansFuncionario func){
          conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("delete from funcionario where matricula_funcionario=?");
            pst.setInt(1,func.getMatricula());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Excluidos com sucesso !"); 
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Erro ao Excluir!!/nErro:"+ex);        }
          
          conecta.desconecta();
      }
}
