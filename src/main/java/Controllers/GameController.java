package Controllers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import Exceptions.WrongSpawnPlaceException;
import Objects.Ball;
import Objects.GameObject;
import Objects.Racket;
import Objects.Score;
import Objects.Wall;
import Utilities.GameKeylistener;

/**
 *
 * @author Vitor
 */
public class GameController {
    final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 475;
    private final List<Racket> rackets = new ArrayList<>();
    private final List<RacketController> racketControllers = new ArrayList<>();
    private final List<Score> scores = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();
    private final Ball ball;
    private int speedCounter = 0;
    private final int maxSpeedCounter = 5; // 5
    public static int objectsCount = 0;
    private String winner;
    private final int maxPointCounter = 5;
    private int wallCount = 0;
    private final Timer timerWallSpawn;
    private final int timeToSpawnANewWall = 5000; // 5 seconds
    private int maxNumberOfWalls = 5;

    public GameController(GameKeylistener keyListener) {
        this.ball = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 1, 1, 3, Color.blue, 10);
        this.rackets.add(new Racket(0, 50, 150, 5, Color.yellow));
        this.rackets.add(new Racket((WINDOW_WIDTH - 15), 150, 150, 5, Color.green));
        this.racketControllers
                .add(new RacketController(KeyEvent.VK_W, KeyEvent.VK_S, rackets.get(0), keyListener, WINDOW_HEIGHT));
        this.racketControllers.add(
                new RacketController(KeyEvent.VK_UP, KeyEvent.VK_DOWN, rackets.get(1), keyListener, WINDOW_HEIGHT));
        this.scores.add(new Score("Player 1 - ", WINDOW_WIDTH / 4 - 15, 25, 0, Color.yellow));
        this.scores.add(new Score("Player 2 - ", WINDOW_WIDTH / 4 - 15 + 225, 25, 0, Color.green));
        this.winner = "";

        timerWallSpawn = new Timer(timeToSpawnANewWall, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Faz as paredes aparecerem
                if (wallCount < maxNumberOfWalls) {
                    spawnWall();

                    if (checkCollisionOfAnElementWithTheBall(walls.get(walls.size() - 1), ball)) {
                        walls.get(walls.size() - 1).setLife(walls.get(walls.size() - 1).getLife() - 1);

                        ball.reverseXDirection();
                    }

                    wallCount++;
                }
            }
        });

        GameController.objectsCount++;
    }

    public void showObjectsOnScreen(Graphics g) {
        ball.paint(g);

        for (int racketCounter = 0; racketCounter < rackets.size(); racketCounter++) {
            rackets.get(racketCounter).paint(g);
        }

        for (int scoreCounter = 0; scoreCounter < scores.size(); scoreCounter++) {
            scores.get(scoreCounter).paint(g);
        }

        for (int wallsCounter = 0; wallsCounter < walls.size(); wallsCounter++) {
            walls.get(wallsCounter).paint(g);
        }
    }

    public void runGameLogic() {
        // Movimentação
        ball.move();

        // Inicializando os controladores das raquetes
        for (int racketControllersCounter = 0; racketControllersCounter < racketControllers
                .size(); racketControllersCounter++) {
            racketControllers.get(racketControllersCounter).checkForMoveDownCommand();
            racketControllers.get(racketControllersCounter).checkForMoveUpCommand();
        }

        // Inicia o temporizador de spawn das paredes
        this.timerWallSpawn.start();

        // Verificando a colisão da bola com as raquetes
        for (int racketCounter = 0; racketCounter < rackets.size(); racketCounter++) {
            if (this.checkCollisionOfAnElementWithTheBall(rackets.get(racketCounter), ball)) {
                ball.reverseXDirection();
            }
        }

        // Verificando a colisão da bola com as paredes
        for (int wallsCounter = 0; wallsCounter < walls.size(); wallsCounter++) {
            if (this.checkCollisionOfAnElementWithTheBall(walls.get(wallsCounter), ball)) {
                this.walls.get(wallsCounter).setLife(this.walls.get(wallsCounter).getLife() - 1);
                ball.reverseXDirection();
            }
        }

        // Lógica
        this.makeBallBounceOnEdges();

        // Verifica se algum player marcou ponto
        this.checkForScore();

        this.respawnBallWhenItExitOfScreen();

        // Verifica se algum player ganhou o jogo
        this.checkIfHasAWinner();

        // Verifica a vida das paredes
        this.checkWallsLife();
    }

    private void makeBallBounceOnEdges() {
        if (ball.getYPosition() > (WINDOW_HEIGHT - ball.getWidth()) || ball.getYPosition() < 0) {
            ball.reverseYDirection();
            this.increaseBallSpeed();
        }
    };

    private boolean checkCollisionOfAnElementWithTheBall(GameObject object, Ball ball) {
        // Pega a coordenada da borda direita do objeto
        int RightSideCoordinate = object.xPosition + object.width;
        // Pega a coordenada da borda inferior do objeto
        int BottomCoordinate = object.yPosition + object.height;

        // Verifica se a coordenada x da bola está sobre o objeto
        if ((ball.getXPosition() + ball.getWidth()) > object.xPosition
                && ball.getXPosition() < RightSideCoordinate) {
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

    private boolean checkWetherBallHasLeftScreen() {
        return this.ball.getXPosition() < 0 || this.ball.getXPosition() > WINDOW_WIDTH;
    };

    private void respawnBallWhenItExitOfScreen() {
        if (this.checkWetherBallHasLeftScreen()) {
            // Faz a bola aparecer no centro da tela
            this.resetBallPosition();

            // Aleatoriza a direção que a bola seguirá

            // Armazenar todas as opções possíveis de direção
            int respawnOptions[][] = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

            // Gera valores aleatórios entre os índices do array e dos sub arrays para
            // garantir a aleatoriedade do spawn
            int randomArrayIndex = new Random().nextInt(4);

            ball.setxDirection(respawnOptions[randomArrayIndex][0]);
            ball.setxDirection(respawnOptions[randomArrayIndex][1]);
            ball.setSpeed(3);
            this.speedCounter = 0;
        }
    };

    private void increaseBallSpeed() {
        if (this.speedCounter < this.maxSpeedCounter) {
            ball.setSpeed(ball.getSpeed() + 1);
            this.speedCounter++;
        }
    }

    private void increasePlayer1Score() {
        scores.get(0).setScore(scores.get(0).getValue() + 1);
        // scores.get(0).update();
    };

    private void increasePlayer2Score() {
        scores.get(1).setScore(scores.get(1).getValue() + 1);
    };

    private void checkForScore() {
        if (this.checkWetherBallHasLeftScreen()) {
            if (this.ball.getXPosition() > WINDOW_WIDTH) {
                this.increasePlayer1Score();
            } else if (this.ball.getXPosition() < 0) {
                this.increasePlayer2Score();
            }
        }
    }

    private void checkIfHasAWinner() {
        if (scores.get(0).getValue() == maxPointCounter) {
            this.winner = "Player 1";
        } else if (scores.get(1).getValue() == maxPointCounter) {
            this.winner = "Player 2";
        }
    }

    public String getWinner() {
        return this.winner;
    }

    public void resetGame() {
        this.winner = "";

        this.resetScores();

        this.resetBallPosition();

        this.walls.clear();
    }

    private void resetBallPosition() {
        ball.setXPosition(WINDOW_WIDTH / 2);
        ball.setYPosition(WINDOW_HEIGHT / 2);
    };

    private void resetScores() {
        this.scores.get(0).setScore(0);
        this.scores.get(1).setScore(0);
    };

    public void spawnWall() {
        int startXBoundary = 40;
        int startYBoundary = 40;
        int offset = 40;
        int randomXValue = new Random().nextInt(startXBoundary, WINDOW_WIDTH - startXBoundary);
        int randomYValue = new Random().nextInt(startYBoundary, WINDOW_HEIGHT - 50);

        try {
            // Verifica se as paredes vão spawnar próximas à outras paredes
            for (int wallsCounter = 0; wallsCounter < walls.size(); wallsCounter++) {
                int xPositionPlusHalfWidth = randomXValue + walls.get(wallsCounter).getWidth() / 2;
                int xPositionMinusHalfWidth = randomXValue - walls.get(wallsCounter).getWidth() / 2;

                int yPositionPlusHalfHeight = randomYValue + walls.get(wallsCounter).getHeight() / 2;
                int yPositionMinusHalfHeight = randomYValue - walls.get(wallsCounter).getHeight() / 2;

                int wallXPositionPlusHalfWidth = walls.get(wallsCounter).getXPosition()
                        + walls.get(wallsCounter).getWidth() / 2;
                int wallXPositionMinusHalfWidth = walls.get(wallsCounter).getXPosition()
                        - walls.get(wallsCounter).getWidth() / 2;
                int wallYPositionPlusHalfHeight = walls.get(wallsCounter).getYPosition()
                        + walls.get(wallsCounter).getHeight() / 2;

                int wallYPositionMinusHalfHeight = walls.get(wallsCounter).getYPosition()
                        - walls.get(wallsCounter).getHeight() / 2;

                if (xPositionPlusHalfWidth > (wallXPositionPlusHalfWidth - offset)
                        && xPositionMinusHalfWidth < (wallXPositionMinusHalfWidth + offset)) {

                    if (yPositionPlusHalfHeight > (wallYPositionMinusHalfHeight - offset)
                            && yPositionMinusHalfHeight < (wallYPositionPlusHalfHeight + offset)) {
                        throw new WrongSpawnPlaceException(
                                "A parede tentou spawnar em um local muito próximo à outra parede");
                    }
                }

                // Verifica se as paredes vão spawnar próximas à bola
                if (xPositionPlusHalfWidth > (this.ball.getXPosition() - offset)
                        && xPositionMinusHalfWidth < (this.ball.getXPosition() + offset)) {

                    if (yPositionPlusHalfHeight > (this.ball.getYPosition() - offset)
                            && yPositionMinusHalfHeight < (this.ball.getYPosition() + offset)) {
                        throw new WrongSpawnPlaceException("A parede tentou spawnar em um local muito próximo à bola");
                    }
                }
            }
        } catch (Exception error) {
            System.out.println(error);
            spawnWall();

            return;
        }

        this.walls.add(new Wall(randomXValue, randomYValue, 150, 10, Color.PINK, 2));
    };

    public void checkWallsLife() {
        for (int wallsCount = 0; wallsCount < this.walls.size(); wallsCount++) {
            if (this.walls.get(wallsCount).getLife() == 0) {
                this.walls.remove(wallsCount);
                // this.wallCount--;
            }
        }
    }
}
