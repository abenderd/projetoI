package view;

import javax.swing.JFrame;

public class CalculadoraFrame extends JFrame {

	public CalculadoraFrame() {
		CalculadoraView calculadora = new CalculadoraView();
		add(calculadora);
	}
	
}
