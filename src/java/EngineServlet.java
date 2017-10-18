import game.Game;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import game.*;

/**
 *
 * @author Yerke
 */
public class EngineServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userMove = Integer.parseInt(request.getParameter("id"));
       
        HttpSession sess = request.getSession();
        Game game = (Game)sess.getAttribute("game");
        
        if(userMove == 9){
          Game defaultGame = new Game("anonim");
          sess.setAttribute("game", defaultGame);
          response.sendRedirect("index.html");
        }else if(userMove == 10){
            game.reStart();
            backToPage(request, response);
        }else if(game.getBoxes()[userMove].getCondition() != 0){
            backToPage(request, response);
        }else {
            BotPlayer bot = new BotPlayer(game.getBoxes());
            chekerAndMover(game, 1, userMove);
            chekerAndMover(game, 2, bot.getBotMove());
            backToPage(request, response);
        }        

    }
    
    private void chekerAndMover(Game game, int someone, int move){
        if(game.winner() == someone){
              //something happen if User Win
        }
        if(game.winner()== 0){
              game.getBoxes()[move].setCondition(someone);          
        }
        if(game.winner() == someone){
              //something happen if User Win
        }
    }
    
    private void backToPage(HttpServletRequest request,  HttpServletResponse response)
                                                throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/GamePage.jsp");
        rd.forward(request, response);
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nikName = (String)request.getParameter("nikName");
        HttpSession session = request.getSession();
        Game game = new Game(nikName);
        session.setAttribute("game", game);
        
        RequestDispatcher rd = request.getRequestDispatcher("/GamePage.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
        
    }

}
