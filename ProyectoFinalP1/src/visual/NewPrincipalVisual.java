package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewPrincipalVisual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPrincipalVisual frame = new NewPrincipalVisual();
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
	public NewPrincipalVisual() {
		setBackground(new Color(51, 153, 102));
		setTitle("Gravity Comunications");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewPrincipalVisual.class.getResource("/imagenes/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelClinets = new JLabel("");
		lblNewLabelClinets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes clie = new Clientes();
				clie.setLocationRelativeTo(null);
				clie.setVisible(true);
			}
		});
		lblNewLabelClinets.setBackground(new Color(255, 255, 255));
		lblNewLabelClinets.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/cli.jpg")));
		lblNewLabelClinets.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelClinets.setBounds(31, 11, 244, 233);
		contentPane.add(lblNewLabelClinets);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		lblNewLabel_1.setBounds(130, 255, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabelServicios = new JLabel("");
		lblNewLabelServicios.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/servicios.png")));
		lblNewLabelServicios.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelServicios.setBounds(300, 27, 244, 214);
		contentPane.add(lblNewLabelServicios);
		
		JLabel lblNewLabel_3 = new JLabel("Servicios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(375, 255, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel Personal = new JLabel("");
		Personal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Empleados emp = new Empleados();
				emp.setLocationRelativeTo(null);
				emp.setVisible(true);
			}
		});
		Personal.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/per.png")));
		Personal.setHorizontalAlignment(SwingConstants.CENTER);
		Personal.setBackground(Color.WHITE);
		Personal.setBounds(581, 11, 244, 233);
		contentPane.add(Personal);
		
		JLabel lblPersonal = new JLabel("Personal");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setBounds(669, 255, 68, 14);
		contentPane.add(lblPersonal);
	}

}
