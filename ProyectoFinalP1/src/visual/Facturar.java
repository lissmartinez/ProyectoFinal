package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Empresa;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcedulacli;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturar dialog = new Facturar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar() {
		setBounds(100, 100, 406, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCedulaDelCliente = new JLabel("Cedula del cliente:");
				lblCedulaDelCliente.setBounds(10, 28, 129, 14);
				panel.add(lblCedulaDelCliente);
			}
			{
				txtcedulacli = new JTextField();
				txtcedulacli.setBounds(10, 47, 97, 20);
				panel.add(txtcedulacli);
				txtcedulacli.setColumns(10);
			}
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Cliente aux = null;
					if(!txtcedulacli.getText().equalsIgnoreCase("")){
						aux= Empresa.getInstance().findclientbycedula(txtcedulacli.getText());
						//table.
					}else{
						JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
					}
				}
			});
			btnBuscar.setBounds(129, 46, 89, 23);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Facturas pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 109, 346, 121);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			table = new JTable();
			panel_1.add(table, BorderLayout.CENTER);
			
			JButton btnPagar = new JButton("Pagar");
			btnPagar.setBounds(267, 241, 89, 23);
			panel.add(btnPagar);
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
}
