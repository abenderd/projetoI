package expressaoLogica;

public class FilaSaida {
	private String[] filaSaida; 
	private int inicio, fim;
	
	public FilaSaida(String palavra){
		filaSaida = new String[100]; //numero maximo de caracteres por ser vetor
		inicio = 0;
		fim = 0;
	}
	
	public void insere(String s) throws Exception {
		if(cheia()) throw new Exception("Lista Cheia");
		else{
			filaSaida[fim] = s;
			fim++;
		}
	}
	
	public String remove() throws Exception {
		if(vazia()) throw new Exception("Lista Vazia");
		else{
			String retorno = filaSaida[inicio];
			filaAnda();
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
		}
	}

}
