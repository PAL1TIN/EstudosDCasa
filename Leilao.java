import java.util.ArrayList;
import java.util.Iterator;

public class Leilao {

	private ArrayList<Lote> lotes;
	private int numeroProxLote;
	
	public Leilao(){
		this.lotes = new ArrayList<>();
		this.numeroProxLote = 1;
	}
	
	public void adicionaLote(String descricao) {
		this.lotes.add(new Lote(this.numeroProxLote, descricao));
		this.numeroProxLote++;
	}
	
	public void mostraLotes() {
		Iterator<Lote> it = this.lotes.iterator();
		while(it.hasNext()) {
			Lote lote = it.next();
			System.out.println(lote.getNumero() + ": " + lote.getDescricao());
			Lance melhorLance = lote.getMaiorLance();
			
			if(melhorLance != null) {
				System.out.println("   Lance:" + melhorLance.getValor());
			}
			else {
				System.out.println("   (Nenhum Lance)");
			}
			
		}
	}
	
	public Lote getLote(int numero) {
		if((numero >= 1) && (numero < this.numeroProxLote)) {
			Lote loteSelecionado = this.lotes.get(numero -1);
			if(loteSelecionado.getNumero() != numero) {
				System.out.println("Erro!!");
			}
			return loteSelecionado;
		}
		
		else {
			System.out.println("Lote numero " + numero + " nao existe");
			return null;
		}
	}
	
	

	
}
