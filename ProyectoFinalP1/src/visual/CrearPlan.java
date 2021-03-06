package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Empresa;
import logico.Personal;
import logico.Plan;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class CrearPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private static Plan plan;
	JRadioButton rdbtnInternet;
	JRadioButton rdbtnTelefono;
	JRadioButton rdbtnCable;
	private JTextField txtcanales;
	private JTextField txtminutos;
	private JTextField txtinternet;

	/**
	 * Launch the application.
	 */
	/*

	/**
	 * Create the dialog.
	 */
	public CrearPlan(Plan pla) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPlan.class.getResource("/imagenes/altice.png")));
		setTitle("Registro de Planes");
		plan = pla;
			
		setBounds(100, 100, 423, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de planes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(10, 22, 76, 14);
				panel.add(lblCodigo);
			}
			{
				txtcodigo = new JTextField();
				txtcodigo.setEditable(false);
				txtcodigo.setBounds(10, 39, 86, 20);
				panel.add(txtcodigo);
				txtcodigo.setColumns(10);
				txtcodigo.setText(""+String.valueOf(Empresa.getInstance().getPlanes().size()+1));
			}
			{
				JLabel lblNewLabel = new JLabel("Nombre del plan:");
				lblNewLabel.setBounds(10, 76, 107, 14);
				panel.add(lblNewLabel);
			}
			{
				txtnombre = new JTextField();
				txtnombre.setBounds(10, 93, 170, 20);
				panel.add(txtnombre);
				txtnombre.setColumns(10);
			}
			{
				JPanel panel_servicios = new JPanel();
				panel_servicios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_servicios.setBounds(10, 135, 352, 84);
				panel.add(panel_servicios);
				panel_servicios.setLayout(null);
				{
				    rdbtnInternet = new JRadioButton("Internet");
				    rdbtnInternet.addActionListener(new ActionListener() {
				    	public void actionPerformed(ActionEvent e) {
				    		txtinternet.setEnabled(true);
				    		
				    	}
				    });
					rdbtnInternet.setBounds(6, 38, 109, 23);
					panel_servicios.add(rdbtnInternet);
				}
				{
					rdbtnTelefono = new JRadioButton("Telefono");
					rdbtnTelefono.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							txtminutos.setEnabled(true);
						}
					});
					rdbtnTelefono.setBounds(117, 38, 109, 23);
					panel_servicios.add(rdbtnTelefono);
				}
				{
					rdbtnCable = new JRadioButton("Cable");
					rdbtnCable.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							txtcanales.setEnabled(true);
						}
					});
					rdbtnCable.setBounds(238, 38, 109, 23);
					panel_servicios.add(rdbtnCable);
				}
			}
			
			JLabel lblPrecioTotal = new JLabel("Precio:");
			lblPrecioTotal.setBounds(11, 346, 101, 14);
			panel.add(lblPrecioTotal);
			
			txtprecio = new JTextField();
			txtprecio.setBounds(10, 361, 102, 20);
			panel.add(txtprecio);
			txtprecio.setColumns(10);
			
			JPanel panel_data = new JPanel();
			panel_data.setLayout(null);
			panel_data.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_data.setBounds(10, 230, 352, 105);
			panel.add(panel_data);
			
			JLabel lblCantidadDeGb_1 = new JLabel("Data (MB):");
			lblCantidadDeGb_1.setBounds(10, 32, 69, 14);
			panel_data.add(lblCantidadDeGb_1);
			
			txtinternet = new JTextField();
			txtinternet.setEnabled(false);
			txtinternet.setColumns(10);
			txtinternet.setBounds(10, 57, 69, 20);
			panel_data.add(txtinternet);
			
			JLabel lblCantidadDeGb = new JLabel("Canales:");
			lblCantidadDeGb.setBounds(245, 32, 69, 14);
			panel_data.add(lblCantidadDeGb);
			
			txtcanales = new JTextField();
			txtcanales.setEnabled(false);
			txtcanales.setBounds(245, 57, 69, 20);
			panel_data.add(txtcanales);
			txtcanales.setColumns(10);
			
			JLabel lblCantidadDeMinutos = new JLabel("Minutos:");
			lblCantidadDeMinutos.setBounds(120, 32, 69, 14);
			panel_data.add(lblCantidadDeMinutos);
			
			txtminutos = new JTextField();
			txtminutos.setEnabled(false);
			txtminutos.setBounds(120, 57, 69, 20);
			panel_data.add(txtminutos);
			txtminutos.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
						if(plan==null){
						Plan aux=null;
						
						String codigo= txtcodigo.getText();
						String nombre= txtnombre.getText();
						int precio = new Integer(txtprecio.getText());
						int cantData = 0;
						int cantMinutos=0;
						int cantCanales=0;
						boolean internet = false;
						boolean cable = false;
						boolean telefono = false;
						
						if(rdbtnInternet.isSelected()){
							
							cantData = new Integer(txtinternet.getText());
							internet = true;
						
						}
						if(rdbtnTelefono.isSelected()){
							cantMinutos= new Integer(txtminutos.getText());
						    telefono = true;
						}
						if(rdbtnCable.isSelected()){
							cantCanales= new Integer(txtcanales.getText());
							cable = true;
							
						}
						aux = new Plan(codigo, nombre, internet, telefono, cable, precio, cantData, cantMinutos, cantCanales);
						Empresa.getInstance().insertPlan(aux);
						JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
						
						}
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	public void clean() {
		txtcodigo.setText(""+(Empresa.getInstance().getPlanes().size()+1));
		txtcanales.setText("");
		txtprecio.setText("");
		txtinternet.setText("");
		txtminutos.setText("");
		txtnombre.setText("");
		rdbtnCable.setSelected(false);
		rdbtnInternet.setSelected(false);
		rdbtnTelefono.setSelected(false);
	}
}
