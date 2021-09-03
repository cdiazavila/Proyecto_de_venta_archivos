
package CLASES;

public class main {
    
      public static void main(String[] args) {
       
          view vista = new view();
          controllerVenta control = new controllerVenta(vista);
          control.Inicar();
          vista.setVisible(true);
          
          
      }
}
