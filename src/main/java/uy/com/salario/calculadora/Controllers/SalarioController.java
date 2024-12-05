package uy.com.salario.calculadora.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.com.salario.calculadora.Domain.Salario;
import uy.com.salario.calculadora.Services.SalarioService;


@RestController
@RequestMapping("/salarios")
public class SalarioController {
    
    @Autowired
    private SalarioService salarioService;

    @PostMapping("/calcularSalario")
    public Salario calcularSalario(Double nominal, boolean tieneHijos, boolean tieneConyuge, Double factorDeduccionPersonasACargo, int cantHijosSinDiscapacidad, int cantHijosConDiscapacidad, boolean aportaFondoSolidaridad, boolean adicionalFondoSolidaridad, Double aportesCJPPU, Double otrasDeducciones){
        return salarioService.getSalarioLiquidoFromNominal(nominal, tieneHijos, tieneConyuge, factorDeduccionPersonasACargo, cantHijosSinDiscapacidad, cantHijosConDiscapacidad, aportaFondoSolidaridad, adicionalFondoSolidaridad, aportesCJPPU, otrasDeducciones);
    
    
    }
}
