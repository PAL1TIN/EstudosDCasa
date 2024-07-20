package poo.gestaodecaixaeletronico;

import poo.gestaodecontas.Conta;


public class Caixa {

	private Terminal meuTerminal;
	private CadastroContas bdContas;
	private double saldo;
	public Caixa(Terminal terminal, CadastroContas bd){
	this.meuTerminal = terminal;
	this.bdContas = bd;
}
	
	public double consultaSaldo(int numeroDaConta, int senha){
	Conta conta;
	conta = this.bdContas.buscaConta(numeroDaConta);
	if (conta != null){
	return conta.verificaSaldo(senha);
}
	else{
	return -1;
}
	}
	
	public boolean efetuaDeposito(int numeroDaConta, double valor) {
		if(valor <= 0) {
			return false;
		}else {
		Conta conta = bdContas.buscaConta(numeroDaConta);
		if(conta == null || !conta.creditaValor(valor, "Deposito em dinheiro")) {
			return false;
		}
			return true;
		}
	}
	
	
	public boolean efetuaCheque(int numeroDaConta, double valor) {
		if(valor <=0) {
			return false;
		}else {
			Conta conta = bdContas.buscaConta(numeroDaConta);
			if(conta == null || !conta.creditaValor(valor, "Deposito em cheque")) {
				return false;
			}
			return true;
		}
	}
	
	public boolean efetuaTransferencia(int contaOrigem, int senha, int contaDestino, double valor) {
		Conta ctOrigem = bdContas.buscaConta(contaOrigem);
		Conta ctDestino = bdContas.buscaConta(contaDestino);
		if(ctOrigem == null || ctDestino == null) {
			return false;
		}
		
		ctOrigem.debitaValor(valor, senha, "Transferencia");
		ctDestino.creditaValor(valor, "Transferencia");
		return true;
		
	}
	
	public String geraExtrato(int numeroDaConta, int senha) {
		Conta conta = bdContas.buscaConta(numeroDaConta);
		if(conta == null) {
			return null;
		}
		String extratoConta = conta.geraExtrato(senha);
		StringBuilder sb = new StringBuilder();
		
		sb.append(extratoConta).append("\n").append(conta.getSaldo());
		
		return sb.toString();		
	}
	
	public boolean efetuaSaque(int numeroDaConta, double valor, int senha){
	if(valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldo){
	return false;
	}
	Conta conta = bdContas.buscaConta(numeroDaConta);
	if (conta == null || !conta.debitaValor(valor, senha, "Saque Automatico")){
	return false;
	}

	this.liberaCedulas((int)(valor/50));
	this.saldo -= valor;
	if(this.saldo < 500){
		this.meuTerminal.setModo(0);
	}
	return true;
	}
	
	
	public void recarrega(){
	this.saldo = 2000;
	this.meuTerminal.setModo(1);
	}
	private void liberaCedulas(int quantidade){
	while(quantidade-- > 0){
	System.out.println("===/ R$50,00 /===");
}
	}
	
}
