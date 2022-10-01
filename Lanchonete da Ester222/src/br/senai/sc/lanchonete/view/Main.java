package br.senai.sc.lanchonete.view;

import br.senai.sc.lanchonete.controller.PedidoController;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Pedido;
import br.senai.sc.lanchonete.model.service.LancheService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static private Scanner sc = new Scanner(System.in);
    static ArrayList<Pedido> listaBebida = new ArrayList<>();
    static ArrayList<Pedido> listaLanche = new ArrayList<>();
    static ArrayList<Pedido> listaOutro = new ArrayList<>();
    static Pedido tipo;

    public static void main(String[] args) throws SQLException {
//		addPadrao();
        menu();
    }

    /**
     * Menu para o usuario selecionar a ação que deseja fazer;
     *
     * @throws SQLException
     */
    private static void menu() throws SQLException {

        System.out.print("" + "----------MENU----------\n" + "1 - Listar\n" + "2 - Cadastrar\n" + "3 - Editar\n"
                + "4 - Remover\n" + "5 - Encerrar\n" + "> ");
        switch (sc.nextInt()) {
            case 1:
                listarPedidos();
//			tipo=selecionaTipo();
//			tipo.listar();
                break;
            case 2:
                coletaDados();
                break;

            case 3:
//                editar();
                break;

            case 4:
                remover();
                break;

            case 5:
                System.exit(0);
        }

        menu();
    }

    /**
     * Lista por codigo ou por tabela de um tipo expecifico;
     *
     * @throws SQLException
     */
    private static void listarPedidos() throws SQLException {
        int tipo = selecionaTipo();
        System.out.println("Listar: \n1-Tipo expecifico \n2- Por código");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1: {
                ArrayList<Lanche> lanches = new ArrayList<>(PedidoController.selecionarPorTipo(tipo));
                for (Lanche l : lanches) {
                    System.out.println(l.toString());
                }
                break;
            }
            case 2:
                System.out.println("Insira o codigo do item a ser removido: ");
                int codigo = sc.nextInt();
                PedidoController.selecionarPorCodigo(tipo, codigo);
                break;
        }
    }

    /**
     * coleta os dados dos pedidos para o cadastro
     *
     * @throws SQLException
     */
    private static void coletaDados() throws SQLException {
        System.out.print("CADASTRAR: ");
        int tipo = selecionaTipo();

        System.out.print("C�digo: ");
        int codigo = sc.nextInt();
        System.out.print("Descri��o: ");
        String descricao = sc.next();
        System.out.print("Pre�o: ");
        double preco = sc.nextDouble();

        if (tipo == 1) {
            System.out.print("Peso: ");
            String peso = sc.next();
            PedidoController.cadastrar(codigo, descricao, preco, peso, tipo);
        } else if (tipo == 2) {
            System.out.print("Volume: ");
            String volume = sc.next();
            PedidoController.cadastrar(codigo, descricao, preco, volume, tipo);
        } else if (tipo == 3) {
            System.out.print("Tamanho: ");
            String tamanho = sc.next();
            PedidoController.cadastrar(codigo, descricao, preco, tamanho, tipo);
        }
    }

    /**
     * Seleciona o tipo de pedido, para fazer as ações;
     *
     * @return
     */
    private static int selecionaTipo() {
        System.out.println("" + "Selecione o que deseja\n" + "1 - Lanche\n" + "2 - Bebida\n" + "3 - Porcao");
        int tipo = sc.nextInt();

        switch (tipo) {
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

        }
        return -1;
    }

    /**
     * Remove pedido atraves do codigo do mesmo;
     *
     * @throws SQLException
     */
    private static void remover() throws SQLException {
        int tipo = selecionaTipo();

        System.out.println("Insira o codigo do item a ser removido: ");
        int codigo = sc.nextInt();

        PedidoController.excluir(codigo, tipo);

        menu();
    }

//    private static void editar() {
//        System.out.println("Insira o codigo do item a ser editado: ");
//        int codigo = sc.nextInt();
//
//        pedido = Pedido.valida(codigo);
//
//        if (pedido != null) {
//            System.out.println("Qual o novo pre�o? ");
//            pedido.setPreco(sc.nextDouble());
//        }
//        menu();
//    }

//	private static void addPadrao() {
//		Lanche xsalada = new Lanche(1, "X-Salada",12.0, 0.8);
//		Lanche xtudo = new Lanche(2, "X-Tudo",18.0,  1.2);
//		Lanche xburger = new Lanche(3, "X-Burger",10.0,  0.6);
//		Lanche xbacon = new Lanche(4, "X-Bacon",15.0, 1.0);
//		listaLanches.add(xsalada);
//		listaLanches.add(xtudo);
//		listaLanches.add(xburger);
//		listaLanches.add(xbacon);
//
//		Bebida refri200 = new Bebida();
//		refri200.setCodigo(1);
//		refri200.setPreco(5.0);
//		refri200.setDescricao("Refrigerante");
//		refri200.setVolume(0.35);
//
//		Bebida refri500 = new Bebida();
//		refri500.setCodigo(2);
//		refri500.setPreco(10.0);
//		refri500.setDescricao("Refrigerante");
//		refri500.setVolume(0.6);
//
//		Bebida suco200 = new Bebida();
//		suco200.setCodigo(3);
//		suco200.setPreco(6.0);
//		suco200.setDescricao("Suco");
//		suco200.setVolume(0.35);
//
//		Bebida suco500 = new Bebida();
//		suco500.setCodigo(4);
//		suco500.setPreco(12.0);
//		suco500.setDescricao("Suco");
//		suco500.setVolume(0.6);
//
//		listaBebidas.add(refri200);
//		listaBebidas.add(refri500);
//		listaBebidas.add(suco200);
//		listaBebidas.add(suco500);
//
//		Outro fritasP = new Outro();
//		fritasP.setCodigo(1);
//		fritasP.setPreco(3.5);
//		fritasP.setTamanho("Pequena");
//		fritasP.setDescricao("Batata Frita");
//
//		Outro fritasM = new Outro();
//		fritasM.setCodigo(2);
//		fritasM.setPreco(4.5);
//		fritasM.setTamanho("M�dia");
//		fritasM.setDescricao("Batata Frita");
//
//		Outro fritasG = new Outro();
//		fritasG.setCodigo(3);
//		fritasG.setPreco(5.5);
//		fritasG.setTamanho("Grande");
//		fritasG.setDescricao("Batata Frita");
//
//		Outro salada = new Outro();
//		salada.setCodigo(4);
//		salada.setPreco(8.0);
//		salada.setTamanho("M�dia");
//		salada.setDescricao("Salada");
//
//		listaOutro.add(fritasP);
//		listaOutro.add(fritasM);
//		listaOutro.add(fritasG);
//		listaOutro.add(salada);
//	}
}