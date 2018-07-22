package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setTitle("Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = null;
				RegistroClientes regCliente = null;
					regCliente = new RegistroClientes(cli);
				regCliente.setModal(true);
				regCliente.setLocationRelativeTo(null);
				regCliente.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/cli.jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(27, 11, 244, 233);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaClientes listaClientes = new ListaClientes();
				listaClientes.setModal(true);
				listaClientes.setLocationRelativeTo(null);
				listaClientes.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(Clientes.class.getResource("/imagenes/Lista.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(306, 11, 244, 233);
		contentPane.add(label_1);
		
		JLabel lblRegistroDeClientes = new JLabel("Registro de clientes");
		lblRegistroDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeClientes.setBounds(87, 255, 124, 14);
		contentPane.add(lblRegistroDeClientes);
		
		JLabel lblListaDeClientes = new JLabel("Lista de clientes");
		lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeClientes.setBounds(366, 255, 124, 14);
		contentPane.add(lblListaDeClientes);
	}

}
