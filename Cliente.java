package com.mycompany.moroteatro;

public class Cliente {
    
    int idCliente;
    String tipoCliente; // DEFINIR SI ES (ESTUDIANTE/ADULTO MAYOR/GENERAL)

    //CONSTRUCTOR
    public Cliente(int idCliente, String tipoCliente) {
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
    }
    
}
