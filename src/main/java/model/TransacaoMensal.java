
package model;
import java.time.LocalDate;
public class TransacaoMensal extends Transacao {

    private final int mesReferencia;

    public TransacaoMensal(String descricao, double valor, boolean ehReceita,
                           LocalDate data, int mesReferencia) {
        super(descricao, valor, ehReceita, data);
        this.mesReferencia = mesReferencia;
    }

    public int getMesReferencia() {
        return mesReferencia;
    }

    @Override
    public String toString() {
        return super.toString() + " | Mês Ref: " + mesReferencia;
    }
}