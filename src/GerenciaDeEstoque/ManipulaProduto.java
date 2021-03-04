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

    /*
     * ProdQuilo prQuilo = new ProdQuilo(0, "", 0f); prQuilo.
     */
    @Override
    public boolean addProduto(Produto p) {
        if (listaProd.size() > 0 && !listaProd.equals(p)) {
            listaProd.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeProduto(int codigo) {
        boolean ok = false;
        Produto removProduto = null;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    removProduto = prod;
                }
            }
            listaProd.remove(removProduto);
            ok = true;
        }
        return ok;
    }

    @Override
    public Produto getProduto(int codigo) {
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    return prod;
                }
            }
        }
        return null;
    }

    @Override
    public boolean updateQuantidade(int codigo, double nova) {
        boolean ok = false;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    prod.setQuantidade(nova);
                    ok = true;
                }
            }
        }
        return ok;
    }

    @Override
    public boolean updatePreco(int codigo, double novo) {
        boolean ok = false;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    prod.setValor(novo);
                    ok = true;
                }
            }
        }
        return ok;
    }

    @Override
    public boolean addQuantidade(int codigo, double quantidade) {
        boolean ok = false;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    prod.setQuantidade(prod.getQuantidade() + quantidade);
                    ok = true;
                }
            }
        }
        return ok;
    }

    @Override
    public boolean subQuantidade(int codigo, double quantidade) {
        boolean ok = false;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    if (prod.getQuantidade() > quantidade) {
                        prod.setQuantidade(prod.getQuantidade() - quantidade);
                        ok = true;
                    }
                }
            }
        }
        return ok;
    }

}
