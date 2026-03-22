
package app;

import controller.FinTracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FinTracker sistema = new FinTracker();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n [ FINTRACK - SEU CONTROLE FINANCEIRO ]");
            System.out.println("1. Depositar nova transacao");
            System.out.println("2. Historico transacoes");
            System.out.println("3. Mostrar saldo atual");
            System.out.println("4. Sacar transacao");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> sistema.adicionarTransacao();
                case 2 -> sistema.listarTransacoes();
                case 3 -> sistema.calcularSaldoTotal();
                case 4 -> sistema.removerTransacao();
                case 5 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 5);
    }
}