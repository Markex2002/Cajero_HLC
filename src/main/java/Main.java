import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String []args){
        //variables necesarias
        double saldo = 1000;
        double cantidad;
        int opcion = -1;

        try {
            //Creamos el escritor de ficheros
            BufferedWriter writer = new BufferedWriter(new FileWriter("movimientos.txt", true));
            BufferedReader reader = new BufferedReader(new FileReader("movimientos.txt"));

            while (opcion != 0 && opcion != 3){
                System.out.println("\nSaldo actual: " + saldo);
                mostrarMenu();

                System.out.println("\nSeleccione una opcion");
                opcion = sc.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("¿Cuanto dinero quieres retirar?");
                        cantidad = sc.nextDouble();
                        //Sacamos la cantidad
                        if (saldo < cantidad){
                            System.out.println("Operacion no valida");
                        } else {
                            writer.write("Se han retirado: " + cantidad + "€");
                            writer.newLine();
                            writer.write("Saldo actual: " + (saldo - cantidad) + "€");
                            writer.newLine();
                            saldo = saldo - cantidad;
                        }
                        break;

                    case 2:
                        System.out.println("¿Cuanto dinero quieres ingresar?");
                        cantidad = sc.nextDouble();
                        //Ingresamos la cantidad
                        writer.write("Se han ingresado: " + cantidad + "€");
                        writer.newLine();
                        writer.write("Saldo actual: " + (saldo + cantidad) + "€");
                        writer.newLine();
                        saldo = cantidad + saldo;
                        break;

                    case 3:
                        //Implementar
                        System.out.println("Mostrando Movimientos");
                        break;

                    case 0:
                        System.out.println("Adios");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
            writer.close();

            //Mostramos los movimientos
            if (opcion == 3){
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            }

            reader.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Fallo de escritura/Lectura");
        }

        sc.close();
    }


    //Funcion para mostrar el menu
    public static void mostrarMenu(){
        System.out.println("1-. Sacar Dinero");
        System.out.println("2-. Ingresar Dinero");
        System.out.println("3-. Ver Movimientos");
        System.out.println("0-. Salir");
    }
}