/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author Eduar
 */
public class FaturamentoBeans {

    public FaturamentoBeans() {
    }

    //variaveis para tela de faturamento
    private String Servico;
    private Date DataDespesa;
    private long ValorDespesa;
    private String MetadoPagamento;
    private String Descricao;
    
    
    // Construtor
    public FaturamentoBeans(String NomeServico, Date data, long valor, String metado, String comentario ){
        this.Servico = NomeServico;
        this.DataDespesa = data;
        this.ValorDespesa =  valor;
        this.MetadoPagamento = metado;
        this.Descricao = comentario;
        
    }
   
    /**
     * @return the Servico
     */
    public String getServico() {
        return Servico;
    }

    /**
     * @param Servico the Servico to set
     */
    public void setServico(String Servico) {
        this.Servico = Servico;
    }

    /**
     * @return the DataDespesa
     */
    public Date getDataDespesa() {
        return DataDespesa;
    }

    /**
     * @param DataDespesa the DataDespesa to set
     */
    public void setDataDespesa(Date DataDespesa) {
        this.DataDespesa = DataDespesa;
    }

    /**
     * @return the ValorDespesa
     */
    public float getValorDespesa() {
        return ValorDespesa;
    }

    /**
     * @param ValorDespesa the ValorDespesa to set
     */
    public void setValorDespesa(long ValorDespesa) {
        this.ValorDespesa = ValorDespesa;
    }

    /**
     * @return the MetadoPagamento
     */
    public String getMetadoPagamento() {
        return MetadoPagamento;
    }

    /**
     * @param MetadoPagamento the MetadoPagamento to set
     */
    public void setMetadoPagamento(String MetadoPagamento) {
        this.MetadoPagamento = MetadoPagamento;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    

    
}
