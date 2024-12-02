package uy.com.salario.calculadora.Domain;

import java.util.ArrayList;

public class Constants {
    /*Valor BPC 2024*/
    public static final Long BPC = 6177L;

    public static final ArrayList<Long> franjasIrpf = new ArrayList<>();
    public static final Long aportesJubilatorios = 15L;
    public static final Long topeAportesJubilatorios=236309L;
    
    public Constants(){
        /*Añadir franjas irpf*/
        franjasIrpf.add(0L); /*desde 0 BPC hasta 7 BPC, tasa 0*/ 
        franjasIrpf.add(10L); /*desde 7 BPC hasta 10 BPC, tasa 10*/
        franjasIrpf.add(15L); /*desde 10 BPC hasta 15 BPC, tasa 15*/
        franjasIrpf.add(24L); /*desde 15 BPC hasta 30 BPC, tasa 24*/
        franjasIrpf.add(25L); /*desde 30 BPC hasta 50 BPC, tasa 24*/
        franjasIrpf.add(27L); /*desde 50 BPC hasta 75 BPC, tasa 27*/
        franjasIrpf.add(31L); /*desde 75 BPC hasta 115 BPC, tasa 31*/
        franjasIrpf.add(36L); /*desde 115 BPC hasta 1000 BPC, tasa 36*/

    }



}
