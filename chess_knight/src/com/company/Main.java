package com.company;

public class Main {
    static int[][] doMatrixForBoard(int n) {

        int[][] matrix = new int[n * n][n * n];
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};
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


    public static void main(String[] args) throws Exception {
        WorkWithFile w = new WorkWithFile();
        int[] arr = w.readFile();
        int size = arr[0] * arr[0];
        int start = arr[1] * 8 + arr[2] ;
        int end = arr[3] * 8 + arr[4] ;
        int[][] matrix = doMatrixForBoard(arr[0] * arr[0]);
        Path path = new Path(size, start, end, matrix);
        int shortest_distance = path.shortestDistance();
        System.out.println(shortest_distance);
        w.addFile(shortest_distance);


    }


}
