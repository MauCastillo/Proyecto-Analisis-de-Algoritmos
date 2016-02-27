/*
 Construccion del Punto 4
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
        funcionalidades.umbral = lectura.getUmbral();

//Ordeno el arreglo con el algoritmo mergeSort Complejida  O(nlogn)
            ArrayList<Rodal> MergeOut = (ArrayList<Rodal>) ordenamieto.mergeSort(c, 0).clone();
            ArrayList<Rodal> MergeOut_arboles = (ArrayList<Rodal>) ordenamieto.mergeSort(c, 1).clone();
            
        
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
        funcionalidades.ImprimirArchivo(funcionalidades.mayorNumeroArboles);
    }

}
