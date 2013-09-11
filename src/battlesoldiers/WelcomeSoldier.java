/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

/**
 *
 * @author gcDataTechnology
 */
//initial startup window
//intention is to use this to interface with data storage, player retrieval
public class WelcomeSoldier extends JFrame{
     Scanner userInput = new Scanner(System.in);//for testing
    boolean complete=false;
    Soldier player;
    HUD playerHUD;
    final int WIDTH=200;
    final int HEIGHT=200;
    
   
    JPanel welcomePanel;
    JPanel rankPanel;
    JPanel userDataPanel;
    JPanel storyPanel;
    JPanel startPanel;
    
    JLabel lbl;
    JButton btn;
    ImageIcon image;
    String pic;
 
    String[] teamList={"RED","BLUE"};   
    
    JComboBox cmboTeam;
    JTextField txtName;
    
    String playerName;
    Team playerTeam;
    int passPoints;
    
    //constructor
    public WelcomeSoldier(){
        
        super("Battle Soldiers");
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout(5,10));
         
       //create welcome text
        welcomePanel=new JPanel();
        welcomePanel.setLayout(new GridLayout(1,1));
        lbl= new JLabel("Welcome Soldier.  \nYou Aren't Tough Enough To Earn Rank!\n  You Can Try...");
        welcomePanel.add(lbl);
        
         add(welcomePanel,BorderLayout.NORTH);
         
        //create rank icons
        rankPanel=new JPanel();
        rankPanel.setLayout(new GridLayout(1,5));
        lbl= new JLabel("");
        pic="picSoldier.jpg";
        image=new ImageIcon(pic);
        lbl.setIcon(image);
        rankPanel.add(lbl);
        
         lbl= new JLabel("");
        pic="picPrivate.jpg";
        image=new ImageIcon(pic);
        lbl.setIcon(image);
        rankPanel.add(lbl);
        
         lbl= new JLabel("");
        pic="picSergeant.jpg";
        image=new ImageIcon(pic);
        lbl.setIcon(image);
        rankPanel.add(lbl);
        
         lbl= new JLabel("");
        pic="picColonel.jpg";
        image=new ImageIcon(pic);
        lbl.setIcon(image);
        rankPanel.add(lbl);
        
         lbl= new JLabel("");
        pic="picGeneral.jpg";
        image=new ImageIcon(pic);
        lbl.setIcon(image);
        rankPanel.add(lbl);
        
        add(rankPanel,BorderLayout.CENTER);
        
        //user input
         userDataPanel=new JPanel();
         userDataPanel.setLayout(new GridLayout(2,2));
         lbl= new JLabel("What's Your Name, Soldier");
        userDataPanel.add(lbl);
        txtName= new JTextField();
        txtName.setEditable(true);
        txtName.setSize(10,10);
        userDataPanel.add(txtName);
        
         lbl= new JLabel("Choose Your Team");
         userDataPanel.add(lbl);
        cmboTeam= new JComboBox(teamList);
        cmboTeam.setEditable(true);
        cmboTeam.setSize(10,10);
        cmboTeam.addActionListener(new TeamSelection());
        userDataPanel.add(cmboTeam);
        
       add(userDataPanel,BorderLayout.WEST);
       
       storyPanel=new JPanel();
       storyPanel.setLayout(new GridLayout(1,1));
       lbl= new JLabel("You've Been Separated From Your Squad");
       storyPanel.add(lbl);
       lbl=new JLabel("Stay Alive To Build An Elite Army.");
       storyPanel.add(lbl);
       add(storyPanel,BorderLayout.EAST);
       
       startPanel=new JPanel();
       startPanel.setLayout(new GridLayout(1,1));
       btn = new JButton("GO");
       btn.addActionListener(new GO());
       startPanel.add(btn);
       add(startPanel,BorderLayout.SOUTH);
       
       pack();
       setVisible(true);
         
        
        //trying to find classes inside this package
       
        
    }
    
    //getters & Setters
    public void setName(String name){
        playerName=name;
        
    }
    
    public void setTeam(Team team){
        playerTeam=team;
    }
    
    public Team getTeam(){
        return playerTeam;
    }
    
    public String getName(){
        return playerName;
    }
    
    public boolean getComplete(){
        return complete;
    }
    
    public void setComplete(boolean x){
        complete=x;
    }
    
    private class GO implements ActionListener{
        //public String[] GO(){
        @Override
        public void actionPerformed(ActionEvent e){
            //sets playerName & playerTeam
            System.out.println("Clicked GO");
            String x=(String) cmboTeam.getSelectedItem();
            for(Team i:Team.values()){//test user input for proper selection
                if(x.toUpperCase().equals(i.toString())){
                    playerTeam=i;
                    
                }
            }
            
            setName(txtName.getText());
            
            
            setTeam(playerTeam);
            
            //cannot update HUD when we create it here, must go back in driver
            //player= new Soldier(playerName, playerTeam);
            //playerHUD= new HUD(player);
            
            setComplete(true);//using to indicate driver can procede since
            //HUD was not working properly
            System.out.println(getComplete());
        }
    }
    
    private class TeamSelection implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            String x=(String) cmboTeam.getSelectedItem();
            
             for(Team i:Team.values()){//test user input for proper selection
                if(x.toUpperCase().equals(i.toString())){
                    playerTeam=i;
                    
                }
            }
         System.out.println("Combo team Selected: " + x);   
        }
    }
    
   
    
}//close WelcomeSoldier Class
