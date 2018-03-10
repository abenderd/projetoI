package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import validadorExpressao.Validar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraView extends JPanel {
	private JTextField textFieldEntrada;
	private JTextField textFieldSaida;

	/**
	 * Create the panel.
	 */
	public CalculadoraView() {
		setBackground(new Color(245, 222, 179));
		setLayout(null);
		
		JButton btnInserirFalse = new JButton("F");
		btnInserirFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "F ");
			}
		});
		btnInserirFalse.setBounds(136, 50, 66, 23);
		add(btnInserirFalse);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText("");
				textFieldSaida.setText("");
			}
		});
		btnLimpar.setBounds(239, 258, 97, 25);
		btnLimpar.setFont(new Font("Sitka Text", Font.BOLD, 12));
		add(btnLimpar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String expressao = textFieldEntrada.getText();
				Validar validador = new Validar(expressao);
				
				try {
					boolean ok = validador.valida();
					String resultado = "" + ok;
					System.out.println(ok);
					textFieldSaida.setText(resultado);
					
					if (ok == false) {
						JOptionPane.showMessageDialog(null, "Expressão inválida!", "", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch(Exception e) {
					System.err.println(e);
					JOptionPane.showMessageDialog(null, "Expressão inválida!", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalcular.setBounds(369, 258, 97, 25);
		btnCalcular.setFont(new Font("Sitka Text", Font.BOLD, 12));
		add(btnCalcular);
		
		textFieldEntrada = new JTextField();
		textFieldEntrada.setEditable(false);
		textFieldEntrada.setBounds(124, 187, 385, 20);
		add(textFieldEntrada);
		textFieldEntrada.setColumns(10);
		
		JLabel lblEntrada = new JLabel("Entrada:");
		lblEntrada.setBounds(10, 190, 104, 14);
		add(lblEntrada);
		
		JLabel lblSaida = new JLabel("Sa\u00EDda:");
		lblSaida.setBounds(10, 221, 104, 14);
		add(lblSaida);
		
		JLabel lblFormeAExpressao = new JLabel("Forme a express\u00E3o l\u00F3gica com os bot\u00F5es, ou a insira diretamente na caixa de entrada:");
		lblFormeAExpressao.setBounds(10, 11, 580, 14);
		add(lblFormeAExpressao);
		
		JButton btnInserirDisjuncao = new JButton("v");
		btnInserirDisjuncao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "v ");
			}
		});
		btnInserirDisjuncao.setBounds(136, 102, 66, 23);
		add(btnInserirDisjuncao);
		
		JButton btnInserirTrue = new JButton("T");
		btnInserirTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "T ");
			}
		});
		btnInserirTrue.setBounds(252, 50, 66, 23);
		add(btnInserirTrue);
		
		JButton btnInserirConjuncao = new JButton("^");
		btnInserirConjuncao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "^ ");
			}
		});
		btnInserirConjuncao.setBounds(252, 102, 66, 23);
		add(btnInserirConjuncao);
		
		JButton btnInserirImplicacao = new JButton("->");
		btnInserirImplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "-> ");
			}
		});
		btnInserirImplicacao.setBounds(369, 102, 66, 23);
		add(btnInserirImplicacao);
		
		JButton btnInserirNegacao = new JButton("~");
		btnInserirNegacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "~ ");
			}
		});
		btnInserirNegacao.setBounds(136, 153, 66, 23);
		add(btnInserirNegacao);
		
		JButton btnInserirAbreParenteses = new JButton("(");
		btnInserirAbreParenteses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "( ");
			}
		});
		btnInserirAbreParenteses.setBounds(252, 153, 66, 23);
		add(btnInserirAbreParenteses);
		
		JButton btnInserirFechaParenteses = new JButton(")");
		btnInserirFechaParenteses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + ") ");
			}
		});
		btnInserirFechaParenteses.setBounds(369, 153, 66, 23);
		add(btnInserirFechaParenteses);
		
		textFieldSaida = new JTextField();
		textFieldSaida.setEditable(false);
		textFieldSaida.setColumns(10);
		textFieldSaida.setBounds(124, 218, 29, 20);
		add(textFieldSaida);
		
		JButton btnInserirEquivalencia = new JButton("<->");
		btnInserirEquivalencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEntrada.setText(textFieldEntrada.getText() + "<-> ");
			}
		});
		btnInserirEquivalencia.setBounds(369, 50, 66, 23);
		add(btnInserirEquivalencia);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnFechar.setBounds(111, 258, 97, 25);
		add(btnFechar);

	}
}
