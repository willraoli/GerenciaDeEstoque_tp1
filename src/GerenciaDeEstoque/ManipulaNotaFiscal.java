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
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    notaF.remove(nota);
                    return true;
                }
            }
        }
        return false;
    }

    public double getValorTotalAllNotaFiscal() {
        double valorTotal = 0;
        if (!notaF.isEmpty()) {
            for (NotaFiscal n : notaF){
                if (n.getCodigo() != 0) {
                    valorTotal += n.getValorTotal();
                }
            }
        }
        return valorTotal;
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) {
        NotaFiscal notaFISCAL = null;
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    notaFISCAL = nota;
                }
            }
        }
        return notaFISCAL; 
    }

    @Override
    public double getTotal(int codigo) {
        double valorNota = 0;
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    valorNota = nota.getValorTotal();
                }
            }
        }
        return valorNota; 
    }

    @Override
    public boolean addItem(int codigo, Item/*Object*/ item) {
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    nota.addItem(item);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(int codigo, Item/*Object*/ item) {
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    nota.removeItem(item);
                    return true;
                }
            }
        }
        return false;
    }
    
}
