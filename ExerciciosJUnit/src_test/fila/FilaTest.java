package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaTest {

	Fila f;
	
	@Before
	public void setUp() throws Exception {
		f = new Fila(2);
	}

	@Test
	public void testTamanho() {
		int tamanho = f.getTam();
		
		assertEquals(2, tamanho);
	}

	@Test
	public void testEstaVazia() {
		
		assertTrue(f.estaVazia());
	}

	@Test
	public void testEstaCheia() {
		f.insereNaFila("a");
		f.insereNaFila("b");
		
		assertTrue(f.estaCheia());
	}

	@Test
	public void testInsereNaFila() {
		Object remove;
		
		f.insereNaFila("a");
		remove = f.removeDaFila();
		
		assertEquals("a", remove);
		
	}
	
	@Test(expected=FilaCheiaException.class)
	public void testInsereNaFilaCheia() throws FilaCheiaException {
		try {
			f.insereNaFila("a");
			f.insereNaFila("b");
			f.insereNaFila("c");
			
		} catch (Exception e) {
			throw new FilaCheiaException("Fila Cheia", e);
		}
		
	}

	@Test
	public void testRemoveDaFila() {
		Object remove;
		
		f.insereNaFila("a");
		f.insereNaFila("b");
		remove = f.removeDaFila();
		
		assertEquals("a", remove);
	}
	
	@Test(expected=FilaVaziaException.class)
	public void testRemoveDaFilaVazia() throws FilaVaziaException{
		try {
			f.removeDaFila();
			
		} catch (Exception e) {
			throw new FilaVaziaException("Fila Vazia", e);
		}
		
	}

	@Test
	public void testLimpaFila() {
		f.insereNaFila("a");
		f.insereNaFila("b");
		
		assertTrue(f.estaCheia());
		
		f.limpaFila();
		
		assertTrue(f.estaVazia());
		
	}

}
