package view;

import javax.swing.JFrame;

public class CalculadoraFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculadoraFrame() {
		CalculadoraView calculadora = new CalculadoraView();
		add(calculadora);
	}
	
}
