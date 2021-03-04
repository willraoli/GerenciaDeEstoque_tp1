/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public class ProdQuilo extends Produto {

    private double /*float*/ quantidade;


    public ProdQuilo(String nome, String descricao, double valor, double /*float*/ quantidade) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }


    public String toString(){
        return super.toString() + "\nQuantidade: " + quantidade;

    }

    public double getQuantidade() {
        return quantidade;
    }

    /*public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }*/

    @Override
    public void setQuantidade(double q) {
        this.quantidade = q;
    }

}