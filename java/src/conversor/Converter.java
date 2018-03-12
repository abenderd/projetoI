package conversor;

import estruturaDeDados.FilaSaida;
import estruturaDeDados.PilhaDeOperadores;
import estruturaDeDados.PilhaResultado;

public class Converter {

	String expressao;
	String[] segmentosExpresao;
	PilhaDeOperadores pilhaDeOperadores = new PilhaDeOperadores();
	FilaSaida filaSaida = new FilaSaida();;
	
	public Converter(String expressao) {
		this.expressao =  expressao;
	}

	public void converterInfixaPosFixa() throws Exception {
		String[] expressaoQuebrada = quebraExpressao();
		
		for (int i = 0; i < expressaoQuebrada.length-1; i++) {
			String elemento = expressaoQuebrada[i];
			Character caracter = elemento.charAt(0);
			
			if (caracter == '(') {
				pilhaDeOperadores.insere(elemento);
			}
			else if (caracter == 'T' || caracter == 'F') {
				filaSaida.insere(elemento);
			}
			else if (caracter == '~' || caracter == '^' || caracter == 'v' || caracter == '-' || caracter == '<') {
				System.out.println(caracter);
			}
		}
		
	}


	public String[] quebraExpressao() {
		expressao = expressao.replaceAll(" ", "").replaceAll("", " ");
		expressao = removeEspacos();
        return expressao.split("");
	}
	
	public String removeEspacos() {
		 String expressaoSemEspacos = expressao.replaceAll(" ", "");
		return expressaoSemEspacos;
	}
	
	public String retornaExpressaoPosFixa() {
		return "" + expressao;
	}
}
