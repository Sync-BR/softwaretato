/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.ClientesBeans;
import Conexao.ConexaoMysql;
import Tela.Programa;
import Telas.Clientes.PesquisarClientes;
import Util.Verificador;

public class ClienteDao {
    //Inserir dados
    public void CadastrarCliente(ClientesBeans clientes) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO estudiotatoo.cliente (NomeCompleto, DataNascimento, Genero, Telefone,Celular, Whatsapp,Email,Rua, Cidade,Estado,Cep,Numero )" 
                    + "VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clientes.getNomeCompleto());
            ps.setString(2, clientes.getDatanascimento().toString());
            ps.setString(3, clientes.getGenero());
            ps.setString(4, clientes.getTelefone());
            ps.setString(5, clientes.getCelular());
            ps.setString(6, clientes.getWhatsapp());
            ps.setString(7, clientes.getEmail());
            ps.setString(8, clientes.getRua());
            ps.setString(9, clientes.getCidade());
            ps.setString(10, clientes.getEstado());
            ps.setString(11, clientes.getCep());
            ps.setString(12, clientes.getNumerodacasa());
            Verificador.VerificarNome(clientes);
            Verificador.VerificarEmail(clientes);
             //Verificar se o usuario já existe no banco de dados
                if(Verificador.EmailVerificado == false && Verificador.UserVerificado == false ){
                
                    int inseridosucesso = ps.executeUpdate();
                    if (inseridosucesso > 0) {
                        Programa.atualizado = true;
                       
                    } else {
                        System.out.println("falhou");
                    }
                
                }
 
                 
           
        } catch (SQLException es) {
            es.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conn, ps);
        }

    }

    //Pesquisar Usuario
    public boolean  sexo;
    public void PesquisarClientes(ClientesBeans clientes) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM estudiotatoo.cliente WHERE NomeCompleto = ? ";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, clientes.getNomeCompleto().toUpperCase());
            rs = ps.executeQuery();
            if (rs.next()) {
                //Guardando os valores na variavel
                ClientesBeans ClientesAdd = new ClientesBeans();
                ClientesAdd.setNomeCompleto(rs.getString("NomeCompleto"));
                ClientesAdd.setDatanascimento(rs.getDate("DataNascimento"));
                //Recebendo o genero do usuario
                ClientesAdd.setGenero(rs.getString("Genero"));
                ClientesAdd.setTelefone(rs.getString("Telefone"));
                ClientesAdd.setCelular(rs.getString("Celular"));
                ClientesAdd.setWhatsapp(rs.getString("Whatsapp"));
                ClientesAdd.setEmail(rs.getString("Email"));
                ClientesAdd.setRua(rs.getString("Rua"));
                ClientesAdd.setEstado(rs.getString("Estado"));
                ClientesAdd.setCidade(rs.getString("Cidade"));
                ClientesAdd.setCep(rs.getString("Cep"));
                ClientesAdd.setNumerodacasa(rs.getString("Numero"));

                //Adicionar as informações na tela de pesquisar cliente
                PesquisarClientes.txtNome.setText(ClientesAdd.getNomeCompleto());
                PesquisarClientes.txtData.setText(ClientesAdd.getDatanascimento().toString());
                PesquisarClientes.TxtGenero.setSelectedItem(ClientesAdd.getGenero());
                PesquisarClientes.txtCelular.setText(ClientesAdd.getCelular());
                PesquisarClientes.TxtTelefone.setText(ClientesAdd.getTelefone());
                PesquisarClientes.TxtWhatsapp.setText(ClientesAdd.getWhatsapp());
                PesquisarClientes.txtEmail.setText(ClientesAdd.getEmail());
                PesquisarClientes.txtRua.setText(ClientesAdd.getRua());
                PesquisarClientes.txtEstado.setSelectedItem(ClientesAdd.getEstado());
                PesquisarClientes.txtEndereco.setText(ClientesAdd.getCidade());
                PesquisarClientes.txtCep.setText(ClientesAdd.getCep());
                PesquisarClientes.txtNumerocasa.setText(ClientesAdd.getNumerodacasa());
                //Confirmando que a busca foi encontrada
                Verificador.BuscarCadastro = true;
            } else {
                Verificador.BuscarCadastro = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoMysql.closeConnection(conn, ps,rs);
        }
    
    }
 
    
    
    //Atualizar dados
    public static boolean updatesucesso;
    public void AtualizarClientes(ClientesBeans clientes) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
            try {
                conn = ConexaoMysql.getconnection();
                String sql = "UPDATE estudiotatoo.cliente SET DataNascimento = ?, Genero = ?, Telefone =?, Celular =?,Whatsapp =?, Email=?, "
                        + "Rua=? ,Estado =?,"
                        + "Cidade =?, Cep =?, Numero =? WHERE NomeCompleto = ?  " ;
                  ps = conn.prepareStatement(sql);
                  //Inserindo dados para efetuar update
                  ps.setString(1, clientes.getDatanascimento().toString());
                  ps.setString(2, clientes.getGenero());
                  ps.setString(3, clientes.getTelefone());
                  ps.setString(4,clientes.getCelular());
                  ps.setString(5, clientes.getWhatsapp());
                  ps.setString(6, clientes.getEmail());
                  ps.setString(7, clientes.getRua());
                  ps.setString(8, clientes.getEstado());
                  ps.setString(9, clientes.getCidade());
                  ps.setString(10, clientes.getCep());
                  ps.setInt(11, Integer.parseInt(clientes.getNumerodacasa()));
                  ps.setString(12, clientes.getNomeCompleto());
                  int StatusUpdate = ps.executeUpdate() ;
                    if(StatusUpdate > 0){
                        updatesucesso = true;
                    } else{
                        updatesucesso = false;
                    }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e+"");
            } finally{
                ConexaoMysql.closeConnection(conn, ps);
            }
    }
    //Apagar do banco de dados
    public static boolean ClienteDeletado;
    public void DeletarClientes(ClientesBeans clientes) throws ClassNotFoundException, Exception{
        Connection conn = null;
        PreparedStatement ps = null;
         try {
             String sql = "DELETE FROM estudiotatoo.cliente where NomeCompleto = ? ";
             conn = ConexaoMysql.getconnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, clientes.getNomeCompleto());

             int deletesucesso = ps.executeUpdate();
             if(deletesucesso > 0){
                 ClienteDeletado = true;
                  Programa.atualizado = true;
             } else{
                 ClienteDeletado = false;
             }
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
             ConexaoMysql.closeConnection(conn, ps);
         }
    
    }
    
    //Contar total de clientes
    public static int TotaldeClientes = 0;
    public static boolean ListarClientes() throws Exception {
        Thread.sleep(2500);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> Total = new ArrayList<>();
        try {
            String sql = "SELECT * FROM estudiotatoo.cliente";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String nome = rs.getString("NomeCompleto");
                Total.add(nome);
                
            }
            
            Programa.CountadorClientes.setText("" + Total.size());
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conn, ps, rs);
        }
        return true;
        
    }
    

 
}
