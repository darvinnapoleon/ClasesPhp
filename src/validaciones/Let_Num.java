/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import java.awt.event.KeyEvent;

/**
 *
 * @author DARVIN
 */
public class Let_Num {

    public void solonum(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }

    public void sololet(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(c < '0' || c > '9')) {
            evt.consume();
        }
    }
    public void numdec(java.awt.event.KeyEvent evt, String tfmi) {
        char k = evt.getKeyChar();

        if (k >= 46 && k <= 57) {
            if (k == 46) {
                String a = tfmi;
                int tama = a.length();
                for (int i = 0; i <= tama; i++) {
                    if (a.contains(".")) {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                    }
                }
            }
            if (k == 47) {
                evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            }
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
        }
    }
    
    
}
