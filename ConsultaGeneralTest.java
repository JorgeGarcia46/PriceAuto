import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class ConsultaGeneralTest {

    @Test
    public void consultaGeneral_alDarClickCargaLaTablaYHaceVisibleElScroll() throws Exception {

        final Frame[] frameHolder = new Frame[1];
        final TableModel[] modelHolder = new TableModel[1];
        final boolean[] spVisibleHolder = new boolean[1];

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame();
                frame.setVisible(false);

                // Ir a: Consultas -> Consulta General
                frame.bCons.doClick();
                frame.bConsultaGen.doClick();

                modelHolder[0] = frame.jt.getModel();
                spVisibleHolder[0] = frame.sp.isVisible();
                frameHolder[0] = frame;
            }
        });

        // Assert (ya fuera del EDT)
        assertNotNull("El TableModel no debe ser null", modelHolder[0]);
        assertTrue("El JScrollPane (sp) debería estar visible después de Consulta General", spVisibleHolder[0]);

        // Si inventario tiene datos, debería regresar >= 1 fila.
        assertTrue("Se esperaba al menos una fila en la consulta general",
                modelHolder[0].getRowCount() >= 1);

        // limpiar ventana
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                frameHolder[0].dispose();
            }
        });
    }
}