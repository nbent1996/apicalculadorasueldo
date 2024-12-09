package uy.com.salario.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import uy.com.salario.calculadora.Domain.Salario;
import uy.com.salario.calculadora.Services.SalarioService;

@SpringBootTest
class CalculadoraApplicationTests {
	private SalarioService salarioService;

    @BeforeEach
    void setUp() {
        salarioService = new SalarioService();
    }
/*
    @Test
    void testSalarioLiquidoValidScenario1() throws Exception {
        // Escenario válido con hijos sin discapacidad y factor de deducción 0.5
        Double nominal = 25000.0;
        Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, false, 0.5, 2, 0, 1.0, false, 1000.0, 2000.0);

        assertNotNull(salario);
        // Comprueba que el salario líquido esté calculado (ajustar el valor esperado)
        assertEquals(19725, salario.getLiquido(), 0.01);
    }*/
 
    @Test
    void testSalarioLiquidoValidScenario2() throws Exception {
        // Escenario válido con hijos con discapacidad y factor de deducción 1.0
        Double nominal = 150000.0;
        Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 1.0, 0, 1,1.0, false, 3000.0, 1000.0);

        assertNotNull(salario);
        // Comprueba que el salario líquido esté calculado (ajustar el valor esperado)
        assertEquals(97721.73, salario.getLiquido(), 0.01);
    }
/*
    @Test
    void testSalarioLiquidoInvalidFactorDeduccion() {
        // Escenario inválido: el factor de deducción no está dentro de los valores permitidos
        Double nominal = 50000.0;
        assertThrows(Exception.class, () -> {
            Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 50.0, 0, 1,1.0, false, 3000.0, 1000.0);
        });
    }

    @Test
    void testSalarioLiquidoInvalidNoHijosButHasCount() {
        // Escenario inválido: debería lanzar una excepción porque tieneHijos es false pero se indican hijos
        Double nominal = 50000.0;
        assertThrows(Exception.class, () -> {
            Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, false, true, 1.0, 3, 1,1.0, false, 3000.0, 1000.0);
        });
    }

    @Test
    void testSalarioLiquidoInvalidFondoSolidaridad() {
        // Escenario inválido: adicionalFondoSolidaridad no puede ser true si aportaFondoSolidariad es false
        Double nominal = 85000.0;
        assertThrows(Exception.class, () -> {
            Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, false, true, 1.0, 3, 1,1.0, true, 3000.0, 1000.0);
        });
    }*/
    // Repite con otros escenarios para cubrir más combinaciones o potenciales errores
}
