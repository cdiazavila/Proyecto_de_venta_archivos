
package CLASES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class controllerProducto implements ActionListener, MouseListener {
       private viewRegistroProductos vistaP;

    public controllerProducto(viewRegistroProductos vistaP) {
        this.vistaP = vistaP;
        
        //activamos el evento click para cada boton 
        this.vistaP.btnenviar.addActionListener(this);
        this.vistaP.bntcancelar.addActionListener(this);
         
        this.vistaP.jMenuReporte.addMouseListener(this);
        this.vistaP.jmenuventa.addMouseListener(this);
    }
       
    
      public void InicarVistaP() {
        vistaP.setLocationRelativeTo(null);
        vistaP.setTitle("Registro de Productos"); 
    } 
    
      public void GuardarDatosProductos(){
       String nombre = vistaP.txtnombreP.getText();
        float precio = Float.parseFloat(vistaP.txtPrecio.getText());
        int cantidad= Integer.parseInt( vistaP.txtCANT.getText());
    
       

          
       producto p = new producto();
   
       p.escribir(nombre, precio, cantidad);
       JOptionPane.showMessageDialog(null,"SU REGISTRO FUE EXITOSO","EXITOS!",
                JOptionPane.INFORMATION_MESSAGE);
     
       
    }
    
    public void limpiar(){
        vistaP.txtnombreP.setText("");
         vistaP.txtCANT.setText("");
          vistaP.txtPrecio.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==vistaP.btnenviar){
         GuardarDatosProductos();
     }
     
     if(e.getSource()==vistaP.bntcancelar){
         limpiar();
     }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource()==vistaP.jmenuventa){
           
          view vista = new view();
          controllerVenta control = new controllerVenta( vista);
          control.Inicar();
          vista.setVisible(true);
          vistaP.setVisible(false);
          
       }
       
          if(e.getSource()==vistaP.jMenuReporte){
           viewReporte vistaR = new viewReporte();
  
            controllerReporte repor= new controllerReporte(vistaR);
             repor.IniciarR();
            vistaR.setVisible(true);
            vistaP.setVisible(false);
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
