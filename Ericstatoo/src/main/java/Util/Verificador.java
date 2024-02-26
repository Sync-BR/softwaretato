/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import static Conexao.ConexaoMysql.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.ClientesBeans;
import Conexao.ConexaoMysql;
import Dao.ClienteDao;
import Dao.ProdutosDao;


public class Verificador {

    public Verificador() {
    }
    
    public static boolean UserVerificado ;
    public static boolean EmailVerificado ;
    public static boolean BuscarCadastro;
    public static boolean UpdateSuceeso = true;
     //Atualizar tela   
    public static void StartUpdateVisual() throws InterruptedException, Exception {
        try {
            new Thread(() -> {
                ClienteDao clientes = new ClienteDao();
                ProdutosDao produtos = new ProdutosDao();
                Calcular starcalculo = new Calcular();
                try {
                    clientes.ListarClientes();
                    produtos.ListarProdutos();
                    starcalculo.CalcularValores();
                    starcalculo.CalcularFaturamento();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
     
     
    //Verificar se o nome do usuario já está registrado
    public static void  VerificarNome(ClientesBeans clientes) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM estudiotatoo.cliente where NomeCompleto = ? ";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clientes.getNomeCompleto());
            rs = ps.executeQuery();
                if(rs.next()){
                    String NomedoUsuario = rs.getString("NomeCompleto");
                    UserVerificado = true;
                } else{
                    UserVerificado = false;
                    System.out.println("nao encontrado");
                      

                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConexaoMysql.closeConnection(conexao, ps,rs);
        }

    }
    //Verificar se o Email já está cadastrado
     public static void  VerificarEmail(ClientesBeans clientes) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM estudiotatoo.cliente where Email = ? ";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clientes.getEmail());
            rs = ps.executeQuery();
                if(rs.next()){
                    String EmailUsuario = rs.getString("Email");
                    EmailVerificado = true;
                } else{
                    EmailVerificado = false;
                    System.out.println("nao encontrado");
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoMysql.closeConnection(conexao, ps, rs);
        }
     }

    
}
