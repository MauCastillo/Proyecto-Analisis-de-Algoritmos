/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloArchivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Pandiriwii
 */
public class Escritura {
        private File addreSaveFile;
    private ArrayList<String> arraytexto = new ArrayList<>();

    public Escritura (){
        JOptionPane.showMessageDialog(null, "Es necesario declara un \n directorio de salida ", "Crear Carpeta de salida", 1);
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.showSaveDialog(null);
        addreSaveFile = file.getSelectedFile();
    }

    public void setArchivoWrite()
    { 
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
        JOptionPane.showMessageDialog(null,"Archivo guardado Correctamente","¡Felicidades!",1);
    }

    public void setAddelement(String texto) {
        arraytexto.add(texto);
    }

    public void setAddelement(int texto) {
        String number = "" + texto;
        arraytexto.add(number);
    }
}
