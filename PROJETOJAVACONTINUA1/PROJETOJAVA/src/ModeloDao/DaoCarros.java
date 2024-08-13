
package ModeloDao;

import ModeloBeans.BeansCarros;
import ModeloConection.ConectaDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class DaoCarros {
     ConectaDB conecta= new ConectaDB();
    BeansCarros func = new BeansCarros();
    
    
    public void Cadastra(BeansCarros func){
        conecta.Conexao();
        try {
            PreparedStatement pst =conecta.con.prepareStatement("insert into carros(nome_carro,modelo_carro,renavam_carro,placa_carro,chassi_carro,ano_carro,cor_carro,valor_carro)values(?,?,?,?,?,?,?,?)");
            pst.setString(1,func.getNomeCarro());
             pst.setString(2,func.getModeloVeiculos());
               pst.setInt(3,func.getRenavamVeiculos());
                pst.setInt(4,func.getPlacaVeiculos());
                pst.setInt(5,func.getChassiVeiculos());
                 pst.setInt(6,func.getAnoVeiculos());
                   pst.setString(7,func.getCorVeiculos());
                    pst.setInt(8,func.getValorFIPEVeiculos());
                     
                     pst.execute();
                     JOptionPane.showMessageDialog(null,"Dados cadastrados com sucesso!!");
        } catch (SQLException ex) {
         //   JOptionPane.showMessageDialog(null,"Erro ao inserir dados!!\nErro:"+ex);        }
        conecta.desconecta();
        }
    }
    public BeansCarros buscaCarros(BeansCarros func){
        conecta.Conexao();
        conecta.executaSql("select * from carros where nome_carro like'%"+func.getPesquisaCarros()+"%'");
        try {
            conecta.rs.first();
            func.setMatriculaCarro(conecta.rs.getInt("cod_carro"));
            func.setNomeCarro(conecta.rs.getString("nome_carro"));
            func.setModeloVeiculos(conecta.rs.getString("modelo_carro"));
            func.setRenavamVeiculos(conecta.rs.getInt("renavam_carro"));
            func.setPlacaVeiculos(conecta.rs.getInt("placa_carro"));
            func.setChassiVeiculos(conecta.rs.getInt("chassi_carro"));
            func.setAnoVeiculos(conecta.rs.getInt("ano_carro"));
            func.setCorVeiculos(conecta.rs.getString("cor_carro"));
            func.setValorFIPEVeiculos(conecta.rs.getInt("valor_carro"));
        } catch (SQLException ex) {
          // JOptionPane.showMessageDialog(null,"Erro ao buscar!!\nErro:"+ex); 
        }
        
        
        
        conecta.desconecta();
        return func;
    } 
    
        public void Editar(BeansCarros func){
            conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("update carros set nome_carro=?,"
                    + "modelo_carro=?,renavam_carro=?,placa_carro=?,chassi_carro=?,ano_carro=?,cor_carro=?,valor_carro=?where cod_carro=?");
       pst.setString(1,func.getNomeCarro());
         pst.setString(2,func.getModeloVeiculos());
               pst.setInt(3,func.getRenavamVeiculos());
                pst.setInt(4,func.getPlacaVeiculos());
                pst.setInt(5,func.getChassiVeiculos());
                 pst.setInt(6,func.getAnoVeiculos());
                   pst.setString(7,func.getCorVeiculos());
                   pst.setInt(8,func.getValorFIPEVeiculos());
                 
                    
                      pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Alterado  com sucesso!");         
                     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não  Alterado !!/nErro:"+ex);
        }
            conecta.desconecta();
        }
              public void Excluir(BeansCarros func){
          conecta.Conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("delete from carros where cod_carro=?");
            pst.setInt(1,func.getMatriculaCarro());
            pst.execute();
             JOptionPane.showMessageDialog(null,"Dados Excluidos com sucesso !"); 
        } catch (SQLException ex) {
       //  JOptionPane.showMessageDialog(null,"Erro ao Excluir!!/nErro:"+ex);        }
          
          conecta.desconecta();
      }
              }
}
