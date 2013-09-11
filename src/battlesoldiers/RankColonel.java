/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

/**
 *
 * @author gcDataTechnology
 */
public class RankColonel extends Soldier implements Commandable{
    
   final int RESET_HEALTH = 150;//used to quickly reset health
   final int NXT_RANK=1000;
  
   
   //Constructors
    public RankColonel() {
       // super(name, team);
        health=RESET_HEALTH;
    }

    public RankColonel(String name, Team team) {
       // super(name, team);
        super();
        this.name=name;
        this.team=team;
        health=RESET_HEALTH;
        defense*=2;
        speed*=2;
        rank=Rank.PRIVATE;
        System.out.println("Congratulations...You just made " + rank);
        
    }
    
     //Command methods - Commandable
   public void soundOff(){
       
   }
   
    public void attack(int opHealth, String attack){
       
   }
   
   public void defend(int opStrength){
       
   }
        
   public void advance(int speed){
        
   }
   
   public void heal(int health){
       
   }
   
   public void increaseRank(int points){
        
   }
    
    
    
}
