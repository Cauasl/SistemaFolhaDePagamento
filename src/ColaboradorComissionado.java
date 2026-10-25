import java.math.BigDecimal;

public class ColaboradorComissionado extends Colaborador{
    BigDecimal valorVendas;
    float percentualComissao;


    ColaboradorComissionado(int matricula, String nome, BigDecimal valorVendas, float percentualComissao) {
        super(matricula, nome);
        if(valorVendas.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("Valor das vendas não pode ser menor que zero!");
        if(percentualComissao < 0) throw new IllegalArgumentException("O percentual não pode ser menor que zero!");
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
        super.tipoColaborador = "Comissionado";
    }

    public BigDecimal calcularComissao(){
        BigDecimal res = valorVendas.multiply(BigDecimal.valueOf(percentualComissao));
        return res.divide(new BigDecimal("100"));
    }

    @Override
    public BigDecimal calcularSalarioFinal(){
        return salarioBase.add(calcularComissao());
    }
}
