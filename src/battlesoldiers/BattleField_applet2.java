/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

import java.applet.Applet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author gcDataTechnology
 */
public class BattleField_applet2 extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
     private JTextField[] txtSoldierAttributes;
        private String[] text={"Team", "Rank", "Name", "Health", "Strength", 
            "Speed","Defense", "Resources"};
        
    public void init() {
        // TODO start asynchronous download of heavy resources
        
        //BattleSoldiers.class(player.health);
        
      // commenting out -- removed public soldier from BattleSoldier   
      /*  String[] roleCall=battlesoldiers.BattleSoldiers.player.soundOff(true);
            setLayout(new FlowLayout());
            
            txtSoldierAttributes= new JTextField[25];
            for(int i=0;i<Integer.parseInt(roleCall[24]);i++){
                if(!roleCall[i].equals("")){
                    txtSoldierAttributes[i] = new JTextField(roleCall[i],12);
                    add(txtSoldierAttributes[i]);
                }
               
                
            }
       */
        
    }
        // TODO overwrite start(), stop() and destroy() methods
 }
