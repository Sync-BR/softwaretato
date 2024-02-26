/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.FaturamentoBeans;


public class FaturamentoDAO {
    public static boolean Sucesso = false;
    public void CadastrarGastos( FaturamentoBeans faturamento) throws Exception{
        PreparedStatement stm = null;
        Connection conn = null;

        try {
            String sql = "INSERT INTO estudiotatoo.despesas(Servico, Data, Valor,Pagamento, Descrição)"
                    + "VALUE (?,?,?,?,?)";
            conn = Conexao.ConexaoMysql.getconnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, faturamento.getServico());
            stm.setDate(2, faturamento.getDataDespesa());
            stm.setFloat(3, faturamento.getValorDespesa());
            stm.setString(4, faturamento.getMetadoPagamento());
            stm.setString(5, faturamento.getDescricao());
            stm.execute();
            Sucesso = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.ConexaoMysql.closeConnection(conn, stm);
            
        }
    
    }
    
}
