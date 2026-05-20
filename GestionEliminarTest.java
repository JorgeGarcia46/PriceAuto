import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GestionEliminarTest {

    @Test
    public void testEliminarVehiculo() {

        Gestion gestion = new Gestion();

        gestion.inventario.add(
            new Coches(201, "Mazda", "Mazda 3", 350000, 2022, 4)
        );

        gestion.inventario.add(
            new Coches(202, "Ford", "Focus", 270000, 2021, 2)
        );

        gestion.inventario.add(
            new Coches(203, "Kia", "Rio", 240000, 2020, 6)
        );

        boolean resultado = gestion.eliminar(202);

        assertTrue(resultado);

        System.out.println("Vehiculo eliminado correctamente");
    }
}