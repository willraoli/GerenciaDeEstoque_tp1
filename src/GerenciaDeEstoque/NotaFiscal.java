/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class NotaFiscal {
   private final int codigo;
   private String data;
   private double valorTotal;
   private ArrayList<Item> relacaoItens = new ArrayList<>();
   private static int nrCodigo = 0;
   //ter uma quantidade vendida
   
   public NotaFiscal(String data, double valorTotal, ArrayList relacaoItens){
       codigo = 1 + nrCodigo;
       NotaFiscal.nrCodigo++;
       this.data = data;
       this.valorTotal = valorTotal;
       this.relacaoItens = relacaoItens;
   }
   
   public NotaFiscal(String data){
       codigo = 1 + nrCodigo;
       NotaFiscal.nrCodigo++;
       this.data = data;
   }
   
   
    public boolean addItem(Item i){
        if(i.getP().subQuantidade(i.getQuantidade())){
        relacaoItens.add(i);
        return true;
        }
        return false;
    }
    
    public boolean removeItem(Item i){
        if(i.getP().addQuantidade(i.getQuantidade())){
        relacaoItens.remove(i);
        return true;
        }
        return false;
    }

    public String toString() {
       String itens = "";

       for (Item i : relacaoItens) {
           itens = itens + "\n\tNome: " + i.getP().getNome() + "\n\tCódigo: " + i.getP().getCodigo() + "\n\tQuantidade: " + i.getP().getQuantidade() + "\n\tPreço: " + i.getP().getValor();
       }

       return "Código: " + codigo + "\nData: " + data + "\nItens: " + itens;
    }


    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Item> getRelacaoItens() {
        return relacaoItens;
    }

    public void setRelacaoItens(ArrayList<Item> relacaoItens) {
        this.relacaoItens = relacaoItens;
    }
   
   
 
}
