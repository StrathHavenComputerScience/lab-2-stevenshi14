public class Lab2 extends Robot
{
    public static void cleanSquare()
    {
        Robot.load("square.txt");
        Robot.setDelay(0.1);
        convertSixWhite();
        turnLeft();
        convertSixWhite();
        turnLeft();
        convertSixWhite();
        turnLeft();
        convertSixWhite();
    }

    public static void darkenComb()
    {
        Robot.load("comb.txt");
        Robot.setDelay(0.05);
        turnRightDark();
        darkenRowAndUp();
        darkenRowAndUp();
        darkenRowAndUp();
        darkenRowAndUp();
        darkenRowAndUp();
    }

    public static void makeCheckered()
    {
        Robot.load("blank.txt");
        Robot.setDelay(0.05);
        checkerTwoRow();
        checkerTwoRow();
        checkerTwoRow();
        checkerRow();
        repositionCheckerRight();
        checkerRow();
    }

    public static void turnRight(){
        //precondition: robot is facing any direction
        //postcondition: robot faces 90 degrees clockwise from intital direction
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public static void turnAround(){
        //precondition: robot is facing any direction
        //postcondition: robot is facing in the other direction
        turnLeft();
        turnLeft();
    }

    public static void convertWhite(){
        //precondition: robot is facing a cell
        //postcondition: robot is on previously stated cell that is now white
        move();
        if(onDark()){
            makeLight();
        }
    }

    public static void convertBlack(){
        //precondition: robot is facing a cell
        //postcondition: robot is on previously stated cell that is now black
        move();
        if(onDark()){
            //nothing lol
        } else{
            makeDark();
        }
    }

    public static void convertSixWhite(){
        //precondition: robot is facing a row of 6 cells
        //postcondition: robot is on 6th cell of row it was facing, all 6 cells are white
        convertWhite();
        convertWhite();
        convertWhite();
        convertWhite();
        convertWhite();
        convertWhite();
    }

    public static void convertSixBlack(){
        //precondition: robot is facing a row of 6 cells
        //postcondition: robot is on 6th cell of row it was facing, all 6 cells are black
        convertBlack();
        convertBlack();
        convertBlack();
        convertBlack();
        convertBlack();
        convertBlack();
    }

    public static void turnAroundSix(){
        //precondition: robot is facing any direction with 6 cells behind it
        //postcondition: robot is 6 cells in opposite direction and facing in the opposite direction
        turnAround();
        move();
        move();
        move();
        move();
        move();
        move();
    }

    public static void turnRightDark(){
        //precondition: robot is facing any direction
        //postcondition: robot turns 90 degrees clockwise and cell its on is Dark
        turnRight();
        if(onDark()){
            //nothing lol
        } else{
            makeDark();
        }
    }

    public static void upLadderDark(){
        //precondition: (checks if right is clear)robot's right is clear there are two cells above the robot
        //postcondition: robot is two cells to its previous right, with two cells prior now dark, robot is facing in the opposite direction
        turnRight();
        if(frontIsClear()){
            move();
            if(onDark()){
                //nothing lol
            } else{
                makeDark();
            }
            move();
            turnRightDark();
        }
    }

    public static void darkenRowAndUp(){
        //precondition: robot is facing 6 cells with one cell to its left
        //postcondition: robot is in the cell that was to its left, and all 6 cells it was previously facing are all dark
        convertSixBlack();
        turnAroundSix();
        upLadderDark();
    }

    public static void checkerAhead(){
        //precondition: Robot is on cell with cell in front of it
        //postcondition: Robot is one cell ahead of where it started, the cell its on is the opposite color of where it started. 
        if(onDark()){
            move();
            if(onDark()){
                makeLight();
            }
        } else {
            move();
            if(onDark()){
                //nothing lolol
            } else{
                makeDark();
            }
        }
    }

    public static void checkerRow(){
        //precondition: Robot is on cell facing 7 cells
        //postcondition: Robot is on 7th cell it was facing, where cells before are checkered
        checkerAhead();
        checkerAhead();
        checkerAhead();
        checkerAhead();
        checkerAhead();
        checkerAhead();
        checkerAhead();
    }

    public static void repositionCheckerRight(){
        //precondition: Robot’s right is a cell
        //postcondition: Robot is on cell that was on its prior right, now facing in the opposite direction from prior. Cell robot is on now is opposite to prior cell
        turnRight();
        checkerAhead();
        turnRight();
    }

    public static void repositionCheckerLeft(){
        //precondition: Robot’s left is a cell
        //postcondition: Robot is on cell that was on its prior left, now facing in the opposite direction from prior. Cell robot is on now is opposite to prior cell
        turnLeft();
        checkerAhead();
        turnLeft();
    }

    public static void checkerTwoRow(){
        //precondition: robot is facing 7 cells, with an entire row of 8 cells right next to the robot
        //postcondition: robot is in the cell next to where it started, facing in same direction it started
        checkerRow();
        repositionCheckerRight();
        checkerRow();
        repositionCheckerLeft();
    }

}
