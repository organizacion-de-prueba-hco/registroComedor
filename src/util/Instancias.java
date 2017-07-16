
package util;

import javax.swing.JDialog;
import win.winInfo;

/**
 *
 * @author Jhon
 */
public class Instancias {
    public static JDialog instancia;

    public Instancias() {
    }
    
    public static synchronized JDialog getInstancias(){
        if (instancia==null) {
            instancia = new winInfo(null, true);
        }
        return instancia;
    }
}
