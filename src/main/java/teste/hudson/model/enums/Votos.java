package teste.hudson.model.enums;

public enum Votos {
    NAO(0, "Não"),
    SIM(1, "Sim");

    private int cod;
    private String descricao;

    private Votos(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Votos toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Votos x : Votos.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
