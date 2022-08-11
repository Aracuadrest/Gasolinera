package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Combustible;
import modelo.Repostaje;
import vistas.FormularioAlta;
import vistas.Listado;

public class Principal {
	
	private FormularioAlta fAlta;
	private List<Combustible> listaCombustibles;
	private Listado fListado;
	public List<Repostaje> listaRepostajes;
	
	

	public Principal() {
		//creo la venta e instancio el controlador
		fAlta=new FormularioAlta();
		fAlta.setControlador(this);
		
		fListado = new Listado();
		fListado.setControlador(this);
		
		listaRepostajes= new ArrayList<>();
		
		listaCombustibles=new ArrayList<Combustible>();
		listaCombustibles.add(new Combustible("Gasolina",1.794));
		listaCombustibles.add(new Combustible("Gasoil",1.773));
		listaCombustibles.add(new Combustible("Gasolina Plus",1.832));
		listaCombustibles.add(new Combustible("Gasoil Plus",1.842));
		
		
	}
	
	public void insertarRepostaje(Repostaje r) {
		listaRepostajes.add(r);
		mostrarListado();
	}
	
	public void mostrarAlta() {
			fListado.setVisible(false);
			fAlta.setListaCombustibles(listaCombustibles);
			fAlta.limpiarFormulario();
			fAlta.setVisible(true);
			
	}


	public static void main(String[] args) {
		Principal ppal=new Principal();
		ppal.mostrarAlta();
	}

	public void mostrarListado() {
		fAlta.setVisible(false);
		fListado.setListaRepostajes(listaRepostajes);
		fListado.setVisible(true);
		
	}

	public void editarListado() {
			
	}

	public void mostrarAlta(int fila) {
		fListado.setVisible(false);
		fAlta.setListaCombustibles(listaCombustibles);
		Repostaje r = listaRepostajes.get(fila);
		fAlta.setRepostaje(r);
		fAlta.setVisible(true);
		
	}

	public void borrarRepostaje(Repostaje editar) {
		listaRepostajes.remove(editar);
		mostrarListado();
		
	}

}
