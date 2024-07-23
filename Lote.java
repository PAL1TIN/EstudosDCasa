
public class Lote {

	private int numero;
	private String descricao;
	private Lance maiorLance;
	
	public Lote(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public Lance getMaiorLance() {
		return this.maiorLance;
	}
	
	public void lancePara(Pessoa licitante, double valor) {
		if(this.maiorLance == null || (this.maiorLance.getValor() < valor)) {
			this.setMaiorLance(new Lance(licitante, valor));
		}
		else {
			System.out.println("Lote nº: " + this.getNumero() + "(" + this.getDescricao() + ")" + "Atualmente tem um lance de: " + this.maiorLance.getValor());
		}
	}
	
	private void setMaiorLance(Lance maiorLance) {
		this.maiorLance = maiorLance;
	}
	
}
