/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;
//Área destinada a configuração do servidor

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class ConexaoMysql {
    //Iniciar uma nova estancia
    public ConexaoMysql() {}
  //     public static Connection conexao = null;
       public static Connection conexao = null;
 public static Connection  getconnection() throws SQLException, Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                 Class.forName("com.mysql.jdbc.Driver");
                return  DriverManager.getConnection("jdbc:mysql://127.0.0.1/estudiotatoo", "root", "");

            } else if(conexao != null){
                conexao.close();
                conexao = null;
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }

        return conexao;
    }

    //Fechar as conexão
    private static void close(Connection conn, Statement stm, ResultSet rs) throws Exception{
        try{
            if(rs != null){
                rs.close();
            } if(stm != null){
                stm.close();
            } if(conn  != null){
                conn.close();
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    // Fechar conexão Statement & Conjunto de resultado do ResultSet
    public static void closeConnection(Connection conn, Statement stm, ResultSet rs) throws Exception{
        close(conn, stm, rs);
    }
    //Fechar um conjunto, sem fechar o resultSet
    public static void closeConnection(Connection conn, Statement stm) throws Exception{
        close(conn, stm, null);
    }
    //Fechar a conexao
    public static void closeConnection (Connection conn) throws Exception{
        close(conn, null, null);
    }

}
