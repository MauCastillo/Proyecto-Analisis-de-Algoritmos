/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Pandiriwii
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String input = JOptionPane.showInputDialog(null,"Escriva el numero de registros para generar"); /*Ingrese el Numero de registro Que desea Obtener Para la Pruebas mas el valor de 1*/ 
        Random na = new Random(3);
        int Numeros_Registro = Integer.parseInt(input)+1;
              
        Random ct = new Random(1);
        Random ne = new Random(8);
        ArrayList<String> salida = new ArrayList<>();

        int numero = 0;
        Random aleatorio;
        aleatorio = new Random();

        Calendar unaFecha = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        int contador = 0;
        int nu = Numeros_Registro - 1;
        salida.add("" + nu);
        while (contador < Numeros_Registro) {
            unaFecha.set(aleatorio.nextInt(2) + 2016, aleatorio.nextInt(12) + 1, aleatorio.nextInt(30) + 1);
            Date date1 = unaFecha.getTime();
            unaFecha.set(aleatorio.nextInt(2) + 2016, aleatorio.nextInt(12) + 1, aleatorio.nextInt(30) + 1);
            Date date2 = unaFecha.getTime();
            if (date1.before(date2)) {
                String entrada = contador + " " + na.nextInt(3)+20 + " " + ct.nextInt(3)+25 + " " + sdf.format(date1) + " " + sdf.format(date2) + " " + ne.nextInt(4)+30;
                salida.add(entrada);
                contador++;
            }

        }
        setArchivoWrite(salida);

    }

    public static void setArchivoWrite(ArrayList<String> arraytexto) {
        File addreSaveFile;

        JOptionPane.showMessageDialog(null, "Es necesario declara un \n directorio de salida ", "Crear Carpeta de salida", 1);
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.showSaveDialog(null);

        addreSaveFile = file.getSelectedFile();
        /*Realiza la escritura en un archivo plano*/
        FileWriter fichero = null;
        PrintWriter pw = null;
        int size = arraytexto.size();
        try {
            fichero = new FileWriter(addreSaveFile, true);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < size; i++) {
                pw.println(arraytexto.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Archivo guardado Correctamente", "¡Felicidades!", 1);
    }
}
