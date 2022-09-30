package br.senai.sc.lanchonete.model.entities;

import java.util.ArrayList;

public class Pedido {

	private int codigo;
	private String descricao;
	private double preco;

	static ArrayList<Pedido> listaPedidos = new ArrayList<>();

	public Pedido() {

	}

//	public static Pedido valida(int codigo) {
//
//		for (int i = 0; i < listaPedidos.size(); i++) {
//			if (codigo == listaPedidos.get(i).getCodigo()) {
//				return listaPedidos.get(i);
//			}
//		}
//		return null;
//	}

	//Precisa fazer mais algo????
	public static Pedido cadastrar(Integer codigo, String descricao, Double preco) {
		return new Pedido(codigo, descricao, preco) {
		};
	}

	@Override
	public String toString() {
		return "\nPedido: \nCodigo=" + getCodigo() + ", \nDescricao=" + getDescricao() + ", \nPreco=" + getPreco();
	}

	public Pedido(int codigo, String descricao, double preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
