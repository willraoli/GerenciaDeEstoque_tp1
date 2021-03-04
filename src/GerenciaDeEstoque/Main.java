/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {

    private ManipulaProduto produtos;
    private ManipulaNotaFiscal notasFiscais;

    public Main() {
        produtos = new ManipulaProduto();
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
                    CadastrarProduto();
                    break;

                case 2:
                    ConsultarProduto();
                    break;

                case 3:
                    AlterarProduto();
                    break;

                case 4:
                    ExcluirProduto();
                    break;

                case 5:
                    CriarNotaFiscal();
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (op != 0);
    }

    public void CadastrarProduto() {
        Scanner teclado = new Scanner(System.in);
        String nomeProduto;
        String descricaoProduto;
        double valorProduto;
        int quantidadeProduto;
        double quantidadeQuilo;
        int quantidadeP = 0;
        String resp;
        boolean ok = false;

        System.out.println("Cadastro de produto");

        System.out.println("Informe o nome do produto:");
        nomeProduto = teclado.nextLine();

        System.out.println("Dê uma descrição para o produto:");
        descricaoProduto = teclado.nextLine();

        System.out.println("Informe o valor do produto:");
        valorProduto = teclado.nextDouble();
        teclado.nextLine();

        //Fazer uma pergunta antes
        System.out.println("Deseja cadastrar por Unidade ou Quilo");
        System.out.println("[Unidade]/[Quilo]:");
        resp = teclado.nextLine();

        if (resp.equalsIgnoreCase("Unidade")) {
            do {
                try {
                    System.out.println("Informe a quantidade do produto:");
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
            System.out.println("Código do produto " + pUnidade.getCodigo());
            System.out.println(produtos.addProduto(pUnidade));

        } else if (resp.equalsIgnoreCase("Quilo")) {
            System.out.println("Informe a quantidade do produto:");
            quantidadeQuilo = teclado.nextDouble();
            teclado = new Scanner(System.in);

            Produto pQuilo = new ProdQuilo(nomeProduto, descricaoProduto, valorProduto, quantidadeQuilo);
            System.out.println("Código do produto " + pQuilo.getCodigo());
            System.out.println(produtos.addProduto(pQuilo));
        }

        //Fazer alguma pergunta em relação a ser por unidade ou por quilo?
        //Para poder determinar qual eu adiciono?                                   
    }

    public void ConsultarProduto() {

        Scanner teclado = new Scanner(System.in);
        int codInfo;
        System.out.println("Consultar produto");
        do {
            System.out.println("Informe o código do produto que deseja consultar:");
            codInfo = teclado.nextInt();
            teclado.nextLine();
            if (produtos.getProduto(codInfo) != null) {
                System.out.println(produtos.getProduto(codInfo).toString());
            }
        } while (produtos.getProduto(codInfo) == null);
    }

    public void AlterarProduto() {
        Scanner tc = new Scanner(System.in);
        int codigo;
        String descricao, nome;
        double valor;
        double quantidade;
        System.out.println("Alterar produto");
        do {
            System.out.println("Informe o código do produto que deseja consultar:");
            codigo = tc.nextInt();
            tc.nextLine();
            if (produtos.getProduto(codigo) != null) {
                System.out.println(produtos.getProduto(codigo).toString());

                System.out.println("Para qual nome você quer alterar? ");
                nome = tc.nextLine();

                System.out.println("Qual será a nova descrição? ");
                descricao = tc.nextLine();

                System.out.println("Qual o valor a ser alterado? ");
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

    public void ExcluirProduto() {
        Scanner teclado = new Scanner(System.in);
        int codProduto;

        System.out.println("Excluir Produto");
        System.out.println("Informe o código do produto: ");
        codProduto = teclado.nextInt();
        teclado.nextLine();

        if (produtos.getProduto(codProduto) != null) {
            System.out.println(produtos.getProduto(codProduto).toString());
            System.out.println(produtos.getProduto(codProduto).getNome() + " foi excluído.");
            //produtos.removeProduto(codProduto);
            System.out.println(produtos.removeProduto(codProduto));
        }
    }

    public void CriarNotaFiscal() {
        NotaFiscal nf;
        Scanner teclado = new Scanner(System.in);
        int codInfo;
        double quantidadeVendida;
        double valorT = 0;
        String data = "";
        String resp = "";
        boolean ok;
        //pegar data atual
        //pegar relação de itens

        System.out.println("Criação da Nota Fiscal");      
        
        System.out.println("Qual a data da criação da nota fiscal (dd/MM/yyyy): ");
        data = teclado.nextLine();        

        nf = new NotaFiscal(data);

        do {
            System.out.println("Informe o código do produto que você deseja cadastrar na nota fiscal: ");
            codInfo = teclado.nextInt();
            teclado.nextLine();

            do {
                if (produtos.getProduto(codInfo) != null) {
                    System.out.println(produtos.getProduto(codInfo).toString());
                }
            } while (produtos.getProduto(codInfo) == null);
           
            do {
                System.out.println("Agora por favor, informe a quantidade vendida deste produto");
                quantidadeVendida = teclado.nextDouble();
                teclado.nextLine();

                Item itemADD = new Item(produtos.getProduto(codInfo), quantidadeVendida);
                ok = nf.addItem(itemADD);
                if (ok) {                                                            
                    System.out.println("Este produto foi adicionado a nota fiscal");                    
                } else {
                    System.out.println("A quantidade informada está acima da em estoque");
                }

            } while (!ok);

            System.out.println("Você quer adicionar mais um produto? [Sim/Não]");
            resp = teclado.nextLine();

        } while (resp.equalsIgnoreCase("Sim"));

        notasFiscais.addNotaFiscal(nf);      
    }
    

    public void ConsultarNotaFiscal() {

    }

    public void AlterarNotaFiscal() {

    }

    public void TotalVendido() {

    }

    public static void main(String args[]) {
        Main mn = new Main();
        mn.menu();
    }
}
