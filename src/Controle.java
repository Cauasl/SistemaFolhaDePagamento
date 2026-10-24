import java.math.BigDecimal;
import java.util.ArrayList;

public class Controle {
    ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public void adicionarColaborador(String nome) {
        colaboradores.add(new ColaboradorPadrao(colaboradores.size(), nome));
    }
    public void adicionarColaborador(String nome, BigDecimal valorVendas, float percentualComissao) {
        colaboradores.add(new ColaboradorComissionado(colaboradores.size(), nome, valorVendas, percentualComissao));
    }
    public void adicionarColaborador(String nome, int quatidadePecas, BigDecimal valorPorPecas) {
        colaboradores.add(new ColaboradorProducao(colaboradores.size(), nome, quatidadePecas, valorPorPecas));
    }


}
