import java.io.*;

public class Reader {
    public static char[][] readFile() throws IOException {
        int rows;
        int columns;
        File file = new File("data/ijones.in");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        columns = Integer.parseInt(st.split(" ")[0]);
        rows = Integer.parseInt(st.split(" ")[1]);
        if((columns > 2000) && (rows < 1)){
            throw new IOException("Wrong data");
        }
        char[][] map = new char[rows][columns];
        for(int i = 0; i < rows; i++){
            String line = br.readLine();
            for (int j = 0; j < columns; j++){
                map[i][j] = line.charAt(j);
            }
        }
        return map;
    }
    public static void writeFile(int ways) throws IOException{
        File file = new File("data", "ijones.out");
        FileWriter writer = new FileWriter(file);
        writer.write(Integer.toString(ways));
        writer.flush();
    }

}
