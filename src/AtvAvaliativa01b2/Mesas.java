package AtvAvaliativa01b2;

public class Mesas {
    
    private int numMesa;
    private int capacidadeMesa;
    private boolean statusMesa; 

    public Mesas(int numMesa, int capacidadeMesa) {
        this.numMesa = numMesa;
        this.capacidadeMesa = capacidadeMesa;
        this.statusMesa = true; 
    }

    public int getNumMesa() {
        return numMesa;
    }

    public int getCapacidadeMesa() {
        return capacidadeMesa;
    }

    public boolean isStatusMesa() {
        return statusMesa; 
    }

    public void ocuparMesa() {
        this.statusMesa = false; 
    }

    public void liberarMesa() {
        this.statusMesa = true; 
    }

    @Override
    public String toString() {
        return "Mesa [Número=" + numMesa + ", Capacidade=" + capacidadeMesa + ", Status=" + (statusMesa ? "Disponível" : "Ocupada") + "]";
    }
}
