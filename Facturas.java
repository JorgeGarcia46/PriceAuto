import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Facturas implements Serializable{  
    private LocalDateTime fechaDeCompra;
    private String cliente;
    private LinkedList<Coches> ListaArticulos = new LinkedList<>();
    private float totalCompra;


    public Facturas(String cliente, LinkedList<Coches> carritoCompras,float totalCompra){
        this.cliente = cliente;
        this.fechaDeCompra = LocalDateTime.now();
        for(int x=0;x<carritoCompras.size();x++){
            Coches aux = carritoCompras.get(x);
            int clave = aux.getClave();
            String marca = aux.getMarca();
            String modelo = aux.getModelo();
            float precio = aux.getPrecio();
            int year = aux.getYear();
            int cantidad = aux.getCantidad();
            Coches aux2 = new Coches(clave, marca, modelo, precio, year, cantidad);
            ListaArticulos.add(aux2);
        }
        this.totalCompra = totalCompra;
    }

    public LocalDateTime getFechaDeCompra(){
        return fechaDeCompra;
    }

    public String getCliente(){
        return cliente;
    }

    public LinkedList<Coches> getListaArticulos(){
        return ListaArticulos;
    }

    public float getTotalCompra(){
        return totalCompra;
    }
}