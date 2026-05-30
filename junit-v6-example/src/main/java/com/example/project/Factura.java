package com.example.project;

import java.time.LocalDate;

/**
 * Clase Factura, representa el documento que se genera al hacer una venta
 */
public class Factura {

    private String codigoFactura;
    private LocalDate fechaEmision;
    private double totalNeto;
    private double totalIva;
    private double totalEnvio;
    private double totalFinal;

    /**
     * Constructor, el codigo de factura se genera automaticamente
     * @param cliente cliente de la factura
     * @param pedido pedido asociado
     * @param totalConDescuento total ya con el descuento aplicado
     */
    public Factura(Cliente cliente, Pedido pedido, double totalConDescuento) {
        this.codigoFactura = cliente.getNombre() + "-" + cliente.getDni() + "-" + LocalDate.now();
        this.fechaEmision = LocalDate.now();
        this.totalNeto = totalConDescuento;
        this.totalIva = totalConDescuento * 0.21;
        this.totalEnvio = totalConDescuento * 0.05;
        this.totalFinal = totalConDescuento + this.totalIva + this.totalEnvio;
    }

    /** @return codigo de la factura */
    public String getCodigoFactura() { 
        return codigoFactura; 
    }
    
    /** @param codigoFactura nuevo codigo */
    public void setCodigoFactura(String codigoFactura) { 
        this.codigoFactura = codigoFactura; 
    }

    /** @return fecha de emision */
    public LocalDate getFechaEmision() { 
        return fechaEmision; 
    }

    /** @param fechaEmision nueva fecha */
    public void setFechaEmision(LocalDate fechaEmision) { 
        this.fechaEmision = fechaEmision; 
    }

    /** @return total neto */
    public double getTotalNeto() { 
        return totalNeto; 
    }

    /** @param totalNeto nuevo total neto */
    public void setTotalNeto(double totalNeto) { 
        this.totalNeto = totalNeto; 
    }

    /** @return total iva */
    public double getTotalIva() { 
        return totalIva; 
    }

    /** @param totalIva nuevo total iva */
    public void setTotalIva(double totalIva) { 
        this.totalIva = totalIva; 
    }

    /** @return total envio */
    public double getTotalEnvio() { 
        return totalEnvio; 
    }

    /** @param totalEnvio nuevo total envio */
    public void setTotalEnvio(double totalEnvio) { 
        this.totalEnvio = totalEnvio; 
    }

    /** @return total final */
    public double getTotalFinal() { 
        return totalFinal; 
    }

    /** @param totalFinal nuevo total final */
    public void setTotalFinal(double totalFinal) { 
        this.totalFinal = totalFinal; 
    }

    /**
     * Imprime el desglose de la factura por consola
     */
    public void imprimirFactura() {
        System.out.println("=== FACTURA ===");
        System.out.println("Codigo: " + codigoFactura);
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("Total neto: " + String.format("%.2f", totalNeto) + "€");
        System.out.println("Total IVA: " + String.format("%.2f", totalIva) + "€");
        System.out.println("Total envio: " + String.format("%.2f", totalEnvio) + "€");
        System.out.println("Total final: " + String.format("%.2f", totalFinal) + "€");
    }
}
