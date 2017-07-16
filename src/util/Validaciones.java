package util;

import java.awt.Component;
import javax.swing.*;
import org.edisoncor.gui.textField.TextFieldRectBackground;

public class Validaciones extends JFrame{
    
    public boolean verificarjTextField(JPanel panel){
     JTextField txt=new JTextField();
     for (Component comp : panel.getComponents()) {
         if (comp.getClass().getName().equals(txt.getClass().getName())) {
           txt=(JTextField) comp;  
             if (txt.getText().isEmpty()) {                 
                 mensaje("Debe rellenar todos los campos",JOptionPane.INFORMATION_MESSAGE);return false;
             }
         }
     }
     return true;
   }
 
 public void limpiarjTextField(JPanel panel){
     TextFieldRectBackground txtb = new TextFieldRectBackground();
     for (Component c : panel.getComponents()) {
         if (c.getClass().getName().equals(txtb.getClass().getName())) {
             txtb = (TextFieldRectBackground) c;
             txtb.setText("");
         }
     }
 }
 public void mensaje(String texto,int msm){
  JOptionPane.showMessageDialog(null, texto,"Mensaje",msm);
} 
}
