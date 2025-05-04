package com.mycompany.moroteatro;
import java.util.Scanner;

public class MoroTeatro {
    static int opcion=5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teatro teatro = new Teatro();
        
        
        System.out.println("BIENVENIDO A TEATRO MORO!");
        while (opcion>=1 && opcion<=5 ) {
        MoroTeatro.Menu();

            switch (opcion) {
                
                case 1:
                    System.out.println("POR FAVOR INGRESA LOS SIGUIENTES DATOS: ");
                    System.out.print("ID CLIENTE: ");
                    int idCliente = scanner.nextInt();scanner.nextLine();
                    System.out.print("TIPO CLIENTE (ESTUDIANTE/ ADULTO MAYOR /GENERAL): ");
                    String tipoCliente = scanner.nextLine();
                    System.out.print("NUMERO DE ASIENTO (DEL 0 AL 99): ");
                    int asiento = scanner.nextInt();scanner.nextLine();
                    System.out.print("TIPO DE ENTRADA (VIP/PLATEA/PALCO): ");
                    String tipoEntrada = scanner.nextLine();
                    String resultado = teatro.venderEntrada(idCliente, tipoCliente, asiento, tipoEntrada); //GETTER VENDER ENTRADA
                    System.out.println(resultado);
                    System.out.println("********************************************************");
                    break;

                case 2:
                    System.out.print("POR FAVOR INGRESE (ID DE VENTA A ELIMINAR): ");
                    int idEliminar = scanner.nextInt();
                    if (teatro.eliminarEntrada(idEliminar)) { //GETTER ELIMAR ENTRADA
                        System.out.println("VENTA ELIMINADA!.");
                    } else {
                        System.out.println("ID DE VENTA INVALIDO, NO SE ENCONTRO LA VENTA A ELIMINAR");
                        System.out.println("********************************************************");
                    }
                    break;

                case 3:
                    System.out.print("POR FAVOR INGRESE (ID DE VENTA A BUSCAR) ");
                    int idBuscar = scanner.nextInt();
                    Venta venta = teatro.buscarVenta(idBuscar); //GETTER BUSCAR ENTRADA
                    if (venta != null) {
                        System.out.println("ID VENTA: " + venta.idVenta);
                        System.out.println("ID CLIENTE: " + venta.cliente.idCliente);
                        System.out.println("DESCUENTO: " + venta.tipoDescuento);
                        System.out.println("ASIENTO: " + venta.entrada.numeroAsiento);
                        System.out.println("TIPO ENTRADA: " + venta.entrada.tipoEntrada);
                        System.out.println("PRECIO FINAL: $" + venta.precioFinal);
                    } else {
                        System.out.println("ID DE VENTA INVALIDO, NO SE ENCONTRO LA VENTA QUE BUSCA");
                        System.out.println("*******************************************************");
                    }
                    break;

                case 4:
                    teatro.mostrarResumen(); //METODO MOSTRAR RESUMEN DE VENTAS
                    break;

                case 5:
                    System.out.println("SALIENDO DEL PROGRAMA... NOS VEMOS PRONTO");
                    opcion++;
                    break;

                default:
                    System.out.println("OPCION INVALIDA");
            }
        }

        scanner.close();
    }
    
    
    public static void Menu(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("**** MENU ***");
    System.out.println("POR FAVOR INGRESE UNA OPCION: ");
    System.out.println("1. VENDER ENTRADA");
    System.out.println("2. ELIMINAR ENTRADA");
    System.out.println("3. MOSTRAR ENTRADA POR ID");
    System.out.println("4. MOSTRAR RESUMEN");
    System.out.println("5. SALIR");
    opcion = scanner.nextInt();
    }
    
    
}
