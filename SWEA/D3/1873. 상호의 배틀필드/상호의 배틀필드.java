import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Tank {
        Position position, direction;

        public Tank(Position position, Position direction) {
            this.position = position;
            this.direction = direction;
        }

        public void updateDirection(char command) {
            switch (command) {
                case '^':
                case 'U':
                    direction.x = -1;
                    direction.y = 0;
                    break;
                case 'v':
                case 'D':
                    direction.x = 1;
                    direction.y = 0;
                    break;
                case '<':
                case 'L':
                    direction.x = 0;
                    direction.y = -1;
                    break;
                case '>':
                case 'R':
                    direction.x = 0;
                    direction.y = 1;
                    break;
            }
        }

        public void move(int height, int width, char[][] battlefield) {
            int newX = position.x + direction.x;
            int newY = position.y + direction.y;

            if (newX >= 0 && newY >= 0 && newX < height && newY < width && battlefield[newX][newY] == '.') {
                battlefield[position.x][position.y] = '.';
                position.x = newX;
                position.y = newY;
            }
            battlefield[position.x][position.y] = getTankChar();
        }

        private char getTankChar() {
            if (direction.x == -1) return '^';
            if (direction.x == 1) return 'v';
            if (direction.y == -1) return '<';
            return '>';
        }

        public void shoot(int height, int width, char[][] battlefield) {
            int currentX = position.x;
            int currentY = position.y;

            while (true) {
                currentX += direction.x;
                currentY += direction.y;

                if (currentX < 0 || currentY < 0 || currentX >= height || currentY >= width || battlefield[currentX][currentY] == '#') {
                    break;
                }

                if (battlefield[currentX][currentY] == '*') {
                    battlefield[currentX][currentY] = '.';
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();

        for (int test_case = 1; test_case <= testCaseCount; test_case++) {
            String[] dimensions = reader.readLine().split(" ");
            int height = Integer.parseInt(dimensions[0]);
            int width = Integer.parseInt(dimensions[1]);

            char[][] battlefield = new char[height][width];
            Tank tank = null;

            for (int i = 0; i < height; i++) {
                String line = reader.readLine();
                for (int j = 0; j < width; j++) {
                    battlefield[i][j] = line.charAt(j);
                    if ("^v<>".indexOf(battlefield[i][j]) != -1) {
                        tank = new Tank(new Position(i, j), new Position(0, 0));
                        tank.updateDirection(battlefield[i][j]);
                    }
                }
            }

            int commandCount = Integer.parseInt(reader.readLine());
            String commands = reader.readLine();

            for (int i = 0; i < commandCount; i++) {
                char command = commands.charAt(i);

                if (command == 'S') {
                    tank.shoot(height, width, battlefield);
                } else {
                    tank.updateDirection(command);
                    tank.move(height, width, battlefield);
                }
            }

            result.append("#").append(test_case).append(" ");
            for (int i = 0; i < height; i++) {
                result.append(new String(battlefield[i])).append("\n");
            }
        }

        System.out.print(result);
        reader.close();
    }
}
