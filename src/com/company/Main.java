
package com.company;

import java.util.*;

public class Main {

    class DisjointSet {
        static class Edge {
            int source;
            int destination;

            public Edge(int source, int destination) {
                this.source = source;
                this.destination = destination;
            }
        }

        static class Graph {
            ArrayList<Edge> allEdges = new ArrayList<>();
            HashMap<Integer, Integer> mapOfNumb = new HashMap<>();
            int count;

            Graph() {
                count = 0;

            }

            public void addEdge(int source, int destination) {
                Edge edge = new Edge(source, destination);

                allEdges.add(edge);
                if (!mapOfNumb.containsValue(source)) {
                    mapOfNumb.put(count, source);
                    count++;
                }
                if (!mapOfNumb.containsValue(destination)) {
                    mapOfNumb.put(count, destination);
                    count++;
                }
                System.out.println(mapOfNumb);
            }


            public int find(int[] parent, int vertex) {

                if (parent[vertex] != vertex)
                    return find(parent, parent[vertex]);
                return vertex;
            }

            public void union(int[] parent, int x, int y) {
                int x_set_parent = find(parent, x);
                int y_set_parent = find(parent, y);
                System.out.println(x_set_parent + " " + y_set_parent);
                if (x_set_parent < y_set_parent)

                    parent[y_set_parent] = x_set_parent;
                else parent[x_set_parent] = y_set_parent;
            }

            public void disjointSets() {


                int[] parent = new int[count];
                for (int i = 0; i < count; i++) {
                    parent[i] = i;
                }


                for (int i = 0; i < allEdges.size(); i++) {
                    Edge edge = allEdges.get(i);

                    int x_set = find(parent, mapOfNumb.values().stream().toList().indexOf(edge.source));
                    int y_set = find(parent, mapOfNumb.values().stream().toList().indexOf(edge.destination));

                    if (x_set == y_set) {

                    } else
                        union(parent, x_set, y_set);
                }

                printSets(parent);

            }

            public void printSets(int[] parent) {
                //Find different Sets
                HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
                System.out.println(parent.length);
                int girls, boys, pairs;
                pairs = 0;

                for (int i = 0; i < parent.length; i++) {

                    if (map.containsKey(parent[i])) {

                        ArrayList<Integer> list = map.get(parent[i]);
                        list.add(mapOfNumb.get(i));//add vertex
                        map.put(parent[i], list);
                    } else {

                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(mapOfNumb.get(i));
                        map.put(parent[i], list);
                    }
                }
                //Print the Different sets
                Set<Integer> set = map.keySet();
                Iterator<Integer> iterator = set.iterator();
                ArrayList<Integer> gender = new ArrayList<>();
                while (iterator.hasNext()) {
                    int key = iterator.next();
                    System.out.println("Set Id: " + key + " elements: " + map.get(key));
                    girls = Long.valueOf(map.get(key).stream().filter(x -> x % 2 == 0).count()).intValue();
                    gender.add(girls);
                    boys = map.get(key).size() - girls;
                    gender.add(boys);
                    System.out.println(girls + " " + boys);
                }
                System.out.println(gender);
                for (int i = 0; i < gender.size() - 2; i++) {
                    if (i % 2 == 0)
                        pairs = pairs + gender.get(i) * gender.get(i + 3);
                    else
                        pairs = pairs + gender.get(i) * gender.get(i + 1);
                }
                System.out.println(pairs);
                // count pairs


            }

        }


    }

    public static void main(String[] args) {

        DisjointSet.Graph graph = new DisjointSet.Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(8, 10);

        graph.disjointSets();
    }
}

