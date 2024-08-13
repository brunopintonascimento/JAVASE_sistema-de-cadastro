/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloBeans.BeansFuncionario;
import ModeloBeans.BeansUsuario;
import ModeloConection.ConectaDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class DaoUsuario {
    ConectaDB conecta= new ConectaDB();
    BeansUsuario func = new BeansUsuario();
    
    public void Cadastra(BeansUsuario func){
        conecta.Conexao();
        try {
            PreparedStatement pst =conecta.con.prepareStatement("insert into usuario (usu_nome,usu_profissao,usu_rg,"
                    + "usu_sexo,usu_cpf,usu_cel,usu_tel,usu_endereco,usu_numero,usu_cep,usu_cidade,usu_bairro,usu_nascimento,usu_salario)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,func.getUsuNome());
             pst.setString(2,func.getUsuProfissao());
               pst.setInt(3,func.getUsuRg());
                pst.setString(4,func.getUsuSexo());
                pst.setInt(5,func.getUsuCpf());
                 pst.setInt(6,func.getUsuCel());
                   pst.setInt(7,func.getUsuTel());
                    pst.setString(8,func.getUsuEndereco());
                     pst.setInt(9,func.getUsuNumero());
                     pst.setInt(10,func.getUsuCep());
                     pst.setString(11,func.getUsuCidade());
                     pst.setString(12,func.getUsuBairro());
                     pst.setInt(13,func.getUsuNascimento());
                     pst.setInt(14,func.getUsuSalario());
                    
                     pst.execute();
                     JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados!!\nErro:"+ex);        }
        conecta.desconecta();
        
      
    
    
    }
    public BeansUsuario buscaUsuario(BeansUsuario func){
        conecta.Conexao();
        conecta.executaSql("select * from usuario where usu_nome like'%"+func.getPesquisaUser()+"%'");
        try {
            conecta.rs.first();
            func.setUsuNome(conecta.rs.getString("usu_nome"));
            func.setUsuProfissao(conecta.rs.getString("usu_profissao"));
            func.setUsuRg(conecta.rs.getInt("usu_rg"));
            func.setUsuSexo(conecta.rs.getString("usu_sexo"));
            func.setUsuCpf(conecta.rs.getInt("usu_cpf"));
            func.setUsuCel(conecta.rs.getInt("usu_cel"));
            func.setUsuTel(conecta.rs.getInt("usu_tel"));
            func.setUsuEndereco(conecta.rs.getString("usu_endereco"));
            func.setUsuNumero(conecta.rs.getInt("usu_numero"));
            func.setUsuCep(conecta.rs.getInt("usu_cep"));
            func.setUsuCidade(conecta.rs.getString("usu_cidade"));
            func.setUsuBairro(conecta.rs.getString("usu_bairro"));
            func.setUsuNascimento(conecta.rs.getInt("usu_nascimento"));
            func.setUsuSalario(conecta.rs.getInt("usu_salario"));
            func.setUsuCod(conecta.rs.getInt("usu_cod"));
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar!!\nErro:"+ex); 
        }
        
        
        
        conecta.desconecta();
        return func;
        
        
    }
    public void Editar(BeansUsuario func){
            conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("update usuario set usu_nome=?,"
                    + "usu_profissao=?,usu_rg=?,usu_sexo=?,usu_cpf =?,usu_cel=?,usu_tel=?,usu_endereco =?,usu_numero=?,usu_cep=?,usu_cidade=?,usu_bairro=?,usu_nascimento=?,usu_salario=?where usu_cod=?");
       pst.setString(1,func.getUsuNome());
         pst.setString(2,func.getUsuProfissao());
               pst.setInt(3,func.getUsuRg());
                pst.setString(4,func.getUsuSexo());
                pst.setInt(5,func.getUsuCpf());
                 pst.setInt(6,func.getUsuCel());
                   pst.setInt(7,func.getUsuTel());
                   pst.setInt(8,func.getUsuTel());
                     pst.setString(9,func.getUsuEndereco());
                     pst.setInt(10,func.getUsuNumero());
                     pst.setInt(11,func.getUsuCep());
                     pst.setString(12,func.getUsuCidade());
                     pst.setString(13,func.getUsuBairro());
                     pst.setInt(14,func.getUsuNascimento());
                     pst.setInt(15,func.getUsuSalario());
                     
                      pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Alterado  com sucesso!");         
                     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não  Alterado !!/nErro:"+ex);
        }
            conecta.desconecta();
        }
      public void Excluir(BeansUsuario func){
          conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("delete from funcionario where matricula_funcionario=?");
            pst.setInt(1,func.getUsuCod());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Excluidos com sucesso !"); 
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Erro ao Excluir!!/nErro:"+ex);        }
          
          conecta.desconecta();
      }
}