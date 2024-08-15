import java.util.ArrayList;
import java.util.List;

class Humane {

  private String nombre;
  private String apellido;
  private int dni;

  public Humane(String nombre, String apellido, int dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public String toString() {
    return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
  }

}

class Empleado extends Humane {

  private double sueldo;

  public Empleado(String nombre, String apellido, int dni, double sueldo) {
    super(nombre, apellido, dni);
    this.sueldo = sueldo;
  }

  public String toString() {
    return "\n" + super.toString();
  }
}

class Caja {
  private Empleado empleado;
  private int nroCaja;

  public Caja(Empleado empleado, int nroCaja) {
    this.empleado = empleado;
    this.nroCaja = nroCaja;
  }

  public String toString() {
    return "\nEmpleado: " + this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
  }

}

class Cliente extends Humane {

  private boolean mayorista;

  public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
    super(nombre, apellido, dni);
    this.mayorista = mayorista;
  }

  public String toString() {
    return super.toString() + "\nMayorista: " + this.mayorista;
  }

}

class Producto {
  private String nombre;
  private float precio;
  private int cantidad;

  public Producto(String nombre, float precio, int cantidad) {
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public float calcularPrecioTotal() {
    return this.precio * this.cantidad;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getNombre() {
    return this.nombre;
  }

  public float getPrecio() {
    return this.precio;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public String toString() {
    return "Nombre:" + this.nombre + " Cantidad:" + this.cantidad + " Precio:$" + this.precio;
  }

}

class Transaccion {
  private List<Producto> productos;
  private Caja caja;
  private Cliente cliente;
  private float montoTotal;

  public Transaccion(List<Producto> productos, Cliente cliente, Caja caja) {
    this.productos = productos;
    this.caja = caja;
    this.cliente = cliente;
    this.montoTotal = calcularMontoTotal();
  }

  public float calcularMontoTotal() {
    float total = 0;
    for (Producto producto : productos) {
      total += producto.calcularPrecioTotal();
    }
    return total;
  }

  public String toString() {
    String productosString = "";

    for (Producto producto : this.productos) {
      productosString += producto.toString() + "\n";
    }
    return "Cliente:\n" + this.cliente.toString() + "\n" + this.caja.toString() + "\n\nLista de productos:\n"
        + productosString + "\nMonto total: $" + this.montoTotal;
  }
}

class ConceptosFundamentales {
  public static void main(String[] args) {

    // Crear empleado y caja
    Empleado empleado = new Empleado("Pepe", "Lopez", 12345678, 2000);
    Caja caja = new Caja(empleado, 1);

    // Crear cliente
    Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);

    // Crear productos
    List<Producto> productos = new ArrayList<>();
    productos.add(new Producto("Pan", 100, 10));
    productos.add(new Producto("Leche", 80, 1));
    productos.add(new Producto("Queso", 200, 1));

    // Crear transaccion
    Transaccion transaccion = new Transaccion(productos, cliente, caja);

    // Mostrar resultado
    System.out.println("\n--- Resumen de la compra ---");
    System.out.println(transaccion);

  }
}
