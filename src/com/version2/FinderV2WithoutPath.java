package com.version2;

import java.util.BitSet;
import java.util.TreeMap;

public class FinderV2WithoutPath {

    public int findWay(int[][] arr, int origin, int destination){

        TreeMap<Integer, BitSet> elem = new TreeMap<>();
        elem.put(0,new BitSet(){{set(origin);}});

        int col;
        while(true){
            col = elem.get(elem.firstKey()).nextSetBit(0);

            for(int i = 0; i < arr.length; i++){
                arr[i][col] = 0;
            }

            if(col == destination){
                break;
            }

            for(int i = 0; i < arr.length; i++){
                if(arr[col][i] > 0){
                    if(elem.containsKey(arr[col][i]+elem.firstKey())){
                        elem.get(arr[col][i]+elem.firstKey()).set(i);
                    }else{
                        int finalI = i;
                        elem.put(arr[col][i]+elem.firstKey(),new BitSet(){{set(finalI);}});
                    }
                }

            }

            if( elem.get(elem.firstKey()).cardinality() > 1){
                elem.get(elem.firstKey()).clear(elem.get(elem.firstKey()).nextSetBit(0));
            }else{
                elem.remove(elem.firstKey());
            }
        }


        return elem.firstKey();
    }
}
