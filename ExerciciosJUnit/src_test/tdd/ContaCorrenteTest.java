package tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tdd.ContaCorrente;
import tdd.Deposito;


/*
 * Voce ir� escrever a classe ContaCorrente guiada pela bateria de testes definida abaixo
 * 
 *  
 *  Descomente os testes 1 por 1, e escreva a quantidade m�nima de c�digo para o teste passar.
 *  Em alguns casos isto significa um resultado "hard coded".
 *  N�o se preocupe, pois o teste seguinte ir� lhe for�ar a evoluir a implementa��o
 *  para checar numa implementacao real da conta corrente.
 * 
 * Primeiramente, fa�a o teste falhar, isto far� perceber que 
 * o teste pode detectar falhas. A� altere o c�digo da classe sendo implementada 
 * para o teste passar.
 */


public class ContaCorrenteTest {
	
	private ContaCorrente conta;

	/*
	 * executando antes de cada metodo de teste
	 */

	@Before
	public void setUp() {
		 conta = new ContaCorrente();
	}

	/*
	 * executado apos cada metodo de teste
	 */
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testANewCheckBookHasAZeroBallanceByDefault() {	
		assertEquals(0.0, conta.getSaldo(), 0.0);
	}
	
	/*
	 * Para fazer o teste anterior passar vc precisa apenas que 
	 * o retorno do get saldo seja ZERO. se voce implementou mais do que isso delete.
	 */
	
	@Test
	public void testSingleDepositoIncreasesBalance() {
		conta.creditar(new Deposito("2009-10-12", 10000));
		
		assertEquals(10000, conta.getSaldo(), 0.0);
	}
	
	/*
	 * Para o teste anterior passar vc precisou criar uma variavel para armazenar o saldo (do ingles: balence)
	 */

	@Test
	public void testMultipleDepositos() {
		conta.creditar(new Deposito("2009-10-12", 100));
		conta.creditar(new Deposito("2009-10-13", 200));
		conta.creditar(new Deposito("2009-10-14", 300));
		
		assertEquals(600, conta.getSaldo(), 0.0);
	}
	
	/*
	 * Para o teste anterior passar vc deve ser capaz de somar cada um dos depositos ao saldo.
	 */
	
	/*
	 * Para o proximo teste passar vc precisar� de um novo construtor.
	 */
	
	@Test
	public void testCreatecontaWithInitialBalance() {
		ContaCorrente conta = new ContaCorrente(10000);

		assertEquals(10000, conta.getSaldo(), 0.0);
	}
	
	/*
	 * Para o proximo teste passar voc� precisar� guardar uma informacao a mais:
	 * o nome do dono da conta.
	 * 
	 * Inicialmente vc nao deve se preocupar com isso, vc pode retornar um string 
	 * hard coded para os testes passarem. Os testes seguintes 
	 * farao com que vc precise deixar de usar este valor hard coded.
	 * 
	 */

	@Test
	public void testExtrato() {
		String extrato_esperado = 
			"Conta de James Grenning\n" +
			"Saldo Inicial $0.0\n" +
			"Saldo Final $0.0\n" +
			"Nenhuma trasacao realizada\n";
		
		conta.setName("James Grenning");
		String extrato_real = conta.extrato();
		
		assertEquals(extrato_esperado, extrato_real);
	}
	
	/*
	* Para este teste vc precisar� de um nome para o dono da conta.
	*/
	
	@Test
	public void testProduceextratoWithDifferentHolder() {
		ContaCorrente conta = new ContaCorrente("Your Name");
		
		String expected = 
			"Conta de Your Name\n" +
			"Saldo Inicial $0.0\n" +
			"Saldo Final $0.0\n" +
			"Nenhuma trasacao realizada\n";	
		String extrato = conta.extrato();
		
		assertEquals(expected, extrato);
	}
	
	/*
	 * Neste proximo teste vc deve alterar o saldo que estava hard coded.
	 */
	
	@Test
	public void testProduceextratoWithDifferentStartigBalancen() {
		ContaCorrente conta = new ContaCorrente("Your Name", 10000);
		
		String expected = 
			"Conta de Your Name\n" +
			"Saldo Inicial $10000.0\n" +
			"Saldo Final $10000.0\n" +
			"Nenhuma trasacao realizada\n";
		String extrato = conta.extrato();
		
		assertEquals(expected, extrato);
	}
	
	/*
	 * At� agora s� tinhamos que armazenar o historico do saldo,
	 * agora precisaremos manter o historico de varias transacaoes:
	 * deposito e saque. Neste teste vc vai realizar um deposito e Precisa armazenar esta informa��o no extrato.
	 */
	
	@Test
	public void testProduceextratoWithOneDeposito() {
		ContaCorrente conta = new ContaCorrente("James Grenning", 0);
		
		String expected = 
			"Conta de James Grenning\n" +
			"Saldo Inicial $0.0\n" +
			"Saldo Final $10000.0\n" +
			"2015-03-13\tDeposito\t$10000.0\n";
			
		conta.creditar(new Deposito("2015-03-13", 10000));
		
		String extrato = conta.extrato();
		
		assertEquals(expected, extrato);
	}
	
	/*
	 * Note que esta abordagem de desenvolvimento faz com que vc 
	 * foque em uma �nica mudan�a de cada vez. E cada mudan�a ser� testada.
	 * 
	 * Agora vamos incluir um conjunto de depositos. 
	 * Isto ir� for�ar vc a criar uma cole��o, e percorrer esta
	 * colecao para gerar o extrato.
	 * 
	 * N�o esque�a que o c�digo de testes deve rodar antes de 
	 * construir a implementa��o que fa�a ele passar:
	 * LEMA DO TDD: RED BAR + GREEN BAR + REFATORAMENTO (QUANDO NECESS�RIO)
	 */
	
	@Test
	public void testProduceextratoWithMultipleDeposito() {
		ContaCorrente conta = new ContaCorrente("James Grenning", 0);
		
		String expected = 
			"Conta de James Grenning\n" +
			"Saldo Inicial $0.0\n" +
			"Saldo Final $60000.0\n" +
			"2015-03-11\tDeposito\t$10000.0\n" +
			"2015-03-12\tDeposito\t$20000.0\n" +	
			"2015-03-13\tDeposito\t$30000.0\n";	
		
		conta.creditar(new Deposito("2015-03-11", 10000));
		conta.creditar(new Deposito("2015-03-12", 20000));
		conta.creditar(new Deposito("2015-03-13", 30000));
		
		String extrato = conta.extrato();
		
		assertEquals(expected, extrato);
	}
	
	/*
	 * Agora se quiser continue a implementar outros m�todos pra esta classe 
	 * seguindo o fluxo TDD. 
	 */

}
