package estruturaDeDados;

public class PilhaDeOperadores {
	private String[] pilhaOperadores;
	private int topo = 0;

	public PilhaDeOperadores() {
		pilhaOperadores = new String[100]; // numero maximo de caracteres por ser vetor
		topo = 0;
	}

	public void insere(String s) throws Exception {
		if (cheia())
			throw new Exception("Pilha Cheia");
		else {
			pilhaOperadores[topo] = s;
			System.out.println("PilhaOperadores " + pilhaOperadores[topo]);
			topo++;
		}
	}

	public String retira() throws Exception {
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
	}

	public boolean vazia() {
		if (topo == 0)
			return true;
		return false;
	}

	public boolean cheia() {
		if (topo == pilhaOperadores.length)
			return true;
		return false;
	}

	public String getUltimoElemento() {
		for (int i = pilhaOperadores.length - 1; i >= 0; i--) {
			if (pilhaOperadores[i] != null) {
				String ultimo = pilhaOperadores[i];

				return ultimo;
			}
		}
		return null;
	}
}