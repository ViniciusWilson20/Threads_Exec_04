package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadCarro;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public static String character;
    public static int op;
	public static void main(String[] args) {

		
		if (op >= 1 || op <= 7) {
			
			try {
			op = Integer.parseInt(JOptionPane.showInputDialog("SELECIONE UM PERSONAGEM: " 
			+ "\n 1) Mario "
			+ "\n 2) Sonic" 
			+ "\n 3) Pikachu" 
			+ "\n 4) Link (O Zelda)" 
			+ "\n 5) Bart"
			+ "\n 6) Megaman"
			+ "\n 7) Sol Badguy"));

			switch (op) {

			case 1:
				character = "mario";
				break;

			case 2:
				character = "sonic";
				break;

			case 3:
				character = "pikachu";
				break;

			case 4:
				character = "link";
				break;

			case 5:
				character = "bart";
				break;
				
			case 6: 
				character = "megaman";
				break;
			case 7:
				character = "sol";
				break;
			}
			
			}catch(Exception e) {
				
				System.exit(EXIT_ON_CLOSE);
			}
		} else {

			System.exit(0);

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {

					e.printStackTrace();
					System.exit(EXIT_ON_CLOSE);
				}

			}
		});

	}

	/**
	 * Create the frame.
	 */

	public Principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Race For The Finish!");
		setBounds(300, 100, 850, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(28, 67, 114));
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.ORANGE);
		separator.setBounds(40, 241, 707, 16);
		contentPane.add(separator);

		JLabel lblCarro_1 = new JLabel("");
		lblCarro_1.setBounds(28, 56, 144, 144);
		try {

			ImageIcon imagem1 = new ImageIcon(Principal.class.getResource("/img/" + character + ".gif"));
			Image img_Carro1 = imagem1.getImage().getScaledInstance(lblCarro_1.getWidth(), lblCarro_1.getWidth(),
					Image.SCALE_DEFAULT);
			lblCarro_1.setIcon(new ImageIcon(img_Carro1));

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Entrada Invalida!");
			System.exit(EXIT_ON_CLOSE);
		}

		contentPane.add(lblCarro_1);

		JLabel lblCarro_2 = new JLabel("");

		ImageIcon imagem2 = new ImageIcon(Principal.class.getResource("/img/sonic.gif"));
		lblCarro_2.setBounds(28, 282, 144, 144);
		Image image_Carro2 = imagem2.getImage().getScaledInstance(lblCarro_2.getWidth(), lblCarro_2.getHeight(),
				Image.SCALE_DEFAULT);
		lblCarro_2.setIcon(new ImageIcon(image_Carro2));
		contentPane.add(lblCarro_2);

		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setForeground(Color.WHITE);
		lblVencedor.setBounds(294, 406, 55, 16);
		contentPane.add(lblVencedor);

		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setForeground(Color.WHITE);
		lblPerdedor.setBounds(294, 434, 55, 16);
		contentPane.add(lblPerdedor);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		textField_1.setForeground(Color.RED);
		textField_1.setBounds(361, 399, 122, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		textField_2.setForeground(Color.RED);
		textField_2.setBounds(361, 428, 122, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				acao(lblCarro_1, lblCarro_2);
			}
		});
		btnStart.setBounds(375, 369, 90, 28);
		contentPane.add(btnStart);
	}

	public void acao(JLabel lblCarro_1, JLabel lblCarro_2) {

		ThreadCarro Player1 = new ThreadCarro(lblCarro_1, 1, textField_1, textField_2);
		ThreadCarro Player2 = new ThreadCarro(lblCarro_2, 2, textField_1, textField_2);
		Player1.start();
		Player2.start();

	}
}
