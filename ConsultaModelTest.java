import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class ConsultaModelTest {

    @Test
    public void consultaPorModelo_conModeloExistente_cargaResultadosEnTabla() throws Exception {

        final Frame[] frameHolder = new Frame[1];
        final TableModel[] modelHolder = new TableModel[1];
        final Object[] modeloEnTablaHolder = new Object[1];

        SwingUtilities.invokeAndWait(() -> {
            Frame frame = new Frame();
            frame.setVisible(false);

            // Navegar: Consultas -> Consulta por modelo
            frame.bCons.doClick();
            frame.bConsultaEsp.doClick();

            String modeloExistente = "Altima"; // debe existir en el archivo "inventario"
            frame.iBusqueda.setText(modeloExistente);
            frame.bBuscarBE.doClick();

            modelHolder[0] = frame.jt.getModel();
            if (modelHolder[0] != null && modelHolder[0].getRowCount() > 0) {
                modeloEnTablaHolder[0] = modelHolder[0].getValueAt(0, 2);
            }

            frameHolder[0] = frame;
        });

        // Asserts FUERA del EDT (ya con valores capturados)
        TableModel tm = modelHolder[0];
        assertNotNull("La tabla no debe ser null", tm);
        assertTrue("Se esperaba al menos una fila", tm.getRowCount() >= 1);

        assertNotNull("El modelo en la primera fila no debe ser null", modeloEnTablaHolder[0]);
        assertEquals("Altima", modeloEnTablaHolder[0].toString());

        // limpiar
        SwingUtilities.invokeAndWait(() -> frameHolder[0].dispose());
    }
}