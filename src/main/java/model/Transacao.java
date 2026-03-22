package model;

import java.time.LocalDate;

public class Transacao {

    private final String descricao;
    private final double valor;
    private final boolean ehReceita;
    private final LocalDate data;

    public Transacao(String descricao, double valor, boolean ehReceita, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.ehReceita = ehReceita;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isEhReceita() {
        return ehReceita;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorReal() {
        return ehReceita ? valor : -valor;
    }

    @Override
    public String toString() {
        return descricao + " | R$ " + valor +
                " | " + (ehReceita ? "Receita" : "Despesa") +
                " | Data: " + data;
    }
}