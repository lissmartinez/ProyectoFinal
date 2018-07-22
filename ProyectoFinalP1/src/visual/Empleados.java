package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Personal;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Empleados extends JFrame {

	private JPanel contentPane;
	private Personal aux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
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
	public Empleados() {
		setTitle("Personal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Empleados.class.getResource("/imagenes/logo.png")));
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
				RegistrarPersonal regp = new RegistrarPersonal(aux);
				regp.setModal(true);
				regp.setLocationRelativeTo(null);
				regp.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/clirn.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(35, 11, 244, 233);
		contentPane.add(label);
		
		JLabel lblRegistro = new JLabel("Registro de personal");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(95, 255, 124, 14);
		contentPane.add(lblRegistro);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaEmpleados listaEmpleados = new ListaEmpleados();
				listaEmpleados.setModal(true);
				listaEmpleados.setLocationRelativeTo(null);
				listaEmpleados.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(Empleados.class.getResource("/imagenes/Lista.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(314, 11, 244, 233);
		contentPane.add(label_1);
		
		JLabel lblListaDePersonal = new JLabel("Lista de personal");
		lblListaDePersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePersonal.setBounds(374, 255, 124, 14);
		contentPane.add(lblListaDePersonal);
	}

}
