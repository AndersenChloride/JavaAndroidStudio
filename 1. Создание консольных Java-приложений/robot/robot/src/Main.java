// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0,Direction.UP);
        System.out.println(robot.getDirection());
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        Robot.moveRobot(robot,3,0);
        System.out.println(robot.getDirection());
        System.out.println(robot.getX());
        System.out.println(robot.getY());

    }
}