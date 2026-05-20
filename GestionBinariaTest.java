import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GestionBinariaTest {

    @Test
    public void testBusquedaBinariaVehiculoExistente() {

        Gestion gestion = new Gestion();

        gestion.inventario.add(
            new Coches(101, "Toyota", "Corolla", 250000, 2022, 5)
        );

        gestion.inventario.add(
            new Coches(102, "Honda", "Civic", 280000, 2023, 3)
        );

        gestion.inventario.add(
            new Coches(103, "Nissan", "Sentra", 300000, 2024, 2)
        );

        Gestion.mergeSort(gestion.inventario);

        int resultado = gestion.busquedaBinariaRecursiva(
            103,
            0,
            gestion.inventario.size() - 1
        );

        assertEquals(2, resultado);

        System.out.println("Prueba Aprobada");
    }
}