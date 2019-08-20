import java.util.ArrayList;
import java.util.Scanner;

public class Producto {



    private int codigo;
    private String nombre;
    private double precio;
    private  ArrayList<Producto> listC = new ArrayList<Producto>();

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(int codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public static Producto getNuevoProducto(){
        Scanner sc = new Scanner(System.in);
        LectorDeTecladoValidado LDTV = LectorDeTecladoValidado.getInstance();
        int cod = LDTV.getInteger("Ingrese el codigo del producto: " , "Intente de nuevo");
        System.out.println("Ingrese el nombre del producto: ");
        String nom = sc.nextLine();
        double pre = LDTV.getDouble("Ingrese el precio del prodducto ", "Intente de nuevo");
        return new Producto(cod,nom,pre);
    }

    public void añadirListC(){
        listC.add(this);
    }
    public void removerListC(int index){
        listC.remove(index);
    }

    public static void mostrarListC(ArrayList<Producto> x){
        for (int i = 0; i <x.size() ; i++){
            System.out.println("Codigo: " + x.get(i).getCodigo()  +
                    " " + "Nombre: " + x.get(i).getNombre() +
                    " " + "Precio: " +  x.get(i).getPrecio() );

        }
    }
    public static void mostrarListPrecio(ArrayList<Producto> x, ArrayList<Integer> y){
        for (int i = 0; i <x.size() ; i++){
            System.out.println("Codigo: " + x.get(i).getCodigo()  + "  " + "Nombre: " + x.get(i).getNombre() +
                    "  " + "Precio: " +  x.get(i).getPrecio() + "  " + "Cantidad " + y.get(i) );
        }
    }
    public static double total(ArrayList<Producto> x, ArrayList<Integer> y) {
        double total = 0;
        for (int i = 0; i < x.size(); i++) {
            total = total + x.get(i).getPrecio() * y.get(i);
        }
        return total;
    }



}
