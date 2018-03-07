package calculadora;

import java.util.Scanner;

import validadorExpressao.Validar;

public class Main {
//MUDAR FILECODING PARA UTF-8 E DELIMITER PARA UNIX
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	public static void start(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite sua expressao:");
		Validar validador = new Validar(sc.nextLine());
		try{
			boolean ok = validador.valida();
			System.out.println(ok);
			start();
		}catch(Exception e){
			System.err.println(e);
			start();
		}
	}
}
