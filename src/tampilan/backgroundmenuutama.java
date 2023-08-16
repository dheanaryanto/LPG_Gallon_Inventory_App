/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class backgroundmenuutama extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
//        Graphics2D graphics = (Graphics2D) g.create();        
        Image img = new ImageIcon(getClass().getResource("/gambar/MenuUtama2.png")).getImage();
//        graphics.drawImage(img, 0, 0, 1920, 1025, null);
//        graphics.dispose();        
        g.drawImage(img, 0, 0, 1920, 1025, null);
    }
    
}
