package br.senai.sc.lanchonete.model.entities;

public class Bebida  {

	private double preco;
	private int codigo, volume;
	private String descricao;

	public static Bebida cadastrar(Integer codigo, String descricao, Double preco, int volume) {
		return new Bebida(codigo, descricao, preco, volume);
	}
	public Bebida(int codigo,String descricao, double preco,  int volume) {
		this.preco = preco;
		this.codigo = codigo;
		this.volume = volume;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Bebida{" +
				"preco=" + preco +
				", codigo=" + codigo +
				", volume=" + volume +
				", descricao='" + descricao + '\'' +
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

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	//	@Override
//	public void listar() {
//		for (int i = 0; Pedido.listaPedidos.size() > i; i++) {
//			if (Pedido.listaPedidos.get(i) instanceof Bebida) {
//				System.out.println(Pedido.listaPedidos.get(i).toString());
//			}
//
//		}
//	}


}
