/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

public class NotaFiscal {
	private final int codigo;
	private String data;
	private double valorTotal;
	private ArrayList<Item> relacaoItens = new ArrayList<>();
	private static int nrCodigo = 0;

	public NotaFiscal(String data) {
		codigo = 1 + nrCodigo;
		NotaFiscal.nrCodigo++;
		this.data = data;
	}

	public NotaFiscal() {
		this.codigo = 0;
	}

	public Item getItem(int codigo) {
		for (Item i : relacaoItens) {
			if (i.getP().getCodigo() == codigo) {
				return i;
			}
		}
		return null;
	}

	public boolean addItem(Item i) {
		if (i.getP().subQuantidade(i.getQuantidade())) {
			relacaoItens.add(i);
			return true;
		}
		return false;
	}

	public boolean removeItem(Item i) {
		if (i.getP().addQuantidade(i.getQuantidade())) {
			relacaoItens.remove(i);
			return true;
		}
		return false;
	}

	public boolean removeTodosItens() {
		for (Item i : relacaoItens) {
			removeItem(i);
		}
		if (relacaoItens.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		String itens = "Código: " + codigo + "\nData: " + data + "\n";

		for (Item i : relacaoItens) {
			itens += i.toString() + "\n";
		}
		itens += "Total da nota: " + getValorTotal();

		return itens;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValorTotal() {
		double valorTotal = 0;
		for (Item i : relacaoItens) {
			valorTotal += i.getValorTotal();
		}
		return valorTotal;
	}

	public ArrayList<Item> getRelacaoItens() {
		return relacaoItens;
	}

	public String getData() {
		return data;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setRelacaoItens(ArrayList<Item> relacaoItens) {
		this.relacaoItens = relacaoItens;
	}

}
