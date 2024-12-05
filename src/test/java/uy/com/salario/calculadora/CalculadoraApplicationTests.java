package uy.com.salario.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import uy.com.salario.calculadora.Domain.Salario;
import uy.com.salario.calculadora.Services.SalarioService;

@SpringBootTest
@Disabled("En construccion")
class CalculadoraApplicationTests {
	private SalarioService salarioService;

    @BeforeEach
    void setUp() {
        salarioService = new SalarioService();
    }
/*
    @Test
    void testSalarioLiquidoValidScenario1() {
        // Escenario válido con hijos sin discapacidad y factor de deducción 0.5
        Double nominal = 25000.0;
        Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, false, 0.5, 2, 0, true, false, 1000.0, 2000.0);

        assertNotNull(salario);
        // Comprueba que el salario líquido esté calculado (ajustar el valor esperado)
        assertEquals(, salario.getLiquido(), 0.01);
    }

    @Test
    void testSalarioLiquidoValidScenario2() {
        // Escenario válido con hijos con discapacidad y factor de deducción 1.0
        Double nominal = 150000.0;
        Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 1.0, 0, 1, false, false, 3000.0, 1000.0);

        assertNotNull(salario);
        // Comprueba que el salario líquido esté calculado (ajustar el valor esperado)
        assertEquals(, salario.getLiquido(), 0.01);
    }

    @Test
    void testSalarioLiquidoInvalidFactorDeduccion() {
        // Escenario inválido: el factor de deducción no está dentro de los valores permitidos
        Double nominal = 50000.0;
        assertThrows(IllegalArgumentException.class, () -> {
            salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 0.7, 1, 1, true, false, 500.0, 500.0);
        });
    }

    @Test
    void testSalarioLiquidoInvalidNoHijosButHasCount() {
        // Escenario inválido: debería lanzar una excepción porque tieneHijos es false pero se indican hijos
        Double nominal = 50000.0;
        assertThrows(IllegalArgumentException.class, () -> {
            salarioService.getSalarioLiquidoFromNominal(
                nominal, false, true, 1.0, 1, 1, true, false, 500.0, 500.0);
        });
    }

    @Test
    void testSalarioLiquidoInvalidFondoSolidaridad() {
        // Escenario inválido: adicionalFondoSolidaridad no puede ser true si aportaFondoSolidariad es false
        Double nominal = 85000.0;
        assertThrows(IllegalArgumentException.class, () -> {
            salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 1.0, 1, 0, false, true, 1000.0, 500.0);
        });
    }

    @Test
    void testSalarioLiquidoAportesOutOfBounds() {
        // Comprobación de aportes límites
        Double nominal = 120000.0;
        Salario salario = salarioService.getSalarioLiquidoFromNominal(
                nominal, true, true, 0.5, 3, 0, true, true, 35000.0, 35000.0);

        assertNotNull(salario);
        // Comprueba código acorde a valores altos de aportes
        assertEquals(, salario.getLiquido(), 0.01);
    }
*/
    // Repite con otros escenarios para cubrir más combinaciones o potenciales errores
}
