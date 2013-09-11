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
public class HUD extends JFrame{
    Soldier player;
    String[] atck,dfnd,cmnd,info,vitals;
    final int WIDTH=500;
    final int HEIGHT=250;
    JPanel infoPanel=new JPanel();
    JPanel vitalPanel=new JPanel();
    JPanel cmndPanel=new JPanel();
    JPanel atckPanel=new JPanel();
    JPanel dfndPanel=new JPanel();
    JLabel lbl;
    JButton btn;
    ImageIcon image;
    int passPoints;
    Color clr;
    
    //constructor
    public HUD(Soldier player){
         super("HUD Control");
         this.player=player;
         setSize(WIDTH,HEIGHT);
         setLayout(new BorderLayout(5,10));
         //clr=(Color)player.team.toString();

         
        
         infoPanel.setLayout(new GridLayout(1,4));
         //attempting to color background according to team color
         //infoPanel.setForeground(clr);
         infoPanel.setBorder(BorderFactory.createTitledBorder("PLAYER INFO"));
         info=player.getInfo();
         for(int i=0;i<info.length-1;i++){
             lbl=new JLabel(info[i]);
             lbl.setName("lblInfo" +i);
             infoPanel.add(lbl);
         }
         lbl=new JLabel("");
         image = new ImageIcon(info[3]);
         lbl.setIcon(image);
         //lbl.setSize(50, 50);
         infoPanel.add(lbl);
         add(infoPanel,BorderLayout.NORTH);
         
        vitalPanel.setLayout(new GridLayout(7,2));
         vitalPanel.setBorder(BorderFactory.createTitledBorder("VITALS"));
         vitals=player.getVitals();
         for(int i=0;i<vitals.length;i++){
             lbl=new JLabel(vitals[i]);
             lbl.setName("lblVitals"+i);
             vitalPanel.add(lbl);
         }
        
         add(vitalPanel,BorderLayout.WEST);
         
         atckPanel.setLayout(new GridLayout(5,1));
         atckPanel.setBorder(BorderFactory.createTitledBorder("ATTACKS"));
         atck=player.getAttack();
         for(int i=0;i<atck.length;i++){
             btn=new JButton(atck[i]);
             btn.setName("cmdAttack" + i);
             atckPanel.add(btn);
         }
         add(atckPanel,BorderLayout.CENTER);
         
         dfndPanel.setLayout(new GridLayout(5,1));
         dfndPanel.setBorder(BorderFactory.createTitledBorder("DEFEND"));
         dfnd=player.getDefend();
         for(int i=0;i<dfnd.length;i++){
             btn=new JButton(dfnd[i]);
             btn.setName("cmdDefend" + i);
             dfndPanel.add(btn);
         }
         add(dfndPanel,BorderLayout.EAST);
         
         cmndPanel.setLayout(new GridLayout(1,5));
         cmndPanel.setBorder(BorderFactory.createTitledBorder("COMMAND SUBORDINATES"));
         cmnd=player.getCommand();
         for(int i=0;i<cmnd.length;i++){
             btn=new JButton(cmnd[i]);
             btn.setName("cmdCommand" + i);
             cmndPanel.add(btn);
         }
         add(cmndPanel,BorderLayout.SOUTH);
         
         pack();
         setVisible(true);
         
         
    }
    
    public void refreshHUD(Soldier player){
       //tried to loop through components to find labels and such
        //Component[] s;
       // System.out.println("refreshHUD");
        
      infoPanel.removeAll();
      atckPanel.removeAll();
      dfndPanel.removeAll();
      cmndPanel.removeAll();
      vitalPanel.removeAll();
      
        infoPanel.setLayout(new GridLayout(1,3));
        infoPanel.setBorder(BorderFactory.createTitledBorder("PLAYER INFO"));
         info=player.getInfo();
         for(int i=0;i<info.length-1;i++){
             lbl=new JLabel(info[i]);
             lbl.setName("lblInfo" +i);
             infoPanel.add(lbl);
         }
         lbl=new JLabel("");
         image = new ImageIcon(info[3]);
         lbl.setIcon(image);
         //lbl.setSize(50, 50);
         infoPanel.add(lbl);
         add(infoPanel,BorderLayout.NORTH);
         
        vitalPanel.setLayout(new GridLayout(7,2));
         vitalPanel.setBorder(BorderFactory.createTitledBorder("VITALS"));
         vitals=player.getVitals();
         for(int i=0;i<vitals.length;i++){
             lbl=new JLabel(vitals[i]);
             lbl.setName("lblVitals"+i);
             vitalPanel.add(lbl);
         }
        
         add(vitalPanel,BorderLayout.WEST);
        
      
         atckPanel.setLayout(new GridLayout(5,1));
         atckPanel.setBorder(BorderFactory.createTitledBorder("ATTACKS"));
         atck=player.getAttack();
         for(int i=0;i<atck.length;i++){
             btn=new JButton(atck[i]);
             btn.setName("cmdAttack" + i);
             atckPanel.add(btn);
         }
         add(atckPanel,BorderLayout.CENTER);
         
         dfndPanel.setLayout(new GridLayout(5,1));
         dfndPanel.setBorder(BorderFactory.createTitledBorder("DEFEND"));
         dfnd=player.getDefend();
         for(int i=0;i<dfnd.length;i++){
             btn=new JButton(dfnd[i]);
             btn.setName("cmdDefend" + i);
             btn.addActionListener(new RankUp());
             dfndPanel.add(btn);
         }
         add(dfndPanel,BorderLayout.EAST);
         
         cmndPanel.setLayout(new GridLayout(1,5));
         cmndPanel.setBorder(BorderFactory.createTitledBorder("COMMAND SUBORDINATES"));
         cmnd=player.getCommand();
         for(int i=0;i<cmnd.length;i++){
             btn=new JButton(cmnd[i]);
             btn.setName("cmdCommand" + i);
             btn.addActionListener(new RankUp());
             cmndPanel.add(btn);
         }
         add(cmndPanel,BorderLayout.SOUTH);
         
         super.pack();
         super.setVisible(true);
         super.revalidate();
         super.repaint();
    }
   
     private class RankUp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                 //test rank up
             //provide a way to test rank up
            //not working here...moving back to driver
            System.out.println("PressedButtonRANKUP");
        player.setRankUP(50000);
            System.out.println(player.rankUP);
        
       /* if(player.checkRank()){
            switch (player.nextRank()){
                case "Private" : passPoints=player.passPoints();
                    player=new RankPrivate(player.name, player.team, passPoints);
                    break;
                case "Sergeant" : passPoints=player.passPoints();
                    player=new RankSergeant(player.name, player.team);
                     break;
                case "Colonel" : passPoints=player.passPoints();
                    player=new RankColonel(player.name, player.team);
                     break;
                case "General" : passPoints=player.passPoints();
                    player=new RankGeneral(player.name, player.team);
                     break;
                    
                default:player=new RankPrivate(player.name, player.team, passPoints);
              } 
            
            //refresh HUD//didnt work?? not sure now to call lables and setText();
           /* playerHUD.refreshHUD();
             playerHUD.revalidate();
            playerHUD.repaint();
            */
            
            /*
              refreshHUD(player);
           
          }
          */
        }
    }
   
    
}
