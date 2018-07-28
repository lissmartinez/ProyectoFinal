package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Empresa;
import logico.Plan;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.CardLayout;

public class NewPrincipalVisual extends JFrame {

	private JPanel contentPane;
	private JPanel panel_clinetes2;
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane2;
	private JLayeredPane layeredPane3;
	private JPanel panel_Empledos2;
    private JPanel panel_Servicios2;
    private JLabel lblClientes;
    private JLabel lblEmplados1;
    private JLabel lblServicios;
    private JLabel lblFacturas;
    private JLabel lblContratos;
    private JLabel lblNewLabel_planes;
    private JPanel panel_Facturas;
    private JPanel panel_Contratos;
    private JPanel panel_Planes;
    private JPanel panel_inicio;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream altice;
				FileOutputStream altice2;
				ObjectInputStream alticeRead;
				ObjectOutputStream alticeWrite;
				try {
					altice = new FileInputStream ("altice.dat");
					alticeRead = new ObjectInputStream(altice);
					Empresa temp = (Empresa)alticeRead.readObject();
					Empresa.setEmp(temp);
				} catch (FileNotFoundException e) {
					try {
						altice2 = new  FileOutputStream("altice.dat");
						alticeWrite = new ObjectOutputStream(altice2);
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				NewPrincipalVisual frame = new NewPrincipalVisual();
				frame.setVisible(true);
				
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public void switching(JPanel panel) {
		layeredPane2.removeAll();
		layeredPane2.add(panel);
		layeredPane2.repaint();
		layeredPane2.revalidate();
		
	}
	public void switching2(JPanel panel) {
		layeredPane3.removeAll();
		layeredPane3.add(panel);
		layeredPane3.repaint();
		layeredPane3.revalidate();
		
	}
	public NewPrincipalVisual() {
		setBackground(new Color(51, 153, 102));
		setTitle("Altice Dominicana");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewPrincipalVisual.class.getResource("/imagenes/altice.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 122, 220, 348);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching(panel_inicio);
				lblClientes.setEnabled(true);
				lblServicios.setEnabled(true);
				lblEmplados1.setEnabled(true);
				lblNewLabel_planes.setEnabled(true);
				lblContratos.setEnabled(true);
				lblFacturas.setEnabled(true);
				
			}
		});
		panel.setBounds(0, 0, 219, 67);
		layeredPane.add(panel);
		panel.setBackground(Color.GRAY);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBienvenido = new JLabel("Inicio");
		lblBienvenido.setSize(219, 55);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBienvenido, BorderLayout.CENTER);
		
		JPanel panel_Clientes1 = new JPanel();
		panel_Clientes1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblClientes.setEnabled(false);
				lblServicios.setEnabled(true);
				lblEmplados1.setEnabled(true);
				switching(panel_clinetes2);
			}
		});
		panel_Clientes1.setBackground(Color.GRAY);
		panel_Clientes1.setBounds(0, 67, 219, 67);
		layeredPane.add(panel_Clientes1);
		panel_Clientes1.setLayout(new BorderLayout(0, 0));
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_Clientes1.add(lblClientes);
		
		JPanel panel_Empleados1 = new JPanel();
		panel_Empleados1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching(panel_Empledos2);
				lblEmplados1.setEnabled(false);
				lblClientes.setEnabled(true);
				lblServicios.setEnabled(true);
			}
		});
		panel_Empleados1.setBackground(new Color(128, 128, 128));
		panel_Empleados1.setBounds(0, 134, 219, 67);
		layeredPane.add(panel_Empleados1);
		panel_Empleados1.setLayout(new BorderLayout(0, 0));
		
		lblEmplados1 = new JLabel("Empleados");
		lblEmplados1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmplados1.setForeground(Color.WHITE);
		lblEmplados1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_Empleados1.add(lblEmplados1, BorderLayout.CENTER);
		
		JPanel panel_servicios1 = new JPanel();
		panel_servicios1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching(panel_Servicios2);
				lblServicios.setEnabled(false);
				lblEmplados1.setEnabled(true);
				lblClientes.setEnabled(true);
			}
		});
		panel_servicios1.setBackground(Color.GRAY);
		panel_servicios1.setBounds(0, 201, 219, 67);
		layeredPane.add(panel_servicios1);
		panel_servicios1.setLayout(new BorderLayout(0, 0));
		
		lblServicios = new JLabel("Servicios");
		lblServicios.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicios.setForeground(Color.WHITE);
		lblServicios.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_servicios1.add(lblServicios, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(0, 268, 219, 80);
		layeredPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Copyright \u00A9 2017 Altice ");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1, BorderLayout.CENTER);
		
		layeredPane2 = new JLayeredPane();
		layeredPane2.setBounds(219, 122, 638, 348);
		contentPane.add(layeredPane2);
		layeredPane2.setLayout(new CardLayout(0, 0));
		
		panel_inicio = new JPanel();
		panel_inicio.setBackground(SystemColor.control);
		layeredPane2.add(panel_inicio, "name_1125477512227400");
		panel_inicio.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 638, 348);
		lblNewLabel_5.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/lane.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_inicio.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Bienvenido a la interfaz de altice");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(205, 39, 222, 16);
		panel_inicio.add(lblNewLabel_6);
		
		panel_clinetes2 = new JPanel();
		panel_clinetes2.setLocation(216, 0);
		panel_clinetes2.setBackground(SystemColor.control);
		layeredPane2.add(panel_clinetes2, "name_1116814916059145");
		panel_clinetes2.setLayout(null);
		
		JPanel panel_cli2 = new JPanel();
		panel_cli2.setBackground(Color.GRAY);
		panel_cli2.setBounds(0, 0, 638, 67);
		panel_clinetes2.add(panel_cli2);
		panel_cli2.setLayout(null);
		
		JLabel lblClientes2 = new JLabel("Clientes");
		lblClientes2.setBounds(6, 20, 108, 26);
		lblClientes2.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes2.setForeground(Color.WHITE);
		lblClientes2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_cli2.add(lblClientes2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_4.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/cli.jpg")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(83, 103, 194, 183);
		panel_clinetes2.add(lblNewLabel_4);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaClientes listaClientes = new ListaClientes();
				listaClientes.setModal(true);
				listaClientes.setLocationRelativeTo(null);
				listaClientes.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/Lista.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(360, 103, 194, 183);
		panel_clinetes2.add(label);
		
		JLabel lblRegistrarClientes = new JLabel("Registrar Clientes");
		lblRegistrarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarClientes.setBounds(125, 298, 110, 16);
		panel_clinetes2.add(lblRegistrarClientes);
		
		JLabel lblListaDeClientes = new JLabel("Lista de Clientes");
		lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeClientes.setBounds(402, 298, 110, 16);
		panel_clinetes2.add(lblListaDeClientes);
		
		panel_Empledos2 = new JPanel();
		panel_Empledos2.setBackground(SystemColor.control);
		panel_Empledos2.setLayout(null);
		layeredPane2.add(panel_Empledos2, "name_1116814953932239");
		
		JPanel panel_Ep2 = new JPanel();
		panel_Ep2.setLayout(null);
		panel_Ep2.setBackground(Color.GRAY);
		panel_Ep2.setBounds(0, 0, 638, 67);
		panel_Empledos2.add(panel_Ep2);
		
		JLabel lblEmpleados_1 = new JLabel("Empleados");
		lblEmpleados_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados_1.setForeground(Color.WHITE);
		lblEmpleados_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEmpleados_1.setBounds(6, 20, 118, 26);
		panel_Ep2.add(lblEmpleados_1);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				RegistrarPersonal regp = new RegistrarPersonal(null);
				regp.setModal(true);
				regp.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/per.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(83, 108, 194, 183);
		panel_Empledos2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaEmpleados listaEmpleados = new ListaEmpleados();
				listaEmpleados.setModal(true);
				listaEmpleados.setLocationRelativeTo(null);
				listaEmpleados.setVisible(true);
			}
		});
		label_2.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/Lista.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(360, 108, 194, 183);
		panel_Empledos2.add(label_2);
		
		JLabel lblRegistrarEmpleados = new JLabel("Registrar Empleados");
		lblRegistrarEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarEmpleados.setBounds(113, 303, 135, 16);
		panel_Empledos2.add(lblRegistrarEmpleados);
		
		JLabel lblListaDeEmpleados = new JLabel("Lista de Empleados");
		lblListaDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeEmpleados.setBounds(381, 303, 152, 16);
		panel_Empledos2.add(lblListaDeEmpleados);
		
		panel_Servicios2 = new JPanel();
		panel_Servicios2.setBackground(SystemColor.control);
		panel_Servicios2.setLayout(null);
		layeredPane2.add(panel_Servicios2, "name_1116814992051661");
		
		JPanel panel_sv2 = new JPanel();
		panel_sv2.setLayout(null);
		panel_sv2.setBackground(Color.GRAY);
		panel_sv2.setBounds(0, 0, 638, 67);
		panel_Servicios2.add(panel_sv2);
		
		lblNewLabel_planes = new JLabel("Planes");
		lblNewLabel_planes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching2(panel_Planes);
				lblNewLabel_planes.setEnabled(false);
				lblContratos.setEnabled(true);
				lblFacturas.setEnabled(true);
			}
		});
		lblNewLabel_planes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_planes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_planes.setForeground(Color.WHITE);
		lblNewLabel_planes.setBounds(148, 0, 76, 67);
		panel_sv2.add(lblNewLabel_planes);
		
		JLabel label_7 = new JLabel("Servicios:");
		label_7.setBounds(0, 0, 120, 67);
		panel_sv2.add(label_7);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label_7.setBackground(Color.GRAY);
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching2(panel_Facturas);
				lblNewLabel_planes.setEnabled(true);
				lblContratos.setEnabled(true);
				lblFacturas.setEnabled(false);
			}
		});
		lblFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturas.setForeground(Color.WHITE);
		lblFacturas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblFacturas.setBounds(264, 0, 76, 67);
		panel_sv2.add(lblFacturas);
		
		lblContratos = new JLabel("Contratos");
		lblContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switching2(panel_Contratos);
				lblNewLabel_planes.setEnabled(true);
				lblContratos.setEnabled(false);
				lblFacturas.setEnabled(true);
			}
		});
		lblContratos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContratos.setForeground(Color.WHITE);
		lblContratos.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblContratos.setBounds(378, 0, 76, 67);
		panel_sv2.add(lblContratos);
		
		layeredPane3 = new JLayeredPane();
		layeredPane3.setBounds(0, 67, 638, 281);
		panel_Servicios2.add(layeredPane3);
		layeredPane3.setLayout(new CardLayout(0, 0));
		
		panel_Facturas = new JPanel();
		panel_Facturas.setBackground(SystemColor.control);
		layeredPane3.add(panel_Facturas, "name_1121464758172479");
		panel_Facturas.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GeneradorDeFacturas generar = new GeneradorDeFacturas();
				generar.setModal(true);
				generar.setVisible(true);
			}
		});
		label_4.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/do.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(345, 6, 239, 231);
		panel_Facturas.add(label_4);
		
		JLabel lblFacturar = new JLabel("Facturar");
		lblFacturar.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturar.setBounds(105, 248, 135, 16);
		panel_Facturas.add(lblFacturar);
		
		JLabel lblGenerarFactura = new JLabel("Generar factura");
		lblGenerarFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarFactura.setBounds(388, 248, 152, 16);
		panel_Facturas.add(lblGenerarFactura);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Facturar fact = new Facturar();
				fact.setModal(true);
				fact.setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/fact.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(53, 6, 239, 231);
		panel_Facturas.add(label_3);
		
		panel_Planes = new JPanel();
		panel_Planes.setBackground(SystemColor.control);
		layeredPane3.add(panel_Planes, "name_1122357687768856");
		panel_Planes.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Plan pla = null;
				CrearPlan crr = new CrearPlan(pla);
				crr.setModal(true);
				crr.setLocationRelativeTo(null);
				crr.setVisible(true);
			}
		});
		label_5.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/carrito.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(88, 47, 239, 184);
		panel_Planes.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaPlan crr = new ListaPlan();
				crr.setModal(true);
				crr.setLocationRelativeTo(null);
				crr.setVisible(true);
			}
		});
		label_6.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/Lista.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(360, 17, 239, 231);
		panel_Planes.add(label_6);
		
		JLabel lblPlanes = new JLabel("Planes");
		lblPlanes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanes.setBounds(134, 259, 135, 16);
		panel_Planes.add(lblPlanes);
		
		JLabel lblListaDeFacturas = new JLabel("Lista de planes");
		lblListaDeFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFacturas.setBounds(417, 259, 152, 16);
		panel_Planes.add(lblListaDeFacturas);
		
		panel_Contratos = new JPanel();
		panel_Contratos.setBackground(SystemColor.control);
		layeredPane3.add(panel_Contratos, "name_1121564173690969");
		panel_Contratos.setLayout(null);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentaPlan vplan = new VentaPlan();
				vplan.setModal(true);
				vplan.setVisible(true);
			}
		});
		label_8.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/cn.png")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(53, 6, 239, 231);
		panel_Contratos.add(label_8);
		
		JLabel lblRealizarContrato = new JLabel("Realizar contrato");
		lblRealizarContrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarContrato.setBounds(96, 249, 152, 16);
		panel_Contratos.add(lblRealizarContrato);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(76, -1, 108, 122);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(NewPrincipalVisual.class.getResource("/imagenes/altice.png")));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new CompoundBorder());
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, -1, 857, 123);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Together has no limits");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(278, 36, 419, 35);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Juntos, sin limites.");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(403, 83, 168, 16);
		panel_6.add(lblNewLabel_3);
	}
}
