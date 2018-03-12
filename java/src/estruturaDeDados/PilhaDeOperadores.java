package estruturaDeDados;

public class PilhaDeOperadores {
	private String[] pilhaOperadores; 
	private int topo = 0;

	public PilhaDeOperadores(){
		pilhaOperadores = new String[100]; //numero maximo de caracteres por ser vetor
		topo = 0;
	}
	
	public void insere(String s) throws Exception {
		if(cheia()) throw new Exception("Pilha Cheia");
		else{
			pilhaOperadores[topo] = s;
			System.out.println("PilhaOperadores " + pilhaOperadores[topo]);
			topo ++;
		}
	}
	
	public String retira() throws Exception {
		if(vazia()) throw new Exception("Pilha Vazia");
		else{
			topo --;
			return pilhaOperadores[topo];
		}
	}
	
	public boolean vazia(){
		if (topo == 0) return true;
		return false;
	}
	
	public boolean cheia(){
		if (topo == pilhaOperadores.length) return true;
		return false;
	}
}