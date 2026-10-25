import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controle controle = new Controle();
        int opcao;
        String nome;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                1 - Cadastrar Colaborador Padrão
                2 - Cadastrar Colaborador Comissionado
                3 - Cadastrar Colaborador Produção
                4 - Gerar Folha de Pagamento
                5 - Exibir Resumo da Folha
                0 - Encerrar
                """);
            System.out.print("Digite a opção que deseja: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println("\n");

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do Colaborador padrão: ");
                        nome = sc.nextLine();
                        controle.adicionarColaborador(nome);
                        System.out.println("\nColaborador adicionado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite o nome do Colaborador comissionado: ");
                        nome = sc.nextLine();

                        System.out.print("Digite o valor de vendas: ");
                        BigDecimal valorVendas = new BigDecimal(sc.nextLine().trim());

                        System.out.print("Digite o percentual de comissão: ");
                        float percentualComissao = Float.parseFloat(sc.nextLine().trim());

                        controle.adicionarColaborador(nome, valorVendas, percentualComissao);
                        System.out.println("\nColaborador adicionado com sucesso!\n");
                        break;

                    case 3:
                        System.out.print("Digite o nome do Colaborador produção: ");
                        nome = sc.nextLine();

                        System.out.print("Digite a quantidade de peças: ");
                        int quantidade = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Digite o valor por peça: ");
                        BigDecimal valorPorPeca = new BigDecimal(sc.nextLine().trim());

                        controle.adicionarColaborador(nome, quantidade, valorPorPeca);
                        System.out.println("\nColaborador adicionado com sucesso!");
                        break;

                    case 4:
                        System.out.println("Segue a folha de pagamento!\n");
                        System.out.println(controle.gerarFolhaPagamento());;
                        break;

                    case 5:
                        System.out.println("Segue o resumo da folha de pagamento!\n");
                        System.out.println(controle.resumoFolhaPagamento());

                    case 0:
                        System.out.print("");
                        break;
                        
                    default:
                        System.out.println("Opção não existente!");
                }
            }catch (NumberFormatException e){
                System.out.println("O número em questão foi inserido de maneira errada, tente deixar sem espaços: " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Não se pode inserir valores menores que zero no cadastrado de colaboradores! " + e.getMessage());
            }finally {
                System.out.println("\n");
            }

        }while(opcao != 0);
    }
}
