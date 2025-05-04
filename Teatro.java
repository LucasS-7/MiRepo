package com.mycompany.moroteatro;
import java.util.ArrayList;
import java.util.Scanner;


public class Teatro {
    
    Venta[] ventas = new Venta[100]; 
    int contadorVentas = 0;
    ArrayList<Integer> asientosOcupados = new ArrayList<>();

    
  //METODOS PARA CALCULAR EL PRECIO Y EL DESCUENTO (SEGUN TIPO DE ENTRADA Y SEGUN SI ES ESTUDIANTE O ADULTO MAYOR)  
    public double calcularPrecio(String tipoEntrada) {
        switch (tipoEntrada.toUpperCase()) {
            case "VIP": return 15000.0;
            case "PLATEA": return 12000.0;
            case "PALCO": return 10000.0;
            default: return 0.0;
        }
    }

    public String aplicarDescuento(String tipoCliente) {
        if (tipoCliente.equalsIgnoreCase("ESTUDIANTE")) return "10%";
        if (tipoCliente.equalsIgnoreCase("ADULTO MAYOR")) return "15%";
        return "0%";
    }

    public double calcularDescuento(String tipoCliente) {
        if (tipoCliente.equalsIgnoreCase("ESTUDIANTE")) return 0.10;
        if (tipoCliente.equalsIgnoreCase("ADULTO MAYOR")) return 0.15;
        else return 0.0;
    }

    
    
    // GETTER Y METODOS DEL MENU
    
    
    //GETTER PARA LA VENTA DE ENTRADAS (PROPIEDADES ENTREGADAS POR MEDIO DEL MAIN)
    public String venderEntrada(int idCliente, String tipoCliente, int numeroAsiento, String tipoEntrada) {
        if (asientosOcupados.contains(numeroAsiento)) {
            return "ASIENTO OCUPADO!";
        }

        double precioBase = calcularPrecio(tipoEntrada);
        double descuento = calcularDescuento(tipoCliente);
        double precioFinal = precioBase * (1 - descuento);

        Cliente cliente = new Cliente(idCliente, tipoCliente);
        Entrada entrada = new Entrada(numeroAsiento, tipoEntrada);
        String tipoDescuento = aplicarDescuento(tipoCliente);
        Venta venta = new Venta(contadorVentas + 1, cliente, entrada, precioFinal, tipoDescuento);

        ventas[contadorVentas++] = venta;
        asientosOcupados.add(numeroAsiento);
        System.out.println();
        return "VENTA REALIZADA! ID VENTA: " + venta.idVenta +", DESCUENTO APLICADO %"+(int)(descuento*100)+ ", PRECIO FINAL $" + precioFinal;
    }

    //GETTER PARA ELIMINAR ENTRADA POR ID DE VENTA   
    public boolean eliminarEntrada(int idVenta) {
        for (int i = 0; i < contadorVentas; i++) {
            if (ventas[i] != null && ventas[i].idVenta == idVenta) {
                asientosOcupados.remove((Integer) ventas[i].entrada.numeroAsiento);
                ventas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //GETTER PARA BUSCAR ENTRADA POR ID DE VENTA    
    public Venta buscarVenta(int idVenta) {
        for (int i = 0; i < contadorVentas; i++) {
            if (ventas[i] != null && ventas[i].idVenta == idVenta) {
                return ventas[i];
            }
        }
        return null;
    }
    
    //METODO PARA MOSTRAR RESUMEN DE VENTAS
    public void mostrarResumen() {
        System.out.println("*** RESUMEN DE VENTAS ****");
        for (int i = 0; i < contadorVentas; i++) {
            if (ventas[i] != null) {
                Venta venta = ventas[i];
               System.out.println("ID VENTA: " + venta.idVenta );
               System.out.println("ID CLIENTE: " + venta.cliente.idCliente);
               System.out.println("DESCUENTO: " + venta.tipoDescuento);
               System.out.println("ASIENTO N*: " + venta.entrada.numeroAsiento);
               System.out.println("TIPO ENTRADA: " + venta.entrada.tipoEntrada);
               System.out.println("PRECIO FINAL: $" + venta.precioFinal);
               System.out.println("***************************");
            }
        }
    }
    
   
    
}
