import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GestionModificarTest {

    @Test
    public void testModificarVehiculo() {

        Gestion gestion = new Gestion();

        gestion.inventario.add(
            new Coches(501, "Toyota", "Corolla", 250000, 2022, 5)
        );


        gestion.infoModificaciones(0);

        gestion.modificar(
            501,
            "Toyota",
            "Corolla Sport",
            300000,
            2024,
            3
        );

        assertEquals(
            "Corolla Sport",
            gestion.inventario.get(0).getModelo()
        );

        System.out.println("Vehiculo modificado correctamente");
    }
}