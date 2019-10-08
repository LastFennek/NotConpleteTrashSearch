package com.controler;

public class RealTestAlgo {

    //static class Graph{
        int vertices;
        int matrix[][];

        //public Graph(int[][] arr) {
        public RealTestAlgo(int[][] arr) {
            this.vertices = arr[0].length;
            matrix = arr;
        }

        public void addEdge(int source, int destination, int weight) {
            //add edge
            matrix[source][destination]=weight;

            //add back edge for undirected graph
            matrix[destination][source] = weight;
        }


        int getMinimumVertex(boolean [] mst, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) {
                if(mst[i]==false && minKey>key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex, int endVertex){
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;

            for (int i = 0; i <vertices ; i++) {
                distance[i] = INFINITY;
            }

            distance[sourceVertex] = 0;

            for (int i = 0; i <vertices ; i++) {

                int vertex_U = getMinimumVertex(spt, distance);
                spt[vertex_U] = true;

                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
                    if(matrix[vertex_U][vertex_V]>0){
                        if(!spt[vertex_V] && matrix[vertex_U][vertex_V]!=INFINITY){

                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            printDijkstra(sourceVertex, distance, endVertex);
        }

        public void printDijkstra(int sourceVertex, int [] key, int endVertex){
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
            for (int i = 0; i <vertices ; i++) {
                if(endVertex == i){
                    System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                            " distance: " + key[i]);
                }
            }
        }
    //}
}
