
package CLASES;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

 class archivo {
  File Archivo;
 PrintWriter linea;
 FileWriter escribir;   
 String nom,f ;
 float p,t;
 int cantidad;
 public archivo(){
     nom=f="";
     p=t=0;
     cantidad=0;
     Archivo = new File("venta.txt");
     
 }
  public void escribir(String nombre, float precio,int c,float total,String fecha){
      if (!Archivo.exists())
      {
          try {
            Archivo.createNewFile();
            cantidad=c;
            nom=nombre;
            p=precio;
            t=total;
            f=fecha;
              escribir= new FileWriter(Archivo,true);
              linea=new PrintWriter(escribir);
              // escribir en el archivo linea por linea 
              linea.println(nom);
              linea.println(cantidad); 
              linea.println(p);
              linea.println(t);
              linea.println(f); 
                linea.close();
                escribir.close();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }
      }else {
          try{
           cantidad=c;
            nom=nombre;
            p=precio;
            t=total;
            f=fecha;
              escribir= new FileWriter(Archivo,true);
              linea=new PrintWriter(escribir);
              // escribir en el archivo linea por linea 
              linea.println(nom);
              linea.println(cantidad); 
              linea.println(p);
              linea.println(t);
              linea.println(f); 
                linea.close();
                escribir.close();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,e);
          }   
      }
  }
 
}
