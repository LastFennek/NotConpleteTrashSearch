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
        int x = origin;
        lowNum.set(x);
        num[origin] = new BitSet(){{set(origin);}};

        int col;
        while(true){
            col = num[lowNum.nextSetBit(x)].nextSetBit(0);
            x = lowNum.nextSetBit(x);

            if(col == destination){
                break;
            }

            for(int i = 0; i < arr.length; i++){
                arr[i][col] = 0;
            }

            for(int i = 0; i < arr.length; i++){
                if(arr[col][i] > 0){
                    if(lowNum.get(arr[col][i]+x)){
                        num[arr[col][i]+x].set(i);
                    }else{
                        int finalI = i;
                        num[arr[col][i]+x] = new BitSet(){{set(finalI);}};
                        lowNum.set(arr[col][i]+x);
                    }
                }

            }
            if( num[x].cardinality() < 2){
                lowNum.clear(x);
            }else {
                num[x].clear(num[x].nextSetBit(0));
            }
        }


        return lowNum.nextSetBit(0);
    }
}
