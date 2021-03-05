/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.Scanner;

public class Main {

    private ManipulaProduto produtos;
    private ManipulaNotaFiscal notasFiscais;

    public Main() {
        produtos = new ManipulaProduto();
        notasFiscais = new ManipulaNotaFiscal();
    }

    public void menu() {
        Scanner tc = new Scanner(System.in);
        int op;

        do {
            System.out.println("Bem vindo ao Gerenciamento de Estoque");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Consultar produto");
            System.out.println("3. Alterar informações do produto");
            System.out.println("4. Excluir produto");
            System.out.println("5. Gerar uma nota fiscal");
            System.out.println("6. Consultar nota fiscal");
            System.out.println("7. Alterar nota fiscal");
            System.out.println("0. Sair");
            op = tc.nextInt();
            tc.nextLine();

            switch (op) {
                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    consultarProduto();
                    break;

                case 3:
                    alterarProduto();
                    break;

                case 4:
                    excluirProduto();
                    break;

                case 5:
                    criarNotaFiscal();
                    break;

                case 6:
                    consultarNotaFiscal();
                    break;

                case 7:
                    alterarNotaFiscal();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (op != 0);
    }

    public void cadastrarProduto() {
        Scanner teclado = new Scanner(System.in);
        String nomeProduto;
        String descricaoProduto;
        double valorProduto;
        int quantidadeProduto;
        double quantidadeQuilo;
        int quantidadeP = 0;
        String resp;
        boolean ok;

        System.out.println("[CADASTRO DE PRODUTO]");

        System.out.print("Informe o nome do produto: ");
        nomeProduto = teclado.nextLine();

        System.out.print("Dê uma descrição para o produto: ");
        descricaoProduto = teclado.nextLine();

        System.out.print("Informe o valor do produto: ");
        valorProduto = teclado.nextDouble();
        teclado.nextLine();

        //Fazer uma pergunta antes
        System.out.println("Deseja cadastrar por Unidade ou Quilo");
        System.out.print("[Unidade]/[Quilo]: ");
        resp = teclado.nextLine();

        if (resp.equalsIgnoreCase("unidade")) {
            do {
                try {
                    System.out.print("Informe a quantidade do produto: ");
                    quantidadeP = teclado.nextInt();
                    ok = true;
                } catch (Exception IO) {
                    System.out.println("Informe, por favor, um inteiro!");
                    ok = false;
                } finally {
                    teclado.nextLine();
                }
            } while (!ok);

            quantidadeProduto = quantidadeP;

            Produto pUnidade = new ProdUnidade(nomeProduto, descricaoProduto, valorProduto, quantidadeProduto);
            System.out.println("Código do produto: " + pUnidade.getCodigo());
            produtos.addProduto(pUnidade);

        } else if (resp.equalsIgnoreCase("Quilo")) {
            System.out.println("Informe a quantidade do produto:");
            quantidadeQuilo = teclado.nextDouble();
            teclado.nextLine();

            Produto pQuilo = new ProdQuilo(nomeProduto, descricaoProduto, valorProduto, quantidadeQuilo);
            System.out.println("Código do produto: " + pQuilo.getCodigo());
            produtos.addProduto(pQuilo);
        }

        //Fazer alguma pergunta em relação a ser por unidade ou por quilo?
        //Para poder determinar qual eu adiciono?                                   
    }

    public void consultarProduto() {

        Scanner teclado = new Scanner(System.in);
        int codInfo;
        System.out.println("[CONSULTAR PRODUTO]");
        do {
            System.out.print("Informe o código do produto que deseja consultar: ");
            codInfo = teclado.nextInt();
            teclado.nextLine();
            if (produtos.getProduto(codInfo) != null) {
                System.out.println(produtos.getProduto(codInfo).toString());
            }
        } while (produtos.getProduto(codInfo) == null);
    }

    public void alterarProduto() {
        Scanner tc = new Scanner(System.in);
        int codigo;
        String descricao, nome;
        double valor;
        double quantidade;
        System.out.println("[ALTERAR PRODUTO]");
        do {
            System.out.print("Informe o código do produto que deseja consultar:");
            codigo = tc.nextInt();
            tc.nextLine();
            if (produtos.getProduto(codigo) != null) {
                System.out.println(produtos.getProduto(codigo).toString());

                System.out.println("Para qual nome você quer alterar?");
                nome = tc.nextLine();

                System.out.println("Qual será a nova descrição?");
                descricao = tc.nextLine();

                System.out.println("Qual o valor a ser alterado?");
                valor = tc.nextDouble();
                tc.nextLine();

                System.out.println("Qual a quantidade a ser alterada?");
                quantidade = tc.nextDouble();
                tc.nextLine();

                produtos.getProduto(codigo).setNome(nome);
                produtos.getProduto(codigo).setDescricao(descricao);
                produtos.updatePreco(codigo, valor);
                produtos.updateQuantidade(codigo, quantidade);

                System.out.println(produtos.getProduto(codigo).toString());

            }
        } while (produtos.getProduto(codigo) == null);

    }

    public void excluirProduto() {
        Scanner teclado = new Scanner(System.in);
        int codProduto;

        System.out.println("[EXCLUIR PRODUTO]");
        System.out.print("Informe o código do produto: ");
        codProduto = teclado.nextInt();
        teclado.nextLine();

        if (produtos.getProduto(codProduto) != null) {
            System.out.println(produtos.getProduto(codProduto).toString());
            System.out.println(produtos.getProduto(codProduto).getNome() + " foi excluído.");
            //produtos.removeProduto(codProduto);
            System.out.println(produtos.removeProduto(codProduto));
        }
    }

    public void criarNotaFiscal() {
        NotaFiscal nf;
        Scanner teclado = new Scanner(System.in);
        int codInfo;
        double quantidadeVendida;
        String data = "";
        String resp;
        boolean ok;

        System.out.println("[CRIAÇÃO DA NOTA FISCAL]");
        nf = new NotaFiscal(data);

        System.out.println("Código da nota fiscal: " + nf.getCodigo());

        System.out.print("Qual a data da criação da nota fiscal (dd/MM/yyyy): ");
        data = teclado.nextLine();
        nf.setData(data);


        do {
            System.out.print("Informe o código do produto que você deseja cadastrar na nota fiscal: ");
            codInfo = teclado.nextInt();
            teclado.nextLine();

            do {
                if (produtos.getProduto(codInfo) != null) {
                    System.out.println(produtos.getProduto(codInfo).toString());
                }
            } while (produtos.getProduto(codInfo) == null);
           
            do {
                System.out.print("Agora por favor, informe a quantidade vendida deste produto: ");
                quantidadeVendida = teclado.nextDouble();
                teclado.nextLine();

                Item itemADD = new Item(produtos.getProduto(codInfo), quantidadeVendida);
                ok = nf.addItem(itemADD);
                if (ok) {                                                            
                    System.out.println("Este produto foi adicionado a nota fiscal.");
                    notasFiscais.addNotaFiscal(nf);
                } else {
                    System.out.println("A quantidade informada está acima da em estoque.");
                }

            } while (!ok);

            System.out.println("Você quer adicionar mais um produto? [Sim/Não]");
            resp = teclado.nextLine();

        } while (resp.equalsIgnoreCase("sim"));
    }
    

    public void consultarNotaFiscal() {
        Scanner in = new Scanner(System.in);

        System.out.print("Insira o código da nota fiscal a ser consultada: ");
        int resp = in.nextInt();

        System.out.println(notasFiscais.getNotaFiscal(resp).toString());
    }

    public void alterarNotaFiscal() {
        Scanner in = new Scanner(System.in);
        int respInt, respProduto;
        NotaFiscal nf;

        System.out.print("Insira o código da nota fiscal a ser alterada: ");
        respInt = in.nextInt();

        NotaFiscal notaAntiga = notasFiscais.getNotaFiscal(respInt); //pegar dados da nota fiscal antiga [GAMBIARRA]

        System.out.println(notasFiscais.getNotaFiscal(respInt).toString());
        System.out.println("O que você deseja fazer?");
        System.out.println("[1] Adicionar item");
        System.out.println("[2] Remover item");
        // adicionar mudança de quantidade
        int respSwitch = in.nextInt();
        in.nextLine();

        switch(respSwitch){
            case 1:
                System.out.println("Qual o código do produto que você deseja adicionar?");
                respProduto = in.nextInt();
                System.out.println("Será alterado:");
                System.out.println(produtos.getProduto(respProduto).toString());

                Item i = new Item(produtos.getProduto(respProduto), produtos.getProduto(respProduto).getQuantidade());
                notasFiscais.addItem(respInt, i);
                break;
            case 2:
                break;
            default:
                System.out.println("Selecione uma das opções.");
        }
    }

    public void totalVendido() {
    }

    public static void main(String[] args) {
        Main mn = new Main();
        mn.menu();
    }
}
