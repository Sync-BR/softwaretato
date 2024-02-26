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
public class ClientesBeans {

    /**
     * @return the NomeCompleto
     */
    public String getNomeCompleto() {
        return NomeCompleto;
    }

    /**
     * @param NomeCompleto the NomeCompleto to set
     */
    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    /**
     * @return the Datanascimento
     */
    public Date getDatanascimento() {
        return Datanascimento;
    }

    /**
     * @param Datanascimento the Datanascimento to set
     */
    public void setDatanascimento(Date Datanascimento) {
        this.Datanascimento = Datanascimento;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the Celular
     */
    public String getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    /**
     * @return the Whatsapp
     */
    public String getWhatsapp() {
        return Whatsapp;
    }

    /**
     * @param Whatsapp the Whatsapp to set
     */
    public void setWhatsapp(String Whatsapp) {
        this.Whatsapp = Whatsapp;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Rua
     */
    public String getRua() {
        return Rua;
    }

    /**
     * @param Rua the Rua to set
     */
    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return Cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Cep
     */
    public String getCep() {
        return Cep;
    }

    /**
     * @param Cep the Cep to set
     */
    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    /**
     * @return the Numerodacasa
     */
    public String getNumerodacasa() {
        return Numerodacasa;
    }

    /**
     * @param Numerodacasa the Numerodacasa to set
     */
    public void setNumerodacasa(String Numerodacasa) {
        this.Numerodacasa = Numerodacasa;
    }


    public ClientesBeans() {
    }

    private String NomeCompleto;
    private Date Datanascimento;
    private String Genero;
    private String Telefone;
    private String Celular;
    private String Whatsapp;
    private String Email;
    private String Rua;
    private String Cidade;
    private String Estado;
    private String Cep;
    private String Numerodacasa;
    //Iniciando instancia
    public ClientesBeans(String nome, Date data, String genero, String telefone, String celular, String whatsapp, String email,
            String rua, String cidade, String estado, String cep, String numerocasa){
        this.NomeCompleto = nome;
        this.Datanascimento = data;
        this.Genero = genero;
        this.Telefone = telefone;
        this.Celular = celular;
        this.Whatsapp = whatsapp;
        this.Email = email;
        this.Rua = rua;
        this.Cidade = cidade;
        this.Estado = estado;
        this.Cep = cep;
        this.Numerodacasa = numerocasa;
    }

}
