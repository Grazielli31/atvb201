package AtvAvaliativa01b2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        Cardapio.adicionarPrato(new Cardapio("Hamburguer", "Coca-Cola", 1, 10, 5)); 
        Cardapio.adicionarPrato(new Cardapio("Cachorro Quente", "Suco de Laranja", 2, 8, 10)); 
        Cardapio.adicionarPrato(new Cardapio("Pizza", "Guaraná", 3, 20, 3)); 

        int numGarcons = 1;
        RelatorioFaturamento relatorioFaturamento = new RelatorioFaturamento(4, numGarcons);
        
        List<Funcionarios> listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(new Funcionarios("Carlos", "Garçom", 0)); 

        List<Mesas> listaMesas = new ArrayList<>();
        listaMesas.add(new Mesas(1, 4));
        listaMesas.add(new Mesas(2, 2));
        listaMesas.add(new Mesas(3, 6));
        listaMesas.add(new Mesas(4, 4));

        while (true) {
            System.out.println("Escolha uma entre as opções: ");
            System.out.println("1 - ADM");
            System.out.println("2 - Usuário (Garçom)");
            System.out.println("3 - Sair");
            int escolhaOpcao = scanner.nextInt();

            if (escolhaOpcao == 1) {
                System.out.println("Logado como Adm");

                while (true) {
                    System.out.println("1 - Cadastrar novo prato");
                    System.out.println("2 - Cadastrar novo funcionário");
                    System.out.println("3 - Cadastrar nova mesa");
                    System.out.println("4 - Listar mesas");
                    System.out.println("5 - Gerar relatório de vendas");
                    System.out.println("6 - Sair do modo ADM");

                    int opcaoCadastro = scanner.nextInt();

                    switch (opcaoCadastro) {
                        case 1:
                            scanner.nextLine(); 
                            System.out.print("Digite o nome do prato: ");
                            String nomePrato = scanner.nextLine();
                            System.out.print("Digite o nome da bebida: ");
                            String nomeBebida = scanner.nextLine();
                            int precoItem;
                            int quantidadeDisponivel;
                            do {
                                System.out.print("Digite o preço do item: ");
                                precoItem = scanner.nextInt();
                                if (precoItem < 0) {
                                    System.out.println("O preço deve ser positivo.");
                                }
                            } while (precoItem < 0);

                            do {
                                System.out.print("Digite a quantidade disponível: ");
                                quantidadeDisponivel = scanner.nextInt();
                                if (quantidadeDisponivel < 0) {
                                    System.out.println("A quantidade deve ser positiva.");
                                }
                            } while (quantidadeDisponivel < 0);

                            Cardapio.adicionarPrato(new Cardapio(nomePrato, nomeBebida, Cardapio.listarPratos().size() + 1, precoItem, quantidadeDisponivel));
                            System.out.println("Prato cadastrado com sucesso!");
                            break;

                        case 2:
                            scanner.nextLine(); 
                            System.out.print("Digite o nome do funcionário: ");
                            String nomeFuncionario = scanner.nextLine();
                            System.out.print("Digite o cargo do funcionário: ");
                            String cargoFuncionario = scanner.nextLine();
                            
                            Funcionarios novoFuncionario = new Funcionarios(nomeFuncionario, cargoFuncionario, 0);
                            listaFuncionarios.add(novoFuncionario);
                            System.out.println("Funcionário cadastrado com sucesso!");
                            break;

                        case 3:
                            System.out.print("Digite o número da mesa: ");
                            int numMesa = scanner.nextInt();
                            System.out.print("Digite a capacidade da mesa: ");
                            int capacidadeMesa = scanner.nextInt();
                            
                            Mesas novaMesa = new Mesas(numMesa, capacidadeMesa);
                            listaMesas.add(novaMesa);
                            System.out.println("Mesa cadastrada com sucesso!");
                            break;

                        case 4:
                            System.out.println("Mesas cadastradas:");
                            for (Mesas mesa : listaMesas) {
                                System.out.println(mesa);
                            }
                            break;

                        case 5:
                            relatorioFaturamento.gerarRelatorio();
                            break;

                        case 6:
                            System.out.println("Saindo do modo ADM...");
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }
                    if (opcaoCadastro == 6) break;
                }
            } else if (escolhaOpcao == 2) {
                while (true) { 
                    System.out.println("Logado como Garçom");
                    System.out.println("Mesas disponíveis:");
                    for (Mesas mesa : listaMesas) {
                        if (mesa.isStatusMesa()) {
                            System.out.println(mesa);
                        }
                    }

                    System.out.print("Escolha a mesa pelo número ou 0 para sair: ");
                    int numMesaEscolhida = scanner.nextInt();
                    if (numMesaEscolhida == 0) {
                        break; 
                    }

                    Mesas mesaEscolhida = null;
                    for (Mesas mesa : listaMesas) {
                        if (mesa.getNumMesa() == numMesaEscolhida) {
                            mesaEscolhida = mesa;
                            break;
                        }
                    }

                    if (mesaEscolhida == null || !mesaEscolhida.isStatusMesa()) {
                        System.out.println("Mesa inválida ou ocupada.");
                        continue;
                    }

                    mesaEscolhida.ocuparMesa();
                    Pedidos pedido = new Pedidos(mesaEscolhida, listaFuncionarios.get(0)); 

                    while (true) {
                        System.out.println("Cardápio:");
                        List<Cardapio> pratos = Cardapio.listarPratos();
                        for (Cardapio prato : pratos) {
                            System.out.println(prato);
                        }
                        System.out.println("Escolha o prato pelo ID ou digite 0 para finalizar o pedido:");
                        int idItem = scanner.nextInt();

                        if (idItem == 0) {
                            pedido.finalizarPedido();
                            relatorioFaturamento.registrarVenda(mesaEscolhida.getNumMesa(), listaFuncionarios.get(0), pedido.getValorTotal());
                            mesaEscolhida.liberarMesa(); 
                            System.out.println("Pedido finalizado!");
                            break; 
                        } else if (idItem > 0 && idItem <= pratos.size()) {
                            Cardapio itemSelecionado = pratos.get(idItem - 1);
                            System.out.print("Digite a quantidade: ");
                            int quantidade = scanner.nextInt();

                            pedido.adicionarItem(itemSelecionado, quantidade);
                        } else {
                            System.out.println("ID de item inválido.");
                        }
                    }
                }
            } else if (escolhaOpcao == 3) {
                System.out.println("Encerrando o sistema! ");
                break; 
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close(); 
    }
}
