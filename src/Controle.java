import java.math.BigDecimal;
import java.util.ArrayList;

public class Controle {
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public void adicionarColaborador(String nome) {
        colaboradores.add(new ColaboradorPadrao(colaboradores.size(), nome));
    }
    public void adicionarColaborador(String nome, BigDecimal valorVendas, float percentualComissao) {
        colaboradores.add(new ColaboradorComissionado(colaboradores.size(), nome, valorVendas, percentualComissao));
    }
    public void adicionarColaborador(String nome, int quatidadePecas, BigDecimal valorPorPecas) {
        colaboradores.add(new ColaboradorProducao(colaboradores.size(), nome, quatidadePecas, valorPorPecas));
    }

    private String gerarFolhaPagamentoUnico(int matricula) {
        Colaborador colaborador =  colaboradores.get(matricula);
        String tipo;
        String benificio;

        switch (colaborador.getTipoColaborador()) {
            case "Produção":
                tipo = "Produção";
                benificio = "Produtividade: " + colaborador.calcularSalarioFinal();
                break;
            case "Comissionado":
                tipo = "Comissionado";
                benificio = "Comissionado: " + colaborador.calcularSalarioFinal();
                break;

            default:
                tipo = "Padrão";
                benificio = "";
        }

        return "Nome: " + colaborador.getNome() + " | " + "Salário base: " +  colaborador.getSalarioBase() + "\n" +
                "Tipo: " + tipo + " | " + benificio + "\n" +
                "Matrícula: " + colaborador.getMatricula() + " | " + "Salário final: " + colaborador.calcularSalarioFinal() + "\n \n";
    }

    public String gerarFolhaPagamento() {
        String folhaPagamento = "";

        for(int i = 0; i < colaboradores.size(); i++) {
            folhaPagamento += gerarFolhaPagamentoUnico(i);
        }

        return folhaPagamento;
    }

    public String resumoFolhaPagamento() {
        BigDecimal somaSalarios = BigDecimal.ZERO;

        for(int i = 0; i < colaboradores.size(); i++) {
            somaSalarios = somaSalarios.add(colaboradores.get(i).getSalarioBase());
        }

        return "Quantidade total de colaboradores; " + colaboradores.size() + " | " + "Soma total: " + somaSalarios + " | " + "Média salarial: " + somaSalarios.divide(BigDecimal.valueOf(colaboradores.size()), 2);
    }
}
