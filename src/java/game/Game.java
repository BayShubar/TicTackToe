package game;

/**
 *
 * @author Yerke
 */
public class Game {
    private Boxes boxes;
    private String nikName;
    private int gameNum;
    private int userWinsNum;
    private int compWinsNum;
    
    public Game(String nikName){
        this.nikName =nikName;
        this.boxes = new Boxes();
        this.gameNum = 0;
        this.userWinsNum = 0;
        this.compWinsNum = 0;
    }
    
    public Box[] getBoxes(){
        return this.boxes.getBoxes();
    }
    
    public int getUserWinsNum(){
        return this.userWinsNum;
    }
    
    public int getCompWinsNum(){
        return this.compWinsNum;
    }
    
    public String getNikName(){
        return this.nikName;
    }
    
    public int winner(){
        if(this.boxes.getWinner() == 1){
            this.gameNum ++;
            this.userWinsNum ++;
            this.reStart();
            return 1;
        }
        if(this.boxes.getWinner() == 2){
            this.gameNum ++;
            this.compWinsNum ++;
            this.reStart();
            return 1;
        }
        return 0;
    }
    
    public void reStart(){
        this.boxes = new Boxes();
    }
}
