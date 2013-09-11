/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

/**
 *
 * @author gcDataTechnology
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;


public class BattleSoldiers extends JFrame{

    /**
     * @param args the command line arguments
     */
    //testing player availability in applet--no luck yet
    //may need to create player in applet???-- 8-9-2013
    
    //changed Soldier variables to public
    //public static Soldier player=new Soldier("Profile", Team.BLUE);
    //able to run applet from NetBeans, not in HTML
    //able to retreive player.Methods & variables
    
    
    
    //transitioned to window Swing environment -- Building 8-11-2013
        
    public static void main(String[] args) {
        //Creating a window envrionment
       
        //System.out.println("Variables");
        //original cmd environment
        Scanner userInput = new Scanner(System.in);
        // System.out.println("Soldier player;");
        Soldier player;
        boolean ready=false;
        int universalNum=0;//use it for anything-testing number
        String playerName;
        Team playerTeam;
        
                
        
        //Team team[] = Team.values();//moved to WelcomeSoldier
        //Team teamChoice=Team.RED;//moved to WelcomeSoldier
        //boolean tChoice=false;//moved to WelcomeSoldier
        
      //  System.out.println("WelcomeSoldier");
        //starting to separate battle field into own class
        WelcomeSoldier ws; 
                
        HUD playerHUD;
        int passPoints=0;
        
        //original code cmd prompt
      
        
        //System.out.println("Create Player");
        //original
        //player = new Soldier(playerName, teamChoice);
        ws= new WelcomeSoldier();
        
        //wait for welcome to complete
        System.out.println("Wainting for ready");
        //changing to do while
        /*
        while(!ready){
            //just wait for the player to create a profile
            ready=ws.getComplete();
            //System.out.println("Checked ready " + ready);//without this it just seems to keep running
            if(ready){//even this will not stop the loop
                break;
            }
        }//changing to do while
        * */
        
        ready=ws.getComplete();
        do{//no resolve...without sout this just runs...Multi-Thread time?
            universalNum++;
            ready=ws.getComplete();
            System.out.println("ready " + ready + " " + universalNum);
        }while(!ready);
        
        playerName=ws.getName();
        playerTeam=ws.getTeam();
                
         player= new Soldier(playerName, playerTeam);
        
        // System.out.println("make HUD");
         
        
       // System.out.println("Make BattleField");
        BattleField bf = new BattleField();
        bf.levelOne();
        
        //started to build own class
        playerHUD= new HUD(player);//shows new player
        JOptionPane.showMessageDialog(null,"Check out your player profile");
        
        /*//changed a bit to better test ranking...see below
        //provide a way to test rank up
        System.out.println("\nLevel up by entering a number => 1000");
        player.rankUP=Integer.parseInt(userInput.nextLine());
        
        if(player.checkRank()){
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
        /*    playerHUD.refreshHUD(player);
        }
        */
         
        //need to make a separate class
         //new rankUp test
         player.setRankUP(50000);
            System.out.println(player.rankUP);
        
        if(player.checkRank()){
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
            playerHUD.refreshHUD(player);
           JOptionPane.showMessageDialog(null,"You Just Ranked Up");
          }
         
        
     
       
        
        
    }//close main
    
   
}//close class BattleSoliders
