/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesoldiers;

/**
 *
 * @author gcDataTechnology
 */
public interface Commandable {
    
    public void soundOff();
    public void attack(int opHealth, String attack);
    public void defend(int opStrength);
    public void advance(int speed);
    public void heal(int health);
    public boolean checkRank();
    public int passPoints();
    public String[] getAttack();
    public String[] getDefend();
    public String[] getCommand();
    public String[] getInfo();
    public String[] getVitals();
    public String nextRank();
    
    
    
}
