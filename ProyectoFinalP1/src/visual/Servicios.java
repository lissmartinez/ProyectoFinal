package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Servicios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicios frame = new Servicios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 594, 291);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(35, 11, 244, 233);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Registro de personal");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(95, 255, 124, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(314, 11, 244, 233);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Lista de personal");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(374, 255, 124, 14);
		panel.add(label_3);
	}

}
