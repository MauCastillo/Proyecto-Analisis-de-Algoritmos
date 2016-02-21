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
import javax.swing.JOptionPane;

/**
 *
 * @author Soporte
 */
public class Funcionalidades {

    int maximoNumeroArboles = 0;
    int tmpNumeroArboles = 0;
    int tmpcosto = 0;
    int costo = 0;
    public int umbral = 0;
    public ArrayList<Rodales> entrada = new ArrayList<>();
    public ArrayList<Rodales> mayorNumeroArboles = new ArrayList<>();
    public ArrayList<Rodales> mayorNumeroArbolesTemporal = new ArrayList<>();
    SimpleDateFormat cambio_Formato_Fecha = new SimpleDateFormat("dd/MM/yyyy");
    Rodales inicial_Rodal = new Rodales();
    public ArrayList<Rodales> Solucion = new ArrayList<>();

    /*Complejida O(n)
     Esta funcion se para en en un punto compara sino se solapa el rodal con los demas elementos del arreglo*/
    public ArrayList<Rodales> MaximoNumeroRodales(int inicio) {
        int test = 0;
        if (umbral > entrada.get(inicio).numero_arboles) {
            Solucion.add(entrada.get(inicio));
            umbral -= entrada.get(inicio).numero_arboles;
        }
        for (int i = inicio; i < entrada.size(); i++) {
            Date date1 = Solucion.get(Solucion.size() - 1).fecha_fin;
            Date date2 = entrada.get(i).fecha_inicio;

            if (!date2.before(date1)) {
                test = umbral -= entrada.get(i).numero_arboles;
                if (test >= 0) {
                    Solucion.add(entrada.get(i));
                }
            } else {
                int beneficio_anterior = Solucion.get(Solucion.size() - 1).numero_arboles;
                int beneficio_presente = Solucion.get(i).numero_arboles;
                if (beneficio_anterior < beneficio_presente) {
                    Solucion.remove(i - 1);
                    Solucion.add(Solucion.get(i));
                }
            }
        }
        ImprimirPantalla(Solucion);
        return Solucion;
    }

    /*Complejida O(n)
     Esta funcion separa en un punto del arreglo que identifique com la varieable inicio y compara si no se solapa con todos los elementos anteriores 
     a el*/
    /*
     public ArrayList<Rodales> MaximoNumeroRodalesReverse(int inicio) {
     int punto = inicio - 1;
     System.out.println("Punto " + punto + " entrada " + entrada.size());
     ArrayList<Rodales> salida = new ArrayList<>();
     //entrada.
     //Este algoritmo resuel el problema del maximo numero de rodales permitido
     int contador = 1;
     for (int i = punto; i > 0; i--) {
     Date date1 = entrada.get(entrada.size() - contador).fecha_inicio;
     Date date2 = entrada.get(i).fecha_fin;

     if (date2.before(date1)) {
     salida.add(entrada.get(i));
     tmpNumeroArboles += entrada.get(i).numero_arboles;
     tmpcosto += entrada.get(i).costo_estimado;
     if (!mayorNumeroArbolesTemporal.contains(entrada.get(i))) {
     mayorNumeroArbolesTemporal.add(entrada.get(i));
     }
     contador++;
     System.out.println(" Date1 Fecha donde esto inicio : " + cambio_Formato_Fecha.format(date1) + "  Date2 Fecha donde anterior fin: " + cambio_Formato_Fecha.format(date2));
     }
     }
     return salida;
     }*/
//Complejidad O(1)
    //Realiza las comparacion para saber si esta operacion obtuvo la mayor ganancia en arboles
    //Comparo el valor que ya existe y el nuevo si el nuevo es mayor almaceno el nuevo. de lo contrario lo ignoro
    //Ademas agrego la condicion de el umbral establecido
    public void Probar() {
        if (tmpNumeroArboles > maximoNumeroArboles && tmpcosto <= umbral) {
            maximoNumeroArboles = tmpNumeroArboles;
            costo = tmpcosto;
            try {
                mayorNumeroArboles = (ArrayList<Rodales>) mayorNumeroArbolesTemporal.clone();
            } catch (Exception e) {
                JOptionPane.showInputDialog(this, "Si sale este Mensaja Algo anda Muy Mal ");
            }
            System.out.println("|||||||||||||||||||||| Ganador |||||||||||||| " + maximoNumeroArboles + " Costo " + costo);
        }
        tmpNumeroArboles = 0;
        tmpcosto = 0;
        mayorNumeroArbolesTemporal.clear();

    }

    /*Funcion que imprime en pantalla full HD*/
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
//Imprime el informacion en un archivo plano
//
//    

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
