/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

//classe A
public class ManipulaProduto implements IProdutos {

    private ArrayList<Produto> listaProd = new ArrayList<>();

    @Override
    public boolean addProduto(Produto p) {
        return listaProd.add(p);
    }

    @Override
    public boolean removeProduto(int codigo) {
        Produto removProduto = null;
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                removProduto = prod;
            }
        }
        return listaProd.remove(removProduto);
    }

//    @Override
//    public boolean removeProduto(int codigo) {
//        boolean ok = false;
//        Produto removProduto = null;
//        if (listaProd.size() > 0) {
//            for (Produto prod : listaProd) {
//                if (prod.getCodigo() == codigo) {
//                    removProduto = prod;
//                }
//            }
//            listaProd.remove(removProduto);
//            ok = true;
//        }
//        return ok;
//    }

    @Override
    public Produto getProduto(int codigo) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean updateQuantidade(int codigo, double nova) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.setQuantidade(nova);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePreco(int codigo, double novo) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.setValor(novo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addQuantidade(int codigo, double quantidade) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.addQuantidade(quantidade);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean subQuantidade(int codigo, double quantidade) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.subQuantidade(quantidade);
                return true;
            }
        }
        return false;
    }

}
