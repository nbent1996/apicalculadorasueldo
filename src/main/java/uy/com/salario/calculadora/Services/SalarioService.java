package uy.com.salario.calculadora.Services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uy.com.salario.calculadora.Domain.Constants;

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

        public Long calcularAportesBPS (Long nominal, boolean tieneHijos, boolean tieneConyuge){
            Integer salarioBPC = nominal.intValue()/Constants.BPC.intValue();
            ArrayList<Double> valoresFonasa = null;
            if(salarioBPC > 2.5)
                valoresFonasa = Constants.APORTE_FONASA_DESDE_25BPC;
            else{
                valoresFonasa = Constants.APORTE_FONASA_HASTA_25BPC;
            }

            /*Calculamos porcentaje fonasa*/
            
        }

}
