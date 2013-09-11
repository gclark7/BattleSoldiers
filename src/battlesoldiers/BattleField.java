/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author gcDataTechnology
 */


//defines the battle field
public class BattleField extends JFrame{
   // JFrame battleField= new JFrame("Battle Field"); place in driver class
    JPanel battlePanel; 
    JLabel battleLabel;
    JButton battleButton;
    final int bHeight=500;
    final int bWidth=600;

    //constructor
    public BattleField() {
        super("Battle Field Class Instance");
        setSize(bWidth,bHeight);
        
        battleButton= new JButton("Remove ME");
        battleButton.addActionListener(new RemoveME());
        battlePanel= new JPanel();
        battlePanel.add(battleButton);
        
        add(battlePanel);
        setVisible(true);
        
    }
        
    
    
    /*
    battleField.setSize(bWidth,bHeight);//Much prefer to get dynamic % from user device
    battleField.setLocation(200,300);
    battleField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    battleField.setVisible(true);
    */
    //constructor
    
    public void levelOne(){
        int I=1;
        battleLabel=new JLabel("here I am");
        battlePanel.add(battleLabel);
        //battleLabel.Visible(true);
        battleLabel.setText("Changed Text");
               GameON(I);//not sure what to do yet, build map then start or what??
    }
    
    //button listeners
    private class RemoveME implements ActionListener{
        public void actionPerformed(ActionEvent e){
            battlePanel.remove(battleButton);
            battlePanel.revalidate();
            battlePanel.repaint();
        }
    }
    
    
    
    public void GameON(int x){
        //runs the level
        switch (x){
            case 1: x=x+1; break;
            default: x++;
        }
    }
    
}
