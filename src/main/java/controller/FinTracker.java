package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.Transacao;
import exceptions.EntradaInvalidaException;

public class FinTracker {

    private final ArrayList<Transacao> transacoes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void adicionarTransacao() {

        try {

            System.out.print("Numero do banco: ");
            String descricao = scanner.nextLine();

            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            System.out.print("E receita? (true/false): ");
            boolean ehReceita = scanner.nextBoolean();
            scanner.nextLine();

            if (valor <= 0) {
                throw new EntradaInvalidaException("ERRO! [Valor deve ser maior que zero.]");
            }

            Transacao t = new Transacao(descricao, valor, ehReceita, LocalDate.now());
            transacoes.add(t);

            System.out.println("Deposito adicionada com sucesso!");

        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Entrada invalida!");
            scanner.nextLine();
        }
    }

    public void listarTransacoes() {

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transacao cadastrada.");
            return;
        }

        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println((i + 1) + " - " + transacoes.get(i));
        }
    }

    public void removerTransacao() {

        listarTransacoes();

        if (transacoes.isEmpty()) return;

        try {
            System.out.print("Digite o numero do valor para retirar: ");
            int indice = scanner.nextInt();
            scanner.nextLine();

            transacoes.remove(indice - 1);

            System.out.println("Transacao retirada!");

        } catch (Exception e) {
            System.out.println("Indice invlido!");
            scanner.nextLine();
        }
    }

    public void calcularSaldoTotal() {

        double saldo = 0;

        for (Transacao t : transacoes) {
            saldo += t.getValorReal();
        }

        System.out.println("Saldo atual: R$ " + saldo);
    }
}
