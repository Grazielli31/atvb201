package AtvAvaliativa01b2;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private Mesas mesa;
    private Funcionarios garcom;
    private List<Cardapio> itens;
    private List<Integer> quantidades;
    private double valorTotal;

    public Pedidos(Mesas mesa, Funcionarios garcom) {
        this.mesa = mesa;
        this.garcom = garcom;
        this.itens = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Cardapio item, int quantidade) {
        if (item.isItemDisp() && item.getQuantidadeDisponivel() >= quantidade) {  
            itens.add(item);
            quantidades.add(quantidade);
            valorTotal += item.getPrecoItem() * quantidade;
            item.setItemDisp(item.getQuantidadeDisponivel() - quantidade); 
        } else {
            System.out.println("Item " + item.getNomePrato() + " não está disponível ou quantidade insuficiente.");
        }
    }

    public void finalizarPedido() {
        System.out.println("Pedido finalizado: Mesa " + mesa.getNumMesa() +
                ", Garçom " + garcom.getNomeFunc() +
                ", Total: R$" + String.format("%.2f", valorTotal));

        garcom.adicionarVenda(valorTotal);
        mesa.liberarMesa(); 
    }

    public Mesas getMesa() {
        return mesa;
    }

    public Funcionarios getGarcom() {
        return garcom;
    }

    public List<Cardapio> getItens() {
        return itens;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setMesa(Mesas mesa) {
        this.mesa = mesa;
    }   

    public void setGarcom(Funcionarios garcom) {
        this.garcom = garcom;
    }

    @Override
    public String toString() {
        return "Pedidos [mesa=" + mesa + ", garcom=" + garcom + ", itens=" + itens + ", quantidades=" + quantidades
                + ", valorTotal=" + valorTotal + "]";
    }
}
