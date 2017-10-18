package game;

/**
 *
 * @author Yerke
 * 
 * condition: 0 default, 1 user, 2 computer
 */
public class Box {
    private int condition;
    
    public Box(int x, int y){
      this.condition = 0;
    }
    public int getCondition(){
        return this.condition;
    }
    
    public void setCondition(int con){
        this.condition = con;
    }
     
}
