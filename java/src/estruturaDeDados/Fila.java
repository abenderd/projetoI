package estruturaDeDados;

import java.util.Arrays;

public class Fila {
	private String[] filaSaida; 
	private int inicio, fim = 0;
	
	public Fila(int tamanho){
		filaSaida = new String[tamanho];
		inicio = 0;
		fim = 0;
	}
	
	public void insere(String s) throws Exception {
		if(cheia()) throw new Exception("Lista Cheia");
		else{
			filaSaida[fim] = s;
			System.out.println("FilaSaida insere " + filaSaida[fim] + " no espaco " + fim);
			fim++;
		}
	}
	
	public String remove() throws Exception {
		if(vazia()) throw new Exception("Lista Vazia");
		else{
			String retorno = filaSaida[inicio];
			filaAnda();
			System.out.println("FilaSaida retira " + retorno);
			return retorno;
		}
	}
	
	public boolean vazia() {
		if (fim == 0){
			return true;
		}
		return false;
	}
	public boolean cheia() {
		if (fim == 99){
			return true;
		}
		return false;
	}
	
	public void filaAnda(){
		for (int x = 0; x <= fim; x++){
			if(x!=0){
				filaSaida[x-1] = filaSaida[x];
			}
			fim--;
		}
		fim--;
	}

	@Override
	public String toString() {
		/*ADICIONADO ENQUANTO ARRAY NAO É DINAMICO
		int x = this.fim;
		String retorno = "";
		for(;x>0;x--){
			retorno = retorno + this.filaSaida[x-1];
		}
		return retorno;
		*/
		//FIM
		return Arrays.toString(filaSaida);
	}
	
}
