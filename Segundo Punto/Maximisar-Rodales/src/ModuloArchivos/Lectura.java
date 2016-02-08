/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloArchivos;

import Logica.Rodales;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Soporte
 */
public class Lectura {

    int id;
    int numero_arboles;
    int costo_estimado;
    /* El Formato defido para las fecha como string es "12/05/2013" */
    String fecha_inicio;
    String fecha_fin;
    int numero_empleados;
    public int numero_maximo_arboles;

    public ArrayList<Rodales> ReadFile() {
        numero_maximo_arboles = 0;
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        Rodales rodal;
        ArrayList<Rodales> zonas = new ArrayList<>();

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            archivo = file.getSelectedFile();
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {

                if (contador > 0) {
                    //Esta funcion separa los caracteres presentes en las lineas
                    StringTokenizer tokens = new StringTokenizer(linea);
                    id = Integer.parseInt(tokens.nextToken());
                    numero_arboles = Integer.parseInt(tokens.nextToken());
                    costo_estimado = Integer.parseInt(tokens.nextToken());
                    fecha_inicio = tokens.nextToken();
                    fecha_fin = tokens.nextToken();
                    numero_empleados = Integer.parseInt(tokens.nextToken());
                    rodal = new Rodales(id, numero_arboles, costo_estimado, fecha_inicio, fecha_fin, numero_empleados);
                    zonas.add(rodal);

                    if (numero_arboles > numero_maximo_arboles) {
                        numero_maximo_arboles = numero_arboles;
                    }

                }
                contador += 1;
            }
            br.close();

        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showInputDialog(e + "Error de lectura de archivo");

        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                JOptionPane.showConfirmDialog(null, e2 + "Error de lectura de archivo");
            }
        }
        return zonas;
    }

}
