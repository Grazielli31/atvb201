package AtvAvaliativa01b2;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private String nomePrato;
    private String nomeBebida;
    private int idItem;
    private int precoItem;
    private boolean itemDisp = true;
    private int quantidadeDisponivel; 

    private static List<Cardapio> listaPratos = new ArrayList<>();

    public Cardapio(String nomePrato, String nomeBebida, int idItem, int precoItem, int quantidadeDisponivel) {
        this.nomePrato = nomePrato;
        this.nomeBebida = nomeBebida;
        this.idItem = idItem;
        this.precoItem = precoItem;
        this.itemDisp = true;
        this.quantidadeDisponivel = quantidadeDisponivel; 
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getPrecoItem() {
        return precoItem;
    }

    public boolean isItemDisp() {
        return itemDisp;
    }

    public void setItemDisp(int novaQuantidade) {
        this.quantidadeDisponivel = novaQuantidade; 
        if (novaQuantidade <= 0) {
            this.itemDisp = false; 
        }
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel; 
    }

    @Override
    public String toString() {
        return "Prato: " + nomePrato + " + " + nomeBebida + " - R$ " + precoItem + " (Disponível: " + quantidadeDisponivel + ")";
    }

    public static void adicionarPrato(Cardapio prato) {
        listaPratos.add(prato);
    }

    public static List<Cardapio> listarPratos() {
        return listaPratos;
    }
}
