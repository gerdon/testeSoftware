package param;

import java.text.DecimalFormat;

public class CalculoImpostoRenda {
	
/**
 * 	Classes de Equivalências
 * 
 *	Restrições de Entrada		Classe Válido				Classe Inválida
 *	0 < valor < 1201			0 < valor < 1201			valor < 0
 *  1201 <= valor <= 5000		1201 <= valor <= 5000		valor < 1201 OR valor >= 5001
 *  5001 <= valor <= 10000		5001 <= valor <= 10000		valor < 5001 OR valor >= 10001
 *  valor > 10000				valor > 10000				valor < 10000 
 */
	
	
	/**
	 * Este método calcula o imposto a ser pago baseado no valor de uma dada compra.
	 * 
	 * Se  0 < valor < 1201 deve pagar 0% de imposto
	 * Se  1201 <= valor <= 5000 deve pagar 10% de imposto
	 * Se  5001 <= valor <= 10000 deve pagar 15% de imposto
	 * Se  valor > 10000 deve pagar 20% de imposto
	 * 
	 * @param valor
	 */
	public Double calculaImposto(double valor) throws ValorLimiteNegativoException{
		//Declaração de Variáveis
		double imposto;
		double impostotot = 0.0;
		String porcento;

		if(valor < 1201) {
			 imposto = 0.0;
	         porcento = "0%";
	         impostotot = 0.0;
		} else if(valor >= 1201 && valor <= 5000) {
	         imposto = 1.1;
	         porcento = "10%";
	         impostotot = 0.1;
		} else if(valor >= 5001 && valor <= 10000){
	         imposto = 1.15;
	         porcento = "15%";
	         impostotot = 0.15;
		} else if(valor > 10000) {
	        imposto = 1.2;
	        porcento = "20%";
	        impostotot = 0.2;
		} else {
			throw new ValorLimiteNegativoException("Não é permitido um valor negativo para o calculo do imposto");
		}
     
       //Saída de dados - Apenas o valor do imposto
//        return valor * impostotot;
		return Double.valueOf(new DecimalFormat("#.#").format(valor * impostotot));
    }
	
	
	public static void main(String[] args) {
		try {
			CalculoImpostoRenda cir = new CalculoImpostoRenda();
			System.out.println(cir.calculaImposto(200.5));
			System.out.println(cir.calculaImposto(2000));
			System.out.println(cir.calculaImposto(5500));
			System.out.println(cir.calculaImposto(12000));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
