import entities.Medicamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<Medicamento> controleMedicamentos = new ArrayList<>();

        boolean continuar = true;

        while(continuar){

            int respostaUser = menu(sc);

            switch (respostaUser){

                case 1:
                    System.out.println("================================");
                    System.out.println("      Cadastro Medicamentos     ");
                    System.out.println("================================");

                    String nome, principioAtivo;
                    int quantidadeEstoque;

                    System.out.println("");
                    sc.nextLine();

                    System.out.print("Nome do medicamento: ");
                    nome = sc.nextLine().toUpperCase();

                    System.out.print("Princípio ativo: ");
                    principioAtivo = sc.nextLine();

                    System.out.print("Quantidade em estoque: ");
                    quantidadeEstoque = sc.nextInt();

                    controleMedicamentos.add(new Medicamento(nome,principioAtivo, quantidadeEstoque));

                    System.out.printf("Medicamento %s salvo com sucesso %n", nome);
                    break;


                case 2:
                    System.out.println("================================");
                    System.out.println("      Listagem Medicamentos     ");
                    System.out.println("================================");

                    System.out.println("");
                    System.out.println("MEDICAMENTO       PRINCÍPIO ATIVO       QUANTIDADE");
                    System.out.println("-------------------------------------------------------");

                    for(Medicamento medicamento: controleMedicamentos){
                        System.out.println(medicamento);
                    }
                    break;


                case 3:
                    System.out.println("================================");
                    System.out.println("      Consultar Medicamento     ");
                    System.out.println("================================");

                    System.out.println("");
                    sc.nextLine();

                    System.out.println("Digite o nome do medicamento: ");
                    String buscarMedicamento = sc.nextLine().toUpperCase();

                    Medicamento medicamentoBuscado = controleMedicamentos.stream().filter(medicamento -> medicamento.getNome().equals(buscarMedicamento)).findFirst().orElse(null);

                    if (medicamentoBuscado != null){

                        System.out.println(medicamentoBuscado);
                    }
                    else {

                        System.out.println("Este medicamento não esta cadastrado");
                    }
                    break;

                case 4:

                    System.out.println("Finalizando Programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Valor Invalido");
                    break;


            }
        }


//Teste

        sc.close();
    }


    public static int menu(Scanner sc){
        System.out.println("================================");
        System.out.println("         MedOps Controls        ");
        System.out.println("================================");

        System.out.println("1 - Cadastrar medicamentos");
        System.out.println("2 - Listar medicamentos");
        System.out.println("3 - Consultar medicamentos");
        System.out.println("4 - Sair");

        return sc.nextInt();
    }
}