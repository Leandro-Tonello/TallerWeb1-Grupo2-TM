package com.tallerwebi.presentacion;

public class DatosEnvio {
    private String origen;
    private String destino;
    private Long cantBultos;
    private Double peso;
    /* Entiendo que estos campos son de logica de negocio por eso no van:
     *metodoPago
     * precio
     * tiempoEspera
     * */
    public DatosEnvio(){}

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getCantBultos() {
        return cantBultos;
    }

    public void setCantBultos(Long cantBultos) {
        this.cantBultos = cantBultos;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
