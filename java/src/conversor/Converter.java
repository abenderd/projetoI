package conversor;

import estruturaDeDados.FilaSaida;
import estruturaDeDados.PilhaDeOperadores;
import estruturaDeDados.PilhaResultado;

public class Converter {

	String expressao;
	String[] segmentosExpresao;
	PilhaDeOperadores pilhaDeOperadores;
	FilaSaida filaSaida;
	
	public Converter(String expressao) {
		this.expressao =  expressao;
	}

	public void converterInfixaPosFixa() throws Exception {
		String[] expressaoQuebrada = quebraExpressao();
		
		for (int i = 0; i < expressaoQuebrada.length-1; i++) {
			String elemento = expressaoQuebrada[i];
			Character caracter = elemento.charAt(0);
			
			if (caracter == '(') {
				// TODO: FAZER FUNCIONAR pilhaDeOperadores.insere(elemento);
				System.out.println(caracter);
			}
			else if (caracter == 'T' || caracter == 'F') {
				// TODO: FAZER FUNCIONAR  filaSaida.insere(elemento);
				System.out.println(caracter);
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
