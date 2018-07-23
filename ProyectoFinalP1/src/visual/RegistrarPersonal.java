package visual;



	import java.awt.BorderLayout;
	import java.awt.FlowLayout;

	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.Comercial;
import logico.Empresa;
import logico.Personal;

import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.UIManager;

	import java.awt.Color;

	import javax.swing.JRadioButton;

	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	
	import javax.swing.JSpinner;
	import javax.swing.SpinnerNumberModel;
	import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

	public class RegistrarPersonal extends JDialog {

		/**
		 * 
		 */
	
		private final JPanel contentPanel = new JPanel();
		private JTextField textNombre;
		JRadioButton rdbtnAdm;
		JRadioButton rdbtnCom;
		JPanel panel_2;
		JPanel panel_3;
		
		private JLabel lblCargo;
		private JLabel lblCodigo;
		private JTextField textcode;
		private Personal aux1=null;
		private String code;
		private JTextField textuser;
		private JLabel lblSueldoBase;
		private JTextField textsueldo;
		private JTextField texthext;
		private JLabel lblPagoPorHoras;
		private JPasswordField passwordField;
		private JComboBox comboBoxCargo;

		
		public RegistrarPersonal( Personal aux) {
			aux1=aux;
			
			if(aux== null){
				setTitle("Registro de Empleados");
			}
			
			setBounds(100, 100, 501, 500);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos Del Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(10, 21, 466, 252);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblRadio = new JLabel("Nombre:");
			lblRadio.setBounds(10, 67, 97, 14);
			panel.add(lblRadio);
			
			textNombre = new JTextField();
			textNombre.setBounds(10, 92, 209, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 11, 46, 14);
			panel.add(lblCodigo);
			
			textcode = new JTextField();
			textcode.setEditable(false);
			textcode.setBounds(10, 36, 209, 20);
			textcode.setText(""+String.valueOf(Empresa.getInstance().getMistrabajadores().size()+1));
			panel.add(textcode);
			textcode.setColumns(10);
			
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(10, 123, 83, 14);
			panel.add(lblUsuario);
			
			textuser = new JTextField();
			textuser.setBounds(10, 148, 209, 20);
			panel.add(textuser);
			textuser.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setBounds(256, 123, 125, 14);
			panel.add(lblContrasea);
			
			lblSueldoBase = new JLabel("Sueldo Base:");
			lblSueldoBase.setBounds(10, 189, 133, 14);
			panel.add(lblSueldoBase);
			
			textsueldo = new JTextField();
			textsueldo.setBounds(10, 215, 209, 20);
			panel.add(textsueldo);
			textsueldo.setColumns(10);
			
			texthext = new JTextField();
			texthext.setBounds(256, 215, 197, 20);
			panel.add(texthext);
			texthext.setColumns(10);
			
			lblPagoPorHoras = new JLabel("Pago por horas extras:");
			lblPagoPorHoras.setBounds(256, 189, 159, 14);
			panel.add(lblPagoPorHoras);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(256, 148, 198, 20);
			panel.add(passwordField);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 288, 466, 55);
			contentPanel.add(panel_1);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo De Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setLayout(null);
			
			rdbtnAdm = new JRadioButton("Administrativo");
			rdbtnAdm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnAdm.setSelected(true);
					rdbtnCom.setSelected(false);
					panel_2.setVisible(true);
					panel_3.setVisible(false);
				}
			});
			rdbtnAdm.setSelected(true);
			rdbtnAdm.setBounds(21, 25, 109, 23);
			panel_1.add(rdbtnAdm);
			
			rdbtnCom = new JRadioButton("Comercial");
			rdbtnCom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnAdm.setSelected(false);
					rdbtnCom.setSelected(true);
					panel_2.setVisible(false);
					panel_3.setVisible(true);
				}
			});
			rdbtnCom.setBounds(151, 25, 128, 23);
			panel_1.add(rdbtnCom);
			
			panel_2 = new JPanel();
			panel_2.setBounds(10, 354, 466, 55);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			
			comboBoxCargo = new JComboBox();
			comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Secretaria ", "Recursos Humanos", "Auditor ", "Director Ejecutivo"}));
			comboBoxCargo.setBounds(50, 24, 186, 20);
			panel_2.add(comboBoxCargo);
			
			lblCargo = new JLabel("Cargo:");
			lblCargo.setBounds(10, 27, 40, 14);
			panel_2.add(lblCargo);
			
			panel_3 = new JPanel();
			panel_3.setBounds(0, 0, 466, 55);
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("Registrar");
					
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(aux==null){
							if(!textNombre.getText().equalsIgnoreCase("")&& !textsueldo.getText().equalsIgnoreCase("")){
							
							float pagoHoraExt = new Integer(texthext.getText());
							float sueldobase = new Integer(texthext.getText());
							String codigo= textcode.getText();
							String nombre= textNombre.getText();
							String usuario= textuser.getText();
							char[] contrasena= passwordField.getPassword();
							
							
							if(rdbtnAdm.isSelected()){
								String cargo = comboBoxCargo.getSelectedItem().toString();
								aux1 = new Administrador(codigo,nombre,sueldobase, usuario, contrasena, pagoHoraExt, cargo );
								
							}
							if(rdbtnCom.isSelected()){
								
					
								aux1 = new Comercial( codigo,nombre,sueldobase, usuario, contrasena, pagoHoraExt);
								
							}
							
							Empresa.getInstance().insertpersonal(aux1);
							JOptionPane.showMessageDialog(null, "Empleado registrado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						
							//System.out.println(empresa.getInstance().getMisquesos().size());	
							clear();
							}else{
								JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
							}}
						}
			
					});
					
					
			
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancel");
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
			
			private void clear() {
			
				textNombre.setText("");
				comboBoxCargo.setSelectedIndex(0);
				texthext.setText("");
				passwordField.setText("");
				textsueldo.setText("");
				textuser.setText("");
				
				textcode.setText(""+String.valueOf(Empresa.getInstance().getMistrabajadores().size()+1));
				
			}
	}