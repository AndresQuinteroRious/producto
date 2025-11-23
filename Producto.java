import java.util.Scanner;
import java.util.ArrayList;

public class Producto {

    //Atributos
    
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private boolean disponible;
    private int minimoStock; //Atributo adicional para que el stock no se acabe.

    public Producto (String nombre, String categoria, double precio, int stock, boolean disponible, int minimoStock){

        this.nombre = nombre;
        this.categoria = categoria;
        this.precio= precio;
        this.stock = stock;
        this.disponible= disponible;
        this.minimoStock= minimoStock;

    }

    public static void limpiarPantalla() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mostrarInformacion(){

        System.out.println("\nDATOS DEL PRODUCTO\n");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoria: " + categoria);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Disponible: " + disponible);
        System.out.println("Minimo Stock: " + minimoStock);

        if (minimoStock>=stock)
        {
            System.out.println("Recuerda comprar mas "+ nombre + " porque tu stock " + stock + " esta muy bajo");
        }

    }

    public String getNombre(){

        return nombre;
    }

    public int getStock()
    {
        return stock;
    }

    public boolean getDisponible()
    {
        return disponible;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void aplicarDescuento(double porcentaje){
        
        precio= precio * (1-(porcentaje/100));
    }

    public void registrarCompra(int cantidad){
        this.stock=stock+cantidad;
    }

    public void marcarComoDisponible(){
        if (disponible){
            disponible=false;
        }

        else {
            disponible=true;
        }
    }

    public void registrarVenta(int cantidad) {

        if (stock==0){

            System.out.println("No se puede realizar venta, ya que no hay productos");
        }

        else if ((stock-cantidad)<0)
        {
            System.out.println("No hay suficientes productos para esta venta");
        }

        else {
            this.stock=stock-cantidad;
        }


    }

    public static void main(String[] args) 
    {

        Scanner leer = new Scanner(System.in);

        int seleccion=0,stock,minimoStock;
        String nombre, categoria,respuesta;
        double precio;
        boolean disponible;
       
        ArrayList<Producto> productos = new ArrayList<>();


        while (seleccion==0) {
            
        


        System.out.println("\n     BIENVENIDO AL MODULO PARA GESTIONAR TUS PRODUCTOS    \n");

        System.out.println("Por favor escribe el numero de la acción que deseas realizar: \n");

        System.out.println("1. Registrar producto.");
        System.out.println("2. Mostrar informacion de todos los productos existentes.");
        System.out.println("3. Registar compra realizada. ");
        System.out.println("4. Registar venta realizada.\n");

        seleccion = leer.nextInt();
        leer.nextLine();




        //Registrar productos

        while(seleccion==1){

        limpiarPantalla();
        
        System.out.println("Ingrese el nombre del producto: ");
        nombre=leer.nextLine();
        System.out.println("Ingrese la categoria del producto: ");
        categoria=leer.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        precio=leer.nextDouble();
        System.out.println("Ingrese el stock que tiene el producto: ");
        stock=leer.nextInt();
        System.out.println("Ingrese el valor minimo que puede tener el producto en el stock: ");
        minimoStock=leer.nextInt();
        leer.nextLine(); // limpiar salto de línea

        if (stock>0)
        {
            disponible=true;
        }
        else 
        {
            disponible=false;
        }


        Producto p = new Producto(nombre, categoria, precio, stock, disponible, minimoStock);
        productos.add(p);

        System.out.println("\n¿Desea registrar otro producto? (s/n): ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("n")) {
                seleccion=0; // salir del bucle
            }
    }

    //Mostrar informacion de los productos

    while (seleccion==2) {

        limpiarPantalla();


        for (Producto p : productos) 
        {
            p.mostrarInformacion();
            System.out.println("-------------------------");
        }

        System.out.println("\n¿Desea salir? (s/n): ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
                seleccion=0; // salir del bucle
            }
        
    }


    //Uso de metodo registrarCompra(int cantidad)

    while (seleccion==3) {

        

        System.out.println("Seleccione el numero del producto que compro. \n");

        int res,stockAntes,stockDespues,cantidadComprados;
        boolean dis;

        int i = 1;
        for (Producto p : productos) 
        {
            System.out.println(i + ". " + p.getNombre());
            i++;
        }

        res=leer.nextInt();

        System.out.println("Ingrese la cantidad comprada: ");
        cantidadComprados=leer.nextInt();

        stockAntes= productos.get((res-1)).getStock(); //registro cuanto habia antes

        productos.get((res-1)).registrarCompra(cantidadComprados);

        stockDespues = productos.get((res-1)).getStock(); //registro en cuanto quedo el stock con esta compra

        System.out.println("El estock del producto " + productos.get((res-1)).getNombre() + " antes era " + stockAntes + " ahora es " + stockDespues );

        dis = productos.get((res-1)).getDisponible();
        if (!dis && stockAntes==0)
        {
            productos.get((res-1)).marcarComoDisponible();
        }

        if (dis)
        {
            System.out.println("El producto esta disponible");
        }
        else
        {
            System.out.println("El producto no esta disponible");
            
        }

        System.out.println("\n¿Desea salir? (s/n): ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
                seleccion=0; // salir del bucle
            }
    }

    //Resta de unidades -- venta de productos

    while (seleccion==4) {

        
        int res,stockAntes,stockDespues,cantidadVendidos,valorDescuento;
        boolean dis;
        double precioTotal,precioAntes,precioDespues;

        System.out.println("      Registrar ventas      ");

         
        System.out.println("\nSeleccione el numero del producto a vender. \n");

        

        int i = 1;
        for (Producto p : productos) 
        {
            System.out.println(i + ". " + p.getNombre());
            i++;
        }

        res=leer.nextInt();

        stockAntes= productos.get((res-1)).getStock();
        precioAntes = productos.get((res-1)).getPrecio();


        System.out.println("Ingrese la cantidad vendida: ");
        cantidadVendidos=leer.nextInt();

        System.out.println("Ingrese un valor de 1 a 100 si desea realizar un descuento de lo contrario ingrese 0: ");

        valorDescuento=leer.nextInt();
        leer.nextLine();




        if (valorDescuento != 0)
        {

            productos.get((res-1)).aplicarDescuento(valorDescuento);

        }

        precioDespues = productos.get((res-1)).getPrecio();

        if (precioAntes != precioDespues) {

            System.out.println("Precio por unidad antes de descuento " + precioAntes + " precio despues de descuento " + precioDespues);
            
        }


       

        productos.get((res-1)).registrarVenta(cantidadVendidos);

        stockDespues = productos.get((res-1)).getStock();


        //El siguiente if me indica si el stock cambio, si esto ocurre es por que la venta se pudo realizar de lo contrario muestra un mensaje indicando porque no se pudo realizar la venta


        if (stockAntes != stockDespues) {

            precioTotal = (productos.get((res-1)).getPrecio())*cantidadVendidos;            
            System.out.println("Precio total de la venta realizada: " + precioTotal);
            
                    
        }

        if (productos.get((res-1)).getStock()==0) 
        {
            productos.get((res-1)).marcarComoDisponible();
        
            
        }

        System.out.println("\n¿Desea seguir registrando ventas? (s/n): ");
        respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("n")) {
                seleccion=0; // salir del bucle
            }


        






        
    }

    }
}

    

}