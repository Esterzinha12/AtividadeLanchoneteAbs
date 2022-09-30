package br.senai.sc.lanchonete.model.entities;

public class Porcao  {

	private double preco;
	private int codigo;
	private String descricao, tamanho;

	public static Porcao cadastrar(Integer codigo, String descricao, Double preco, String tamanho) {
		return new Porcao(codigo, descricao, preco, tamanho);
	}

	public Porcao(int codigo,String descricao, double preco, String tamanho) {
		this.preco = preco;
		this.codigo = codigo;
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Porcao{" +
				"preco=" + preco +
				", codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				", tamanho='" + tamanho + '\'' +
				'}';
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

//	@Override
//	public void listar() {
//		for (int i = 0; Pedido.listaPedidos.size() > i; i++) {
//			if (Pedido.listaPedidos.get(i) instanceof Porcao) {
//				System.out.println(Pedido.listaPedidos.get(i).toString());
//			}
//
//		}
//
//	}




}
