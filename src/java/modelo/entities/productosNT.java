package modelo.entities;

public class productosNT {
    private int codigo;
    private String descripcion;
    private double stock;
    private double precio;
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public productosNT(int codi, String desc, double stoc, double prec){
        this.codigo=codi;
        this.descripcion=desc;
        this.stock= stoc;
        this.precio=prec;
    }
    
    public productosNT(){
    }        
}
