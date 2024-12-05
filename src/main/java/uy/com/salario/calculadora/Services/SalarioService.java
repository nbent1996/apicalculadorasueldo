package uy.com.salario.calculadora.Services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uy.com.salario.calculadora.Domain.Constants;
import uy.com.salario.calculadora.Domain.DetalleIRPF;
import uy.com.salario.calculadora.Domain.FranjaIRPF;
import uy.com.salario.calculadora.Domain.Salario;

@Service
public class SalarioService {
        private static final Logger logger = LoggerFactory.getLogger(SalarioService.class);

        public Salario getSalarioLiquidoFromNominal(Double nominal, boolean tieneHijos, boolean tieneConyuge, Double factorDeduccionPersonasACargo, int cantHijosSinDiscapacidad, int cantHijosConDiscapacidad, boolean aportaFondoSolidariad, boolean adicionalFondoSolidaridad, Double aportesCJPPU, Double otrasDeducciones ){
            Salario s = new Salario();
            s.setNominal(nominal.doubleValue());
            s.setAdicionalFondoSolidaridad(adicionalFondoSolidaridad);
            s.setAportaFondoSolidaridad(aportaFondoSolidariad);
            s.setAportesCJPPU(aportesCJPPU);
            s.setAportesOtrasDeducciones(otrasDeducciones);
            return calcularImpuestos(s,tieneHijos, tieneConyuge, factorDeduccionPersonasACargo,cantHijosSinDiscapacidad, cantHijosConDiscapacidad);

        }

        public Long getSalarioNominalFromLiquido(Long liquido){
            Long retorno = 0L;

            return retorno;
        }

        public Salario calcularAportesBPS (Salario salario, boolean tieneHijos, boolean tieneConyuge){
            /*
             * Se espera un objeto salario con salarioNominal
             */
            Double salarioBPC = salario.getNominal().doubleValue()/Constants.BPC.doubleValue();
            ArrayList<Double> valoresFonasa = null;
            if(salarioBPC > 2.5)
                valoresFonasa = Constants.APORTE_FONASA_DESDE_25BPC;
            else{
                valoresFonasa = Constants.APORTE_FONASA_HASTA_25BPC;
            }
            
            /*Calculamos porcentaje fonasa*/
            int porcentajeFonasa = -1;
            if(tieneHijos) porcentajeFonasa+= valoresFonasa.get(2);
            if(tieneConyuge) porcentajeFonasa += valoresFonasa.get(1);

            //Calcular valores de retorno
            Double aportesJubilatorios = Math.min(Constants.TOPE_APORTE_JUBILATORIO, salario.getNominal()) * Constants.APORTE_JUBILATORIO * 0.01;
            Double aportesFonasa = salario.getNominal() * porcentajeFonasa * 0.01;
            Double aporteFrl = salario.getNominal() * Constants.APORTE_FRL * 0.01;
            return new Salario(aportesJubilatorios, aportesFonasa, aporteFrl);
        }
        public Salario calcularAportesIRPF(Salario salario, Double factorDeduccionPersonasACargo, int cantHijosSinDiscapacidad, int cantHijosConDiscapacidad){
            /*
             * objeto salario debe tener
             *  salarioNominal,
                aportesJubilatorios,
                aportesFONASA,
                aporteFRL,
                aportesFondoSolidaridad,
                adicionalFondoSolidaridad,
                aportesCJPPU,
                otrasDeducciones
             */
            Double salarioEnBPC = salario.getNominal().doubleValue() / Constants.BPC;
            Integer tasaDeducciones = null;
            if(salarioEnBPC>15) tasaDeducciones = Constants.TASA_DEDUCCIONES_DESDE15BPC;
            else tasaDeducciones = Constants.TASA_DEDUCCIONES_HASTA15BPC;

            /*Calcular si hay que aplicar el aumento a ingresos gravados Seguridad Social*/
            Double nominal = salario.getNominal();
            if(salarioEnBPC>10) salario.setNominal(nominal *= 1 + Constants.INCREMENTO_INGRESOS_GRAVADOS.doubleValue() *0.01);

            /*Cantidad deducida del IRPF por los hijos */
            Double deduccionesHijos = factorDeduccionPersonasACargo * (cantHijosSinDiscapacidad * Constants.DEDUCCION_HIJO_SIN_DISCAPACIDAD +
                                                                     cantHijosConDiscapacidad * Constants.DEDUCCION_HIJO_CON_DISCAPACIDAD);

            Double aporteAdicionalFondoSolidaridad = salario.getAdicionalFondoSolidaridad() ? Constants.ADICIONAL_FONDO_SOLIDARIDAD.doubleValue() : 0;

            Double deducciones = deduccionesHijos + 
                                    salario.getAportesJubilatorios() + 
                                    salario.getAportesFonasa() + 
                                    salario.getAportesFRL() + 
                                    ((salario.getAportesFondoSolidaridad()*Constants.BPC)/12) +  
                                    aporteAdicionalFondoSolidaridad +
                                    salario.getAportesCJPPU() +
                                    salario.getAportesOtrasDeducciones();
            
            /*Cantidad de impuesto de IRPF de cada franja */
            DetalleIRPF detalleIRPF = new DetalleIRPF(deducciones, tasaDeducciones);

            for (FranjaIRPF franja : Constants.FRANJAS_IRPF) {
            double hasta = franja.getHasta() != 0 ? franja.getHasta() : 999;
            if (salario.getNominal() > franja.getDesde() * Constants.BPC) {
                double impuesto = (Math.min(hasta * Constants.BPC, salario.getNominal()) - franja.getDesde() * Constants.BPC) * franja.getTasa() * 0.01;
                detalleIRPF.getImpuestoFranja().add(impuesto);
            } else {
                detalleIRPF.getImpuestoFranja().add(0.0);
            }
                    // Calcular la suma total de impuestos
            double sumaImpuestos = 0;
            for (double impuesto : detalleIRPF.getImpuestoFranja()) {
            sumaImpuestos += impuesto;
                }
            double totalIRPF = sumaImpuestos - (deducciones * tasaDeducciones * 0.01);
            salario.setAportesIRPF(totalIRPF);
            salario.setDetalleIRPF(detalleIRPF);
        }
                    return salario;
} 
        public Salario calcularImpuestos(Salario salario, boolean tieneHijos, boolean tieneConyuge, Double factorDeduccionPersonasACargo, int cantHijosSinDiscapacidad, int cantHijosConDiscapacidad){
            /*Se espera un  objeto salario con*/
            /*
             * salarioNominal
             * aportesFondoSolidaridad
             * adicionalFondoSolidaridad
             * aportesCJPPU
             * otrasDeducciones
             */
            salario = calcularAportesBPS(salario, tieneHijos, tieneConyuge);
            salario = calcularAportesIRPF(salario,factorDeduccionPersonasACargo, cantHijosSinDiscapacidad, cantHijosConDiscapacidad);
            salario.setLiquido(salario.getNominal()-salario.getAportesJubilatorios()-salario.getAportesFonasa()-salario.getAportesFRL()-salario.getAportesIRPF());
            
            return salario;
        }
}