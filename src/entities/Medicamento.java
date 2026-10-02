package entities;

public class Medicamento {
    private String nome;
    private String principioAtivo;
    private int quantidade;


    public Medicamento(String nome, String principioAtivo, int quantidade ){
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return String.format("%-18s %-22s %10d",
                nome, principioAtivo, quantidade);
    }
}

//Teste