import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {

    public Clientes(int numIdentidad, String nombre){
        this.numIdentidad = numIdentidad;
        this.nombre = nombre;
    }
    private int numIdentidad;
    private String nombre;
    private ArrayList<Clientes> listC = new ArrayList<Clientes>();


    public int getNumIdentidad() {
        return numIdentidad;
    }
    public void setNumIdentidad(int numIdentidad) {
        this.numIdentidad = numIdentidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    static void mostrarListC(ArrayList<Clientes> x) {
        for (int i = 0; i <x.size() ; i++){
            System.out.println("Numero de identidad: " + x.get(i).getnumIdentidad() + "  " + "Nombre: " + x.get(i).getNombre());

        }
    }
    public void añadirListC(){

        listC.add(this);
    }
    public void removerListC(int index){

        listC.remove(index);
    }
    public static Clientes getNuevoCliente(){
        Scanner sc = new Scanner(System.in);
        LectorDeTecladoValidado LDTV = LectorDeTecladoValidado.getInstance();
        int ide = LDTV.getInteger("Ingrese el numero de identidad del Cliente: " , "Intente de nuevo");
        System.out.println("Ingrese el nombre del cliente: ");
        String nom = sc.nextLine();
        return  new Clientes(ide,nom);
    }

    int getnumIdentidad() {
        return  numIdentidad;
    }


}
