package uy.com.salario.calculadora.Domain;

import java.util.ArrayList;

public class DetalleIRPF {
    ArrayList<Double> impuestoFranja;
    double deducciones;
    double tasaDeducciones;
    

    
    public DetalleIRPF(double deducciones, double tasaDeducciones) {
        this.deducciones = deducciones;
        this.tasaDeducciones = tasaDeducciones;
    }
    public ArrayList<Double> getImpuestoFranja() {
        return impuestoFranja;
    }
    public void setImpuestoFranja(ArrayList<Double> impuestoFranja) {
        this.impuestoFranja = impuestoFranja;
    }
    public double getDeducciones() {
        return deducciones;
    }
    public void setDeducciones(double deducciones) {
        this.deducciones = deducciones;
    }
    public double getTasaDeducciones() {
        return tasaDeducciones;
    }
    public void setTasaDeducciones(double tasaDeducciones) {
        this.tasaDeducciones = tasaDeducciones;
    }
    
}
