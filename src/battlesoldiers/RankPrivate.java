/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

/**
 *
 * @author gcDataTechnology
 */
public class RankPrivate extends Soldier implements Commandable{
    
   final int RESET_HEALTH = 150;//used to quickly reset health
   final int NXT_RANK=1000;
   
  
   
   //Constructors
    public RankPrivate() {
       // super(name, team);
        health=RESET_HEALTH;
    }

    public RankPrivate(String name, Team team, int passPoints) {
       // super(name, team);
        super();
        this.name=name;
        this.team=team;
        health=RESET_HEALTH;
        defense*=2;
        speed*=2;
        strength*=2;
        rank=Rank.PRIVATE;
        pic="picPrivate.jpg";
        rankUP=passPoints;
        
    }
      
           
    //Command methods - Commandable
   @Override
   public void soundOff(){
       System.out.println(team + " TEAM:  " + rank + "  " + name + " " + 
               "Health:" + health + "\nStrength:"  + strength + " " +
               "Speed:" + speed + " Defense:" + defense +  "\nResources:" + resources +
               "\n *** Actions *** \n ATTACKS: ");
       for(ATTACK a: ATTACK.values()){
           System.out.print(" * " + a + " * ");
       }
       
       System.out.println("\n DEFENSE:  ");
       for(DEFEND d:DEFEND.values()){
           System.out.print(" * " + d + " * ");
       }
   }
   
   public String[] soundOff(boolean o){//overloaded (not from commandable)
       //populates BattleField HUD
       String[] roleCall= new String[26];
       int i=0;//index for ATTACK & DEFEND
       int j=0;//index for roleCall array
       int AD=5;//attack & defend will have 5 attributes, test for them all
       
       roleCall[0]=team.toString();
       roleCall[1]=rank.toString();
       roleCall[2]=name;
       roleCall[3]=Integer.toString(health);
       roleCall[4]=Integer.toString(strength);
       roleCall[5]=Integer.toString(speed);
       roleCall[6]=Integer.toString(defense);
       roleCall[7]=Integer.toString(resources);
       roleCall[8]=Integer.toString(rankUP);
       roleCall[9]=Integer.toString(NXT_RANK);
       j=10;
       for(ATTACK a:ATTACK.values()){
           roleCall[j]=a.toString();
           i++;
           j++;
       }      
       
       //check lacking attacks -- not all classes have 5
       if(AD-i>0){
          
           for(int index=AD-i;index>0;index--,j++){
               roleCall[j]="";
           }
       }
       
       i=0;//reset i
       for(DEFEND d:DEFEND.values()){
          roleCall[j]= d.toString();
          i++;
          j++;
       }
       
        //check lacking defense -- not all classes have 5
       if(AD-i>0){
          
           for(int index=AD-i;index>0;index--,j++){
               roleCall[j]="";
           }
       }
       
       roleCall[25]=Integer.toString(j);
       //other classes will need to add COMMAND
       return roleCall;
   }
   
   @Override
   public void attack(int opHealth, String attack){
       
   }
   
   @Override
   public void defend(int opStrength){
       
   }
   
   @Override
   public void advance(int speed){
        
   }
   
   @Override
   public void heal(int health){
       
   }
   
   @Override
   public boolean checkRank(){
        boolean iR = false;
        if(this.rankUP>=this.NXT_RANK){
            iR=true;
        }
        return iR;
   }
   
   @Override
   public int passPoints(){
       int i=this.NXT_RANK-this.rankUP;
       if(i<0){
           i=0;
       }
       return i;
   }
  
   @Override
   public String[] getAttack(){
       String[] atck = new String[5];
       int j=0;
       for(ATTACK a:ATTACK.values()){
           atck[j]=a.toString();
           j++;
       }
       atck[4]="";
       return atck;
   }
   
   @Override
   public String[] getDefend(){
       String[] dfnd = new String[5];
       int j=0;
       for(DEFEND d:DEFEND.values()){
           dfnd[j]=d.toString();
           j++;
       }
       dfnd[3]="";
       dfnd[4]="";
       return dfnd;
   }
   
   @Override
   public String[] getCommand(){
       String[] cmnd = new String[5];
       int j=0;
       for(COMMAND c:COMMAND.values()){
           cmnd[j]=c.toString();
           j++;
       }
       cmnd[1]="";
       cmnd[2]="";
       cmnd[3]="";
       cmnd[4]="";
       return cmnd;
   }
   
   @Override
   public String[] getInfo(){
       String[] info = new String[4];
      
       info[0]=team.toString();
       info[1]=rank.toString();
       info[2]=name;
       info[3]=pic;
       return info;
   }
   
   @Override
    public String[] getVitals(){
       String[] vitals = new String[14];
       vitals[0]="Health: ";
       vitals[1]=Integer.toString(health);
       vitals[2]="Strength: ";
       vitals[3]=Integer.toString(strength);
       vitals[4]="Speed: ";
       vitals[5]=Integer.toString(speed);
       vitals[6]="Defense: ";
       vitals[7]=Integer.toString(defense);
       vitals[8]="Resources: ";
       vitals[9]=Integer.toString(resources);
       vitals[10]="Rank Up: ";
       vitals[11]=Integer.toString(rankUP);
       vitals[12]=" / ";
       vitals[13]=Integer.toString(NXT_RANK);
       
       return vitals;
   }
   
   @Override
    public String nextRank(){
       return "Sergeant";
   }
   
   //private list
   enum ATTACK{MISSLES, EXPLOSIVES, HAND2HAND, SHORTRANGE};
   enum DEFEND{DISTRACT, SHIELD, EVADE};
   enum COMMAND{SOLDIERS};
   
   
}

