import entities.Estoque;
import entities.Medicamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();


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

                    estoque.cadastrarMedicamento(new Medicamento(nome,principioAtivo, quantidadeEstoque));

                    System.out.printf("Medicamento %s salvo com sucesso %n", nome);
                    break;


                case 2:
                    System.out.println("================================");
                    System.out.println("      Listagem Medicamentos     ");
                    System.out.println("================================");

                    System.out.println("");
                    System.out.println("MEDICAMENTO       PRINCÍPIO ATIVO       QUANTIDADE");
                    System.out.println("-------------------------------------------------------");

                    for(Medicamento medicamento: estoque.listarEstoque()){
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
                    String medicamento = sc.nextLine().toUpperCase();

                    Medicamento medicamentoFiltro = estoque.buscarMedicamento(medicamento);

                    if (medicamentoFiltro != null){

                        System.out.println(medicamentoFiltro);
                    }
                    else {

                        System.out.println("Este medicamento não esta cadastrado");
                    }
                    break;


                case 4:
                    System.out.println("================================");
                    System.out.println("     Entrada de Medicamentos    ");
                    System.out.println("================================");

                    System.out.println("");
                    sc.nextLine();

                    System.out.print("Nome medicamento: ");
                    String medicamentoEntrada = sc.nextLine().toUpperCase();

                    System.out.print("quantidade de entrada: ");
                    int quantidadeEntrada = sc.nextInt();

                    int resultadoEntrada = estoque.entradaEstoque(medicamentoEntrada, quantidadeEntrada);

                    if (resultadoEntrada == estoque.MEDICAMENTO_NAO_ENCONTRADO) {
                        System.out.println("Erro! Medicamento não encontrado");

                    } else if (resultadoEntrada == estoque.QUANTIDADE_ENTRADA_INVALIDA) {
                        System.out.println("Erro! A quantidade precisa ser superior a 0");

                    } else {
                        System.out.printf("Sucesso! A entrada do medicamento %s foi um sucesso %n", medicamentoEntrada);

                        System.out.println("Medicamento atualizado: " + estoque.buscarMedicamento(medicamentoEntrada));
                    }

                    break;

                case 5:

                    System.out.println("Finalizando Programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Valor Invalido");
                    break;


            }
        }




        sc.close();
    }


    public static int menu(Scanner sc){
        System.out.println("================================");
        System.out.println("         MedOps Controls        ");
        System.out.println("================================");

        System.out.println("1 - Cadastrar medicamentos");
        System.out.println("2 - Listar medicamentos");
        System.out.println("3 - Consultar medicamentos");
        System.out.println("4 - Entrada medicamentos");
        System.out.println("5 - Sair");

        return sc.nextInt();
    }
}