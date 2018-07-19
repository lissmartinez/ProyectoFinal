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
import logico.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFormattedTextField formattedTextField;
	private static logico.Cliente cliente;
	private JTextField textFieldnumber;

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
	public RegistroClientes(final int code, Cliente cli) throws ParseException {
		cliente = cli;
		setTitle("Registro de clientes");
		setBounds(100, 100, 259, 261);
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
			txtCodigo.setBounds(10, 39, 86, 20);
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
			lblTelefono.setBounds(10, 116, 86, 14);
			panel.add(lblTelefono);
			
			textFieldnumber = new JTextField();
			textFieldnumber.setBounds(10, 141, 179, 20);
			panel.add(textFieldnumber);
			textFieldnumber.setColumns(10);
			MaskFormatter a = new MaskFormatter("(###)-###-####");
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNombre.getText().equalsIgnoreCase("")) {
							String nombre = txtNombre.getText();
							String telefono =  textFieldnumber.getText();
							String codigo = txtCodigo.getText();
						//boolean estado = (Boolean) null;
						//float cuantaxpagar = (Float) null;
							ArrayList<Plan> misplanes = Empresa.getInstance().getPlanes();
							
							Cliente aux = new Cliente(nombre, telefono, codigo, misplanes);
							Empresa.getInstance().insertCliente(cli);
							JOptionPane.showMessageDialog(null, "Operaci�n satisfactoria", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							clean();
							}else {JOptionPane.showMessageDialog(null, "No se puede registrar el cliente, llene los datos faltantes", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);}
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
	private void clean() {
		txtCodigo.setText("");
		txtNombre.setText("");
		textFieldnumber.setText("");
		
	}
}