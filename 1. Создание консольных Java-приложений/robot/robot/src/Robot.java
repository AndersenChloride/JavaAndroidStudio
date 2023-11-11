public class Robot {
    int X;
    int Y;
    Direction direction;

    public Robot(int X, int Y, Direction direction) {
        this.X = X;
        this.Y = Y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void turnLeft() {
        if(direction == Direction.LEFT){
            direction = Direction.DOWN;
        }else if(direction == Direction.RIGHT){
            direction = Direction.UP;
        }else if(direction == Direction.UP){
            direction = Direction.LEFT;
        }else{
            direction = Direction.RIGHT;
        }
    }

    public void turnRight() {
        if(direction == Direction.LEFT){
            direction = Direction.UP;
        }else if(direction == Direction.RIGHT){
            direction = Direction.DOWN;
        }else if(direction == Direction.UP){
            direction = Direction.RIGHT;
        }else{
            direction = Direction.LEFT;
        }
    }

    public void stepForward() {
        if(direction == Direction.LEFT | direction == Direction.RIGHT){
            X++;
        }else{
            Y++;
        }

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() != toX || robot.getY() != toY) {
            if (robot.getX() < toX) {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnRight();
                }
                robot.stepForward();
            } else if (robot.getX() > toX) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnRight();
                }
                robot.stepForward();
            }

            if (robot.getY() < toY) {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnRight();
                }
                robot.stepForward();
            } else if (robot.getY() > toY) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnRight();
                }
                robot.stepForward();
            }
        }
    }
}