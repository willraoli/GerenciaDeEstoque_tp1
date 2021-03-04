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
        boolean ok = false;
        if(notaF.size() > 0){
            notaF.add(nf);
            ok = true;
        }
        return ok;
    }

    @Override
    public boolean removeNotaFiscal(int codigo) {
        boolean ok = false;
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    notaF.remove(nota);
                    ok = true;
                }
            }
        }
        return ok;
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

        boolean ok = false;
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    nota.addItem(item);
                    ok = true;
                }
            }
        }
        return ok;
    }

    @Override
    public boolean removeItem(int codigo, Item/*Object*/ item) {
        boolean ok = false;
        if (notaF.size() > 0) {
            for (NotaFiscal nota : notaF) {
                if (nota.getCodigo() == codigo) {
                    nota.removeItem(item);
                    ok = true;
                }
            }
        }
        return ok;
    }

}
