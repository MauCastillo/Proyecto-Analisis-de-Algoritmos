/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import Logica.Algoritmos;
import Logica.Rodales;
import ModuloArchivos.Lectura;
import java.util.ArrayList;
import Logica.Funcionalidades;

/**
 * Este Proyecto no cumple con las especificaciones del paradigma orientado a
 * objetos Se puede encontrar cosas incomprensibles para otros programadores.
 *
 * @author Soporte
 */
public class ProyectoAlgoritmos {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {

        Lectura lectura = new Lectura();
        Algoritmos ordenamieto = new Algoritmos();
        Funcionalidades funcionalidades = new Funcionalidades();
        int numero_maximo = 1000;
        /*Eliminar prueba de lectura posteriormente*/
        ArrayList<Rodales> c = lectura.ReadFile();
        long time_start, time_end;
        time_start = System.currentTimeMillis();

        ArrayList<Rodales> MergeOut = ordenamieto.mergeSort(c);
        MergeOut = (funcionalidades.MaximoNumeroRodales(MergeOut)); //Calculo es costo de tiempo del algoritmo//
        time_end = System.currentTimeMillis();
        funcionalidades.ImprimirArchivo(MergeOut);

        System.out.println("the task has taken " + (time_end - time_start) + " milliseconds");
    }

}
