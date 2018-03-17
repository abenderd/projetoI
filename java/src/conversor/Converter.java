package conversor;

import estruturaDeDados.Fila;
import estruturaDeDados.Pilha;

public class Converter {

	private String expressao;
	private Pilha pilhaDeOperadores;
	private Fila filaSaida;

	public Converter(String expressao) {
		this.expressao = expressao;
		this.filaSaida = new Fila(expressao.length());
		this.pilhaDeOperadores = new Pilha(expressao.length());
	}

	public void converterInfixaPosFixa() throws Exception {
		String[] expressaoQuebrada = quebraExpressao();

		for (int i = 0; i < expressaoQuebrada.length; i++) {
			String elemento = expressaoQuebrada[i];
			Character caracter = elemento.charAt(0);

			if (caracter == '(') {
				pilhaDeOperadores.insere(elemento);
			} else if (caracter == 'T' || caracter == 'F') {
				filaSaida.insere(elemento);
			} else if (caracter == '~' || caracter == '^' || caracter == 'v' || caracter == '-' || caracter == '<') {
				switch (caracter) {
				case '(': {
					if (pilhaDeOperadores.getUltimoElemento() == null) {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '~') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '^') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == 'v') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '-') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
					break;
				}
				case '~': {
					if (pilhaDeOperadores.getUltimoElemento() == null) {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '~') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '^') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == 'v') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '-') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
					break;
				}
				case ')': {
					if (pilhaDeOperadores.getUltimoElemento() == null) {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '~') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '^') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == 'v') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '-') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
					break;
				}
				default:{
					if (pilhaDeOperadores.getUltimoElemento() == null) {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '~') {
						filaSaida.insere(pilhaDeOperadores.retira());
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '^') {
						filaSaida.insere(pilhaDeOperadores.retira());
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == 'v') {
						filaSaida.insere(pilhaDeOperadores.retira());
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '-') {
						filaSaida.insere(pilhaDeOperadores.retira());
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						filaSaida.insere(pilhaDeOperadores.retira());
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
					break;
				}
				}
			} else if (caracter == ')') {
				Character aux = pilhaDeOperadores.retira().charAt(0);
				while(aux != '('){
					filaSaida.insere(aux.toString());
					aux = pilhaDeOperadores.retira().charAt(0);
				};
				
			}
		}
		//VERIFICA SE AINDA TEM ALGO NA PILHA
		while(!pilhaDeOperadores.vazia()){
			filaSaida.insere(pilhaDeOperadores.retira());
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

	public Fila retornaExpressaoPosFixa() {
		return filaSaida;
	}
}
