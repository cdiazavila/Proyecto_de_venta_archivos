/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controllerReporte implements ActionListener, MouseListener{

   private viewReporte vistaR;

    public controllerReporte( viewReporte vistaR) {
       
        this.vistaR = vistaR;
        
        
        
       this.vistaR.jmenuVentas.addMouseListener(this);
       this.vistaR.jmenuRegistrarP.addMouseListener(this);
    }
   
    public void IniciarR (){
        vistaR.setLocationRelativeTo(null);
        vistaR.setTitle("Vista Reporte");
        this.MostrarListaVentas();
    
}
     public void   MostrarListaVentas() {
        DefaultTableModel modelTable = new DefaultTableModel();
        vistaR.tabla.setModel(modelTable);
        modelTable.addColumn("Nombre Producto");
        modelTable.addColumn("Cantidad");
        modelTable.addColumn("Precio");
        modelTable.addColumn("Total");
        modelTable.addColumn("Fecha");
        Object Columna[]=new Object[4];
       vistaR.tabla.setModel(modelTable);
       
       String nmbreP;
       int cantidad;
       float precio;
       float total;
       String fecha;
       float ingreso = 0;
       Scanner linea=null;
       File  Archivo = new File("venta.txt");
       try{
           linea = new Scanner(Archivo);
           while(linea.hasNextLine()){
               nmbreP=linea.nextLine();
               cantidad=Integer.parseInt(linea.nextLine());
               precio = Float.parseFloat(linea.nextLine());
               total = Float.parseFloat(linea.nextLine());
               fecha=linea.nextLine();
               modelTable.addRow(new Object[]{nmbreP,cantidad,precio,total,fecha});
             ingreso=ingreso+total;
             
           }
           vistaR.labelingreso.setText(String.valueOf(ingreso));
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error");
       }
 
    }
       
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if(e.getSource()==vistaR.jmenuVentas){
          view vista = new view();
          controllerVenta control = new controllerVenta( vista);
          control.Inicar();
          vista.setVisible(true);
          vistaR.setVisible(false);
          }
           if(e.getSource()==vistaR.jmenuRegistrarP){
           viewRegistroProductos vistaP=new viewRegistroProductos();
  
            controllerProducto control= new controllerProducto(vistaP);
            control.InicarVistaP();
            vistaP.setVisible(true);
            vistaR.setVisible(false);
       }
    }

    
    
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}
