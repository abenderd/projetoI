package calculadora;

import java.util.Scanner;

import javax.swing.JFrame;

import validadorExpressao.Validar;
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
