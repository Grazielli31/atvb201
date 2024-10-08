package AtvAvaliativa01b2;

public class RelatorioFaturamento {
    private double totalVendas;
    private double[] vendasPorMesa;
    private double[] vendasPorGarcom;
    private int numMesas;
    private int numGarcons;

    public RelatorioFaturamento(int numMesas, int numGarcons) {
        totalVendas = 0.0;
        this.numMesas = numMesas;
        this.numGarcons = numGarcons;
        vendasPorMesa = new double[numMesas];
        vendasPorGarcom = new double[numGarcons];
    }

    public void registrarVenda(int numMesa, Funcionarios garcom, double valor) {
        totalVendas += valor;
        vendasPorMesa[numMesa - 1] += valor; 
        vendasPorGarcom[garcom.getIdFunc() - 1] += valor; 
    }

    public void gerarRelatorio() {
        System.out.println("Relatório do Dia:");
        System.out.println("Total Vendido: R$" + totalVendas);
        
        System.out.println("Vendas por Mesa:");
        for (int i = 0; i < numMesas; i++) {
            System.out.println("Mesa " + (i + 1) + ": R$" + vendasPorMesa[i]);
        }
        
        System.out.println("Vendas por Garçom:");
        for (int i = 0; i < numGarcons; i++) {
            System.out.println("Garçom ID " + (i + 1) + ": R$" + vendasPorGarcom[i]);
        }
    }
}
