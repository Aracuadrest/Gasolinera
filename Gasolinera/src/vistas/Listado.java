package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.Principal;
import modelo.Repostaje;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Principal controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado frame = new Listado();
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
	public Listado() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][347.00][grow]"));
		
		JLabel lblListado = new JLabel("Listado de ventas:");
		lblListado.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblListado, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matrícula", "Nombre", "DNI", "Combustible", "Litros", "Total", "Desc. Agrario", "Desc. Gobierno", "Desc. vuelves"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 2,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAlta();
			}
		});
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				controlador.mostrarAlta(fila);
			}
		});
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel.add(btnEditar);
	}

	public void setListaRepostajes(List<Repostaje> listaRepostajes) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		//vaciamos la tabla por si contiene algun dato anterior
		modelo.setRowCount(0);
		//recorro la lista y los recojo
		for (Repostaje repostaje : listaRepostajes) {
			Object[] fila = {
					repostaje.getMatricula(),
					repostaje.getNombre(),
					repostaje.getDni(),
					repostaje.getCombustible(),
					repostaje.getLitros(),
					repostaje.getTotal(),
					repostaje.isAgrario(),
					repostaje.isGobierno(),
					repostaje.isVuelves()
			};
			//los incorporo
			modelo.addRow(fila);
		}	
	}

	public void setControlador(Principal controlador) {
		this.controlador = controlador;
	}
	

}
