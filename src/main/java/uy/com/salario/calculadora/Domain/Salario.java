package uy.com.salario.calculadora.Domain;

public class Salario {
    
    private Double nominal;
    private Double liquido;
    private Double aportesJubilatorios;
    private Double aportesFonasa;
    private Double aportesFRL;
    private Double aportesIRPF;
    private Double aportesFondoSolidaridad;
    private Double aportesAdicionalFondoSolidaridad;
    private Double aportesCJPPU;
    private Double aportesOtrasDeducciones;
        
    public Salario(Double aportesJubilatorios, Double aportesFonasa, double aportesFRL) {
        this.aportesJubilatorios = aportesJubilatorios;
        this.aportesFonasa = aportesFonasa;
        this.aportesFRL = aportesFRL;
        this.nominal = -1.0;
        this.liquido = -1.0;
    }
    public Salario(Double nominal, Double liquido, Double aportesJubilatorios, Double aportesFonasa, double aportesFRL) {
        this.nominal = nominal;
        this.liquido = liquido;
        this.aportesJubilatorios = aportesJubilatorios;
        this.aportesFonasa = aportesFonasa;
        this.aportesFRL = aportesFRL;
    }

    public Salario(Double aportesIRPF) {
        this.aportesIRPF = aportesIRPF;
        this.nominal = -1.0;
        this.liquido = -1.0;
    }
    public Double getNominal() {
        return nominal;
    }
    public void setNominal(Double nominal) {
        this.nominal = nominal;
    }
    public Double getLiquido() {
        return liquido;
    }
    public void setLiquido(Double liquido) {
        this.liquido = liquido;
    }
    public Double getAportesJubilatorios() {
        return aportesJubilatorios;
    }
    public void setAportesJubilatorios(Double aportesJubilatorios) {
        this.aportesJubilatorios = aportesJubilatorios;
    }
    public Double getAportesFonasa() {
        return aportesFonasa;
    }
    public void setAportesFonasa(Double aportesFonasa) {
        this.aportesFonasa = aportesFonasa;
    }
    public Double getAportesFRL() {
        return aportesFRL;
    }
    public void setAportesFRL(Double aportesFRL) {
        this.aportesFRL = aportesFRL;
    }
    public Double getAportesIRPF() {
        return aportesIRPF;
    }
    public void setAportesIRPF(Double aportesIRPF) {
        this.aportesIRPF = aportesIRPF;
    }
    public Double getAportesFondoSolidaridad() {
        return aportesFondoSolidaridad;
    }
    public void setAportesFondoSolidaridad(Double aportesFondoSolidaridad) {
        this.aportesFondoSolidaridad = aportesFondoSolidaridad;
    }
    public Double getAportesAdicionalFondoSolidaridad() {
        return aportesAdicionalFondoSolidaridad;
    }
    public void setAportesAdicionalFondoSolidaridad(Double aportesAdicionalFondoSolidaridad) {
        this.aportesAdicionalFondoSolidaridad = aportesAdicionalFondoSolidaridad;
    }
    public Double getAportesCJPPU() {
        return aportesCJPPU;
    }
    public void setAportesCJPPU(Double aportesCJPPU) {
        this.aportesCJPPU = aportesCJPPU;
    }
    public Double getAportesOtrasDeducciones() {
        return aportesOtrasDeducciones;
    }
    public void setAportesOtrasDeducciones(Double aportesOtrasDeducciones) {
        this.aportesOtrasDeducciones = aportesOtrasDeducciones;
    }

  
    
}
