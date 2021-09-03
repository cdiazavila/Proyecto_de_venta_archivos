
package CLASES;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class producto {
 File Archivo;
 PrintWriter linea;
 FileWriter escribir;   
 String nomP;
 float precio;
 int cantidadD;
 public producto(){
    nomP="";
    precio=0;
    cantidadD=0;
     Archivo = new File("productos.txt");
     
 }
 
  public void escribir(String nombre, float p,int c){
      if (!Archivo.exists())
      {
          try {
            Archivo.createNewFile();
            cantidadD=c;
            nomP=nombre;
            precio=p;
              escribir= new FileWriter(Archivo,true);
              linea=new PrintWriter(escribir);
              // escribir en el archivo linea por linea 
              linea.println("\n");
              linea.println(nomP);
               linea.println(precio); 
              linea.println(cantidadD); 
                linea.close();
                escribir.close();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }
      }else {
          try{
           cantidadD=c;
            nomP=nombre;
            precio=p;
              escribir= new FileWriter(Archivo,true);
              linea=new PrintWriter(escribir);
              // escribir en el archivo linea por linea 
              linea.println(nomP);
               linea.println(precio); 
              linea.println(cantidadD); 
              
                linea.close();
                escribir.close();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }   
      }
  }
 
}
