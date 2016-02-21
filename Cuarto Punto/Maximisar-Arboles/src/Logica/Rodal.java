/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Soporte
 */
public class Rodal implements Comparable<Rodal> {

    public Rodal() {
    }

    //Declaracion 
    int id;
    int numero_arboles;
    int costo_estimado;
    /* El Formato defido para las fecha como string es "12/05/2013" */
    Date fecha_inicio;
    Date fecha_fin;
    int numero_empleados;
    SimpleDateFormat cambio_Formato_Fecha = new SimpleDateFormat("dd/MM/yyyy");

    public Rodal(int id, int numero_arboles, int costo_estimado, String fecha_inicio, String fecha_fin, int numero_empleados) {
        this.id = id;
        this.numero_arboles = numero_arboles;
        this.costo_estimado = costo_estimado;
        this.numero_empleados = numero_empleados;
        /*Realizo la conversion de String a variables de tipo Date*/
        try {
            this.fecha_inicio = cambio_Formato_Fecha.parse(fecha_inicio);
            this.fecha_fin = cambio_Formato_Fecha.parse(fecha_fin);
        } catch (ParseException ex) {
            JOptionPane.showInputDialog(null, "Error en formato de Lectura de fechas", "Error de Lectura", 0);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_arboles() {
        return numero_arboles;
    }

    public void setNumero_arboles(int numero_arboles) {
        this.numero_arboles = numero_arboles;
    }

    public int getCosto_estimado() {
        return costo_estimado;
    }

    public void setCosto_estimado(int costo_estimado) {
        this.costo_estimado = costo_estimado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        try {
            this.fecha_inicio = cambio_Formato_Fecha.parse(fecha_inicio);
        } catch (ParseException ex) {
            JOptionPane.showInputDialog(null, "Error Lectura de Fecha de Inicio ", "Error Rodal Id " + id, 0);
        }
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        try {
            this.fecha_inicio = cambio_Formato_Fecha.parse(fecha_fin);
        } catch (ParseException ex) {
            JOptionPane.showInputDialog(null, "Error Lectura de Fecha de finalizacion ", "Error Rodal Id " + id, 0);
        }
    }

    public int getNumero_empleados() {
        return numero_empleados;
    }

    public void setNumero_empleados(int numero_empleados) {
        this.numero_empleados = numero_empleados;
    }

    @Override
    public int compareTo(Rodal other) {
        return fecha_fin.compareTo(other.fecha_fin);
    }

}
