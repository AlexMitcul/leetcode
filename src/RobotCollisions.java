import java.util.*;


public class RobotCollisions {
    class Robot implements Comparable<Robot> {
        private final int position;
        private int health;
        private final char direction;
        private final int defaultPosition;

        public Robot(int position, int health, char direction, int defaultPosition) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.defaultPosition = defaultPosition;
        }

        public int getPosition() {
            return position;
        }

        public int getHealth() {
            return health;
        }

        public char getDirection() {
            return direction;
        }

        public void decreaseHealth() {
            health -= 1;
        }

        @Override
        public int compareTo(Robot robot) {
            return Integer.compare(this.position, robot.position);
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "position=" + position +
                    ", health=" + health +
                    ", direction=" + direction +
                    '}';
        }

        public int getDefaultPosition() {
            return defaultPosition;
        }
    }


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Robot> stack = new Stack<>();
        List<Robot> robots = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            var robot = new Robot(positions[i], healths[i], directions.charAt(i), i);
            robots.add(robot);
        }

        Collections.sort(robots);

        for (var robot : robots) {
            boolean toPush = true;

            while (!stack.isEmpty()) {
                var stackRobot = stack.peek();

                if (stackRobot.getDirection() == 'R' && robot.getDirection() == 'L') {
                    if (robot.getHealth() == stackRobot.getHealth()) {
                        stack.pop();
                        toPush = false;
                        break;
                    } else if (stackRobot.getHealth() < robot.getHealth()) {
                        stack.pop();
                        robot.decreaseHealth();
                    } else if (stackRobot.getHealth() > robot.getHealth()) {
                        robot = stack.pop();
                        robot.decreaseHealth();
                    }
                } else {
                    break;
                }
            }
            if (toPush) stack.push(robot);
        }

        robots.clear();
        while (!stack.isEmpty()) {
            var robot = stack.pop();
            robots.add(robot);
        }
        return robots.stream()
                .sorted(Comparator.comparingInt(Robot::getDefaultPosition))
                .map(Robot::getHealth)
                .toList();
    }
}
