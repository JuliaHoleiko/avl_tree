package com.company;

public class Path {
    int graph_length;
    int start;
    int end;
    int[][] graph;

    public Path(int graph_length, int start, int end, int[][] graph) {
        this.graph_length = graph_length;
        this.start = start;
        this.end = end;
        this.graph = graph;
    }

    int minDistance(int[] distance, Boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int near_vertex = -1;
        for (int i = 0; i < graph_length; i++) {
            if (!visited[i] && (distance[i] <= min)) {
                min = distance[i];
                near_vertex = i;
            }
        }
        return near_vertex;
    }

    int shortestDistance() {
        int[] distance = new int[graph_length];
        int[] parents = new int[graph_length];
        parents[start] = -1;
        Boolean[] visited = new Boolean[graph_length];

        for (int i = 0; i < graph_length; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[start] = 0;

        for (int i = 0; i < graph_length; i++) {
            int visited_vertex = minDistance(distance, visited);
            visited[visited_vertex] = true;
            for (int v = 0; v < graph_length; v++) {
                if (!visited[v] && graph[visited_vertex][v] != 0 && distance[visited_vertex] != Integer.MAX_VALUE
                        && distance[visited_vertex] + graph[visited_vertex][v] < distance[v]) {
                    distance[v] = distance[visited_vertex] + graph[visited_vertex][v];
                    parents[v] = visited_vertex;
                }
            }
        }
        printResults(distance, parents);
        return distance[end];
    }

    void printResults(int[] dist, int[] parents) {
        System.out.println();
        System.out.println("From " + start + " to " + end + ": " + " distance:" + dist[end] + "   path: ");
        printPath(end, parents);
    }
    void printPath(int currentVertex, int[] parents) {
        if (currentVertex == -1) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
}
