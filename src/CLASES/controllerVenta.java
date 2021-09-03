
package CLASES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class controllerVenta implements ActionListener, MouseListener {
          
              private view vista;
             

    public controllerVenta( view vista) {
       
        this.vista = vista;
        
        this.vista.btnenviar.addActionListener(this);
        this.vista.bntcancelar.addActionListener(this);
        
        // botones de addmouseListener
         this.vista.menuIrreporte.addMouseListener(this);
         this.vista.registroP.addMouseListener(this);
    }
     
    
    public void Inicar() {
        vista.setLocationRelativeTo(null);
        vista.setTitle("Venta");
        crearCombox();
      
    } 
    
    public void GuardarDatos(){
       String nombre= vista.comboProductos.getSelectedItem().toString();
        float precio = Float.parseFloat(vista.txtprecio.getText());
        int cantidad= Integer.parseInt( vista.txtcant.getText());
        float total=precio*cantidad;
        vista.txttotal.setText(String.valueOf(total));
        vista.txttotal.setEditable(false);
      
          Calendar c1 = Calendar.getInstance();
         String  dia = Integer.toString(c1.get(Calendar.DATE));
          String  mes = Integer.toString(c1.get(Calendar.MONTH));
          String  anio = Integer.toString(c1.get(Calendar.YEAR));
          String fecha = dia+"/"+(mes+1)+"/"+anio;
          
       archivo ar = new archivo();
       
       ar.escribir(nombre, precio, cantidad, total,fecha);
       JOptionPane.showMessageDialog(null,"La venta se realizo Correctamente","EXITOS!",
                JOptionPane.INFORMATION_MESSAGE);
     
       
    }
 
    public void crearCombox(){
        // Creacion del JComboBox y añadir los items.
             String nombreP;
            
       Scanner linea=null;
       File  ArchivoP = new File("productos.txt");
       try{
           linea = new Scanner(ArchivoP);
           while(linea.hasNextLine()){
               nombreP=linea.nextLine();
               
              
		vista.comboProductos.addItem(nombreP);
		
               
           }
         
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error");
       }
 
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==vista.btnenviar){
          this.GuardarDatos();
      }
      
       if(e.getSource()==vista.bntcancelar){
          vista.txtcant.setText("");
          vista.txtprecio.setText("");
          vista.txttotal.setText("");
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource()==vista.menuIrreporte){
           viewReporte vistaR = new viewReporte();
  
            controllerReporte repor= new controllerReporte(vistaR);
             repor.IniciarR();
            vistaR.setVisible(true);
            vista.setVisible(false);
       }
       
        if(e.getSource()==vista.registroP){
           viewRegistroProductos vistaP=new viewRegistroProductos();
  
            controllerProducto control= new controllerProducto(vistaP);
            control.InicarVistaP();
            vistaP.setVisible(true);
            vista.setVisible(false);
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
