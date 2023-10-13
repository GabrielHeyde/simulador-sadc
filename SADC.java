import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SADC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Paciente> pacientes = new LinkedList<>();

        boolean parar = false;

        while (parar == false) {
            System.out.println(
                    "\nBem-vindo ao sistema de cadastro do SADC!\n\nDigite 1 para adicionar um novo paciente;\nDigite 2 para Encerrar os cadastramentos.");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o nome do paciente: ");
                    String nome = scanner.next();
                    System.out.println(" ");
                    System.out.println("Digite a idade do paciente: ");
                    String idadeStr = scanner.next();
                    while (verificaInt(idadeStr) == false) {
                        System.out.println("Valor inválido! Digite novamente a idade do paciente: ");
                        idadeStr = scanner.next();
                    }
                    int idade = Integer.parseInt(idadeStr);
                    System.out.println(" ");
                    System.out.println("Digite o número do prontuário do paciente: ");
                    String prontuario = scanner.next();
                    while (verificaInt(prontuario) == false) {
                        System.out.println(
                                "Valor inválido! Digite novamente o prontuário (apenas com números) do paciente: ");
                        prontuario = scanner.next();
                    }
                    System.out.println(" ");
                    System.out.println(
                            "O paciente relatou Doença febril aguda com duração máxima de sete dias, acompanhada de pelo menos dois dos seguintes sintomas como: \n-Cefaleia; \n-Dor retro-orbitária; \n-Mialgia; \n-Artralgia; \n-Prostação ou Exantema, associados ou não à presença de hemorragias. \nDigite POSITIVO em caso afirmativo e NEGATIVO em caso negativo: ");
                    boolean sintomas = false;
                    String texto = scanner.next();
                    String resposta = texto.toLowerCase();
                    while (resposta.equals("negativo") == false && resposta.equals("positivo") == false) {
                        System.out.println("VALOR INVÁLIDO! Tente novamente.");
                        texto = scanner.next();
                        resposta = texto.toLowerCase();
                    }
                    if (resposta.equals("positivo")) {
                        System.out.println("Resposta AFIRMATIVA.");
                        sintomas = true;
                    } else if (resposta.equals("negativo")) {
                        System.out.println("Resposta NEGATIVA.");
                        sintomas = false;
                    }
                    Paciente pNovo = new Paciente(nome, idade, prontuario, sintomas);
                    pacientes.add(pNovo);
                    System.out.println(" ");
                    System.out.println(
                            "Cadastro realizado com sucesso!\n==============================================================================================================================");
                    break;
                case 2:
                    System.out.println("Encerrando o programa de cadastro...");
                    System.out.println("==============================================================================================================================");
                    parar = true;
                    break;

                default:
                    System.out.println("Opção Inválida! Tente novamente informando 1 ou 2.");
                    break;
            }
        }























        Queue<Paciente> pacientesAtendidos = new LinkedList<>();

        for (Paciente paciente : pacientes) {
            if (paciente.isSintomas() == true) {
                System.out.println("O(A) paciente " + paciente.getNome()
                        + " apresenta tempo de doença menor que seis dias?\nDigite POSITIVO em caso afirmativo ou NEGATIVO em caso negativo: ");
                String resposta = scanner.next();
                String veredito = resposta.toLowerCase();
                while (veredito.equals("negativo") == false && resposta.equals("positivo") == false) {
                    System.out.println("VALOR INVÁLIDO! Tente novamente.");
                    resposta = scanner.next();
                    veredito = resposta.toLowerCase();
                }
                    if (veredito.equals("positivo")) {
                        System.out
                                .println("O paciente " + paciente.getNome()
                                        + " passará pela triagem do Teste Rápido.");
                        System.out.println(
                                "\nPara o resultado do teste de NS1, digite *POSITIVO* em caso positivo e *NEGATIVO* em caso negativo");
                        String resposta1 = scanner.next();
                        String r1 = resposta1.toUpperCase();
                        boolean NS1 = false;
                        while(r1.equals("POSITIVO") == false && r1.equals("NEGATIVO") == false){
                            System.out.println("Valor inválido! Digite novamente: ");
                            resposta1 = scanner.next();
                            r1 = resposta1.toUpperCase();
                        }

                        if (r1.equals("POSITIVO")) {
                            NS1 = true;
                        } else if (r1.equals("NEGATIVO")) {
                            NS1 = false;
                        }

                        System.out.println(
                                "\nPara o resultado do teste de IgM, digite *POSITIVO* em caso positivo e *NEGATIVO* em caso negativo");
                        String resposta2 = scanner.next();
                        String r2 = resposta2.toUpperCase();
                        boolean IgM = false;
                        while(r2.equals("POSITIVO") == false && r2.equals("NEGATIVO") == false){
                            System.out.println("Valor inválido! Digite novamente: ");
                            resposta2 = scanner.next();
                            r2 = resposta2.toUpperCase();
                        }
                        if (r2.equals("POSITIVO")) {
                            IgM = true;
                        } else if (r2.equals("NEGATIVO")) {
                            IgM = false;
                        }

                        System.out.println(
                                "\nPara o resultado do teste de IgG, digite *POSITIVO* em caso positivo e *NEGATIVO* em caso negativo");
                        String resposta3 = scanner.next();
                        String r3 = resposta3.toUpperCase();
                        boolean IgG = false;
                        while(r3.equals("POSITIVO") == false && r3.equals("NEGATIVO") == false){
                            System.out.println("Valor inválido! Digite novamente: ");
                            resposta3 = scanner.next();
                            r3 = resposta3.toUpperCase();
                        }
                        if (r3.equals("POSITIVO")) {
                            IgG = true;
                        } else if (r3.equals("NEGATIVO")) {
                            IgG = false;
                        }
                        paciente.setDiagnostico(passaDiagnostico(NS1, IgM, IgG));
                        System.out.println("==============================================================================================================================");

                    }























                    else {
                        System.out
                                .println("\nO paciente " + paciente.getNome() + " passará pela triagem do Teste ElisA.");
                        System.out.println(
                                "\nPara o resultado do teste de IgM, digite *POSITIVO* em caso positivo e *NEGATIVO* em caso negativo");
                        String resposta2 = scanner.next();
                        String r2 = resposta2.toUpperCase();
                        boolean IgM = false;
                        while(r2.equals("POSITIVO") == false && r2.equals("NEGATIVO") == false){
                            System.out.println("Valor inválido! Digite novamente: ");
                            resposta2 = scanner.next();
                            r2 = resposta2.toUpperCase();
                        }
                        if (r2.equals("POSITIVO")) {
                            IgM = true;
                        } else if (r2.equals("NEGATIVO")) {
                            IgM = false;
                        }

                        System.out.println(
                                "\nPara o resultado do teste de IgG, digite *POSITIVO* em caso positivo e *NEGATIVO* em caso negativo");
                        String resposta3 = scanner.next();
                        String r3 = resposta3.toUpperCase();
                        boolean IgG = false;
                        while(r3.equals("POSITIVO") == false && r3.equals("NEGATIVO") == false){
                            System.out.println("Valor inválido! Digite novamente: ");
                            resposta3 = scanner.next();
                            r3 = resposta3.toUpperCase();
                        }
                        if (r3.equals("POSITIVO")) {
                            IgG = true;
                        } else if (r3.equals("NEGATIVO")) {
                            IgG = false;
                        }
                        paciente.setDiagnostico(passaDiagnosticoElisA(IgM, IgG));
                        System.out.println("==============================================================================================================================");

                    }

                    pacientesAtendidos.add(paciente);
                }

                if (paciente.isSintomas() == false) {
                    System.out.println(
                            "\nPela falta de sintomas apresentados pelo paciente " + paciente.getNome()
                                    + ", não será feito os testes com o mesmo.");
                    System.out.println("==============================================================================================================================");
                }
            }

            scanner.close();









































            int contador = 1;
            for (Paciente p : pacientesAtendidos) {
                System.out.println("\nINFORMAÇÕES DO " + contador + "º PACIENTE: ");
                System.out.println("Nome do Paciente: " + p.getNome());
                System.out.println("Idade do Paciente: " + p.getIdade());
                System.out.println("Prontuário do Paciente: " + p.getProntuario());
                System.out.println("DIAGNÓSTICO DO PACIENTE: " + p.getDiagnostico());
                contador++;
                System.out.println(
                        "================================================================================================================================================================");
            }

            String arquivoSaida = "Diagnosticos_Pacientes.csv";

            try {
                PrintWriter escritor = new PrintWriter(new FileWriter(arquivoSaida));
                for (Paciente pac : pacientesAtendidos) {
                    escritor.println(pac.getProntuario() + ";" + pac.getDiagnostico());

                }

                escritor.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println("Arquivo criado com sucesso!");
        }

    public static boolean verificaInt(String texto) {
        try {
            int teste = Integer.parseInt(texto);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String passaDiagnostico(boolean NS1, boolean IgM, boolean IgG) {
        if (NS1 == false && IgM == false && IgG == true) {
            return "Provável infecção prévia";
        } else if (NS1 == false && IgM == false && IgG == false) {
            return "Dengue improvável";
        } else if (NS1 == true && IgM == false && IgG == true) {
            return "Infecção aguda e provável infecção prévia";
        } else {
            return "Infecção aguda";
        }
    }

    public static String passaDiagnosticoElisA(boolean IgM, boolean IgG) {
        if (IgM == false && IgG == true) {
            return "Provável infecção prévia";
        } else if (IgM == false && IgG == false) {
            return "Dengue improvável";
        } else if (IgM == true && IgG == false) {
            return "Infecção aguda";
        } else {
            return "Infecção aguda e provável infecção prévia";
        }
    }

}