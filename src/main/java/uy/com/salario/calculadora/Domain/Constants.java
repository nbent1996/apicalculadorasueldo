package uy.com.salario.calculadora.Domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    /*Valor BPC 2024*/
    public static final Long BPC = 6177L;

    /*Franjas de IRPF, se definen en el constructor
     * 'desde' y 'hasta' son los valores en BPC en los que esta comprendida la franja
     * El valor de 'desde' esta dentro de la franja, el de hasta NO
     * La ultima franja tiene un valor muy alto.
     * tasa es el porcentaje de impuesto.
    */
    public static final ArrayList<FranjaIRPF> FRANJAS_IRPF = new ArrayList<>();

    /*Porcentaje de aportes jubilatorios*/
    public static final Integer APORTE_JUBILATORIO = 15;

    /*Maximo del salario nominal sobre el cual se aplican los aportes jubilatorios*/
    public static final Integer TOPE_APORTE_JUBILATORIO=236309;

    /*Porcentaje de aporte de fonasa para personas con salario hasta 2.5BPC */
    public static final ArrayList<Double> APORTE_FONASA_HASTA_25BPC = new ArrayList<>(Arrays.asList(3.0,2.0,0.0)); /*base 3, conyuge 2, hijos 0*/
    
    /*Porcentaje de aporte de fonasa para personas con salario mayor a 2.5 BPC */
    public static final ArrayList<Double> APORTE_FONASA_DESDE_25BPC = new ArrayList<>(Arrays.asList(4.5,2.0, 1.5)); /*base 4.5, conyuge 2, hijos 1.5*/
    
    /*Porcentaje de aporte al FRL*/
    public static final Double APORTE_FRL = 0.1;
    
    /*Maximo del salario nominal sobre el cual se aplican los aportes a afap*/
    public static final Long TOPE_AFAP = 236309L;

    /*Porcentaje de incremento de ingresos gravados que aplica si la renta computable es mayor a 10BPC*/
    public static final Integer INCREMENTO_INGRESOS_GRAVADOS = 6;

    /*Porcentaje de deducciones de IRPF para personas con salario hasta 15BPC*/
    public static final Integer TASA_DEDUCCIONES_HASTA15BPC = 10;
    
    /*Porcentaje de deducciones IRPF para personas con salario desde 15BPC*/
    public static final Integer TASA_DEDUCCIONES_DESDE15BPC = 8;

    /*Cantidad deducida del IRPF por cada hijo sin discapacidad*/
    public static final Long DEDUCCION_HIJO_SIN_DISCAPACIDAD = (20 * BPC) / 12;

    /*Cantidad deducida del IRPF por cada hijo con discapacidad*/
    public static final Long DEDUCCION_HIJO_CON_DISCAPACIDAD = (40 * BPC) / 12;

    /*Adicional al fondo de solidaridad que debe pagarse en carreras de duracion igual o mayor a 5 años*/ 
    public static final Long ADICIONAL_FONDO_SOLIDARIDAD = ((5/4) * BPC) / 12;

    public Constants(){
        FRANJAS_IRPF.add(new FranjaIRPF(0, 7, 0)); // desde 0 BPC hasta 7 BPC, tasa 0
        FRANJAS_IRPF.add(new FranjaIRPF(7, 10, 10)); // desde 7 BPC hasta 10 BPC, tasa 10
        FRANJAS_IRPF.add(new FranjaIRPF(10, 15, 15)); // desde 10 BPC hasta 15 BPC, tasa 15
        FRANJAS_IRPF.add(new FranjaIRPF(15, 30, 24)); // desde 15 BPC hasta 30 BPC, tasa 24
        FRANJAS_IRPF.add(new FranjaIRPF(30, 50, 25)); // desde 30 BPC hasta 50 BPC, tasa 25
        FRANJAS_IRPF.add(new FranjaIRPF(50, 75, 27)); // desde 50 BPC hasta 75 BPC, tasa 27
        FRANJAS_IRPF.add(new FranjaIRPF(75, 115, 31)); // desde 75 BPC hasta 115 BPC, tasa 31
        FRANJAS_IRPF.add(new FranjaIRPF(115, 1000, 36)); // desde 115 BPC hasta 1000 BPC, tasa 36
    }



}
