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
		this.expressao = expressao;
	}

	public void converterInfixaPosFixa() throws Exception {
		String[] expressaoQuebrada = quebraExpressao();

		for (int i = 0; i < expressaoQuebrada.length - 1; i++) {
			String elemento = expressaoQuebrada[i];
			Character caracter = elemento.charAt(0);

			if (caracter == '(') {
				pilhaDeOperadores.insere(elemento);
			} else if (caracter == 'T' || caracter == 'F') {
				filaSaida.insere(elemento);
			} else if (caracter == '~' || caracter == '^' || caracter == 'v' || caracter == '-' || caracter == '<') {
				switch (caracter) {
				case '(': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
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
				}
				case '~': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
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
				}
				case '^': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '~') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '^') {
						pilhaDeOperadores.retira();
						filaSaida.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == 'v') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '-') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
				}
				case 'v': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
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
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '<') {
						pilhaDeOperadores.insere(elemento);
					} else if (pilhaDeOperadores.getUltimoElemento().charAt(0) == ')') {
						pilhaDeOperadores.insere(elemento);
					}
					break;
				}
				case '-': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
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
				case '<': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
						pilhaDeOperadores.insere(elemento);
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
				case ')': {
					if (pilhaDeOperadores.getUltimoElemento().charAt(0) == '(') {
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
				}
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
