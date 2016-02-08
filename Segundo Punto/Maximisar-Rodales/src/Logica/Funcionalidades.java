/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import ModuloArchivos.Escritura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Soporte
 */
public class Funcionalidades {

    SimpleDateFormat cambio_Formato_Fecha = new SimpleDateFormat("dd/MM/yyyy");
    Rodales inicial_Rodal = new Rodales();
    ArrayList<Rodales> Solucion = new ArrayList<>();

    public ArrayList<Rodales> MaximoNumeroRodales(ArrayList<Rodales> entrada) {
        inicial_Rodal = entrada.get(0);
        Solucion.add(inicial_Rodal);

        //Este algoritmo resuel el problema del maximo numero de rodales permitido    
        for (int i = 1; i < entrada.size(); i++) {
            Date date1 = Solucion.get(Solucion.size() - 1).fecha_fin;
            Date date2 = entrada.get(i).fecha_inicio;

            if (!date2.before(date1)) {
                Solucion.add(entrada.get(i));
                System.out.println(" Date1 " + cambio_Formato_Fecha.format(date1) + " Date2 " + cambio_Formato_Fecha.format(date2));
            }
        }
        return Solucion;
    }

    public void ImprimirPantalla(ArrayList<Rodales> entrada_arraylist) {

        ArrayList<Rodales> c = entrada_arraylist;
        for (Rodales c1 : c) {
            System.out.println("-- Imprimir --");
            System.out.println("Id " + c1.getId());
            System.out.println("Numero de Arboles " + c1.getNumero_arboles());
            System.out.println("Costo " + c1.getCosto_estimado());
            System.out.println("Inicio fecha " + cambio_Formato_Fecha.format(c1.getFecha_inicio()));
            System.out.println("Fin fecha " + cambio_Formato_Fecha.format(c1.getFecha_fin()));
            System.out.println("Numero empleados " + c1.getNumero_empleados());
        }

    }

    public void ImprimirArchivo(ArrayList<Rodales> entrada_arraylist) {
        Escritura escritura = new Escritura();
        ArrayList<Rodales> c = entrada_arraylist;
        escritura.setAddelement(c.size());
        for (int i = 0; i < c.size(); i++) {
            escritura.setAddelement("id: " + entrada_arraylist.get(i).id);
        }
        escritura.setArchivoWrite();
    }
}
