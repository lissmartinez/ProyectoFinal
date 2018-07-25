package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Personal;
import logico.Plan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PrincipalVisual extends JFrame {

	private JPanel contentPane;
private Personal aux;




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
		setTitle("Gravity Comunications");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 527);
		setLocationRelativeTo(null);
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
				RegistrarPersonal regp = new RegistrarPersonal(aux);
				regp.setModal(true);
				regp.setVisible(true);
					
			}
		});
		mnProductos.add(mntmRegistro);
		
		JMenuItem mntmListaDeEmpledos = new JMenuItem("Lista de Empleados");
		mntmListaDeEmpledos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmpleados listaEmpleados = new ListaEmpleados();
				listaEmpleados.setModal(true);
				listaEmpleados.setLocationRelativeTo(null);
				listaEmpleados.setVisible(true);
			}
		});
		mnProductos.add(mntmListaDeEmpledos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistro_1 = new JMenuItem("Registro");
		mntmRegistro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cli = null;
				RegistroClientes regCliente = null;
			    regCliente = new RegistroClientes(cli);
				regCliente.setModal(true);
				regCliente.setLocationRelativeTo(null);
				regCliente.setVisible(true);
			
				
			}
		});
		mnClientes.add(mntmRegistro_1);
		
		JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaClientes listaClientes = new ListaClientes();
				listaClientes.setModal(true);
				listaClientes.setLocationRelativeTo(null);
				listaClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmListaDeClientes);
		
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
		
		JMenuItem mntmListaDePlanes = new JMenuItem("Lista de planes");
		mntmListaDePlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPlan crr = new ListaPlan();
				crr.setModal(true);
				crr.setLocationRelativeTo(null);
				crr.setVisible(true);
				
			}
		});
		mnPlanes.add(mntmListaDePlanes);
		
		JMenu mnNewMenu = new JMenu("Contrato");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRealizarContrato = new JMenuItem("Realizar contrato");
		mntmRealizarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentaPlan vplan = new VentaPlan();
				vplan.setModal(true);
				vplan.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRealizarContrato);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		JMenuItem mntmFactura = new JMenuItem("Facturar");
		mntmFactura.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				Facturar fact = new Facturar();
				fact.setModal(true);
				fact.setVisible(true);
			}
		});
		mnFacturas.add(mntmFactura);
		
		JMenuItem mntmGenerarFactura = new JMenuItem("Generar factura");
		mntmGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneradorDeFacturas generar = new GeneradorDeFacturas();
				generar.setModal(true);
				generar.setVisible(true);
			}
		});
		mnFacturas.add(mntmGenerarFactura);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}