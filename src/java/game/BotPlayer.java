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
     
//     public int getBotMove(){
//         for(int i=0; i<boxes.length; i++)
//             if(boxes[i].getCondition() == 0)
//                 return i;
//         return 0;
//     }
     
     public int getBotMove(){
         int hor = chekerHor();
         int ver = chekerVer();
         if(hor != -1){
             return hor;
         }else if(ver != -1){
             return ver;
         }else 
             return randomPos();
     }
//-------------------Horizantal---------------------------
        private int chekerHor(){
            for(int start = 0 ; start < boxes.length; start+=3){
               int counter = 0;
               for(int i= start ; i < start + 3; i++){
                    if(boxes[i].getCondition() == 1)
                        counter++;
                }
               if(counter == 2){
                   return findInLineHor(start);
               }
               counter = 0;
            }
            return -1;
        }
        
        /*
        * this method used if two elements of row is filled
        * then this method find a position of empty position
        */
        private int findInLineHor(int start){
           for(int i= start ; i < start + 3; i++)
                if(boxes[i].getCondition() == 0)
                    return i;
            return -1;
        }
        
//--------------Vertical----------------------
        private int chekerVer(){
           for(int start = 0 ; start < 3; start++){
               int counter = 0;
               for(int i= start ; i < start + 7; i+=3){
                    if(boxes[i].getCondition() == 1)
                        counter++;
                }
               if(counter == 2){
                   return findInLineVer(start);
               }
               counter = 0;
            }
            return -1;
        
        } 
                
        private int findInLineVer(int start){
           for(int i= start ; i < start + 7; i+=3){
                if(boxes[i].getCondition() == 0)
                    return i;
           }
            return -1;
        }         
                
//--------------
        
        private int randomPos(){
            while(true){
                int res = (int)Math.round((Math.random()*8));
                if(this.boxes[res].getCondition() == 0)
                    return res;
            }
        }
     
}
