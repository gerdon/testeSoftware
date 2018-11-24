package param;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculoImpostoRendaTest {
	
	private double valor;
	private double valorExpected;
	
	CalculoImpostoRenda cir;
	
	public CalculoImpostoRendaTest(double valorExpected, double valor) {
		this.valorExpected = valorExpected;
		this.valor = valor;
	}

	@Before
	public void setUp() throws Exception {
		cir = new CalculoImpostoRenda();
	}
	
//	@Parameters(name = "Teste {index}: imposto[{1}] = {0}")
//    public static Object[][] impostoValors() {
//        return new Double[][] { { 200.0, 2000.0 }, 
//        						{ 825.0, 5500.0 }, 
//        						{ 2400.0, 12000.0}, 
//        						{ 2400.0, 12000.0},
//        						{0.0, 800.0} };
//    }
	
	@Parameters(name = "Teste de Equivalencia {index}: imposto[{1}] = {0}")
    public static Object[][] testeEquivalencia() {
        return new Double[][] { { 0.0, 0.0 },
        						{ 0.0, 1200.0 },
        						{ 0.0, 1200.1 },
        						{ 120.1, 1201.0 }, 
        						{ 825.0, 5500.0 }, 
        						{ 2400.0, 12000.0 }, 
        						{ 2400.0, 12000.0 },
        						{ 0.0, 800.0 } };
    }

	@Test(expected=ValorLimiteNegativoException.class)
	public void testCalculaImposto() throws ValorLimiteNegativoException {
		assertEquals(valorExpected, cir.calculaImposto(valor), 0.0);
	}

}
