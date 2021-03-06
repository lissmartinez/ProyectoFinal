package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;


import logico.Cliente;
import logico.Empresa;
import logico.Factura;
import logico.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegistroClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFormattedTextField formattedTextField;
	private static Cliente cliente;
	private JTextField textFieldnumber;
	private JTextField textFieldCedula;
	private JTextField textFieldDireccion;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			RegistroClientes dialog = new RegistroClientes(cliente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public RegistroClientes(Cliente cli) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroClientes.class.getResource("/imagenes/altice.png")));
		setTitle("Registro de Clientes");
		cliente = cli;
		if(cliente== null){
			setTitle("Registro de Clientes");
		}else{
			setTitle("Modificar Clientes");
		}
	
		setBounds(100, 100, 474, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 21, 79, 14);
			panel.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(10, 39, 179, 20);
			txtCodigo.setText(""+String.valueOf(Empresa.getInstance().getClientes().size()+1));
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 70, 79, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 88, 179, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 119, 86, 14);
			panel.add(lblTelefono);
			
			textFieldnumber = new JTextField();
			textFieldnumber.setBounds(10, 144, 179, 20);
			panel.add(textFieldnumber);
			textFieldnumber.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(248, 70, 111, 14);
			panel.add(lblCedula);
			
			textFieldCedula = new JTextField();
			textFieldCedula.setBounds(248, 88, 187, 20);
			panel.add(textFieldCedula);
			textFieldCedula.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(248, 119, 98, 14);
			panel.add(lblDireccion);
			
			textFieldDireccion = new JTextField();
			textFieldDireccion.setBounds(248, 144, 187, 20);
			panel.add(textFieldDireccion);
			textFieldDireccion.setColumns(10);
			//MaskFormatter a = new MaskFormatter("(###)-###-####");
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				if(cliente == null){
				  okButton.setText("Registrar");
				}else{
					okButton.setText("Modificar");
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cliente==null){
						if(!txtNombre.getText().equalsIgnoreCase("")) {
							String codigo = txtCodigo.getText();
							String nombre = txtNombre.getText();
							String telefono =  textFieldnumber.getText();
							String cedula= textFieldCedula.getText();
							String direccion= textFieldDireccion.getText();
							
							
							
						//boolean estado = (Boolean) null;
						//float cuantaxpagar = (Float) null;
							
							
							Cliente cli = new Cliente(codigo,nombre, telefono,cedula, direccion);
							Empresa.getInstance().insertCliente(cli);
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
							}else {JOptionPane.showMessageDialog(null, "No se puede registrar el cliente, llene los datos faltantes", "Información", JOptionPane.INFORMATION_MESSAGE);}
					}else{
						cliente.setCodigo(txtCodigo.getText());
						cliente.setNombre(txtNombre.getText());
						cliente.setTelefono(textFieldnumber.getText());
						cliente.setCedula(textFieldCedula.getText());
						cliente.setDireccion(textFieldDireccion.getText());
					
						Empresa.getInstance().updateclient(cliente);
						JOptionPane.showMessageDialog(null, "Cliente modificado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
                        ListaClientes.loadTable();
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
		loadcliente(cli);
	}
	private void loadcliente(Cliente  client) {
		if(client!=null){
			txtNombre.setText(client.getNombre());
			txtCodigo.setText(client.getCodigo());
			textFieldCedula.setText(client.getCedula());
			textFieldDireccion.setText(client.getDireccion());
			textFieldnumber.setText(client.getTelefono());
			
		}
		}
	private void clean() {
		txtCodigo.setText(""+String.valueOf(Empresa.getInstance().getClientes().size()+1));
		txtNombre.setText("");
		textFieldnumber.setText("");
		textFieldCedula.setText("");
		textFieldDireccion.setText("");
		textFieldnumber.setText("");
		
	}
}
