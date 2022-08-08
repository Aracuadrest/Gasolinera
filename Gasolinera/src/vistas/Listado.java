package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		
		table = new JTable();
		contentPane.add(table, "cell 0 1,grow");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 16));
		contentPane.add(btnVolver, "cell 0 2,alignx center");
	}

}
