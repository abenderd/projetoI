package calculadora;

import javax.swing.JFrame;

import estruturaDeDados.Fila;
import expressaoLogica.Somador;
import view.CalculadoraFrame;

public class Main {

	private static CalculadoraFrame calculadoraFrame = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculadoraFrame = new CalculadoraFrame();
		calculadoraFrame.setSize(600, 400);
		calculadoraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculadoraFrame.setVisible(true);
	}

}

/*	
//TESTE PARTE 3
	//((A∨B→A)∧(A→B))→(∼B↔A)
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Fila fila = new Fila(15);
	try {
		fila.insere("T");
		fila.insere("F");
		fila.insere("v");
		fila.insere("T");
		fila.insere("-");
		fila.insere("T");
		fila.insere("F");
		fila.insere("-");
		fila.insere("^");
		fila.insere("F");
		fila.insere("~");
		fila.insere("T");
		fila.insere("<");
		fila.insere("-");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Somador soma = new Somador(fila);
	System.out.println(soma.geraResultado());
}
}
*/
