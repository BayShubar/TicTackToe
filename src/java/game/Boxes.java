package game;

/**
 *
 * @author Yerke
 */
public class Boxes {
    private Box[] boxes;
    
    public Boxes(){
        this.boxes = new Box[9];
        
        int incr = 0;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                this.boxes[incr] = new Box(j, i);
                incr++;
            }
       }
    
        public int getCon(int index){
            return this.boxes[index].getCondition();
        }
        
        public void setUser(int index){
            this.boxes[index].setCondition(1);
        }
        
        public void setComp(int index){
            this.boxes[index].setCondition(2);
        }
        
        public Box[] getBoxes(){
            return this.boxes;
        }
        
        
        /**
         * this method return -1 if Nobudy Win
         * this method return 0 if here some places
         * this method return 1 if User win
         * this method return 2 if Comp win
         */
        public int getWinner(){
            int ver = checkVer();
            int hor = checkHor();
            int dio = checkDiogonal();
            if(dio != 0)
                return dio;
            if( ver != 0)
                return ver;
            if(hor != 0)
                return hor;
            if(haveMove())
                return 0;
            return -1;
        }
        /**
         * this method chek field vertically
         * if user win return 1
         * if comp win return 2
         * if nobody win return 0
         */
        
        private boolean haveMove(){
            for(int i=0; i<boxes.length; i++){
                if(boxes[i].getCondition() == 0)
                    return true;
            }
            return false;
        }
        
        private int checkDiogonal(){
            if(checkDiogonalChild(1))
                return 1;
            if(checkDiogonalChild(2))
                return 2;
            return 0;
        }
        
        private boolean checkDiogonalChild(int boxCon){
          if(boxes[0].getCondition() == boxCon && boxes[4].getCondition() == boxCon && boxes[8].getCondition() == boxCon)
              return true;
          if(boxes[2].getCondition() == boxCon && boxes[4].getCondition() == boxCon && boxes[6].getCondition() == boxCon)
              return true;
          else return false;
        }
        
        private int checkVer(){
            if( chekerVerChild(1 , 0)|| chekerVerChild(1 , 1)|| chekerVerChild(1 , 2))
                return 1;
            if( chekerVerChild(2 , 0)|| chekerVerChild(2 , 1)|| chekerVerChild(2 , 2) )
                return 2;
            return 0;
        }
        
         private boolean chekerVerChild(int boxCon, int start){
            for(int i = 0; i<3; i++)
                if(boxes[start + 3*i].getCondition() != boxCon)
                    return false;
            return true;
         }
        
         
         
         /**
         * this method chek field horizontally
         * if user win return 1
         * if comp win return 2
         * if nobody win return 0
         */
        private int checkHor(){
          if(chekerHorChild(1, 0) || chekerHorChild(1, 3) || chekerHorChild(1, 6))
                 return 1;  
          if(chekerHorChild(2, 0) || chekerHorChild(2, 3) || chekerHorChild(2, 6))
                 return 2;
          return 0;
        }
        
        private boolean chekerHorChild(int boxCon, int start){
            for(int i= start ; i < start + 3; i++)
                if(boxes[i].getCondition() != boxCon)
                    return false;
            return true;
        }

}
