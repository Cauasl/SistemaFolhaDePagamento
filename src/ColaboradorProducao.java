import java.math.BigDecimal;

public class ColaboradorProducao extends Colaborador{
    int quantidadePecas;
    BigDecimal valorPorPeca;

    ColaboradorProducao(int matricula, String nome, int quantidadePecas, BigDecimal valorPorPeca) {
        super(matricula, nome);
        if (quantidadePecas <= 0) throw new IllegalArgumentException("Quantidade de peças precisa ser maior que 0");
        if (valorPorPeca.compareTo(new BigDecimal("0.00")) <= 0) throw new IllegalArgumentException("Valor por peças precisa ser maior que 0");
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
        super.tipoColaborador = "Produção";
    }


    public BigDecimal calcularProdutividade() {
        return valorPorPeca.add(BigDecimal.valueOf(quantidadePecas));
    }

    @Override
    public BigDecimal calcularSalarioFinal() {
        return salarioBase.add(calcularProdutividade());
    }
}
