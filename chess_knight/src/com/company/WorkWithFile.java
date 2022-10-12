package com.company;

import java.io.*;

public class WorkWithFile {
    void addFile(int path) throws Exception {
        FileWriter writer = new FileWriter("result.txt");
        writer.write(Integer.toString(path));
        writer.flush();
    }


    int[] readFile() throws Exception {
        File file = new File("task.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int[] input = new int[5];

        int i = 0;
        while ((st = br.readLine()) != null) {
            if (st.contains(",")) {
                String[] arr = st.split(",");
                int pos_x, pos_y;
                pos_x = Integer.parseInt(arr[0]);
                pos_y = Integer.parseInt(arr[1]);
                input[i] = pos_x;
                i++;
                input[i] = pos_y;
                i++;



            } else {

                input[i] = Integer.parseInt(st);
                i++;
            }
        }

        return input;
    }
}
