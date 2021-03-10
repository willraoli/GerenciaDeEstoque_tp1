/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public class ProdUnidade extends Produto {

    private int quantidade;
    
    /**
     * 
     * @param nome recebe o nome produto
     * @param descricao
     * @param valor
     * @param quantidade
     */
    public ProdUnidade(String nome, String descricao, double valor, int quantidade) {
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
    
    public String toString(){
        return super.toString() + "\nQuantidade: " + quantidade + " unidades.";
    }
    
    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(double q) {
        int quantidadeInt;
        quantidadeInt = (int) q;
        this.quantidade = quantidadeInt;
    }

    
   

}
