package controladores;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Combustible;
import modelo.Repostaje;

class PrincipalTest {

	@Test
	void insertarRepostajeTest() {
		//Poner las dos a 0 en el mismo estado para poder compararlas después
		List<Repostaje> lista= new ArrayList<>();
		Principal pp = new Principal();
		
		assertIterableEquals(lista, pp.listaRepostajes);
		//Ahora al añadir un repostaje e insertarlo en la lista comprobamos si se ha hecho correctamento
		Repostaje r = new Repostaje("","","",new Combustible("Gasolina",1.794),30,false, false, false);
		
		pp.insertarRepostaje(r);
		lista.add(r);
		//comparamos que sean iguales al insertar r
		assertIterableEquals(lista, pp.listaRepostajes);
	}

}
