import java.util.ArrayList;

public class Ijones {
    char[][] map;

    public Ijones(char[][] map) {
        this.map = map;

    }
    public int findAllWaysFromCell(int x, int y) {
        if (y != 0) {
            int ways = 0;
            ArrayList<Position> waysToJump = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < y; j++) {
                    if (map[i][j] == map[x][y]) {
                        Position pos = new Position(i, j);
                        waysToJump.add(pos);
                    }
                }
            }
            for (int i = 0; i < waysToJump.size(); i++) {
                ways = ways + findAllWaysFromCell(waysToJump.get(i).x, waysToJump.get(i).y);
            }
            if (map[x][y] != map[x][y - 1]) {
                ways = ways + findAllWaysFromCell(x, y - 1);
            }
            return ways;
        } else return 1;
    }

    public int getPaths() {
        int rows = map.length;
        int columns = map[0].length;
        int ways = 0;
        ways = ways + findAllWaysFromCell(rows - 1, columns - 1);
        if (rows > 1) {
            ways = ways + findAllWaysFromCell(0, columns - 1);
        }
        return ways;
    }

}

