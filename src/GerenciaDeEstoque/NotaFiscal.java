/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {
    private int codigo;
    private String data;
    private double valorTotal;
    private ArrayList<Item> relacaoItens = new ArrayList<>();
    private static int nrCodigo = 0;
    //ter uma quantidade vendida

    public NotaFiscal(String data, ArrayList relacaoItens){
        codigo = 1 + nrCodigo;
        NotaFiscal.nrCodigo++;
        this.data = data;
        this.valorTotal = valorTotal;
        this.relacaoItens = relacaoItens;
    }

    public NotaFiscal(String data){
        this.data = data;
    }

    public boolean addItem(Item i){
        relacaoItens.add(i);
        return true;
    }

    public void removeItem(Item i){
        relacaoItens.remove(i);
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the relacaoItens
     */
    public ArrayList<Item> getRelacaoItens() {
        return relacaoItens;
    }

    /**
     * @param relacaoItens the relacaoItens to set
     */
    public void setRelacaoItens(ArrayList<Item> relacaoItens) {
        this.relacaoItens = relacaoItens;
    }



}
