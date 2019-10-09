package com.version2;

import com.controler.Graph;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class FinderV2O1WithoutPath {

    public int findWay(int[][] arr, int origin, int destination, int max){

        Graph graf = new Graph();

        BitSet lowNum = new BitSet();
        BitSet[] num = new BitSet[(arr.length-1)*max];
        lowNum.set(origin);
        num[origin] = new BitSet(){{set(origin);}};

        int col;
        while(true){
            col = num[lowNum.nextSetBit(0)].nextSetBit(0);


            for(int i = 0; i < arr.length; i++){
                arr[i][col] = 0;
            }

            //graf.printArr(arr);
            if(col == destination){
                break;
            }
            for(int i = 0; i < arr.length; i++){
                if(arr[col][i] > 0){
                    if(lowNum.get(arr[col][i]+lowNum.nextSetBit(0))){
                        num[arr[col][i]+lowNum.nextSetBit(0)].set(i);
                    }else{
                        int finalI = i;
                        num[arr[col][i]+lowNum.nextSetBit(0)] = new BitSet(){{set(finalI);}};
                        lowNum.set(arr[col][i]+lowNum.nextSetBit(0));
                    }
                }

            }
            num[lowNum.nextSetBit(0)].clear(num[lowNum.nextSetBit(0)].nextSetBit(0));
            //System.out.println(num[lowNum.nextSetBit(0)].cardinality());
            if( num[lowNum.nextSetBit(0)].cardinality() < 1){
                lowNum.clear(lowNum.nextSetBit(0));
            }
        }


        return lowNum.nextSetBit(0);
    }
}
