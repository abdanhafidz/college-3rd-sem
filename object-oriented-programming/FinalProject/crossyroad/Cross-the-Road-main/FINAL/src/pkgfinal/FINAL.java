/*
FINAL
Creator: Jason Tang
Date: Jan. 17, 2019
Cross the Road game, inspired by Frogger and Crossy Road, where a chicken, controlled by the player, crosses traffic roads and rivers
 */
package pkgfinal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

/*
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 */
public class FINAL extends JPanel implements KeyListener {

    String s; //the string where keyboard input is saved,
    boolean pressedLeft, pressedRight, pressedEnter, jump; //the different inputs the user has
    int screen = 1; //which screen the user is on, 1 is for start menu, 2 is for the actual game, and 3 is for game over menu
    Image road, grass, busRight, busLeft, river, log2, log3; // different images used in the actual game
    Image chicken[] = new Image[3]; //the 3 different chicken images
    Image chickenMove[] = new Image[3]; //the 3 different chicken images when the chicken is moving
    Image carRight[] = new Image[3]; //the 3 different cars going in the right direction
    Image carLeft[] = new Image[3]; //3 different cars heading in the left direction
    int score = 0, highScore = 0; //the player's score and the high score
    Image land[] = new Image[7]; //the array of the 7 strips of land
    Image car[] = new Image[7]; //the array of the 7 cars on the 7 strips of land
    int xCar[] = new int[7]; //the x coordinate of the 7 cars or 7 logs
    char dir[] = new char[7]; //the direction of the 7 cars and logs
    Image log[] = new Image[7]; //the 7 logs on each strip of land
    int x = 400, y = 325; //the x and y coordinate of the player's chicken
    int chickenDelay = 0; //the delay used for the chickens forward movement
    int first = 0; //whether its the players first jump
    boolean move = false; //whether the player's chicken is moving
    Image avatar; //the image of the chicken
    int chic; //the integer value that corresponds with which chicken the user wants to play with
    Image background, begin, gameOver; //the background, game over screen and text images
    int chickenSideDelay = 0; //the delay for the chicken moving to the side
    //Scanner file;
    //PrintWriter output; //create the file writer

    FINAL() {
   
        this.addKeyListener(this); //add the keyboard input
        setFocusable(true); // need this to set the focus of the keyboard

        try { //open all the necessary images
            road = ImageIO.read(new File("road.png")); //image of the road
            grass = ImageIO.read(new File("grass.jpg")); //image of the grass
            busRight = ImageIO.read(new File("busRight.png")); //image of the bus going right
            busLeft = ImageIO.read(new File("busLeft.png")); //image of the bus going left
            carRight[0] = ImageIO.read(new File("carRight1.png")); //image of the silver car going right
            carRight[1] = ImageIO.read(new File("carRight2.png")); //image of the yellow car going right
            carRight[2] = ImageIO.read(new File("carRight3.png")); //image of the blue car going right
            carLeft[0] = ImageIO.read(new File("carLeft1.png")); //image of the silver car going left
            carLeft[1] = ImageIO.read(new File("carLeft2.png")); //image of the yellow car going left
            carLeft[2] = ImageIO.read(new File("carLeft3.png")); //image of the blue car going left
            chicken[0] = ImageIO.read(new File("Chicken.png")); //the white chicken
            chickenMove[0] = ImageIO.read(new File("Chicken1.png")); //the white chicken moving
            chicken[1] = ImageIO.read(new File("Chicken2.png")); //beige chicken
            chickenMove[1] = ImageIO.read(new File("Chicken3.png")); //beige chicken moving 
            chicken[2] = ImageIO.read(new File("Chicken4.png")); //dark brown chicken
            chickenMove[2] = ImageIO.read(new File("Chicken5.png")); //dark brown chicken moving
            river = ImageIO.read(new File("river.png")); //river
            log2 = ImageIO.read(new File("log.png")); //the log
            background = ImageIO.read(new File("background.jpg")); //main menu background
            begin = ImageIO.read(new File("begin.png")); //the text in the main menu
            gameOver = ImageIO.read(new File("gameOver.png")); //the game over screen
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(-1);
        }
        road = road.getScaledInstance(900, 100, Image.SCALE_DEFAULT); //scale the road
        grass = grass.getScaledInstance(900, 100, Image.SCALE_DEFAULT); //scale the grass
        river = river.getScaledInstance(900, 100, Image.SCALE_DEFAULT); //scale the river
        for (int i = 0; i <= 2; i++) { //scale all the cars going right
            carRight[i] = carRight[i].getScaledInstance(150, 80, Image.SCALE_DEFAULT);
        }
        for (int i = 0; i <= 2; i++) { //scale all the cars going left
            carLeft[i] = carLeft[i].getScaledInstance(150, 80, Image.SCALE_DEFAULT);
        }
        //scale the bus
        busRight = busRight.getScaledInstance(200, 80, Image.SCALE_DEFAULT);
        busLeft = busLeft.getScaledInstance(200, 80, Image.SCALE_DEFAULT);

        for (int i = 0; i <= 2; i++) { //scale all the chickens
            chicken[i] = chicken[i].getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        }
        for (int i = 0; i <= 2; i++) { //scale the moving chickens

            chickenMove[i] = chickenMove[i].getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        }

        //scale the logs
        log2 = log2.getScaledInstance(500, 80, Image.SCALE_DEFAULT);
        log3 = log2.getScaledInstance(600, 80, Image.SCALE_DEFAULT);

        //scale the text
        begin = begin.getScaledInstance(500, 120, Image.SCALE_DEFAULT);

    }

    public void keyTyped(KeyEvent e) {
        s = s + e.getKeyChar(); //save the keyboard input
    }

    public void keyPressed(KeyEvent e) { //determining when a key is pressed
        char key = (char) e.getKeyCode(); //convert keyboard input to char

        //when the user wants to go left
        if (key == e.VK_LEFT && screen == 2 && chickenSideDelay == 0 || key == 'A' && screen == 2 && chickenSideDelay == 0) {
            pressedLeft = true; //set the left boolean true
            chickenSideDelay = 20; //delay is reset
        } else if (key == e.VK_RIGHT && screen == 2 && chickenSideDelay == 0 || key == 'D' && screen == 2 && chickenSideDelay == 0) { //go right
            pressedRight = true; //set the right boolean true      
            chickenSideDelay = 20; //set the delay
        } else if (key == ' ' && screen == 2 && chickenDelay == 0 || screen == 2 && key == e.VK_UP && chickenDelay == 0) { //when the uswer wants to move the chicken up  
            jump = true; //set the jump boolean true
            chickenDelay = 20; //set the delay
            if (first != 0) { //if its not the user's first jump, then the player's score increases
                score++;
            }
            first++; //first increases
        } else if (key == '1' && screen == 1) { //choose the white chicken
            chic = 0;
        } else if (key == '2' && screen == 1) { //choose the beige chicken
            chic = 1;
        } else if (key == '3' && screen == 1) { //choose the dark brown chicken
            chic = 2;
        } else if (key == e.VK_ENTER) { //pressed enter to start the game or restart the game
            pressedEnter = true;
        } else if (key == e.VK_ESCAPE || key == 'Q') //quit the program
        {
            System.exit(0);
        }

        repaint(); //repaint the graphics after input
    }

    public void keyReleased(KeyEvent e) {
        pressedLeft = pressedRight = jump = false; //when the key is no longer inputted
        repaint(); //repaint the graphics after no input
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //clear screen
        Dimension s = this.getSize(); //gets the size of the current window

      
        if (screen == 1) { //start menu
            g.drawImage(background, -10, -40, null); //draw the background image

            if (chic == 0) { //when the white chicken is chosen
                //draw the rectangle around the white chicken
                g.setColor(Color.black);
                g.fillRect(90, 180, 10, 170);
                g.fillRect(90, 180, 140, 10);
                g.fillRect(90, 350, 140, 10);
                g.fillRect(220, 180, 10, 180);
            } else if (chic == 1) { //the beige chicken is chosen
                //draw rectangle around the beige chicken
                g.setColor(Color.black);
                g.fillRect(363, 180, 10, 170);
                g.fillRect(363, 180, 140, 10);
                g.fillRect(363, 350, 140, 10);
                g.fillRect(503, 180, 10, 180);
            } else if (chic == 2) {//the dark brown chicken is chosen
                //draw rectangle around the dark brown chicken
                g.setColor(Color.black);
                g.fillRect(612, 180, 10, 170);
                g.fillRect(612, 180, 140, 10);
                g.fillRect(612, 350, 140, 10);
                g.fillRect(742, 180, 10, 180);
            }

            g.drawImage(begin, 50, 400, null); //draw the text
            Font font = new Font("Arial", Font.BOLD, 30); //font of the string output
            //output the high score
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("High Score: " + highScore, 630, 400);

            //set the avatar as the chosen chicken
            avatar = chicken[chic];

            //set the road/land
            for (int i = 3; i <= 6; i++) { //the first 4 strips of land are always grass when the game begins
                land[i] = grass; //set the land to grass
            }
            land[2] = road; //the next piece of land is always a road      

            //set the car and the direction of the car and log
            for (int i = 0; i <= 6; i++) {
                dir[i] = randDirection(); //get a random direction
                if (dir[i] == 'r') { //when the direction is right
                    int z = randCar(); //get a random car
                    if (z == 3) { //when the car is a bus
                        car[i] = busRight;
                    } else { //when the car is not a bus
                        car[i] = carRight[z];
                    }
                    xCar[i] = 0 - (randDistance()); //set the x coordinate of the car
                } else { //when the direction is left
                    int z = randCar(); //get a random car
                    if (z == 3) { //when the car is a bus
                        car[i] = busLeft;
                    } else { //when the car is not a bus
                        car[i] = carLeft[z];
                    }
                    xCar[i] = 900 + (randDistance()); //set the x coordinate of the bus
                }
                if (randCar() <= 1) { //use the randomCar method to get a log
                    log[i] = log2; //the 500 length log

                } else {
                    log[i] = log3; //600 length log
                }
            }

            for (int i = 1; i >= 0; i--) {//generate the next 2 roads
                int h = randRoad(); //get a random road
                if (h <= 4) { //grass
                    land[i] = grass;
                } else if (h != 9) { //when the road is a road
                    land[i] = road;
                } else {//river
                    land[i] = river; //set the land to river
                    if (dir[i] == 'r') { //when the direction is right
                        xCar[i] = -600 - randDistance() / 10; //set the x coordinate of the log
                    } else {
                        xCar[i] = 1500 + randDistance() / 10; //set the x coordinate of the log
                    }
                }
            }

            if (pressedEnter) { //when the user presses enter
                screen = 2; //go to the game screen
                pressedEnter = false; //set the boolean to false
            }
        } else if (screen == 2) { //the actual game
            super.paintComponent(g); //clear screen

            //draw the road/grass/river and draw the cars
            for (int i = 0; i <= 6; i++) {
                g.drawImage(land[i], 0, i * 100, null); //draw the strip of land in corresponding coordinate
                g.drawImage(avatar, x, y, null); //draw the chicken
                if (land[i] == road) { //when the land is a road
                    g.drawImage(car[i], xCar[i], i * 100 + 10, null); //draw the car if the strip of land is a road
                    if (dir[i] == 'r') { //when the car is going right
                        xCar[i] = xCar[i] + 6; //the x coordinate increases
                        if (xCar[i] >= 1000) { // when the car goes off screen
                            xCar[i] = 0 - randDistance(); //reset the distance
                            int z = randCar(); //generate a new car
                            if (z == 3) { //when the car is a bus
                                car[i] = busRight;
                            } else {
                                car[i] = carRight[z]; //when the car isn't a bus
                            }
                        }
                    } else { //when the direction is going left
                        xCar[i] = xCar[i] - 6; //x coordinate decreases
                        if (xCar[i] <= -200) { //when the car goes off screen
                            xCar[i] = 900 + randDistance(); //reset the position
                            int z = randCar();//generate new car
                            if (z == 3) { //when the car is a bus
                                car[i] = busLeft;
                            } else { //when the car isn't a bus
                                car[i] = carLeft[z];
                            }
                        }
                    }
                } else if (land[i] == river) { //when the strip of land is a river 
                    g.drawImage(log[i], xCar[i], i * 100 + 10, null);//draw the lob
                    if (dir[i] == 'r') { //when the log is going right
                        xCar[i] = xCar[i] + 1; //x coordinate increases
                        if (xCar[i] >= 1500) { //when the log goes off the screen
                            xCar[i] = -600 - (randDistance() / 10); //reset coordinate
                            if (randCar() <= 1) { //whe the generated log is the smaller one
                                log[i] = log2;
                            } else { //generated the longer log
                                log[i] = log3;
                            }
                        }
                    } else { //when the log is going in the left
                        xCar[i] = xCar[i] - 1; //the x coordinate decreases
                        if (xCar[i] <= -600) { //when the log goes off screen
                            xCar[i] = 1500 + (randDistance() / 10); //reset the distance
                            if (randCar() <= 1) { //when the log is 500 wide
                                log[i] = log2;
                            } else { //generated a 600 wide log
                                log[i] = log3;
                            }
                        }
                    }
                }
            }

            //moving the chicken left or right
            if (pressedRight) { //the user presses right
                x = x + 100; //the chicken moves right
                pressedRight = false; //set the boolean to false
            }
            if (pressedLeft) { //the user presses left
                x = x - 100; //chicken moves left
                pressedLeft = false; //set boolean to false
            }

            //setting a border for the chicken
            if (x <= 0) { //when the chicken hits the left border
                x = 0; //don't let chicken go past the screen
            }
            if (x + 57 >= 900) { //when the chicken hits the right border
                x = 900 - 57; //set the position of the chicken
            }

            if (chickenDelay > 0) { //decrease the delay for going forward
                chickenDelay--;
            }
            if (chickenSideDelay > 0) { //decrease the delay for going to the side
                chickenSideDelay--;
            }

            //progressing to the next road
            if (jump == true) { //when the user moves forward
                move = true;//set move to true
                jump = false; //set the jump to false
            }

            if (move) { //when move is true
                avatar = chickenMove[chic]; //change the image of the chicken to the moving chicken
                y = y - 5; //decrease y coordinate
            }

            if (y <= 200) { //when the chicken moves to the next road
                avatar = chicken[chic]; //reset the chicken image
                move = false; //the chicken no longer moves
                y = 325; //reset the y coordinate of the chicken

                for (int i = 6; i >= 1; i--) { //shift down all the values for the arrow
                    land[i] = land[i - 1]; //shift down the land strip
                    car[i] = car[i - 1]; //shift down the car
                    xCar[i] = xCar[i - 1]; //shift down the car/log position
                    dir[i] = dir[i - 1]; //shift down the direction of the car/log
                    log[i] = log[i - 1]; //shift down the log
                }

                //generate the new road
                int h = randRoad(); //generate a new road
                if (h <= 4) { //when the land strip is grass
                    land[0] = grass;
                } else if (h != 9) { //when the land strip is a road
                    land[0] = road;
                } else { //when the land strip is a river
                    land[0] = river;
                }

                //get the new direction and car
                dir[0] = randDirection(); //generate new direction
                if (dir[0] == 'r') { //when the direction is right
                    int z = randCar(); //generate a new car
                    if (z == 3) { //generate a bus
                        car[0] = busRight;
                    } else { //generate a car
                        car[0] = carRight[z];
                    }
                    xCar[0] = 0 - (randDistance()); //set a position
                } else { //if the direction is left
                    int z = randCar(); //generate new car
                    if (z == 3) { //generate bus
                        car[0] = busLeft;
                    } else { //generate car
                        car[0] = carLeft[z];
                    }
                    xCar[0] = 900 + (randDistance()); //set position
                }

            }

            //car collision detection
            for (int i = 6; i >= 0; i--) { //check through all strips of land and their cars
                if (land[i] == road) { //if the land is a road
                    if (car[i] == busRight || car[i] == busLeft) { //if the the vehicle is a bus
                        if (x + 50 >= xCar[i] && y <= i * 100 + 80 && y + 50 >= i * 100 + 10 && x <= xCar[i] + 200) { //check if the chicken and bus collide
                            jump = false; //chicken no longer move
                            move = false;
                            screen = 3; //change to the gamme over screen
                        }
                    } else {
                        if (x + 50 >= xCar[i] && y <= i * 100 + 80 && y + 50 >= i * 100 + 10 && x <= xCar[i] + 150) { //check if chicken and car collide
                            jump = false;//chicken no longer moves
                            move = false;
                            screen = 3; //change to game over screen
                        }
                    }
                }
            }

            //log collision detection
            if (land[3] == river) { //if the piece of land the chicken is on is a river
                if (log[3] == log2) { //if the log is the smaller log
                    if (x + 50 > xCar[3] && x < xCar[3] + 500) { //check if the chicken is on the log
                        if (dir[3] == 'r') { //if the direction is right
                            x = x + 1; //x coordinate of chicken increases
                            if (x + 57 > 900) { //once the chicken goes off screen
                                screen = 3; //game over
                            }

                        } else { //when the direction is left
                            x = x - 1; //x coordinate of the chicken decreases
                            if (x < 0) { // when the chicken goes off screen
                                screen = 3; //game over
                            }
                        }
                    } else { //when the chicken isn't on a log
                        screen = 3;
                    }
                } else { //when the log is the larger log
                    if (x + 50 > xCar[3] && x < xCar[3] + 600) { //check whether the chicken is on the log
                        if (dir[3] == 'r') { //when the log is going right
                            x = x + 1; //x coordinate increases
                            if (x + 57 > 900) { //when the chicken goes off screen
                                screen = 3; //game over
                            }
                        } else { //when the log is going left
                            x = x - 1; //x coordinate of chicken decreases
                            if (x < 0) { //when the chicken goes off screen
                                screen = 3; //game over
                            }
                        }
                    } else { //when the chicken is not on the log
                        screen = 3; //game over
                    }
                }
            }

            Font font = new Font("Arial", Font.BOLD, 30); //font of the string output
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Score: " + score, 390, 50); //output the user's score
            g.drawString("High Score: " + highScore, 600, 50); //output the highscore

            if (score >= highScore) { //when the score is greater than the highscore
                highScore = score; //the highscore is the player's score

            }

            //delay(2); //1 milisecond delay
            repaint(); //repaint
        } else if (screen == 3) { //when the player has lost
            /*
            try {
                output = new PrintWriter (new FileWriter("score.txt")); //create the file
            } catch (IOException ex) {
                Logger.getLogger(FINAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            output.print(highScore); //outputs high score  
            file.close();
             */
            first = 0; //reset first
            super.paintComponent(g); //clear screen
            g.drawImage(gameOver, -10, -40, null); //draw the background
            move = false; //the chicken no longer moves
            avatar = chicken[chic]; //reset the chicken image
            //set the road/land
            for (int i = 3; i <= 6; i++) { //reset the first 4 strips of land as grass
                land[i] = grass; //set the land as grass
            }
            land[2] = road; //the next road is always road

            for (int i = 1; i >= 0; i--) { //generate the next 2 roads
                int h = randRoad(); //generate random road
                if (h <= 4) { //when the land strip is grass
                    land[i] = grass;
                } else if (h != 9) { //land strip is road
                    land[i] = road;
                } else { //land strip is river
                    land[i] = river;
                }
            }

            //set the car and the direction of the car and log
            for (int i = 0; i <= 6; i++) { //generate values for the next 6 roads
                dir[i] = randDirection(); //get random direction
                if (dir[i] == 'r') { //if the direction is right
                    int z = randCar(); //generate random car
                    if (z == 3) { //vehicle is a bus
                        car[i] = busRight;
                    } else { //vehicle is a car
                        car[i] = carRight[z];
                    }
                    xCar[i] = 0 - (randDistance()); //set position
                } else { //when the direction is going left
                    int z = randCar(); //generate a new car
                    if (z == 3) { //vehicle is a bus
                        car[i] = busLeft;
                    } else { //vehicle is a car
                        car[i] = carLeft[z];
                    }
                    xCar[i] = 900 + (randDistance()); //set position
                }
                if (randCar() <= 1) { //use the randomCar method to get a log
                    log[i] = log2; //the 500 length log

                } else {
                    log[i] = log3; //600 length log
                }
            }
            if (pressedEnter) { //when the user presses enter to play again
                screen = 2; //go back to the game
                pressedEnter = false; //set boolean to false
                score = 0; //reset score
            }
            //reset chicken position
            x = 400;
            y = 325;
            Font font = new Font("Arial", Font.BOLD, 30); //font of the string output
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Your Score: " + score, 350, 140); //output player's score
            g.drawString("High Score: " + highScore, 600, 140); //output highscore
            //score = 0;
        }
    }

    public static void delay(int mili) //the delay method
    {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("ERROR IN SLEEPING");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FINAL"); //create new frame called FINAL
        frame.getContentPane().add(new FINAL());
        frame.setSize(900, 700); //set frame size
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static char randDirection() { //method that generates the random direction
        double r = Math.random(); //obtain random double
        int max = 2; //max roll
        int min = 1; //minimum roll
        int rand = (int) ((max - min + 1) * r + min); //calculate random number between 1 and 2
        char ran;
        if (rand == 1) {
            ran = 'r'; //when the number is 1, direction is right
        } else {
            ran = 'l'; //when the number is 2, direction is left
        }
        return ran;
    }

    static int randCar() { //method that generates a random car
        double r = Math.random(); //obtain random double
        int max = 3; //max roll
        int min = 0; //minimum roll
        int rand = (int) ((max - min + 1) * r + min); //calculate random number between 0 and 4
        return rand;
    }

    static int randRoad() { //method that generates a road
        double r = Math.random(); //obtain random double
        int max = 9; //max roll
        int min = 1; //minimum roll
        int rand = (int) ((max - min + 1) * r + min); //calculate random number between 1 and 9
        return rand;
    }

    static int randDistance() { //generates a random distance
        double r = Math.random(); //obtain random double
        int max = 9; //max roll
        int min = 1; //minimum roll
        int rand = (int) ((max - min + 1) * r + min); //calculate random number between 1 and 9
        rand = rand * 100; //multiply 100
        return rand;
    }

}
