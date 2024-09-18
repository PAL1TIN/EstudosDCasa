package tarefa;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MapaTematico extends Item {
	private int nivPriv;

	public MapaTematico(String nome, int nP) {
		super(nome);
		this.nivPriv = nP;

	}

	public boolean empresta(Usuario u, int prazo) {
		GregorianCalendar cal = new GregorianCalendar();
		if ((this.isDisponivel()) && (u.getNivelPriv() >= this.nivPriv)) {

			this.retiradoPor = u;
			this.dtEmprestimo = cal.getTime();
			cal.add(Calendar.DATE, 2);
			this.dtDevolucao = cal.getTime();
			return true;
		}
		return false;
	}

}