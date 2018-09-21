package controller;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;
public class ThreadCarro extends Thread {

	private int velocidade;
	private int percurso;
	private JLabel carro;
	private int limite;
	private JTextField vencedor, perdedor;
	private static int posicao;
	private int player_number;

	
	
	public ThreadCarro(JLabel carro, int player_number, JTextField vencedor, JTextField perdedor) {

		this.carro = carro;
		this.player_number = player_number;
		this.vencedor = vencedor;
		this.perdedor = perdedor;
		
	}

	public void run() {

		controle();
		Chegada();
	}

	public void controle() {

		Random r = new Random();
		limite = 660;
		percurso = carro.getLocation().x;
		velocidade = carro.getLocation().x;

		int tempo = 30;
		while (percurso < limite) {

			velocidade = r.nextInt(10);
			percurso = percurso + velocidade;

			if (percurso > limite) {

				percurso = limite;
			}
			carro.setLocation(percurso, carro.getLocation().y);

			try {

				Thread.sleep((tempo));

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		
	}

	public void Chegada() {
		
		posicao++;
		
		if (posicao == 1) {
			
			vencedor.setText(posicao + "º Player " + player_number );
		
		} 
		else if (posicao == 2) {
			
			perdedor.setText(posicao + "º Player " + player_number );
		}
	}
}
