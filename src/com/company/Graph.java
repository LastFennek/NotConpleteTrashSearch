package com.company;

import java.util.Random;

public class Graph {
    int[][] arr;
    Random rand = new Random(1);

    Graph(int size, int density, int upTo){
        this.arr = new int[size][size];
        this.createEdges(density, upTo);
    }

    public void createEdges(int density,int upTp){
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++){
                if(density>rand.nextInt(100)){
                    arr[x][y] = rand.nextInt(upTp);
                }
            }
        }
    }

    public int[][] getArr() {
        return arr;
    }

    public void printArr(){
        int count = 0;
        String out = "";
        for (int[] x : arr){
            out += "|"+count+"\t";
            count++;
        }
        out = "|\t\t"+out+"\n\n";
        count = 0;
        for (int[] x : arr) {
            out += "|"+count+"\t\t";
            count++;
            for (int y : x){
                out += "|"+y+"\t";
            }
            out += "\n";
        }
        System.out.println(out+"\n\n");
    }
}
