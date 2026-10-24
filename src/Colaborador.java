import java.math.BigDecimal;

public abstract class Colaborador {
    private int matricula;
    private String nome;
    protected BigDecimal salarioBase = new BigDecimal("2000.00");
    protected String tipoColaborador;

    Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public BigDecimal calcularSalarioFinal() {
        return this.salarioBase;
    }

    public String exibirDados() {
        return super.toString();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioBase(String salarioBase) {
        BigDecimal salario = new BigDecimal(salarioBase);
        if(salarioBase.compareTo("0.00") <= 0) {
            this.salarioBase = salario;
        }else {
            throw new IllegalArgumentException("Valores negaivos não são permitidos!");
        }
    }
}
