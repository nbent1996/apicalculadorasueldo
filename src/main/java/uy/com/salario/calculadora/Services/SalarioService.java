package uy.com.salario.calculadora.Services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uy.com.salario.calculadora.Domain.Constants;
import uy.com.salario.calculadora.Domain.Salario;

@Service
public class SalarioService {
        private static final Logger logger = LoggerFactory.getLogger(SalarioService.class);

        public Long getSalarioLiquidoFromNominal(Long nominal){
            Long retorno = 0L;

            return retorno;

        }

        public Long getSalarioNominalFromLiquido(Long liquido){
            Long retorno = 0L;

            return retorno;
        }

        public Salario calcularAportesBPS (Long nominal, boolean tieneHijos, boolean tieneConyuge){
            Double salarioBPC = nominal.doubleValue()/Constants.BPC.doubleValue();
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
            Double aportesJubilatorios = Math.min(Constants.TOPE_APORTE_JUBILATORIO, nominal) * Constants.APORTE_JUBILATORIO * 0.01;
            Double aportesFonasa = nominal * porcentajeFonasa * 0.01;
            Double aporteFrl = nominal * Constants.APORTE_FRL * 0.01;
            return new Salario(aportesJubilatorios, aportesFonasa, aporteFrl);
        }
        public Salario calcularAportesIRPF(Salario salario, int factorDeduccionPersonasACargo, int cantHijosSinDiscapacidad, int cantHijosConDiscapacidad){
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
            Long deduccionesHijos = factorDeduccionPersonasACargo * (cantHijosSinDiscapacidad * Constants.DEDUCCION_HIJO_SIN_DISCAPACIDAD +
                                                                     cantHijosConDiscapacidad * Constants.DEDUCCION_HIJO_CON_DISCAPACIDAD);

        }


}
