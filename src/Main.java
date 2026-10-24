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
            opcao = Integer.parseInt(sc.nextLine());

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
                    BigDecimal valorVendas = new BigDecimal(sc.nextLine());

                    System.out.println("Digite o percentual de comissão: ");
                    float percentualComissao = Float.parseFloat(sc.nextLine());

                    controle.adicionarColaborador(nome, valorVendas, percentualComissao);
                    System.out.println("\nColaborador adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o nome do Colaborador produção: ");
                    nome = sc.nextLine();

                    System.out.print("Digite a quantidade de peças: ");
                    int quantidade = Integer.parseInt(sc.nextLine());

                    System.out.print("Digite o valor por peça: ");
                    BigDecimal valorPorPeca = new BigDecimal(sc.nextLine());

                    controle.adicionarColaborador(nome, quantidade, valorPorPeca);
                    System.out.println("\nColaborador adicionado com sucesso!");
                    break;
            }
        }while(opcao != 0);
    }
}
