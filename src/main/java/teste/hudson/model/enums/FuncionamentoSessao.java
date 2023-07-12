package teste.hudson.model.enums;

public enum FuncionamentoSessao {
    ATIVA(1, "Ativa"),
    INATIVA(2, "Inativa");

    private int cod;
    private String descricao;

    private FuncionamentoSessao(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FuncionamentoSessao toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (FuncionamentoSessao x : FuncionamentoSessao.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
