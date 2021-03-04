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
        boolean ok = false;
        //if (listaProd.size() > 0 && !listaProd.equals(p)) {
            listaProd.add(p);
            ok = true;
       // }
        return ok;
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
        Produto prodNovo = null;
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    prodNovo = prod;
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
        
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {                   
                    prod.addQuantidade(quantidade);
                    return true;                   
                }
            }
        }
        return false;
    }

    @Override
    public boolean subQuantidade(int codigo, double quantidade) {        
        if (listaProd.size() > 0) {
            for (Produto prod : listaProd) {
                if (prod.getCodigo() == codigo) {
                    prod.subQuantidade(quantidade);
                    return true;
                }
            }
        }
        return false;
    }

}
