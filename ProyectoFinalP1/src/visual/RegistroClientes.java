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
import logico.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField formattedTextField;
	private static logico.Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroClientes dialog = new RegistroClientes(cliente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public RegistroClientes(Cliente cli) throws ParseException {
		cliente = cli;
		setTitle("Registro de clientes");
		setBounds(100, 100, 237, 249);
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
			
			textField = new JTextField();
			textField.setBounds(10, 39, 86, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 70, 79, 14);
			panel.add(lblNombre);
			
			textField_1 = new JTextField();
			textField_1.setBounds(10, 88, 179, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 116, 86, 14);
			panel.add(lblTelefono);
			
			MaskFormatter a = new MaskFormatter("(###)-###-####");
			JFormattedTextField formattedTextField = new JFormattedTextField(a);
			formattedTextField.setBounds(10, 134, 86, 20);
			panel.add(formattedTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textField_1.getText().equalsIgnoreCase("")) {
							String nombre = textField_1.getText();
							String codigo = textField.getText();
							boolean estado = (Boolean) null;
							float cuantaxpagar = (Float) null;
							ArrayList<Plan> misplanes = null;
							String telefono = formattedTextField.getText();
							logico.Cliente aux = new logico.Cliente(nombre, telefono, codigo, estado, cuantaxpagar, misplanes);
							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							logico.Empresa.getInstance().getClientes().add(aux);
							clean();
							}else {JOptionPane.showMessageDialog(null, "No se puede registrar el cliente, llene los datos faltantes", "Información", JOptionPane.INFORMATION_MESSAGE);}
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
		textField.setText("");
		textField_1.setText("");
		
	}
}
