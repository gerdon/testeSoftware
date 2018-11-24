package banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	public Conta c1, c2;
	public double saldoAtual;
	
	@Before
	public void setUpClass() {
		c1 = new Conta("123", 100);
		c2 = new Conta("456", 50);
	}

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException{
		saldoAtual = c1.debitar(10);
		
		assertEquals(saldoAtual, c1.getSaldo(), 0.0);
		
		saldoAtual = c1.debitar(90);
		
		assertEquals(saldoAtual, c1.getSaldo(), 0.0);
	} 
	
	@Test
	public void testCreditarSucesso() throws OperacaoIlegalException{
		saldoAtual = c1.creditar(10);
		
		assertEquals(saldoAtual, c1.getSaldo(), 0.0);
	}
	
	@Test
	public void testTranferirSucesso() throws OperacaoIlegalException{
		c1.transferir(c2, 50.0);
		
		assertEquals(100.0, c2.getSaldo(), 0.0);
		assertEquals(50.0, c1.getSaldo(), 0.0);
	}
	
	@Test(expected=OperacaoIlegalException.class)
	public void testTranferirFail() throws OperacaoIlegalException{
		c1.transferir(c2, 150.0);
	}
	
	@Test(expected=OperacaoIlegalException.class)
	public void testCreditarFail() throws OperacaoIlegalException{
		c1.creditar(-100);
	}
	
	@Test(expected=OperacaoIlegalException.class)
	public void testCreditarValorZeradoFail() throws OperacaoIlegalException{
		c1.creditar(0);
	}
	
	@Test(expected=OperacaoIlegalException.class)
	public void testDebitarValorAcimaFail() throws OperacaoIlegalException{
		c1.debitar(c1.getSaldo() + 1);
	}
	
	@Test(expected=OperacaoIlegalException.class)
	public void testDebitarValorAbaixoFail() throws OperacaoIlegalException{
		c1.debitar(0);
	}
}
