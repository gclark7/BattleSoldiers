/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author gcDataTechnology
 */
public class BattleField_applet extends JApplet{
    
     //testing JApplet
        //trying to build GUI
        private JTextField[] txtSoldierAttributes;
        private String[] text={"Team", "Rank", "Team", "Health", "Strength", 
            "Speed","Defense", "Resources"};
        
        public void init(){
            setLayout(new FlowLayout());
            
            txtSoldierAttributes= new JTextField[8];
            for(int i=0;i<txtSoldierAttributes.length;i++){
                txtSoldierAttributes[i] = new JTextField(text[i],25);
                add(txtSoldierAttributes[i]);
            }
            
        }
        
    
}
