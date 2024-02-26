/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoMysql;
import Tela.Programa;

public class Calcular {
    public static double ValorSomado = 0;
    public static boolean ValorAtualizado = false;
    public static boolean ProdutosEncontrado = false;
    public static boolean CancelarCalculos = true;
    public static String valorformatado;
    //Calcular valores do produtos
    public static void CalcularValores() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Float> ValoresDoProdutos = new ArrayList<>() ;
        List<Integer> QuantidadesTotal = new ArrayList<>();
        int count = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        ValorSomado = 0;
        try {
            //     while (CancelarCalculos) {

            String sql = "SELECT ProdutoPreco,ProdutoEstoque FROM estudiotatoo.produtos";
            conn = ConexaoMysql.getconnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
                //Pegar os valores no banco de dados
                while (rs.next()) {
                    float Valores = rs.getFloat("ProdutoPreco");
                    ValoresDoProdutos.add(Valores);
                    int Quantidade = rs.getInt("ProdutoEstoque");
                    QuantidadesTotal.add(Quantidade);
                    count++;
                }
            //Calcular os preços
            double[][] SomasArray = new double[ValoresDoProdutos.size()][1];
                for (int index = 0; index < ValoresDoProdutos.size(); index++) {
                    //Converter
                    double Conversor = Double.parseDouble(ValoresDoProdutos.get(index).toString());
                    SomasArray[index][0] = Conversor * QuantidadesTotal.get(index);
                }
            //verificar se o banco de dados foi atualizado
            int id = 0;
            for (int i = 0; i < count; i++) {
                ValorSomado += SomasArray[i][0];
            }

            valorformatado = df.format(ValorSomado);
            Programa.ValorTotal.setText("R$: " +valorformatado);
            CancelarCalculos = false;
            //   }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMysql.closeConnection(conn, ps, rs);
        }

    }
    
    //Calcular valores da despesa
    public String DespesaCalculada ;
    public double DespesaValores;
    public  String ValorFinal;
    public void CalcularFaturamento( ) throws Exception{
        DecimalFormat formatado = new DecimalFormat("#.##");
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Float> FaturamentoTotal = new ArrayList<>();
        DespesaValores = 0;
        
        try {
            String sql = "SELECT Valor FROM estudiotatoo.despesas" ;
            conn = ConexaoMysql.getconnection();
            stm = conn.prepareStatement(sql);    
            rs = stm.executeQuery();
                while(rs.next()){
                    float valor = rs.getFloat("Valor");
                    FaturamentoTotal.add(valor);
                }
                for(int i = 0; i < FaturamentoTotal.size(); i++){
                    double GastoConvertido =  Double.parseDouble(FaturamentoTotal.get(i).toString());
                    DespesaValores += GastoConvertido ;
                }
                try{
                   String STRValor = String.valueOf(DespesaValores);
                   double ValorDouble =  Double.parseDouble(STRValor);
                   DespesaValores = ValorDouble - Double.valueOf(ValorSomado);
                    ValorFinal = String.valueOf(DespesaValores);
                   
                } catch(NumberFormatException e ){
                    e.printStackTrace();
                }

                Programa.txtGasto.setText("R$ " +DespesaValores);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoMysql.closeConnection(conn, stm, rs);
        }
        
    
    }
    
    //Calcular valor total no caixa


}
