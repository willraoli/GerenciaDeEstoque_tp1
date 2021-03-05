/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

/**
 *
 * @author Usuario
 */
public class Item {
    private Produto p;
    private double quantidade;

    public Item(Produto p, double quantidade){
        this.p = p;
        this.quantidade = quantidade;
    }

    public double getValorTotal(){
        return p.getValor() * quantidade;
    }
    public String toString(){
        return "\n\tNome: " + p.getNome() + "\n\tQuantidade: " + quantidade + "\n\tPreço: " + p.getValor() + "\n\tTotal em R$: " + getValorTotal() + "\n";
    }
    /**
     * @return the p
     */
    public Produto getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Produto p) {
        this.p = p;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
