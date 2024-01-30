public class Cuenta {
    private String nombre;
    private String apellidos;
    private double saldo;
    private String DNI;

    //CONSTRUCTOR
    public Cuenta(String nombre, String apellidos, int saldo, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.saldo = saldo;
        this.DNI = DNI;
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //METODOS
    @Override
    public String toString() {
        String resultado = "";
        resultado += "Nombre: " + nombre + " " + apellidos + ", Dni: " + DNI + ", saldo: " + saldo;

        return resultado;
    }
}