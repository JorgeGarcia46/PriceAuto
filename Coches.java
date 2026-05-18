import java.io.Serializable;

public class Coches implements Serializable, Comparable<Coches>{  
    private int clave;
    private String marca;
    private String modelo;
    private float precio;
    private int year;
    private int cantidad;

    public Coches(int clave, String marca, String modelo, float precio,int year,int cantidad){
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.year = year;
        this.cantidad = cantidad;
    }

    public void setClave(int clave){
        this.clave = clave;
    }

    public int getClave(){
        return this.clave;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }

    public float getPrecio(){
        return this.precio;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    @Override
    public int compareTo(Coches otro) {
        // Comparación basada en el año
        return Integer.compare(this.clave, otro.clave);
    }
}
