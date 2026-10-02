package entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque{
    private final List<Medicamento> estoqueMedicamentos = new ArrayList<>();


    public void cadastrarMedicamento(Medicamento medicamento){

        estoqueMedicamentos.add(medicamento);

    }

    public List<Medicamento> listarEstoque(){

        return estoqueMedicamentos;

    }

    public Medicamento buscarMedicamento(String nomeMedicamento){

        return  estoqueMedicamentos.stream().filter(medicamento -> medicamento.getNome().equals(nomeMedicamento)).findFirst().orElse(null);
    }
}
