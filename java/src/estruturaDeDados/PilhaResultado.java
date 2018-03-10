package estruturaDeDados;

public class PilhaResultado {
	private String[] pilhaResultado; 
	private int topo;

	public PilhaResultado(){
		pilhaResultado = new String[100]; //numero maximo de caracteres por ser vetor
		topo = 0;
	}
	
	public void insere(String s) throws Exception {
		if(cheia()) throw new Exception("Pilha Cheia");
		else{
			pilhaResultado[topo] = s;
			topo ++;			
		}
	}
	
	public String retira() throws Exception {
		if(vazia()) throw new Exception("Pilha Vazia");
		else{
			topo --;
			return pilhaResultado[topo];
		}
	}
	
	public boolean vazia(){
		if (topo == 0) return true;
		return false;
	}
	
	public boolean cheia(){
		if (topo == pilhaResultado.length) return true;
		return false;
	}
}
