package com.company;

import java.io.*;
import java.util.ArrayList;


public class Main {
    static int[][] doMatrixForBoard(int n){
        // int n = 8;
        int[][] matrix = new int[n * n][n * n];

        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};

        int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};
        int x, y, pos;

        for (int i = 0; i < n * n; i++) {


            for (int j = 0; j < 8; j++) {
                x = i / 8;
                y = i % 8;

                x = x + row[j];
                y = y + col[j];

                if ((x >= 0) && (y >= 0) && (x <= 7) && (y <= 7)) {
                    pos = x * 8 + y;

                    matrix[i][pos] = 1;
                }
            }

        }

        return matrix;
    }
    static int[]  readFile() throws Exception {
        File file = new File("task.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int input[] = new int[5];

        int i = 0;
        while ((st = br.readLine()) != null){
            if(st.contains(",")){
                String arr[] = st.split(",");
                int pos_x,pos_y;
                pos_x = Integer.parseInt(arr[0]);
                pos_y = Integer.parseInt(arr[1]);
                input[i] = pos_x;
                i++;
                input[i] = pos_y;
                i++;

                System.out.println(pos_x+ " "+ pos_y);
                //System.out.println(pos_y);
            }
            else {
                System.out.println(st);
                input[i] = Integer.parseInt(st);
                i++;
            }
        }
        System.out.println();
        for(int j = 0; j <5;j++){
            System.out.println(input[j]);
        }
        return input;
    }

    public static void main(String[] args) throws Exception {
        int arr[] = readFile();

        int matrix[][] = doMatrixForBoard(arr[0]* arr[0]);
        Path p = new Path(arr[0]*arr[0], 0,62);
       int k = p.dijkstra(matrix, 0);
        System.out.println();
        System.out.println(k);
        WorkWithFile w = new WorkWithFile();
        w.addFile(k);



    }







    }
