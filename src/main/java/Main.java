import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String []args){
        double saldo = 1000;
        double cantidad = 0;
        int opcion = -1;


        while (opcion != 0){
            System.out.println("\nSaldo actual: " + saldo);
            mostrarMenu();

            System.out.println("\nSeleccione una opcion");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("¿Cuanto dinero quieres retirar?");
                    cantidad = sc.nextDouble();
                    //Sacamos la cantidad
                    saldo = sacarDinero(saldo, cantidad);
                    break;

                case 2:
                    System.out.println("¿Cuanto dinero quieres ingresar?");
                    cantidad = sc.nextDouble();
                    //Ingresamos la cantidad
                    saldo = ingresarDinero(saldo, cantidad);
                    break;

                case 3:
                    //Implementar
                    break;

                case 0:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

        sc.close();
    }


    //Funcion para mostrar el menu
    public static void mostrarMenu(){
        System.out.println("1-. Sacar Dinero");
        System.out.println("2-. Ingresar Dinero");

        System.out.println("0-. Salir");
    }


    //Funcion para Sacar dinero y guardar el movimiento en un fichero
    public static double sacarDinero(double sueldo, double cantidad){
        //Comprobamos que se pueda sacar dinero de la cuenta
        if (sueldo < cantidad){
            System.out.println("Operacion no valida");
        } else {
            sueldo = sueldo - cantidad;
        }

        return sueldo;
    }


    //Funcion para Ingresar Dinero y guardar el movimiento en un fichero
    public static double ingresarDinero(double sueldo, double cantidad){
        return sueldo + cantidad;
    }



    //Funcion para ver los movimientos del Fichero





}