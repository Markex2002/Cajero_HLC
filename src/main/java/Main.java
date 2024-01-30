import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String []args){
        Cuenta cuenta1 = new Cuenta("Marco", "Martin", 3000, "ASDFGHJK9");
        Cuenta cuenta2 = new Cuenta("Marco", "Martin", 2000, "ASDFGHJK9");
        Cuenta cuenta3 = new Cuenta("Marco", "Martin", 10000, "ASDFGHJK9");
        Cuenta cuenta4 = new Cuenta("Antonio", "Perez", 4000, "MSKGDAKS3");
        Cuenta cuenta5 = new Cuenta("Antonio", "Perez", 6000, "MSKGDAKS3");
        //Creamos un listado de cuentas
        List<Cuenta> listadoCuentas = new ArrayList<>();
        listadoCuentas.add(cuenta1);
        listadoCuentas.add(cuenta2);
        listadoCuentas.add(cuenta3);
        listadoCuentas.add(cuenta4);
        listadoCuentas.add(cuenta5);


        //variables necesarias
        double cantidad;
        int opcion = -1;

        try {
            //Creamos el escritor de ficheros
            BufferedWriter writer = new BufferedWriter(new FileWriter("movimientos.txt", true));
            BufferedReader reader = new BufferedReader(new FileReader("movimientos.txt"));

            while (opcion != 0 && opcion != 3){
                System.out.println("\nSaldo actual: " + cuenta1.getSaldo());
                mostrarMenu();

                System.out.println("\nSeleccione una opcion");
                opcion = sc.nextInt();

                switch (opcion){
                    //Caso Retirar Dinero
                    case 1:
                        System.out.println("¿Cuanto dinero quieres retirar?");
                        cantidad = sc.nextDouble();
                        //Sacamos la cantidad
                        if (cuenta1.getSaldo() < cantidad){
                            System.out.println("Operacion no valida");
                        } else {
                            writer.write("Se han retirado: " + cuenta1.getSaldo() + "€");
                            writer.newLine();
                            writer.write("Saldo actual: " + (cuenta1.getSaldo() - cantidad) + "€");
                            writer.newLine();
                            cuenta1.setSaldo(cuenta1.getSaldo() - cantidad);
                        }
                        break;

                        //Caso Ingresar Dinero
                    case 2:
                        System.out.println("¿Cuanto dinero quieres ingresar?");
                        cantidad = sc.nextDouble();
                        //Ingresamos la cantidad
                        writer.write("Se han ingresado: " + cantidad + "€");
                        writer.newLine();
                        writer.write("Saldo actual: " + (cuenta1.getSaldo() + cantidad) + "€");
                        writer.newLine();
                        cuenta1.setSaldo(cuenta1.getSaldo() + cantidad);
                        break;

                        //ver Movimientos
                    case 3:
                        //Implementar
                        System.out.println("Mostrando Movimientos");
                        break;

                        //Listar todas las cuentas de un cliente
                    case 4:
                        System.out.println("Digame su Dni");
                        sc.nextLine();
                        String dniSeleccionado = sc.nextLine();

                        System.out.println("Aqui estan las cuentas asociadas");
                        listadoCuentas.forEach(c -> {
                            if (c.getDNI().equalsIgnoreCase(dniSeleccionado)) {
                                System.out.println(c);
                            }
                        });
                        break;

                    case 5:
                        System.out.println("Digame el saldo menor al que debe ser la cuenta");
                        double saldoMinimo = sc.nextDouble();
                        System.out.println("Cuentas con el saldo menor al proporcionado");

                        listadoCuentas.forEach(c -> {
                            if (c.getSaldo() < saldoMinimo) {
                                System.out.println(c);
                            }
                        });
                        break;

                        //Salir
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
        System.out.println("4-. Ver Cuentas relacionadas a un Dni");
        System.out.println("5-. Ver cuentas con saldo Inferior al mencionado");
        System.out.println("0-. Salir");
    }
}