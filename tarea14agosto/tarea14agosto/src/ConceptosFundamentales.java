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
    return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
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
    return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
  }

}

class Cliente extends Humane {

  private boolean mayorista;

  public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
    super(nombre, apellido, dni);
    this.mayorista = mayorista;
  }

  public String toString() {
    return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
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
    return "Nombre: " + this.nombre + "\nPrecio: " + this.precio + "\n Cantidad: " + this.cantidad;
  }
}

class Transaccion {
  private Producto[] productos;
  private float montoTotal;
  private Caja caja;

  public Transaccion(Producto[] productos, float montoTotal, Caja caja) {
    this.productos = productos;
    this.montoTotal = montoTotal;
    this.caja = caja;
  }

  public String toString() {
    String productosString = "";

    for (int i = 0; i < this.productos.length; i++) {
      productosString += this.productos[i].toString() + "\n";
    }
    return "Lista de productos: " + productosString + "\nMonto total: " + this.montoTotal;
  }

}

class ConceptosFundamentales {
  public static void main(String[] args) {

    Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);
    System.out.println(cliente);
  }

}
