import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Gestion {
    private String nombreArchivo;
    LinkedList<Coches> inventario = new LinkedList<>();
    LinkedList<Coches> carritoCompras = new LinkedList<>();
    LinkedList<Facturas> facturas = new LinkedList<>();
    LinkedList<Reportes> reportes = new LinkedList<>();
    private int posicionMod;
    private int claveCarrito;

    public void setNombre() {
        this.nombreArchivo = "inventario.txt";
    }

    public void write(int clave, String marca, String modelo, float precio, int year, int cantidad) {
        try {
            FileOutputStream file = new FileOutputStream(nombreArchivo);
            ObjectOutputStream output = new ObjectOutputStream(file);
            Coches aux = new Coches(clave, marca, modelo, precio, year, cantidad);
            inventario.add(aux);

            for (Coches coches : inventario) {
                output.writeObject(coches);
            }
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeArchivo() {
        try {
            FileOutputStream file = new FileOutputStream(nombreArchivo);
            ObjectOutputStream output = new ObjectOutputStream(file);

            for (Coches coches : inventario) {
                output.writeObject(coches);
            }
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public boolean eliminar(int clave) {

        mergeSort(inventario);
        // clave con los demas elementos del arraylist
        int pos = busquedaBinariaRecursiva(clave, 0, inventario.size() - 1);

        if (pos == -1) {
            return false;
        } else {
            inventario.remove(pos);
            this.writeArchivo();
            return true;
        }
    }

    public void recopilarDatos() throws IOException {
        FileInputStream fileStream = null;
        ObjectInputStream input = null;
        LinkedList<Coches> inventarioAux = new LinkedList<>();

        try {
            fileStream = new FileInputStream(nombreArchivo);
            input = new ObjectInputStream(fileStream);
            while (true) {
                Coches aux = (Coches) input.readObject();
                inventarioAux.add(aux);
            }
        } catch (Exception e) {

        } finally {
            fileStream.close();
            input.close();
            inventario = inventarioAux;
        }
    }

    public String[][] recargarTabla() {
        String[][] newInventario = new String[inventario.size()][6];

        mergeSort(inventario);

        for (int i = 0; i < inventario.size(); i++) {
            Coches aux = inventario.get(i);
            newInventario[i][0] = String.valueOf(aux.getClave());
            newInventario[i][1] = aux.getMarca();
            newInventario[i][2] = aux.getModelo();
            newInventario[i][3] = String.valueOf(aux.getYear());
            newInventario[i][4] = String.valueOf(aux.getPrecio());
            newInventario[i][5] = String.valueOf(aux.getCantidad());
        }

        return newInventario;
    }

    public String[][] recargarTablaBusqueda(String modelo) {

        mergeSort(inventario);

        int coincidencias = 0;
        for (int i = 0; i < inventario.size(); i++) {
            Coches aux = inventario.get(i);
            if (aux.getModelo().equalsIgnoreCase(modelo)) {
                coincidencias++;
            }
        }
        if (coincidencias == 0) {
            return null;
        }
        String[][] newInventario = new String[coincidencias][6];
        int x = 0;
        for (int i = 0; i < inventario.size(); i++) {
            Coches aux = inventario.get(i);
            if (aux.getModelo().equalsIgnoreCase(modelo)) {
                newInventario[x][0] = String.valueOf(aux.getClave());
                newInventario[x][1] = aux.getMarca();
                newInventario[x][2] = aux.getModelo();
                newInventario[x][3] = String.valueOf(aux.getYear());
                newInventario[x][4] = String.valueOf(aux.getPrecio());
                newInventario[x][5] = String.valueOf(aux.getCantidad());
                x++;
            }
        }

        return newInventario;
    }

    // Matematicas discretas
    public String[][] recargarTablaBusquedaBinariaR(int clave) {
        mergeSort(inventario);
        int pos = busquedaBinariaRecursiva(clave, 0, inventario.size() - 1);
        this.claveCarrito = clave;

        if (pos == -1) {
            return null;
        } else {
            String[][] newInventario = new String[1][6];
            Coches aux2 = inventario.get(pos);
            newInventario[0][0] = String.valueOf(aux2.getClave());
            newInventario[0][1] = aux2.getMarca();
            newInventario[0][2] = aux2.getModelo();
            newInventario[0][3] = String.valueOf(aux2.getYear());
            newInventario[0][4] = String.valueOf(aux2.getPrecio());
            newInventario[0][5] = String.valueOf(aux2.getCantidad());
            return newInventario;
        }
    }

    public void CarritoCompras(int cantidad) {
        mergeSort(inventario);
        int pos = busquedaBinariaRecursiva(this.claveCarrito, 0, inventario.size() - 1);
        if (pos == -1) {
        } else {
            Coches aux = inventario.get(pos);
            int clave = aux.getClave();
            String marca = aux.getMarca();
            String modelo = aux.getModelo();
            float precio = aux.getPrecio();
            int year = aux.getYear();
            int cantidad2 = cantidad;
            Coches aux2 = new Coches(clave, marca, modelo, precio, year, cantidad2);
            carritoCompras.add(aux2);
        }
    }

    public boolean ValidarStock(int solicitado) {
        int solicitadoFinal = solicitado;
        for (int x = 0; x < carritoCompras.size(); x++) {
            if (claveCarrito == carritoCompras.get(x).getClave()) {
                solicitadoFinal = solicitadoFinal + carritoCompras.get(x).getCantidad();
            }
        }
        mergeSort(inventario);
        int pos = busquedaBinariaRecursiva(claveCarrito, 0, inventario.size() - 1);
        if (solicitadoFinal > inventario.get(pos).getCantidad()) {
            return false;
        }
        return true;
    }

    public String[][] recargarTablaCarrito() {
        quicksort(inventario, 0, inventario.size()-1);
        String[][] newInventario = new String[carritoCompras.size()][6];
        for (int x = 0; x < carritoCompras.size(); x++) {
            Coches aux = carritoCompras.get(x);
            newInventario[x][0] = String.valueOf(aux.getClave());
            newInventario[x][1] = aux.getMarca();
            newInventario[x][2] = aux.getModelo();
            newInventario[x][3] = String.valueOf(aux.getYear());
            newInventario[x][4] = String.valueOf(aux.getPrecio());
            newInventario[x][5] = String.valueOf(aux.getCantidad());
        }
        return newInventario;
    }

    // Matematicas Discretas
    public int busquedaBinariaRecursiva(int buscar, int inicio, int fin) {
        int mitad = (inicio + fin) / 2;

        if (inventario.get(mitad).getClave() == buscar) {
            return mitad;
        }

        if (inicio > fin) {
            return -1;
        }

        if (buscar < inventario.get(mitad).getClave()) {
            return busquedaBinariaRecursiva(buscar, inicio, mitad - 1);
        } else {
            return busquedaBinariaRecursiva(buscar, mitad + 1, fin);
        }
    }

    public boolean validarClave(int clave) {
        int bandera = 0;
        for (int i = 0; i < inventario.size(); i++) {
            Coches aux = inventario.get(i);
            if (aux.getClave() == clave) {
                bandera = 1;
            }
        }

        if (bandera == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String[][] infoModificaciones(int pos) {
        Coches aux = inventario.get(pos);
        this.posicionMod = pos;
        String[][] informacion = new String[1][6];
        informacion[0][0] = String.valueOf(aux.getClave());
        informacion[0][1] = aux.getMarca();
        informacion[0][2] = aux.getModelo();
        informacion[0][3] = String.valueOf(aux.getYear());
        informacion[0][4] = String.valueOf(aux.getPrecio());
        informacion[0][5] = String.valueOf(aux.getCantidad());

        return informacion;
    }

    public void modificar(int clave, String marca, String modelo, float precio, int year, int cantidad) {
        inventario.get(posicionMod).setClave(clave);
        inventario.get(posicionMod).setMarca(marca);
        inventario.get(posicionMod).setModelo(modelo);
        inventario.get(posicionMod).setPrecio(precio);
        inventario.get(posicionMod).setYear(year);
        inventario.get(posicionMod).setCantidad(cantidad);

        this.guardarArchivo();
    }

    public void guardarArchivo() {
        try {
            FileOutputStream file = new FileOutputStream(nombreArchivo);
            ObjectOutputStream output = new ObjectOutputStream(file);

            for (Coches coches : inventario) {
                output.writeObject(coches);
            }
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public int getClaveCarrito() {
        return claveCarrito;
    }

    public void HacerFactura(String cliente, float totalCompra) {
        Facturas aux = new Facturas(cliente, this.carritoCompras, totalCompra);
        facturas.add(aux);
        for (int x = 0; x < inventario.size(); x++) {
            for (int y = 0; y < carritoCompras.size(); y++) {
                if (carritoCompras.get(y).getClave() == inventario.get(x).getClave()) {
                    inventario.get(x)
                            .setCantidad(inventario.get(x).getCantidad() - carritoCompras.get(y).getCantidad());
                }
            }
        }
        this.guardarArchivo();
    }

    public void leerReportesArchivo() throws IOException {
        FileInputStream fileStream = null;
        ObjectInputStream input = null;
        LinkedList<Reportes> reportesAux = new LinkedList<>();

        try {
            fileStream = new FileInputStream("reportes.txt");
            input = new ObjectInputStream(fileStream);
            while (true) {
                Reportes aux = (Reportes) input.readObject();
                reportesAux.add(aux);
            }
        } catch (Exception e) {

        } finally {
            fileStream.close();
            input.close();
            reportes = reportesAux;
        }
    }

    public void HacerReporte() {
        Reportes aux = new Reportes(facturas);
        reportes.add(aux);
        this.escribirReportesArchivo();
    }

    public void escribirReportesArchivo() {
        try {
            FileOutputStream file = new FileOutputStream("reportes.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            for (Reportes aux : reportes) {
                output.writeObject(aux);
            }
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String[] comboBoxReportes() throws IOException {
        this.leerReportesArchivo();
        ArrayList<String> listaReportes = new ArrayList<>();
        for (Reportes aux : reportes) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
            listaReportes.add(aux.getDiaReporte().format(dateTimeFormatter));
        }

        String[] aux = new String[listaReportes.size()];
        for (int x = 0; x < listaReportes.size(); x++) {
            aux[x] = listaReportes.get(x);
        }
        return aux;
    }

    public String[] comboBoxVentas(int numeroReporte) {
        ArrayList<String> listaVentas = new ArrayList<>();
        for (int x = 0; x < reportes.get(numeroReporte).getListasFacturas().size(); x++) {
            listaVentas.add("Venta " + (x + 1));
        }
        String[] aux = new String[listaVentas.size()];
        for (int x = 0; x < listaVentas.size(); x++) {
            aux[x] = listaVentas.get(x);
        }
        return aux;
    }

    public String[][] recargarTablaConsultaReportes(int reporteSeleccionado, int ventaSeleccionada) {
        String[][] newInventario = {};
        for (int i = 0; i < reportes.size(); i++) {
            for (int y = 0; y < reportes.get(reporteSeleccionado).getListasFacturas().size(); y++) {
                if (y == ventaSeleccionada) {
                    Facturas aux = reportes.get(reporteSeleccionado).getListasFacturas().get(ventaSeleccionada);
                    newInventario = new String[aux.getListaArticulos().size()][6];
                    for (int z = 0; z < aux.getListaArticulos().size(); z++) {
                        newInventario[z][0] = String.valueOf(aux.getListaArticulos().get(z).getClave());
                        newInventario[z][1] = aux.getListaArticulos().get(z).getMarca();
                        newInventario[z][2] = aux.getListaArticulos().get(z).getModelo();
                        newInventario[z][3] = String.valueOf(aux.getListaArticulos().get(z).getYear());
                        newInventario[z][4] = String.valueOf(aux.getListaArticulos().get(z).getPrecio());
                        newInventario[z][5] = String.valueOf(aux.getListaArticulos().get(z).getCantidad());
                    }
                }
            }
        }
        return newInventario;
    }

// Metodos de ordenacion
    public static <E extends Comparable<E>> void mergeSort(LinkedList<E> lista) {
        if (lista.size() > 1) {
            int mitad = lista.size() / 2;
            LinkedList<E> izquierda = new LinkedList<>(lista.subList(0, mitad));
            LinkedList<E> derecha = new LinkedList<>(lista.subList(mitad, lista.size()));
            
            mergeSort(izquierda);
            mergeSort(derecha);
            
            merge(izquierda, derecha, lista);
        }
    }

    private static <E extends Comparable<E>> void merge(LinkedList<E> izquierda, LinkedList<E> derecha, LinkedList<E> mezclado) {
        int i = 0, j = 0, k = 0;
        
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).compareTo(derecha.get(j)) < 0) {
                mezclado.set(k++, izquierda.get(i++));
            } else {
                mezclado.set(k++, derecha.get(j++));
            }
        }
        
        while (i < izquierda.size()) {
            mezclado.set(k++, izquierda.get(i++));
        }
        
        while (j < derecha.size()) {
            mezclado.set(k++, derecha.get(j++));
        }
    }
    private static <E extends Comparable<E>> void quicksort(LinkedList<Coches> a, int primero, int ultimo){
        int central = (primero + ultimo) / 2;
        Coches pivote = a.get(central);
        int i = primero;
        int j = ultimo;
        do {
            while (a.get(i).compareTo(pivote) < 0)
                i++;
            while (a.get(j).compareTo(pivote) > 0)
                j--;
            if (i <= j) {
                Coches aux = a.get(i);
                a.set(i, a.get(j));
                a.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j)
            quicksort(a, primero, j); // mismo proceso con sublista izquierda
        if (i < ultimo)
            quicksort(a, i, ultimo); // mismo proceso con sublista derecha
    }
}


