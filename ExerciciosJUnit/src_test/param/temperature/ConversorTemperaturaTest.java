package param.temperature;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversorTemperaturaTest {

	@Test
	public void testConverteCelsiusForFahrenheit() throws TempException {
		Temperatura temp;
		
		ConversorTemperatura ct = new ConversorTemperatura();
		Temperatura tempC = new Celsius();
		tempC.setValue(0);
		
		temp = ct.converte(tempC);
		
		assertEquals(32, temp.getValue(), 0.0);
	}
	
	@Test
	public void testConverteFahrenheitForCelsius() throws TempException {
		Temperatura temp;
		
		ConversorTemperatura ct = new ConversorTemperatura();
		Temperatura tempF = new Fahrenheit();
		tempF.setValue(89.6);
		
		temp = ct.converte(tempF);
		
		assertEquals(32, temp.getValue(), 0.0);
	}
	
	@Test(expected=TempException.class)
	public void testConverteCelsiusException() throws TempException {
		Temperatura temp;
		
		ConversorTemperatura ct = new ConversorTemperatura();
		Temperatura tempC = new Celsius();
		tempC.setValue(-274);
		
		temp = ct.converte(tempC);
	}
	
	@Test(expected=TempException.class)
	public void testConverteFahrenheitException() throws TempException {
		Temperatura temp;
		
		ConversorTemperatura ct = new ConversorTemperatura();
		Temperatura tempF = new Fahrenheit();
		tempF.setValue(-460);
		
		temp = ct.converte(tempF);
	}

}
