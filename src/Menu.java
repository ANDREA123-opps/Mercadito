import java.util.ArrayList;

public class Menu {

    ArrayList<Clientes> listaCliente = new ArrayList<>(7);
    ArrayList<Producto> listaProducto = new ArrayList<>(7);
    ArrayList<Producto> listaProductoFactura = new ArrayList<>(7);
    ArrayList<Integer> precios = new ArrayList<>(7);

    public void menu() {

        listaCliente.add(new Clientes(1111,"Maricela Espinosa"));
        listaCliente.add(new Clientes(5555, "Gaby smith"));
        listaCliente.add(new Clientes(3333, "Edwin Matamoros"));
        listaCliente.add(new Clientes(0000, "Carlos Robers"));
        listaCliente.add(new Clientes(6666, "Emilio GUtierres"));
        listaCliente.add(new Clientes(4444, "Moises Boricua"));
        listaProducto.add(new Producto(222, "CocaCola", 15));
        listaProducto.add(new Producto(111, "Azucar", 20));
        listaProducto.add(new Producto(444, "Leche", 23));
        listaProducto.add(new Producto(666, "Pollo Frito", 90));
        listaProducto.add(new Producto(777, "Yogurt", 14));
        listaProducto.add(new Producto(999, "Pollo", 90));
        listaProducto.add(new Producto(888, "IceCream", 150));
        listaProducto.add(new Producto(000, "Jugo de naranja", 35));
        listaProducto.add(new Producto(999, "Cereal", 70));

        int x;
        do {
            System.out.println("\n Escojas una de las opciones mostradas a continuacion: \n" +
                    "\t-----------------------------\n" +
                    "\t| 1. Agregar nuevo cliente  |\n" +
                    "\t| 2. Eliminar cliente       |\n" +
                    "\t| 3. Ver lista de clientes  |\n" +
                    "\t| 4. Agregar neuvo producto |\n" +
                    "\t| 5. Quitar producto        |\n" +
                    "\t| 6. Ver lista de productos |\n" +
                    "\t| 7. Facturar               |\n" +
                    "\t| 8. Salir                  |\n"+
                    "\t-----------------------------");

            LectorDeTecladoValidado LDTV = LectorDeTecladoValidado.getInstance();
            x = LDTV.getInteger("", "No tecleastes un numero");
            switch (x) {
                case 1:
                    listaCliente.add(Clientes.getNuevoCliente());

                    break;
                case 2:
                    int z = LDTV.getInteger("Ingrese el lugar de la lista en donde se encuentra el cliente a eliminar: \"", "Intente de nuevo");
                    listaCliente.remove(z-1);
                    break;
                case 3:
                    Clientes.mostrarListC(listaCliente);
                    break;
                case 4:
                    listaProducto.add(Producto.getNuevoProducto());
                    break;
                case 5:
                    int a = LDTV.getInteger("Ingrese el lugar de la lista en donde se encuentre el produto a eliminar: ", "Intente otra vez");
                    listaProducto.remove(a-1);
                    break;
                case 6:
                    Producto.mostrarListC(listaProducto);
                    break;
                case 7:
                    factura();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida intente de nuevo");
            }
        } while (x != 8);
    }

    public void factura(){
        LectorDeTecladoValidado LDTV = LectorDeTecladoValidado.getInstance();
        System.out.println("---SUPERMERCADO LAS DIABLAS---\n\n" +
                "Ingrese el codigo de los productos y la cantidad\n" +
                "Al finalizar su compra ingrese -1 ");
        int a = 0;
        int b = 0;
        double totalFac = 0;
        do {
            a = LDTV.getInteger("Codigo de producto", "no valido");
            for (int i = 0; i < listaProducto.size(); i++) {
                if (a == listaProducto.get(i).getCodigo()) {
                    b = LDTV.getInteger("Cantidad", "no valido");
                    totalFac =  totalFac + listaProducto.get(i).getPrecio()* b;
                    listaProductoFactura.add(listaProducto.get(i));
                    precios.add(b);

                }
            }

        } while (a != -1);
        System.out.println("El total de la factura es: " + totalFac);

        System.out.println("Desea la factura con RTN?\n" +
                "1. Si\t" +
                "2. No");
        int respuesta = LDTV.getInteger("" , "Intente nuevamente");
        if (respuesta == 1) {
            int RTN = LDTV.getInteger("Ingrese el RTN: ", "Intente nuevamente");
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getnumIdentidad() == RTN) {
                    System.out.println("Usted ya es nuestro cliente " + listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getnumIdentidad());
                    int  v = i;
                }
            }
            System.out.println("             FACTURA             ");
            System.out.println("---------------------------------");
            System.out.println("       SUPER-MERCADO LAS DIABLAS     ");
            System.out.println("       Centro Comercial Las Palmas    ");
            System.out.println("RTN: " + RTN);
            System.out.println("       Cajero: Andy Avila    ");
            Producto.mostrarListPrecio(listaProductoFactura, precios);
            System.out.println("Total: " + totalFac);
            System.out.println("");
            System.out.println("        - Cuenta Cerrada -       ");
            System.out.println("");
        }else {
            System.out.println("             FACTURA             ");
            System.out.println("---------------------------------");
            System.out.println("       SUPER-MERCADO LAS DIABLAS     ");
            System.out.println("       Centro Comercial Las Palmas    ");
            System.out.println("RTN: ND");
            System.out.println("       Cajero: Andy Avila   ");
            Producto.mostrarListPrecio(listaProductoFactura, precios);
            System.out.println("Total: " + totalFac);
            System.out.println("");
            System.out.println("        - Cuenta Cerrada -       ");
            System.out.println("");
        }


    }
}
