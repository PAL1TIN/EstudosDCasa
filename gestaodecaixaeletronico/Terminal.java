package poo.gestaodecaixaeletronico;
import java.util.Scanner;

public class Terminal{
	

 private Caixa meuCaixa;
 private int modoAtual;
 
  public Terminal(CadastroContas bd) {
      this.meuCaixa = new Caixa(this, bd);
 }
  public void iniciaOperacao() {
     int opcao;
     opcao = this.getOpcao();
     while (opcao != 4) {
        switch (opcao) {
            case 1: double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da Conta"), getInt("Senha"));
                   if (saldo != -1) {
                       System.out.println("Saldo Atual: " + saldo);
                   } else {
                       System.out.println("Conta/senha inválida");
                   }
                   break;
            case 2: boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da Conta"), (double) getInt("Valor"),getInt("Senha"));
                   if (b) {
                      System.out.println("Retire o dinheiro");
                   } else {
                      System.out.println("Pedido de saque recusado");
                   }
                   break;
                   
                   
            case 3: this.meuCaixa.recarrega();
            break;
            
            case 5: boolean c = this.meuCaixa.efetuaDeposito(getInt("Numero da Conta"), (double) getInt ("Valor"));
            	if(c) {
            		System.out.println("Deposito efetuado");
            	}else {
            		System.out.println("Erro ao efetuar");
            	}
            	break;
            case 6: boolean d = this.meuCaixa.efetuaCheque(getInt("Numero da conta"), (double) getInt("Valor"));
            	if(d) {
            		System.out.println("Cheque efetuado");
            	}
            	else{
            		System.out.println("Erro ao efetuar cheque");
            	}
            	break;
            case 7: boolean t = this.meuCaixa.efetuaTransferencia(getInt("Numero da conta de origem"),getInt("Senha"), getInt("Conta destino"), (double) getInt("Valor"));
            	if(t) {
            		System.out.println("Transferencia com sucesso");
            	}else {
            		System.out.println("Erro ao transferir");
            	}
            	break;
            case 8:
            	String z = this.meuCaixa.geraExtrato(getInt("Numero da conta"), getInt("Senha"));
            	
            	if(z == null) {
            		System.out.println("Erro no sistema");
            	}
            	
            	System.out.println(z);
            	
            	break;
            	
            
        }
        opcao = getOpcao();
     }
  }
  
    public void setModo(int modo) {
	   if (modo == 0 || modo == 1) {
	     this.modoAtual = modo;
	     }
	  }
	  private int getOpcao() {
	     int opcao;
	     do {
	       if (this.modoAtual == 1) {
	           opcao = getInt("Opcao: 1 - Consulta Saldo, 2 - Saque, 4 - Sair, 5 - Deposito em Dinheiro, 6 - Deposito em Cheque, 7 - Transferencia, 8 - Extrato ");
               if (opcao != 1 & opcao != 2 & opcao != 4 & opcao!= 5 & opcao != 6 & opcao != 7 & opcao != 8 ) {
	             opcao = 0;
	         }
	      } else {
	           opcao = getInt("Opcao: 3 - Recarrega, 4 - Sair");
                 if (opcao != 3 & opcao != 4) {
	             opcao = 0;
	           }
	       }
	    } while (opcao == 0);
	     
	   return opcao;
	   
	  }
	  private int getInt(String string) {
	     Scanner r = new Scanner(System.in);
	     System.out.println("Entre com " + string);
	   
	     if (r.hasNextInt()) {
		  
	      return r.nextInt();
	  
	  }
	  String st = r.next();
	  System.out.println("Erro na Leitura de Dados");
	  return 0;
   }
}