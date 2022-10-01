package br.senai.sc.lanchonete.model.entities;

public class Lanche {

	private double preco, peso;
	private int codigo;
	private String descricao;


//	public void listar() {
//		for (int i = 0; Pedido.listaPedidos.size() > i; i++) {
//			if (Pedido.listaPedidos.get(i) instanceof Lanche) {
//				System.out.println(Pedido.listaPedidos.get(i).toString());
//			}
//		}
//	}


	public Lanche( int codigo,String descricao,double preco, double peso) {
		this.preco = preco;
		this.peso = peso;
		this.codigo = codigo;
		this.descricao = descricao;
	}


    public static Lanche cadastrar(Integer codigo, String descricao, Double preco, double peso) {
		return new Lanche(codigo, descricao, preco, peso);
	}

	@Override
	public String toString() {
		return "Lanche{" +
				"preco=" + preco +
				", peso=" + peso +
				", codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				'}';
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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
}
