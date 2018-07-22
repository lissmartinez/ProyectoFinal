package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import logico.Cliente;
import logico.Empresa;
import logico.Factura;
import logico.Plan;
import logico.Venta;

public class VentaPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private String code = "";
	private JTextField txtcodecliente;
	private JTextField txtnombre;
	private JTextField txttelefono;
	private JTextField txtdireccion;
	private JTextField txtcedula;
	private JList jlistcarrito;
	private JList jlistdisponible;
	private ArrayList<String> listaDisponible;
	private ArrayList<String> listaCarrito;
	private DefaultListModel<String> planDisponible;
	private DefaultListModel<String> planContratar;
	private JButton btnSelect;
	private JButton btnUnselect;
	private JButton btnBuscar;
	private JTextField txttotal;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			VentaPlan dialog = new VentaPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public VentaPlan() {
		listaDisponible = new ArrayList<>();
		listaCarrito = new ArrayList<>();
		setTitle("Contrato");
		setBounds(100, 100, 586, 545);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			planDisponible = new DefaultListModel<String>();
			planContratar = new DefaultListModel<String>();
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(10, 11, 67, 14);
				panel.add(lblCodigo);
			}
			{
				txtcodigo = new JTextField();
				txtcodigo.setEditable(false);
				txtcodigo.setBounds(10, 30, 86, 20);
				panel.add(txtcodigo);
				txtcodigo.setColumns(10);
				txtcodigo.setText(date()+"-"+(Empresa.getInstance().getMisventas().size()+1));
			}
			
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Informacion del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 68, 519, 148);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblCodigoDelCliente = new JLabel("Cedula del Cliente:");
					lblCodigoDelCliente.setBounds(10, 31, 105, 14);
					panel_1.add(lblCodigoDelCliente);
				}
				{
					txtcodecliente = new JTextField();
					txtcodecliente.setBounds(10, 50, 118, 20);
					panel_1.add(txtcodecliente);
					txtcodecliente.setColumns(10);
				}
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnBuscar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Cliente aux = null;
						if(!txtcodecliente.getText().equalsIgnoreCase("")){
							aux= Empresa.getInstance().findclientbycedula(txtcodecliente.getText());
							if(aux == null){
								int delete = JOptionPane.showConfirmDialog(null, "Cliente no registrado \n Desea registrarlo? " , null, JOptionPane.YES_NO_OPTION);
							    if (delete == JOptionPane.YES_OPTION)
							    {
									txtcodecliente.setText("");
									RegistroClientes regC = new RegistroClientes( aux);
									regC.setModal(true);
									regC.setLocationRelativeTo(null);
									regC.setVisible(true);
							    }	
							}else{
							
							txtnombre.setText(aux.getNombre());
							txttelefono.setText(aux.getTelefono());
							}
					}else{
						JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
					}
					}
				});
				btnBuscar.setBounds(154, 49, 86, 23);
				panel_1.add(btnBuscar);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 89, 55, 14);
				panel_1.add(lblNombre);
				
				txtnombre = new JTextField();
				txtnombre.setBounds(10, 109, 206, 20);
				panel_1.add(txtnombre);
				txtnombre.setColumns(10);
				
				JLabel lblTelefono = new JLabel("Telefono");
				lblTelefono.setBounds(288, 89, 86, 14);
				panel_1.add(lblTelefono);
				
				txttelefono = new JTextField();
				txttelefono.setBounds(288, 109, 206, 20);
				panel_1.add(txttelefono);
				txttelefono.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 227, 200, 156);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			jlistdisponible = new JList();
			jlistdisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					code = (String)jlistdisponible.getModel().getElementAt(jlistdisponible.getSelectedIndex());
					if(!code.equalsIgnoreCase("")){
						btnSelect.setEnabled(true);
					}
				}
			});
			jlistdisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlistdisponible.setModel(planDisponible);
			scrollPane.setColumnHeaderView(jlistdisponible);
			
			btnSelect = new JButton("Select");
			btnSelect.setEnabled(false);
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listaCarrito.add(code);
					loadListadeCompra();
					listaDisponible.remove(code);
					loadListaDisponible();
					btnSelect.setEnabled(false);
				}


			});
			btnSelect.setBounds(220, 264, 86, 23);
			panel.add(btnSelect);
			
			btnUnselect = new JButton("Unselect");
			btnUnselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listaCarrito.remove(code);
					loadListadeCompra();
					btnUnselect.setEnabled(false);
				}

			
			});
			btnUnselect.setEnabled(false);
			btnUnselect.setBounds(220, 306, 86, 23);
			panel.add(btnUnselect);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Carrito", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(329, 227, 200, 156);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			jlistcarrito = new JList();
			jlistcarrito.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					code = (String)jlistcarrito.getModel().getElementAt(jlistcarrito.getSelectedIndex());
					if(!code.equalsIgnoreCase("")){
						btnUnselect.setEnabled(true);
					}
				}
			});
			jlistcarrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlistcarrito.setModel(planContratar);
			scrollPane_1.setViewportView(jlistcarrito);
			
			JLabel lblNewLabel = new JLabel("Total");
			lblNewLabel.setBounds(329, 394, 46, 14);
			panel.add(lblNewLabel);
			
			txttotal = new JTextField();
			txttotal.setEditable(false);
			txttotal.setBounds(329, 413, 86, 20);
			panel.add(txttotal);
			txttotal.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Plan> misplanes = new ArrayList<>();
						ArrayList<Factura> misfacturas = new ArrayList<>();
						Cliente miCliente = null;
						float precio = 0;
				        for (String codigos : listaCarrito) {
							String planId = codigos.substring(0, codigos.indexOf('-'));
							Plan plan = Empresa.getInstance().findplanbycode(planId);
							if(plan != null){
								precio+=(plan.getPrecio()*1.18);
								misplanes.add(plan);
							}
						}
				        
					   /* if(Empresa.getInstance().findclientbycedula(txtcodecliente.getText() !=null)){
					      miCliente = Empresa.getInstance().findclientbycedula(txtcodecliente.getText()); 	
					    }else{
						  miCliente = new Cliente(txtcodecliente.getText(), txtnombre.getText(), txttelefono.getText(),misplanes,misfacturas, txtcedula.getText(),txtdireccion.getText());
					    }*/
						Venta vent = new Venta(txtcodigo.getText(), miCliente, misplanes, precio, null);
						txttotal.setText("$"+Float.toString(vent.Pago()));
						 int option =JOptionPane.showConfirmDialog(null, "El monto total a pagar es de:$"+vent.Pago(),"Información",JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION){
				            JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								Empresa.getInstance().getMisventas().add(vent);
							}
						
						//System.out.println(Empresa.getInstance().getMisventas().size());
						clean();
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadPlanesToSale();
		loadListaDisponible();
	}
	
	public String date(){
		Date fecha = new Date();
		SimpleDateFormat formatfecha =new SimpleDateFormat("YYYYMMDD");
		return formatfecha.format(fecha);
	}
	
	private void loadPlanesToSale() {
		for (Plan aux : Empresa.getInstance().getPlanes()){
			listaDisponible.add(aux.getCodigo()+"-"+aux.getNombre()+"-$"+aux.getPrecio());

		}
		
	}
	

	private void loadListadeCompra() {
		jlistcarrito.removeAll();
		planContratar.removeAllElements();
		for (String nombre : listaCarrito) {
			planContratar.addElement(nombre);
		}
		jlistcarrito.setModel(planContratar);
		
	}

	private void loadListaDisponible() {
		jlistdisponible.removeAll();
		planDisponible.removeAllElements();
		for (String nombre : listaDisponible) {
			planDisponible.addElement(nombre);
		}
		jlistdisponible.setModel(planDisponible);
		
		
	}
	public void clean() {
		txtcodecliente.setText("");
		txtnombre.setText("");
		txttelefono.setText("");
		planDisponible.removeAllElements();
        planContratar.removeAllElements();
	}
}
