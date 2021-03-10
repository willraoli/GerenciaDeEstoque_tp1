/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

public class ManipulaNotaFiscal implements INotasFiscais {

    ArrayList<NotaFiscal> notaF = new ArrayList<>();

    @Override
    public boolean addNotaFiscal(NotaFiscal nf) {
        return notaF.add(nf);
    }

    @Override
    public boolean removeNotaFiscal(int codigo) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return notaF.remove(nota);
            }
        }
        return false;
    }
  
/**
 * O método deve receber uma data como parâmetro e  irá percorrer a arrayList de notas fiscais verificando se elas possuem a mesma
 *  data e checando também o código
 * @param date corresponde a data
 * @return após uma atribuição cumulativa, ele irá retornar o valor de totas as notas
 */
    public double getValorTotalAllNotaFiscal(String date) {
        double valorTotal = 0;
        for (NotaFiscal n : notaF) {
            if (n.getCodigo() != 0 && n.getData().equals(date)) {
                valorTotal += n.getValorTotal();
            }
        }
        return valorTotal;
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) {
        NotaFiscal notaFISCAL = null;
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                notaFISCAL = nota;
            }
        }
        return notaFISCAL;
    }

    @Override
    public double getTotal(int codigo) {
        double valorNota = 0;
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                valorNota = nota.getValorTotal();
            }
        }
        return valorNota;
    }
    
    @Override
    public boolean addItem(int codigo, Item item) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return nota.addItem(item);
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(int codigo, Item item) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return nota.removeItem(item);
            }
        }
        return false;
    }


}
