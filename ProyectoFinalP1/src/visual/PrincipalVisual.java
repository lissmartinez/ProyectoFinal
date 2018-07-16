package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Plan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PrincipalVisual extends JFrame {

	private JPanel contentPane;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual frame = new PrincipalVisual();
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
	public PrincipalVisual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 567, 21);
		panel.add(menuBar);
		
		JMenu mnProductos = new JMenu("Empleados");
		menuBar.add(mnProductos);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro");
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
			}
		});
		mnProductos.add(mntmRegistro);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistro_1 = new JMenuItem("Registro");
		mntmRegistro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logico.Cliente cli = null;
				RegistroClientes regCliente = null;
				try {
					regCliente = new RegistroClientes(cli);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				regCliente.setModal(true);
				regCliente.setLocationRelativeTo(null);
				regCliente.setVisible(true);
			
				
			}
		});
		mnClientes.add(mntmRegistro_1);
		
		JMenu mnNewMenu = new JMenu("Contrato");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRealizarContrato = new JMenuItem("Realizar contrato");
		mnNewMenu.add(mntmRealizarContrato);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		JMenuItem mntmFactura = new JMenuItem("Factura");
		mntmFactura.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mnFacturas.add(mntmFactura);
		
		JMenuItem mntmGenerarFactura = new JMenuItem("Generar factura");
		mnFacturas.add(mntmGenerarFactura);
		
		JMenu mnPlanes = new JMenu("Planes");
		menuBar.add(mnPlanes);
		
		JMenuItem mntmCrearPlan = new JMenuItem("Crear plan");
		mntmCrearPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plan pla = null;
				CrearPlan crr = new CrearPlan(pla);
				crr.setModal(true);
				crr.setLocationRelativeTo(null);
				crr.setVisible(true);
			}
		});
		mnPlanes.add(mntmCrearPlan);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}