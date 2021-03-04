/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;



public class ProdUnidade extends Produto {

    private int quantidade;
    private Produto p;

    public ProdUnidade(String nome, String descricao, double valor, int quantidade) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    public String toString(){
        return super.toString() + "\nQuantidade: " + quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    /*public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }*/

    @Override
    public void setQuantidade(double q) {
        int quantidadeInt;
        quantidadeInt = (int)q;
        this.quantidade = quantidadeInt;
    }




}
