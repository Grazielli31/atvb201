package AtvAvaliativa01b2;

public class Funcionarios {
    
    private String nomeFunc;
    private int idFunc;
    private String cargoFunc;
    private int totalVendasGarcons;
    private int totalPedidos; 
    private double valorTotalVendas;

  
    private static int contadorId = 1;
    
    public Funcionarios(String nomeFunc, String cargoFunc, int totalVendasGarcons) {
        this.nomeFunc = nomeFunc;
        this.idFunc = contadorId++; 
        this.cargoFunc = cargoFunc;
        this.totalVendasGarcons = totalVendasGarcons;
        this.totalPedidos = 0; 
        this.valorTotalVendas = 0.0; 
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public String getCargoFunc() {
        return cargoFunc;
    }

    public int getTotalVendasGarcons() {
        return totalVendasGarcons;
    }

    public void setTotalVendasGarcons(int totalVendasGarcons) {
        this.totalVendasGarcons = totalVendasGarcons;
    }

    public void adicionarVenda(double valorVenda) {
        totalPedidos++;
        valorTotalVendas += valorVenda; 
    }

    public int getTotalPedidos() {
        return totalPedidos;
    }

    public double getValorTotalVendas() {
        return valorTotalVendas;
    }

    public void exibirRelatorio() {
        System.out.println("Relatório de Vendas:");
        System.out.println("Nome do Funcionário: " + nomeFunc);
        System.out.println("Total de Pedidos Realizados: " + totalPedidos);
        System.out.println("Valor Total Vendido: R$" + String.format("%.2f", valorTotalVendas));
    }

    public String toString() {
        return "Funcionarios [nomeFunc=" + nomeFunc + ", idFunc=" + idFunc + ", cargoFunc=" + cargoFunc
                + ", totalVendasGarcons=" + totalVendasGarcons + "]";
    }
}
