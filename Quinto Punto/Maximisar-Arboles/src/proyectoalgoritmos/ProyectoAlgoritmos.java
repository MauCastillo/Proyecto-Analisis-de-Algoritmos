/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmos;

import Logica.Algoritmos;
import Logica.Rodal;
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
        ArrayList<Rodal> c = lectura.ReadFile();

//Ordeno el arreglo con el algoritmo mergeSort Complejida  O(nlogn)
        ArrayList<Rodal> MergeOut = (ArrayList<Rodal>) ordenamieto.mergeSort(c, 0).clone();
        ArrayList<Rodal> MergeOut_arboles = (ArrayList<Rodal>) ordenamieto.mergeSort(c, 1).clone();
        /*En esta parte agregao los umbrales estraidos del archivo plano a la funcion*/
        funcionalidades.umbralArboles = lectura.getUmbral();
        funcionalidades.umbralEmpleados = lectura.getUmbralEmpleados();

        /*La complejida Total de este ciclo es de O(n^2) porque al relizar la llamada a las funciones
         MaximoNumeroRodales(i); 
         MaximoNumeroRodalesReverse(i);
         Cada una de ellas Posee una Complejida de O(n)
         */
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        for (int i = 0; i < MergeOut.size(); i++) {
            /*Casos Base*/
            funcionalidades.entrada = MergeOut;
            funcionalidades.Solucion.clear();
            funcionalidades.MaximoNumeroRodales(i); //
            funcionalidades.MaximoNumeroRodalesReverse(i);
            /*Probar el mayor beneficio*/
            funcionalidades.Probar();
            /*Posibilidades alternas*/
            funcionalidades.entrada = MergeOut_arboles;
            funcionalidades.Solucion.clear();
            funcionalidades.MaximoNumeroRodales(i); //
            funcionalidades.MaximoNumeroRodalesReverse(i);
            /*Probar el mayor beneficio*/
            funcionalidades.Probar();
        }
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken " + (time_end - time_start) + " milliseconds");
        funcionalidades.ImprimirArchivo(funcionalidades.MayorNumeroArboles);

    }

}
