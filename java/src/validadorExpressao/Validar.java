package validadorExpressao;

import java.util.StringTokenizer;

public class Validar {
	private String str;
	public Validar(String string){
		this.str = string;
	}
	
	public boolean valida() throws Exception{
		tiraEspaco();
		converte();
		caracterInvalido();
		return expressao();
	}
	public void tiraEspaco(){
		StringBuffer newstr = new StringBuffer();
		StringTokenizer quebrador = new StringTokenizer (this.str, " ");
		while(quebrador.hasMoreTokens() == true){
			newstr.append(quebrador.nextToken());
		}
		str = newstr.toString();
	}
	public void converte(){
		str = str.replaceAll("<->", "<");
		str = str.replaceAll("->", "-");
		str = str.replaceAll("t", "T");
		str = str.replaceAll("f", "F");
		str = str.replaceAll("f", "F");
		str = str.replaceAll("t", "T");
		str = str.replaceAll("V", "v");
		str = str.replaceAll("âˆ¨", "v");
		str = str.replaceAll("∨", "v");
		str = str.replaceAll("âˆ§", "^");
		str = str.replaceAll("Ë†", "^");
		str = str.replaceAll("âˆ¼", "~");
		str = str.replaceAll("Ëœ", "~");
		str = str.replaceAll("˜", "~");
	}
	public void caracterInvalido() throws Exception{
		String palavra[] = str.split("");
		for (int x = 0; x < palavra.length; x++){
			if(!palavra[x].contains("(") && !palavra[x].contains("~") && !palavra[x].contains("^") && !palavra[x].contains("v") && 
					!palavra[x].contains("-") && !palavra[x].contains("<") && !palavra[x].contains(")") && !palavra[x].contains("T") && 
					!palavra[x].contains("F")){
				throw new Exception("Expressao com caracter invalido");
			}
		}
	}
	public boolean expressao(){
		int parenteses = 0, operador = 0, negacao = 0, variavel = 0; //para retornar true, todos tem que estar 0
		StringTokenizer quebrador = new StringTokenizer (this.str, "~^âˆ¨-<", true);
		while(quebrador.hasMoreTokens() == true){
			String palavraQuebrada[] = quebrador.nextToken().split("");
			for(int x = 0; x < palavraQuebrada.length; x++){
				//()~^v-<
				switch (palavraQuebrada[x]){
				case "(":
					parenteses ++;
					break;
				case ")":
					parenteses --;
					break;
				case "~":
					negacao ++;
					break;
				case "^":
					if(variavel > 0)
						variavel --;
					else if(variavel == 0)
						return false;
					if(negacao > 0)
						return false;
					if(operador > 0)
						return false;
					operador ++;
					break;
				case "v":
					if(variavel > 0)
						variavel --;
					else if(variavel == 0)
						return false;
					if(negacao > 0)
						return false;
					if(operador > 0)
						return false;
					operador ++;
					break;
				case "-":
					if(variavel > 0)
						variavel --;
					else if(variavel == 0)
						return false;
					if(negacao > 0)
						return false;
					if(operador > 0)
						return false;
					operador ++;
					break;
				case "<":
					if(variavel > 0)
						variavel --;
					else if(variavel == 0)
						return false;
					if(negacao > 0)
						return false;
					if(operador > 0)
						return false;
					operador ++;
					break;
				case "T":
					if(negacao > 0)
						negacao --;
					if(operador > 0)
						operador --;
					if(variavel > 0)
						return false;
					variavel ++;
					break;
				case "F":
					if(negacao > 0)
						negacao --;
					if(operador > 0)
						operador --;
					if(variavel > 0)
						return false;
					variavel ++;
					break;
				default:
					System.err.println("Caracter invalido - " + palavraQuebrada[x]);
					return false;
				}
				if(quebrador.hasMoreTokens() == false && x == (palavraQuebrada.length - 1)){
					//verifica ultima palavra
					switch (palavraQuebrada[x]){
					case ")":
						break;
					case "T":
						break;
					case "F":
						break;
					default :
						return false;
					}
					//Variavel tem que ser 1 para ser valida, isso significa que nenhum operador ou negacao esta terminando a frase.
					if(variavel != 1){
						return false;
					}else{
						variavel --;
					}
				}
			}
		}
		if((parenteses + operador + negacao + variavel) == 0){
			return true;
		}else{			
			return false;
		}
	}
}
