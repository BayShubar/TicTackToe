package game;
/**
 *
 * @author Yerke
 */
public class BotPlayer {
     private Box[] boxes;
     
     public BotPlayer(Box[] boxes){
         this.boxes = boxes;
     }
     
     public int getBotMove(){
         for(int i=0; i<boxes.length; i++)
             if(boxes[i].getCondition() == 0)
                 return i;
         return 0;
     }
}
