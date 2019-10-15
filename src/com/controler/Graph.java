package com.controler;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {
    int[][] arr;
    private ThreadLocalRandom rand = ThreadLocalRandom.current();

    public Graph(int size, int density, int upTo){
        this.arr = new int[size][size];
        this.createEdges(density, upTo);
    }

    public Graph(){}

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
        StringBuilder out = new StringBuilder();
        for (int[] x : arr){
            out.append("|").append(count).append("\t");
            count++;
        }
        out = new StringBuilder("|\t\t" + out + "\n\n");
        count = 0;
        for (int[] x : arr) {
            out.append("|").append(count).append("\t\t");
            count++;
            for (int y : x){
                out.append("|").append(y).append("\t");
            }
            out.append("\n");
        }
        System.out.println(out+"\n\n");
    }

    public void printArr(int[][] arr1){
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int[] x : arr1){
            out.append("|").append(count).append("\t");
            count++;
        }
        out = new StringBuilder("|\t\t" + out + "\n\n");
        count = 0;
        for (int[] x : arr1) {
            out.append("|").append(count).append("\t\t");
            count++;
            for (int y : x){
                out.append("|").append(y).append("\t");
            }
            out.append("\n");
        }
        System.out.println(out+"\n\n");
    }
}
