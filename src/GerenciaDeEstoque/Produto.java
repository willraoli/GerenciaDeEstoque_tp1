/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public abstract class Produto {

    protected final int codigo;
    protected String nome;
    protected String descricao;
    protected double valor;
    protected static int nCodigo = 0;
/**
 * Primeiro foi criado um construtor apenas com o parâmetro de nome, pois seria o único atributo necessário para a criação de produto.
 * 
 */
    public Produto(String nome) {
        codigo = 1 + nCodigo;
        this.nome = nome;
        this.descricao = "";
        this.valor = 0;
        Produto.nCodigo++;
    }
 
/**
 * Na classe abstrata foi criado a sobrecarga um construtor com os atributos em comum entre ProdQuilo e ProdUnidade, além de um contador para gerar códigos automaticamente para os produtos
 * e garantindo que o número do código fosse um atributo identificador.
 * 
 * 
 */
    /**
     * 
     * @param nome
     * @param descricao
     * @param valor
     */
    public Produto(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        codigo = 1 + nCodigo;
        Produto.nCodigo++;
    }
/**Os métodos
 * 
 * 
 */
    public abstract void setQuantidade(double q);

    public abstract double getQuantidade();

    public abstract boolean subQuantidade(double quantidade);
    
    public abstract boolean addQuantidade(double quantidade);
        
    

    public String toString() {
        return "Código: " + codigo  + "\nNome: " + nome + "\nDescrição: " + descricao + "\nValor: R$ " + valor;
    	//return "Código: %d Nome: %s Descrição: %s Valor R$ %.2f.", codigo, nome, descricao, valor;  
    }
    

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
