package tdd;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

	private double saldo;
	private double saldoInicial;
	private String name;
	private List<Deposito> depositos;


	public ContaCorrente() {
		inicializedConstructor("", 0);
	}

	public ContaCorrente(double saldo) {
		inicializedConstructor("", saldo);
	}

	public ContaCorrente(String name) {
		inicializedConstructor(name, 0);
	}

	public ContaCorrente(String name, double saldo) {
		inicializedConstructor(name, saldo);
	}
	
	private void inicializedConstructor(String name, double saldo) {
		this.name = name;
		this.saldo = saldo;
		this.saldoInicial = saldo;
		depositos = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void creditar(Deposito deposito) {
		depositos.add(deposito);
		saldo += (double) deposito.valor;
		
	}

	public String extrato() {
		String extrato = 
			"Conta de " + name +
			"\nSaldo Inicial $" + saldoInicial +
			"\nSaldo Final $" + saldo + "\n";
		
		if(depositos.size() == 0) {
			extrato += "Nenhuma trasacao realizada\n";
		} else {
			for(Deposito d : depositos) {
				extrato += d.data + "\tDeposito\t$" + (double) d.valor + "\n"; 
			}
		}
			
		return extrato;
	}


}
