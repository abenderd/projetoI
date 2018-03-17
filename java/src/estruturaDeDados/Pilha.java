package estruturaDeDados;

public class Pilha {
	private String[] pilhaOperadores;
	private int topo;

	public Pilha(int tamanho) {
		pilhaOperadores = new String[tamanho];
		topo = -1;
	}

	public void insere(String s) throws Exception {
		if (cheia())
			throw new Exception("Pilha Cheia");
		else {
			topo++;
			pilhaOperadores[topo] = s;
			System.out.println("Pilha insere " + pilhaOperadores[topo]);
			
		}
	}

	/*public String retira() throws Exception {
		if (vazia())
			throw new Exception("Pilha Vazia");
		else {
			for (int i = pilhaOperadores.length - 1; i >= 0; i--) {
				if (pilhaOperadores[i] != null) {
					pilhaOperadores[topo] = pilhaOperadores[i];
					topo--;
				}
			}
			System.out.println("Removendo " + pilhaOperadores[topo]);
			return pilhaOperadores[topo];
		}
	}*/
	
	public String retira() throws Exception {
		if(vazia()) throw new Exception("Pilha Vazia");
		else{
			topo --;
			System.out.println("Pilha retira " + pilhaOperadores[topo+1]);
			return pilhaOperadores[topo+1];
		}
	}

	public boolean vazia() {
		if (topo == -1)
			return true;
		return false;
	}

	public boolean cheia() {
		if (topo == pilhaOperadores.length)
			return true;
		return false;
	}

	public String getUltimoElemento() {
		if(vazia())
			return null;
		return pilhaOperadores[topo];
	}
}