/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Objects.Ball;
import Objects.GameObject;
import Objects.Racket;
import Objects.Score;
import Utilities.MyKeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vitor
 */
public class GameController {
    final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private final List<Racket> rackets = new ArrayList();
    private final List<RacketController> racketControllers = new ArrayList();
    private final List<Score> scores = new ArrayList();
    private final Ball ball;
    private int speedCounter=0;
    private final int maxSpeedCounter = 5;
    private static int objectsCount = 0;
    public String winner = "";
    private final int maxPointCounter = 2;
    
    public GameController(MyKeyListener keyListener){
        this.ball = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 1, 1, 3, Color.blue, 10, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.rackets.add(new Racket(0, 50, 150, 5, Color.yellow));
        this.rackets.add(new Racket((WINDOW_WIDTH - 15), 150, 150, 5, Color.green));
        this.racketControllers.add(new RacketController(KeyEvent.VK_W, KeyEvent.VK_S, rackets.get(0), keyListener, WINDOW_HEIGHT));
        this.racketControllers.add(new RacketController(KeyEvent.VK_UP, KeyEvent.VK_DOWN, rackets.get(1), keyListener, WINDOW_HEIGHT));
        this.scores.add(new Score("Player 1 - ",WINDOW_WIDTH/4 - 15,25,0,Color.yellow));
        this.scores.add(new Score("Player 2 - ",WINDOW_WIDTH/4 -15 + 225,25,0,Color.green));
    
        GameController.objectsCount ++;
    }
    
    public void showObjectsOnScreen(Graphics g){
        ball.paint(g);
        
        for(int racketCounter=0; racketCounter < rackets.size(); racketCounter++){
            rackets.get(racketCounter).paint(g);
        }
        
        for(int scoreCounter=0; scoreCounter < scores.size(); scoreCounter++){
            scores.get(scoreCounter).paint(g);
        }
    }

    public void runGameLogic(){
        //Movimentação
        
            ball.move();
            
            //System.out.println("Criou" + ball.getObjectsCount());

            // Inicializando os controladores das raquetes
            for(int racketControllersCounter=0; racketControllersCounter < racketControllers.size(); racketControllersCounter++){
                racketControllers.get(racketControllersCounter).checkForMoveDownCommand();
                racketControllers.get(racketControllersCounter).checkForMoveUpCommand();
            }
        
        //Lógica
        
            this.makeBallBounceOnEdges();
        
            // Verificando a colisão da bola com as raquetes
            for(int racketCounter=0; racketCounter < rackets.size(); racketCounter++){
                if(this.checkCollisionOfAnElementWithTheBall(rackets.get(racketCounter), ball)){
                    ball.reverseXDirection();
                }
            }
            
            //Verifica qual player marcou o ponto
            this.checkForScore();
            
            this.respawnBallWhenItExitOfScreen();
            
            //Verifica se algum player ganhou o jogo
            this.checkIfHasAWinner();
    }
    
    private void makeBallBounceOnEdges(){
        if (ball.getYPosition() > (WINDOW_HEIGHT - ball.getWidth()) || ball.getYPosition() < 0) {
            ball.reverseYDirection();
            this.increaseBallSpeed();
        }
    };
    
    private boolean checkCollisionOfAnElementWithTheBall(GameObject object,Ball ball) {
        // Pega a coordenada da borda direita do objeto
        int RightSideCoordinate = object.xPosition + object.width;
        // Pega a coordenada da borda inferior do objeto
        int BottomCoordinate = object.yPosition + object.height;

        // Verifica se a coordenada x da bola está sobre o objeto
        if (ball.getXPosition() > (object.xPosition - ball.getWidth()) && ball.getXPosition() < RightSideCoordinate) {
            // Verifica se a coordenada y da bola está sobre o objeto
            if (ball.getYPosition() > object.yPosition && ball.getYPosition() < BottomCoordinate) {
                // Se entrou neste if, é porque há colisão com a bola
                this.increaseBallSpeed();
                return true;
            }
        }

        // Caso não haja colisão, retorna falso
        return false;
    }
    
    private boolean checkWetherBallHasLeftScreen(){
        return ball.getXPosition() < 0 || ball.getXPosition() > WINDOW_WIDTH;
    };
        
    private void respawnBallWhenItExitOfScreen(){
        if(this.checkWetherBallHasLeftScreen()){
            //Faz a bola aparecer no centro da tela
            ball.setXPosition(WINDOW_WIDTH/2);
            ball.setYPosition(WINDOW_HEIGHT/2);
            
            //Aleatoriza  a direção que a bola seguirá
            
            //Armazenar todas as opções possíveis de direção
            int respawnOptions[][] = {{1,1},{1,-1},{-1,1},{-1,-1}};
            
            //Gera valores aleatórios entre os índices do array e dos sub arrays para garantir a aleatoriedade do spawn
            int randomArrayIndex = new Random().nextInt(4);
            
            ball.setxDirection(respawnOptions[randomArrayIndex][0]);
            ball.setxDirection(respawnOptions[randomArrayIndex][1]);
            ball.setSpeed(3);
            this.speedCounter=0;
        }
    };
    
    private void increaseBallSpeed(){
        if(this.speedCounter < this.maxSpeedCounter){
            ball.setSpeed(ball.getSpeed() + 1);
            this.speedCounter++;
        }
    }
    
    private void increasePlayer1Score(){
        scores.get(0).setScore(scores.get(0).getValue() + 1);
        scores.get(0).update();
    };
    
    private void increasePlayer2Score(){
        scores.get(1).setScore(scores.get(1).getValue() + 1);
    };
    
    private void checkForScore(){
        if(this.checkWetherBallHasLeftScreen()){
            if(this.ball.getXPosition() > WINDOW_WIDTH){
                this.increasePlayer1Score();
            }else if(this.ball.getXPosition() < 0){
                this.increasePlayer2Score();
            }
        }
    }
    
    private void checkIfHasAWinner(){
        if(scores.get(0).getValue() == maxPointCounter){
            this.winner = "Player 1";
        }
        else if(scores.get(1).getValue() == maxPointCounter){
            this.winner = "Player 2"; 
        }
    }
    
    public String getWinner(){
        return this.winner;
    }
}
