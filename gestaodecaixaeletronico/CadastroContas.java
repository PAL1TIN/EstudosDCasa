package poo.gestaodecaixaeletronico;

import poo.gestaodecontas.Conta;

public class CadastroContas {

	private Conta[] contas;
	private int numeroDeContas;
	public CadastroContas(int numeroDeContas) {
	this.contas = new Conta[numeroDeContas];
}
	
	public boolean adicionaConta(Conta conta) {
	if(this.numeroDeContas == this.contas.length |
	this.buscaConta(conta.getNumero()) != null) {
	return false;
}
	this.contas[this.numeroDeContas++] = conta;
	return true;
	
}
	
	public Conta buscaConta(int numero) {
	for (int i = 0; i < this.numeroDeContas; i++) {
	if(numero == this.contas[i].getNumero()) {
	return this.contas[i];
	}
}
	
	return null;
}
	
}
