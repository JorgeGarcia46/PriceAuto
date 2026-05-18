import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Reportes implements Serializable{  

    private LocalDateTime diaReporte;
    private LinkedList<Facturas> ListaFacturas = new LinkedList<>();


    public Reportes(LinkedList<Facturas> facturas){
        this.diaReporte = LocalDateTime.now();
        this.ListaFacturas = facturas;
    }

    public LocalDateTime getDiaReporte(){
        return diaReporte;
    }

    public LinkedList<Facturas> getListasFacturas(){
        return ListaFacturas;
    }
}