import java.math.BigDecimal;

public class ColaboradorComissionado extends Colaborador{
    BigDecimal valorVendas;
    float percentualComissao;


    ColaboradorComissionado(int matricula, String nome, BigDecimal valorVendas, float percentualComissao) {
        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
        super.tipoColaborador = "Comissionado";
    }

    public BigDecimal calcularComissao(){
        return valorVendas.multiply(BigDecimal.valueOf(percentualComissao)).divide(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal calcularSalarioFinal(){
        return salarioBase.add(calcularComissao());
    }
}
