package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Empresa;
import logico.Factura;
import logico.Plan;
import logico.Venta;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcedulacli;
	private JTextField txtBuscar;
	private String code = "";
	private JList jlistdisponible;
	private ArrayList<String> listaDisponible;
	private DefaultListModel<String> planDisponible;
	private JButton btnBuscar;
	private JButton btnPagar;
	private float precio;
	private Factura fact = null;
	private Cliente aux = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/imagenes/altice.png")));
		setTitle("Pago de facturas");
		listaDisponible = new ArrayList<>();
		precio=0;
		setBounds(100, 100, 406, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			planDisponible = new DefaultListModel<String>();
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Facturas pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 125, 346, 121);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			jlistdisponible = new JList();
			jlistdisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					code = (String)jlistdisponible.getModel().getElementAt(jlistdisponible.getSelectedIndex());
					code = code.substring(0, code.lastIndexOf("-"));
					if(!code.equalsIgnoreCase("")){
					
						btnPagar.setEnabled(true);
					}
				}
			});
			jlistdisponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlistdisponible.setModel(planDisponible);
			panel_1.add(jlistdisponible, BorderLayout.CENTER);
			
			btnPagar = new JButton("Pagar");
			btnPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fact = Empresa.getInstance().findfactbycode(code);
					fact.setEstado(true);
					JOptionPane.showMessageDialog(null, "Se ha pagado satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					loadFacturasPendientes(aux);
					loadFacturas();
					btnPagar.setEnabled(false);
				}
			});
			btnPagar.setEnabled(false);
			btnPagar.setBounds(267, 257, 89, 23);
			panel.add(btnPagar);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 22, 346, 92);
			panel.add(panel_2);
			panel_2.setLayout(null);
			{
				JLabel lblCedulaDelCliente = new JLabel("Cedula del cliente:");
				lblCedulaDelCliente.setBounds(10, 26, 129, 14);
				panel_2.add(lblCedulaDelCliente);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.setBounds(10, 45, 97, 20);
				panel_2.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!txtBuscar.getText().equalsIgnoreCase("")){
						aux= Empresa.getInstance().findclientbycedula(txtBuscar.getText());
						if(aux == null){
							JOptionPane.showMessageDialog(null, "Cedula incorrecta, Favor introducirla nuevamente", null, JOptionPane.INFORMATION_MESSAGE, null);
							txtBuscar.setText("");

						}else{
							//for (Venta ventaAux : Empresa.getInstance().getMisventas()) {
						    //	  if(ventaAux.getCli().get){
						    		  loadFacturasPendientes(aux);
										loadFacturas();
						    	 // }
						    	  
							//}
							
						}
				}else{
					JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
				}
				}
			});
			btnBuscar.setBounds(129, 44, 89, 23);
			panel_2.add(btnBuscar);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
	}
	
	private void loadFacturasPendientes(Cliente cliente) {
		listaDisponible.removeAll(listaDisponible);
		for (Factura aux : cliente.getMisfacturas()){
			if(!aux.isEstado()){
			listaDisponible.add(aux.getCodigo()+"-$"+aux.getPrecioTotal());
			}

		}
		/*for (Venta ventaAux : Empresa.getInstance().getMisventas()) {
	    	listaDisponible.add(ventaAuxgetCodigo()+"-----$"+ventaAux.getMontoTotal());
	    		 
	    	  
	    }*/
	}

	private void loadFacturas() {
		jlistdisponible.removeAll();
		planDisponible.removeAllElements();
		for (String nombre : listaDisponible) {
			planDisponible.addElement(nombre);
		}
		jlistdisponible.setModel(planDisponible);
		
	}
}
