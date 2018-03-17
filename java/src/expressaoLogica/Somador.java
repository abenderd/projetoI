package expressaoLogica;

import estruturaDeDados.*;

public class Somador {
	private String v1, v2, opl;
	private Pilha result;
	private Fila fila;
	
	public Somador(Fila fila){
		this.result = new Pilha(fila.toString().length());
		this.fila = fila;
	}
	
	public boolean geraResultado(){
		while(true){
			//limpa para não sobrar lixo da ultima rodada
			v2 = null;
			v1 = null;
			try{
				String str = fila.remove();
				switch (str){
				case "T":
					result.insere(str);
					break;
				case "F":
					result.insere(str);
					break;
				case "~":
					opl = str;
					v2 = result.retira();
					result.insere(Calcula());
					break;
				default:
					opl = str;
					v2 = result.retira();
					v1 = result.retira();
					result.insere(Calcula());
				}
			}catch(Exception e){
				System.err.println(e);
				break;
			}
			System.out.println("\n");
		}
		try {
			switch(result.retira()){
			case"T":
				return true;
			case"F":
				return false;
			default:
				throw new Exception("Erro ao exibir resultado final");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			return false;
		}
	}
	
	private String Calcula() throws Exception{
		switch(this.opl){
		case "<":
			if(this.v2.equals(this.v1)) //A conjunção é verdadeira se, e somente se, ambos operandos forem falsos ou ambos verdadeiros				return "F";
				return "T";
			return "F";
		case "-":
			if(this.v2.equals("F") && this.v1.equals("T")) //A conjunção é falsa se, e somente se, o primeiro operando é verdadeiro e o segundo operando é falso.
				return "F";
			return "T";
		case "^":
			if(this.v2.equals("T") && this.v1.equals("T")) //A conjunção é verdadeira se e somente se os operandos são verdadeiros
				return "T";
			return "F";
		case "v":
			if(this.v2.equals("F") && this.v1.equals("F")) //A disjunção é falsa se, e somente se ambos os operandos forem falsos.
				return "F";
			return "T";
		case "~":
			if(this.v2.equals("T"))//Inverte o sinal
				return "F";
			else
				return "T";
		default:
			throw new Exception("Erro na funçao calcula");
		}
	}
}
