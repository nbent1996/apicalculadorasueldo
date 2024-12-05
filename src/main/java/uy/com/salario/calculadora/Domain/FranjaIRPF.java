package uy.com.salario.calculadora.Domain;

public class FranjaIRPF {
    double desde;
    double hasta;
    double tasa;
    
    public FranjaIRPF(double desde, double hasta, double tasa) {
        this.desde = desde;
        this.hasta = hasta;
        this.tasa = tasa;
    }
    public double getDesde() {
        return desde;
    }
    public void setDesde(double desde) {
        this.desde = desde;
    }
    public double getHasta() {
        return hasta;
    }
    public void setHasta(double hasta) {
        this.hasta = hasta;
    }
    public double getTasa() {
        return tasa;
    }
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    
}
