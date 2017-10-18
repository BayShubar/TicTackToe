<%-- 
    Document   : GamePage
    Created on : 18.10.2017, 9:47:56
    Author     : Yerke
--%>

<%@page import="game.Box"%>
<%@page import="game.Game"%>
<%@page import="game.Boxes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .holder {
            width:350px; 
            background:#C5D200; 
            padding: 20px; 
            margin:auto; 
            border-radius: 10px;
            margin-top: 20px;
        }
        .element{
            width:100px;
            border:1px solid white;
            border-radius: 10px;
            height: 100px;
            background: ehite;
            display:inline-block;
            color:white;
            font-size: 70px;
            padding: 10px;
        }
        .element:hover{
            background: #F7CE00;
            border:3px solid white;
            font-size: 80px;
            padding: 5px;
        }
        .btnStyle{
           color: white;
        }
        .btnStyle:hover{
           color: white;
        }
        .btnStyle:active{
           color: white;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background:#F7CE00;">
       <%
           HttpSession sess = request.getSession();
           Game game = (Game)sess.getAttribute("game");
           Box[] boxes = game.getBoxes();
       %>
        
        
        
       <div class="holder">
           <a href="EngineServlet?id=10" class="btn btn-success" style="background: #F7CE00; margin: 5px; border:2px solid white;">
               <span class="glyphicon glyphicon-flash"></span> restart
           </a>
           <h1 class="btn btn-success" style="background: #C5D200; margin: 5px; border:2px solid white;">
               <span class="glyphicon glyphicon-user"></span> You  <%= game.getUserWinsNum() %>
           </h1>
            <h1 class="btn btn-success" style="background: #C5D200; margin: 5px; border:2px solid white;">
               <span class="glyphicon glyphicon-cloud"></span> Comp <%= game.getCompWinsNum()%>
           </h1>
           <h1 style="text-align: center; color: white;"><%= game.getNikName() %></h1>
           <a href="EngineServlet?id=9" class="btn btn-success" style=" margin-left:85px;
                        background: #C5D200; border:2px solid white;">
               <span class="glyphicon glyphicon-flash"></span> Close a Game
           </a>
       </div>
        <div class="holder">
            <%for(int i=0; i<boxes.length; i++){
                String link = "EngineServlet?id="+i;
                 %>
               <div class="element">                        
                   <a href=<%= link %> class="btnStyle">
                        <%if(boxes[i].getCondition() == 1){%>
                            <span class="glyphicon glyphicon-ok"></span>
                        <%} else if(boxes[i].getCondition() == 2){%>
                            <span class="glyphicon glyphicon-remove"></span>
                        <%} else {%>
                            <span class="glyphicon glyphicon-asterisk"></span>
                        <%}%>
                   </a>
               </div>
            <%}%>
        </div>
    </body>
</html>


