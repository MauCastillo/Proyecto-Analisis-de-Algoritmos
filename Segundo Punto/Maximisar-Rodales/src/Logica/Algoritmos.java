/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * En esta Clase esta diseñada para la implementacion de los algoritmos no para
 * la resolucion de los problemas.
 *
 * @author Soporte
 */
public class Algoritmos {

    private ArrayList<Rodales> salidaMersort = new ArrayList<>();

    public ArrayList<Rodales> getSalidaMersort() {
        return salidaMersort;
    }
    /* Este algoritmo de ordenamieto tiene una complejida de O(n) */
    /**
     * Counting Sort function de ordenamieto de arboles adaptada Mauro Castillo
     * Este algoritmo lo hize basado en el webSite
     * http://www.sanfoundry.com/java-program-implement-counting-sort/
     *
     *
     * @param entrada
     */
    /*InsertionSort  Implementado para rodales partiendo de la caracteristica numero arboles*/
    
    public ArrayList<Rodales> InsertionSort(ArrayList<Rodales> entrada) {
        ArrayList<Rodales> temporal = entrada;
        Rodales key = new Rodales();
        temporal.add(0, key);

        int i = 0;
        for (int j = 0; j < temporal.size(); j++) {
            key = temporal.get(j);
            i = j - 1;

            while (i > 0 && (temporal.get(i).fecha_fin.compareTo(key.fecha_fin) > 0)) {
                temporal.set(i + 1, temporal.get(i));
                i -= 1;
            }
            temporal.set(i + 1, key);
        }
        temporal.remove(0);
        return temporal;
    }

    public ArrayList <Rodales> mergeSort(ArrayList<Rodales> a) {
        ArrayList<Rodales> tmpArray = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            tmpArray.add(a.get(i));
        }
        mergeSort(a, tmpArray, 0, a.size() - 1);
        return salidaMersort;
    }

    private void mergeSort(ArrayList<Rodales> a, ArrayList<Rodales> tmpArray,
            int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private void merge(ArrayList<Rodales> a, ArrayList<Rodales> tmpArray,
            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a.get(leftPos).compareTo(a.get(rightPos)) <= 0) {
                tmpArray.set(tmpPos++, a.get(leftPos++));
            } else {
                tmpArray.set(tmpPos++, a.get(rightPos++));
            }
        }

        while (leftPos <= leftEnd) // Copy rest of first half
        {
            tmpArray.set(tmpPos++, a.get(leftPos++));
        }

        while (rightPos <= rightEnd) // Copy rest of right half
        {
            tmpArray.set(tmpPos++, a.get(rightPos++));
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a.set(rightEnd, tmpArray.get(rightEnd));
        }
        salidaMersort = a;
        
    }
    
}
