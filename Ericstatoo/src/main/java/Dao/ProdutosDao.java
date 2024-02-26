/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import static Conexao.ConexaoMysql.conexao;
import static Util.Calcular.CancelarCalculos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.ProdutosBeans;
import Conexao.ConexaoMysql;
import Tela.Programa;
import Util.Calcular;
import Util.Verificador;

/**
 *
 * @author Eduar
 */
public class ProdutosDao {
    public static boolean ProdutoCadastrado = false;
    //Cadastrar Produtos
    public void CadastrarProdutos(ProdutosBeans produtos) throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO estudiotatoo.produtos (ProdutoNome, ProdutoCategoria, ProdutoMarcar, ProdutoDescricao, CodigoBarras,"
                    + "ProdutoPreco, ProdutoEstoque,Validade, ProdutoObservacao)"
                    + "VALUE (?,?,?,?,?,?,?,?,?)";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, produtos.getProdutoNome());
            ps.setString(2, produtos.getProdutoCategoria());
            ps.setString(3, produtos.getProdutoMarcar());
            ps.setString(4, produtos.getProdutoDescricao());
            ps.setLong(5, produtos.getProdutoCodigoBarras());
            ps.setFloat(6, produtos.getProdutopreco());
            ps.setInt(7, produtos.getProdutoEstoque());
            ps.setDate(8, produtos.getProdutoValidade());
            ps.setString(9, produtos.getProdutoObservacao());
            int Produtocadastrado = ps.executeUpdate();
            if (Produtocadastrado > 0) {
                ProdutoCadastrado = true;
                Calcular.ValorAtualizado = true;
                CancelarCalculos = true;
                
            } else {
                ProdutoCadastrado = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conexao, ps);
        }
        
    }
    
    //Pesquisar um produto
    public static boolean PesquisarSucesso;
    public void PesquisarProduto(ProdutosBeans produtos) throws Exception{
        ProdutosBeans addprodutos = new ProdutosBeans();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConexaoMysql.getconnection();
            String sql = "SELECT * FROM estudiotatoo.produtos WHERE ProdutoNome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produtos.getProdutoNome());
            rs = ps.executeQuery();
            if(rs.next()){
                //Receber Resultado da consulta
                System.out.println("encontrado");
                PesquisarSucesso = true;
                String ProdutoNome = rs.getString("ProdutoNome");
                String ProdutoCategoria = rs.getString("ProdutoCategoria");
                String ProdutoMarca = rs.getString("ProdutoMarcar");
                String ProtudoDescricao = rs.getString("ProdutoDescricao");
                long ProdutoCodigo = rs.getLong("CodigoBarras");
                float ProdutoPreco = rs.getFloat("ProdutoPreco");
                int ProdutoEstoque = rs.getInt("ProdutoEstoque");
                Date ProdutoValidade = rs.getDate("Validade");
                String ProdutoObservacao = rs.getString("ProdutoObservacao");
                // Adicionar os dados no impult
                produtos.setProdutoNome(ProdutoNome);
                produtos.setProdutoCategoria(ProdutoCategoria);
                produtos.setProdutoMarcar(ProdutoMarca);
                produtos.setProdutoDescricao(ProtudoDescricao);
                produtos.setProdutoCodigoBarras(ProdutoCodigo);
                produtos.setProdutopreco(ProdutoPreco);
                produtos.setProdutoEstoque(ProdutoEstoque);
                produtos.setProdutoValidade(ProdutoValidade);
                produtos.setProdutoObservacao(ProdutoObservacao);
            } else{
                PesquisarSucesso = false;
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoMysql.closeConnection(conexao, ps,rs);
        }
        
    }

    //Atualizar Produtos
    public static boolean AtualizadoSucesso;
    public void AtualizarProdutos(ProdutosBeans produtos) throws  Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoMysql.getconnection();
            String sql = "UPDATE estudiotatoo.produtos SET ProdutoCategoria = ?,ProdutoMarcar = ?, "
                    + "ProdutoDescricao = ?, CodigoBarras =?, ProdutoPreco = ?, ProdutoEstoque = ?, Validade = ?,"
                    + "ProdutoObservacao = ? WHERE ProdutoNome =? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produtos.getProdutoCategoria());
            ps.setString(2, produtos.getProdutoMarcar());
            ps.setString(3, produtos.getProdutoDescricao());
            ps.setLong(4, produtos.getProdutoCodigoBarras());
            ps.setFloat(5, produtos.getProdutopreco());
            ps.setInt(6, produtos.getProdutoEstoque());
            ps.setDate(7, produtos.getProdutoValidade());
            ps.setString(8, produtos.getProdutoObservacao());
            ps.setString(9, produtos.getProdutoNome());
            int ProdutoUpdate = ps.executeUpdate();
            if(ProdutoUpdate > 0){
                Calcular.ProdutosEncontrado = true;
                Verificador.StartUpdateVisual();
                AtualizadoSucesso = true;
            } else{
                AtualizadoSucesso = false;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conexao, ps);
        }

    }

    //Apagar do banco de dados
    public static boolean ProdutoDeleted;
    public void DeletarProduto(ProdutosBeans produtos) throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoMysql.getconnection();
            String sql = "DELETE FROM estudiotatoo.produtos where ProdutoNome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, produtos.getProdutoNome());
            int ProdutoDeletado = ps.executeUpdate();
            if (ProdutoDeletado > 0) {
                ProdutoDeleted = true;
                 Programa.atualizado = true;
                 CancelarCalculos = true;
                 Calcular.CalcularValores();
            } else {
                ProdutoDeleted = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conexao, ps);
        }

    }
    
    public static void  ListarProdutos() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> ListadeProdutos = new ArrayList<>();
            try {
                String sql = "SELECT * FROM estudiotatoo.produtos";
                conn = ConexaoMysql.getconnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                    while (rs.next()) {                    
                        String ProdutoNome = rs.getString("ProdutoNome");
                        ListadeProdutos.add(ProdutoNome);
                    }
                    
                     Programa.atualizado = true;
                    Programa.ConterProdutos.setText(""+ListadeProdutos.size());
                    
                    
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                ConexaoMysql.closeConnection(conexao, ps,rs);
            }
        
        
    }


}
