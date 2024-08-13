package ModeloConection;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConectaDB {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho= "jdbc:postgresql://localhost:5432/lojacadastro";
    private String usuario="postgres";
    private String senha ="21011986";
    public Connection con ;
    
    public void  Conexao(){
       
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario,senha);
           //JOptionPane.showMessageDialog(null,"conectado com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar no Banco de dados:\n"+ex.getMessage());
        }
    
                
        
    }
      public void executaSql(String sql){
        try {
            stm =con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql);
     

            
        } catch (SQLException ex) {
          //  JOptionPane.showMessageDialog(null,"Erro de  executa sql:\n"+ex.getMessage());
        }
          
          
          
      }
    public void desconecta(){
        try {
            con.close();
         //   JOptionPane.showMessageDialog(null,"desconectado com sucesso!!!");
        } catch (SQLException ex) {
        //  JOptionPane.showMessageDialog(null,"Erro ao fechar banco de dados!!!\n"+ex.getMessage());
        }
    }
}

         

