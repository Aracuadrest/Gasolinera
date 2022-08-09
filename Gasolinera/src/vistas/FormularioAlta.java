package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.Principal;
import modelo.Combustible;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;

public class FormularioAlta extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtLitros;
	private JTextField txtTotal;
	private List<Combustible> listaCombustibles;
	private JComboBox<Combustible> comboBoxCombustible;
	private JCheckBox cbxAgrario;
	private JCheckBox cbxBonificacion;
	private JCheckBox cbxPorquetuvuelves;
	private Principal controlador;
	private JButton btnMostrarListado;
	private Repostaje editar=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAlta() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Nuevo Repostaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[45px][grow]", "[13px][][][][][][][][center][]"));
		
		JLabel lblMatricula = new JLabel("Matrícula");
		lblMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblMatricula, "cell 0 0,alignx right,aligny center");
		
		txtMatricula = new JTextField();
		txtMatricula.setMaximumSize(new Dimension(2147483647, 35));
		txtMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtMatricula, "cell 1 0,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNombre, "cell 0 1,alignx trailing,aligny center");
		
		txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(2147483647, 35));
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		contentPane.add(txtNombre, "cell 1 1,growx");
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblDni, "cell 0 2,alignx trailing,aligny center");
		
		txtDni = new JTextField();
		txtDni.setMaximumSize(new Dimension(2147483647, 35));
		txtDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDni.setColumns(10);
		contentPane.add(txtDni, "cell 1 2,growx");
		
		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblCombustible, "cell 0 3,alignx trailing,aligny center");
		
		comboBoxCombustible = new JComboBox();
		comboBoxCombustible.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(comboBoxCombustible, "cell 1 3,growx");
		
		JLabel lblLitros = new JLabel("Litros");
		lblLitros.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblLitros, "cell 0 4,alignx trailing,aligny center");
		
		txtLitros = new JTextField();
		txtLitros.setMaximumSize(new Dimension(2147483647, 35));
		txtLitros.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtLitros.setColumns(10);
		contentPane.add(txtLitros, "cell 1 4,growx");
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblTotal, "cell 0 5,alignx trailing,aligny center");
		
		txtTotal = new JTextField();
		txtTotal.setMaximumSize(new Dimension(2147483647, 35));
		txtTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtTotal.setColumns(10);
		contentPane.add(txtTotal, "cell 1 5,growx");
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblDescuento, "cell 0 6,alignx right,aligny center");
		
		 cbxAgrario = new JCheckBox("Agrario");
		 cbxAgrario.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		comprobarOtros();
		 	}
		 });
		cbxAgrario.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxAgrario, "flowx,cell 1 6");
		
		 cbxBonificacion = new JCheckBox("Bonificación Gobierno");
		 cbxBonificacion.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		compruebaAgrario();
		 	}
		 });
		cbxBonificacion.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxBonificacion, "cell 1 6");
		
		 cbxPorquetuvuelves = new JCheckBox("Porque tu vuelves");
		 cbxPorquetuvuelves.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		compruebaAgrario();
		 	}
		 });
		cbxPorquetuvuelves.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(cbxPorquetuvuelves, "cell 1 7");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(btnAceptar, "flowx,cell 1 9,alignx left");
		
		btnMostrarListado = new JButton("Mostrar Listado");
		btnMostrarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListado();
				
			}
		});
		btnMostrarListado.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(btnMostrarListado, "cell 1 9");
		
				
	}



	protected void comprobarOtros() {
		if(cbxAgrario.isSelected()&& (cbxBonificacion.isSelected() || cbxPorquetuvuelves.isSelected())) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuento con el descuento Agrario", 
					"Descuento no aplicable", JOptionPane.INFORMATION_MESSAGE);
			cbxAgrario.setSelected(false);
		}
		
	}

	protected void compruebaAgrario() {
		if (cbxBonificacion.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuento con el descuento Agrario", 
					"Descuento no aplicable", JOptionPane.INFORMATION_MESSAGE);
			cbxBonificacion.setSelected(false);
		}
		if (cbxPorquetuvuelves.isSelected() && cbxAgrario.isSelected()) {
			JOptionPane.showMessageDialog(this, "No se puede seleccionar otros descuento con el descuento Agrario", 
					"Descuento no aplicable", JOptionPane.INFORMATION_MESSAGE);
			cbxPorquetuvuelves.setSelected(false);
		}
	}
	
	
	protected void insertar() {
		
		Repostaje r = new Repostaje();
		if(txtMatricula.getText()==null || txtMatricula.getText().isBlank() ||
				txtNombre.getText()==null || txtNombre.getText().isBlank() ||
				txtDni.getText()==null || txtDni.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Los campos matricula, nombre y DNI son obligatorios", 
					"Campos obligatorios vacios", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		r.setMatricula(txtMatricula.getText());
		r.setNombre(txtNombre.getText());
		r.setDni(txtDni.getText());
		if (txtLitros.getText()!=null && !txtLitros.getText().isBlank() &&
				txtTotal.getText()!=null && !txtTotal.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Sólo puedes rellenar uno de los dos campos, litros o total", 
					"Entrada no valida", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		r.setCombustible((Combustible) comboBoxCombustible.getSelectedItem());
		r.setAgrario(cbxAgrario.isSelected());
		r.setGobierno(cbxBonificacion.isSelected());
		r.setVuelves(cbxPorquetuvuelves.isSelected());
		try {
			if(txtLitros.getText()!=null && !txtLitros.getText().isBlank()) {
			r.setLitros(Double.parseDouble(txtLitros.getText()));
		}else {
			r.setTotal(Double.parseDouble(txtTotal.getText()));
		}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Debe introducir un número válido en litros o total", 
					"Número incorrecto", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (editar!=null) {
			controlador.borrarRepostaje(editar);
		}
		
		controlador.insertarRepostaje(r);
		
	}

	public void setListaCombustibles(List<Combustible> listaCombustibles) {
		this.listaCombustibles=listaCombustibles;
		 DefaultComboBoxModel<Combustible>modelo= new DefaultComboBoxModel<>();
		 modelo.addAll(listaCombustibles);
		 comboBoxCombustible.setModel(modelo);
		 comboBoxCombustible.setSelectedIndex(0);
		
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
		
	}
	public void limpiarFormulario() {
		this.editar=null;
		this.txtMatricula.setText("");
		this.txtNombre.setText("");
		this.txtDni.setText("");
		this.comboBoxCombustible.setSelectedIndex(0);
		this.txtLitros.setText("");
		this.txtTotal.setText("");
		this.cbxAgrario.setSelected(false);
		this.cbxBonificacion.setSelected(false);
		this.cbxPorquetuvuelves.setSelected(false);
		
	}

	public void setRepostaje(Repostaje r) {
		this.editar=r;
		this.txtMatricula.setText(r.getMatricula());
		this.txtNombre.setText(r.getNombre());
		this.txtDni.setText(r.getDni());
		this.comboBoxCombustible.setSelectedItem(r.getCombustible());
		this.txtLitros.setText(""+r.getLitros());
		this.txtTotal.setText(""+r.getTotal());
		this.cbxAgrario.setSelected(r.isAgrario());
		this.cbxBonificacion.setSelected(r.isGobierno());
		this.cbxPorquetuvuelves.setSelected(r.isVuelves());
		
	}
	
}
