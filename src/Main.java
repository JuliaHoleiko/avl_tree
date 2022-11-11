import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        char[][] map = Reader.readFile();
        Ijones game = new Ijones(map);
        System.out.println(game.getPaths());
        Reader.writeFile(game.getPaths());


    }
}