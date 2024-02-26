/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.sql.Date;

public class ProdutosBeans {

    /**
     * @return the ProdutoNome
     */
    public String getProdutoNome() {
        return ProdutoNome;
    }

    /**
     * @param ProdutoNome the ProdutoNome to set
     */
    public void setProdutoNome(String ProdutoNome) {
        this.ProdutoNome = ProdutoNome;
    }

    /**
     * @return the ProdutoCategoria
     */
    public String getProdutoCategoria() {
        return ProdutoCategoria;
    }

    /**
     * @param ProdutoCategoria the ProdutoCategoria to set
     */
    public void setProdutoCategoria(String ProdutoCategoria) {
        this.ProdutoCategoria = ProdutoCategoria;
    }

    /**
     * @return the ProdutoMarcar
     */
    public String getProdutoMarcar() {
        return ProdutoMarcar;
    }

    /**
     * @param ProdutoMarcar the ProdutoMarcar to set
     */
    public void setProdutoMarcar(String ProdutoMarcar) {
        this.ProdutoMarcar = ProdutoMarcar;
    }

    /**
     * @return the ProdutoDescricao
     */
    public String getProdutoDescricao() {
        return ProdutoDescricao;
    }

    /**
     * @param ProdutoDescricao the ProdutoDescricao to set
     */
    public void setProdutoDescricao(String ProdutoDescricao) {
        this.ProdutoDescricao = ProdutoDescricao;
    }

    /**
     * @return the ProdutoCodigoBarras
     */
    public long getProdutoCodigoBarras() {
        return ProdutoCodigoBarras;
    }

    /**
     * @param ProdutoCodigoBarras the ProdutoCodigoBarras to set
     */
    public void setProdutoCodigoBarras(long ProdutoCodigoBarras) {
        this.ProdutoCodigoBarras = ProdutoCodigoBarras;
    }

    /**
     * @return the Produtopreco
     */
    public float getProdutopreco() {
        return Produtopreco;
    }

    /**
     * @param Produtopreco the Produtopreco to set
     */
    public void setProdutopreco(float Produtopreco) {
        this.Produtopreco = Produtopreco;
    }

    /**
     * @return the ProdutoEstoque
     */
    public int getProdutoEstoque() {
        return ProdutoEstoque;
    }

    /**
     * @param ProdutoEstoque the ProdutoEstoque to set
     */
    public void setProdutoEstoque(int ProdutoEstoque) {
        this.ProdutoEstoque = ProdutoEstoque;
    }

    /**
     * @return the ProdutoValidade
     */
    public Date getProdutoValidade() {
        return ProdutoValidade;
    }

    /**
     * @param ProdutoValidade the ProdutoValidade to set
     */
    public void setProdutoValidade(Date ProdutoValidade) {
        this.ProdutoValidade = ProdutoValidade;
    }

    /**
     * @return the ProdutoObservacao
     */
    public String getProdutoObservacao() {
        return ProdutoObservacao;
    }

    /**
     * @param ProdutoObservacao the ProdutoObservacao to set
     */
    public void setProdutoObservacao(String ProdutoObservacao) {
        this.ProdutoObservacao = ProdutoObservacao;
    }

    public ProdutosBeans() {
    }
    private String ProdutoNome;
    private String ProdutoCategoria;
    private String ProdutoMarcar;
    private String ProdutoDescricao;
    private long ProdutoCodigoBarras;
    private float Produtopreco;
    private int ProdutoEstoque;
    private Date ProdutoValidade;
    private String ProdutoObservacao;
    
   public ProdutosBeans(String Nome, String Categoria, String Marcar, String Descricao, long CodigoBarras, float valor, int estoque
   , Date validade, String Observacao){
       this.ProdutoNome = Nome;
       this.ProdutoCategoria = Categoria;
       this.ProdutoMarcar = Marcar;
       this.ProdutoDescricao = Descricao;
       this.ProdutoCodigoBarras = CodigoBarras;
       this.Produtopreco = valor;
       this.ProdutoEstoque = estoque;
       this.ProdutoValidade = validade;
       this.ProdutoObservacao = Observacao;
   
   }
    
    
    
    
    
}
