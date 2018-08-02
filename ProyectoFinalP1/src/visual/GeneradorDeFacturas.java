package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import logico.Cliente;
import logico.Empresa;
import logico.Factura;
import logico.Venta;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class GeneradorDeFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JProgressBar progressBar; 
	private Timer timer = new Timer(30, createFacturasLoadAction());
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GeneradorDeFacturas dialog = new GeneradorDeFacturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GeneradorDeFacturas() {
		setTitle("Generador de Facturas");
		setBounds(100, 100, 450, 161);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			progressBar = new JProgressBar();
			progressBar.setBounds(10, 24, 414, 20);
			contentPanel.add(progressBar);
		}
		
		textField = new JTextField();
		textField.setBounds(10, 55, 44, 20);
		contentPanel.add(textField);
		textField.setText(String.valueOf(0));
		textField.setColumns(10);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setBounds(60, 58, 46, 14);
		contentPanel.add(lblDe);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		int cant = Empresa.getInstance().getCantClienteActivos();
		textField_1.setText(String.valueOf(cant));
		progressBar.setMaximum(cant);
		//progressBar.setMaximum(50);
		textField_1.setBounds(80, 55, 44, 20);
		
		contentPanel.add(textField_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			   okButton = new JButton("Iniciar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButton.setEnabled(false);
						cancelButton.setEnabled(false);
						if(Empresa.getMesActual().equalsIgnoreCase("") || !Empresa.getMesActual().equalsIgnoreCase(date())){
						for (Venta ventaAux : Empresa.getInstance().getMisventas()) {
					    	  if(ventaAux.getCli().isActivo()){
					    		  Factura fac = new Factura(ventaAux.getCodigo()+"-"+date(),false, ventaAux.getMontoTotal(), ventaAux.getCli().getNombre(), ventaAux.getPlanes());
					    		  ventaAux.getCli().getMisfacturas().add(fac);
					    		  Empresa.getInstance().getMisfacturas().add(fac);
					    	  }
					     }
						Empresa.setMesActual(date());
						}
						 if (progressBar.getValue() == progressBar.getMaximum()) { 
		                     progressBar.setValue(0);
						 }
						 timer.start();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Salir");
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
	
	public String date(){
		Date fecha = new Date();
		SimpleDateFormat formatfecha =new SimpleDateFormat("YYYYMMM");
		return formatfecha.format(fecha);
	}
	
	public Action createFacturasLoadAction() { 
	return new AbstractAction("generando facturas") { 
	    public void actionPerformed (ActionEvent e) { 
	    	
	    		if(progressBar.getValue() < progressBar.getMaximum()) { 			
	    		    progressBar.setValue(progressBar.getValue() + 1); 
	    		    int value = Integer.valueOf(textField.getText());
	    		    value++;
	    		    textField.setText(String.valueOf(value));
	    		 	} else { 
	    			timer.stop(); 
	    			okButton.setEnabled(true);
	    			cancelButton.setEnabled(true);
	    			System.out.println(Empresa.getInstance().getMisfacturas().size());
	    			
	    		}	    					
		 
	    } 
	}; 
    } 
}
