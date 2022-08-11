package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepostajeTest {

	@Test
	void getPrecioLitroDescuentoTest() {
		Repostaje r = new Repostaje("","","",new Combustible("Gasolina",1.794),30,false, false, false);
		assertEquals(1.794,r.getPrecioDescuento());
		r.setAgrario(true);
		assertEquals(1.794-0.45,r.getPrecioDescuento());
		r.setGobierno(true);
		assertEquals(1.794-0.45,r.getPrecioDescuento());
		r.setVuelves(true);
		assertEquals(1.794-0.45,r.getPrecioDescuento());
		r.setAgrario(false);
		assertEquals(1.794-0.20-0.05, r.getPrecioDescuento());
		r.setVuelves(false);
		assertEquals(1.794-0.20, r.getPrecioDescuento());
		r.setGobierno(false);
		r.setVuelves(true);
		assertEquals(1.794-0.05, r.getPrecioDescuento());
	}
	
	@Test
	void setTotalTest() {
		Repostaje r = new Repostaje("","","",new Combustible("Gasolina",1.794),30,true, false, false);
		r.setTotal(50);
		assertAll(
			()->assertEquals(50,r.getTotal(), "El importe total debe seguir siendo 50"),
			()->assertEquals(50/r.getPrecioDescuento(), r.getLitros(),"El numero de litros no corresponde a 50 con descuento")
					);
	}
	
}
