/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public class ProdQuilo extends Produto {

    private double quantidade;
/**
 * 
 * @param nome refere-se ao nome do Produto
 * @param descricao refere-se à descrição do produto
 * @param valor refere-se ao preço do produto
 * @param quantidade refere-se à quantidade do produto
 */
    public ProdQuilo(String nome, String descricao, double valor, double quantidade) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    public boolean subQuantidade(double quantidade) {

        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    public boolean addQuantidade(double quantidade) {
        this.quantidade += quantidade;
        return true;

    }

    public String toString() {
        return super.toString() + "\nQuantidade:  " + quantidade + " kg.";

    }

    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(double q) {
        this.quantidade = q;
    }

}
