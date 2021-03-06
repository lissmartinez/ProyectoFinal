package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListaClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JButton btnModificar;
	private JButton btnEliminar;
	private String identificador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaClientes dialog = new ListaClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaClientes() {
		setTitle("Liste de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaClientes.class.getResource("/imagenes/altice.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								int index = table.getSelectedRow();
								identificador = (String)table.getModel().getValueAt(index, 0);				
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Codigo","Cedula","Nombre", "Telefono"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 btnModificar = new JButton("Modificar");
					btnModificar.setEnabled(false);
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!identificador.equalsIgnoreCase("")){
								logico.Cliente aux = logico.Empresa.getInstance().findclientbycode(identificador);
								RegistroClientes regclient = new RegistroClientes(aux);
								regclient.setModal(true);
								regclient.setVisible(true);
						
								 btnEliminar.setEnabled(false);
								 btnModificar.setEnabled(false);
								 loadTable();
						}
					}
				});
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!identificador.equalsIgnoreCase("")){
							logico.Cliente aux = logico.Empresa.getInstance().findclientbycode(identificador);
							//if(Empresa.getInstance().removeClient(identificador)) {
								int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el cliente: " + aux.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							  if(option == JOptionPane.OK_OPTION){
								logico.Empresa.getInstance().getClientes().remove(aux);
							    loadTable();
							    btnEliminar.setEnabled(false);
							    btnModificar.setEnabled(false);
							  }
							//}
							  //else {JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente", "Información", JOptionPane.INFORMATION_MESSAGE);}
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
	public static void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (logico.Cliente aux : logico.Empresa.getInstance().getClientes()) {
			fila[0] = aux.getCodigo();
			fila[1] = aux.getCedula();
			fila[2] = aux.getNombre();
			fila[3] = aux.getTelefono();
			model.addRow(fila);
		}
		
	}

}
