/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Conexao {
      private static Connection conexao;
   private static final String URL_CONEXAO = "jdbc:postgresql://localhost/trabalhorestapi";
   private static final String USUARIO = "postgres";
   private static final String SENHA = "postgres";
   
  public static Connection getConexao(){
      if(conexao == null){
          try {
              Class.forName("org.postgresql.Driver");
              conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return conexao;
  }
  
  public static void fecharConexao(){
    if(conexao != null){
        try {
            conexao.close();
            conexao = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  }
}
