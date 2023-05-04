import java.util.Scanner;

public class Conta {

    private String tipoConta;
    private double saldo;
    private String nome;

    public Conta(String nome, String tipoConta) {
        this.nome = nome;
        this.tipoConta = tipoConta;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        int resposta = 1;
        while(resposta>=1 && resposta<=4){
            System.out.println("1- Consultar saldos\n" +
                    "2- Receber valor\n" +
                    "3- Transferir valor\n" +
                    "4- Sair");
            resposta = sc.nextInt();
            if (resposta>=1 && resposta<=4){
                switch (resposta) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        System.out.println("Valor a ser recebido: ");
                        System.out.print("R$");
                        double valorReceber = sc.nextDouble();
                        recebePix(valorReceber);
                        break;
                    case 3:
                        System.out.println("Valor a ser transferido: ");
                        System.out.print("R$");
                        double valorTransferir = sc.nextDouble();
                        fazPix(valorTransferir);
                        break;
                    case 4:
                        resposta = 0;
                        break;
            }
        }
    }}

    private void recebePix(double valor){
        this.saldo += valor;
        System.out.println("Novo saldo: R$" + saldo);
    }

    private void fazPix(double valor){
        if (valor>this.saldo){
            System.out.println("Saldo insuficiente!\n");
            return;
        }
        this.saldo -= valor;
        System.out.println("Transferencia bem-sucedida.");
    }

    private void consultarSaldo(){
        System.out.println("\n*****************");
        System.out.println("Nome: " + nome + "\n" +
                "Tipo Conta: " + tipoConta + "\n" +
                "Saldo atual: " + saldo);
        System.out.println("*****************");
    }


}
