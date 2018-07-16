package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Plan;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodigo;
	private JTextField textField;
	private JTextField textField_1;
	private static logico.Plan plan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearPlan dialog = new CrearPlan(plan);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPlan(Plan pla) {
		plan = pla;
		setTitle("Registro de planes");
		setBounds(100, 100, 401, 329);
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
				textFieldCodigo = new JTextField();
				textFieldCodigo.setBounds(10, 39, 86, 20);
				panel.add(textFieldCodigo);
				textFieldCodigo.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("Nombre del plan:");
				lblNewLabel.setBounds(123, 22, 107, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(123, 39, 170, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 83, 119, 105);
				panel.add(panel_1);
				
				JCheckBox chckbxInternet = new JCheckBox("Internet");
				chckbxInternet.setBounds(6, 19, 97, 23);
				panel_1.add(chckbxInternet);
				
				JCheckBox chckbxMinutos = new JCheckBox("Minutos");
				chckbxMinutos.setBounds(6, 45, 97, 23);
				panel_1.add(chckbxMinutos);
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("TV");
				chckbxNewCheckBox.setBounds(6, 71, 97, 23);
				panel_1.add(chckbxNewCheckBox);
			}
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(139, 83, 224, 102);
			panel.add(panel_2);
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			JLabel lblPrecioTotal = new JLabel("Precio Total:");
			lblPrecioTotal.setBounds(262, 190, 101, 14);
			panel.add(lblPrecioTotal);
			
			textField_1 = new JTextField();
			textField_1.setBounds(261, 205, 102, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
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
}
