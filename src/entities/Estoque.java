package entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque{
    private final List<Medicamento> estoqueMedicamentos = new ArrayList<>();

    //consts de retorno de entrada
    public final int MEDICAMENTO_NAO_ENCONTRADO = 1;
    public final int QUANTIDADE_ENTRADA_INVALIDA = 2;
    public final int ENTRADA_MEDICAMENTO_SUCESSO = 3;

    public void cadastrarMedicamento(Medicamento medicamento){

        estoqueMedicamentos.add(medicamento);

    }

    public List<Medicamento> listarEstoque(){

        return estoqueMedicamentos;

    }

    public Medicamento buscarMedicamento(String nomeMedicamento){

        return  estoqueMedicamentos.stream().filter(medicamento -> medicamento.getNome().equals(nomeMedicamento)).findFirst().orElse(null);
    }

    public int entradaEstoque(String nomeMedicamento, int quantidade){

        Medicamento medicamentoBuscado = buscarMedicamento(nomeMedicamento);
        if (medicamentoBuscado == null){
            return MEDICAMENTO_NAO_ENCONTRADO;
        }

        if (quantidade < 0){
            return QUANTIDADE_ENTRADA_INVALIDA;
        }

        medicamentoBuscado.entradaMedicamento(quantidade);
        return ENTRADA_MEDICAMENTO_SUCESSO;
    }
}
//teste