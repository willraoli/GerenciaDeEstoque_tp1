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
 * 
 * @param nome refere-se ao nome do produto
 * Um construtor Produto com o atributo mínimo para ser gerado, que no caso é o nome.
 */
    public Produto(String nome) {
        codigo = 1 + nCodigo;
        this.nome = nome;
        this.descricao = "";
        this.valor = 0;
        Produto.nCodigo++;
    }
 

    /**
     * Uma sobrecarga do construtor Produto
     * @param nome refere-se ao nome do produto
     * @param descricao refere-se à descrição do produto
     * @param valor refere-se ao preço do produto
     * 
     */
    public Produto(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        codigo = 1 + nCodigo;
        Produto.nCodigo++;
    }

    public abstract void setQuantidade(double q);

    public abstract double getQuantidade();

    public abstract boolean subQuantidade(double quantidade);
    
    public abstract boolean addQuantidade(double quantidade);
        
    
    public String toString() {
        return "Código: " + codigo  + "\nNome: " + nome + "\nDescrição: " + descricao + "\nValor: R$ " + String.format("%.2f",valor) + ".";
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
