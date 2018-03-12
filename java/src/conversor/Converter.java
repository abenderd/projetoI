package conversor;

import estruturaDeDados.FilaSaida;
import estruturaDeDados.PilhaDeOperadores;
import estruturaDeDados.PilhaResultado;

public class Converter {

	String expressao;
	String[] segmentosExpresao;

	public Converter(String expressao) {
		this.expressao =  expressao;
	}

	public void converterInfixaPosFixa() {
		String[] expressaoQuebrada = quebraExpressao();
		System.out.println(expressaoQuebrada);
		
		/*for (int i = 0; i < expressao.length(); i++) {
			if (expressao.charAt(i) == '(') {
				//elementos.inserePilha(i);
			}
			else  if (expressao.charAt(i) == 'T' || expressao.charAt(i) == 'F') {
				//elementos.insereFilaSaida(i);
			}
			else if (expressao.charAt(i) == '~' || expressao.charAt(i) == '^' || expressao.charAt(i) == 'v' || expressao.charAt(i) == '-' || expressao.charAt(i) == '<') {
				
			}
		}*/
		
	}


	public String[] quebraExpressao() {
		expressao = expressao.replaceAll(" ", "").replaceAll("", " ");
		expressao = removeEspacos();
        return expressao.split(" ");
	}
	
	public String removeEspacos() {
		 String expressaoSemEspacos = expressao.replaceAll(" ", "");
		return expressaoSemEspacos;
	}
	
	public String retornaExpressaoPosFixa() {
		return "" + expressao;
	}
}
