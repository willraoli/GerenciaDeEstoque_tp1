/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;
//TESTE
//TEste2
public abstract class Produto {
    protected final int codigo;
    protected String nome;
    protected String descricao;
    protected double valor;
    protected static int nCodigo = 0;

    // private double quantidade; --> quantidade int(unidade) e quantidade float(kg)
    // [usar float como descritor do método]

    public Produto(String nome) {

        codigo = 1 + nCodigo;
        this.nome = nome;
        this.descricao = "";
        this.valor = 0;
        Produto.nCodigo++;
    }

    public Produto(String nome, String descricao, double valor){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        codigo = 1 + nCodigo;
        Produto.nCodigo++;
    }

    public abstract void setQuantidade(double q);

    public abstract double getQuantidade();

    public String toString(){
        return "Nome: " + nome + "\nDescrição: " + descricao + "\nValor: " + valor + "\nCódigo: " + codigo;
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

    public String getDescricao() {
        return descricao;
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

}