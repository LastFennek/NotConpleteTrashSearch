package com.version2;

import java.util.ArrayList;
import java.util.TreeMap;

public class FinderV2WithoutPath {

    public int findWay(int[][] arr, int origin, int destination){

        Boolean[] already = new Boolean[arr.length];
        for(int i = 0; i < already.length;i++){
            already[i] = false;
        }
        TreeMap<Integer, ArrayList<Integer>> elem = new TreeMap<>();
        elem.put(0,new ArrayList<Integer>(){{add(origin);}});

        int col;
        while(true){
            ArrayList<Integer> x = elem.get(elem.firstKey());
            col = x.get(0);

            already[col] = true;

            if(col == destination){
                break;
            }

            for(int i = 0; i < arr.length; i++){
                if(!already[i]){
                    if(arr[col][i] > 0){
                        if(elem.containsKey(arr[col][i]+elem.firstKey())){
                            elem.get(arr[col][i]+elem.firstKey()).add(i);
                        }else{
                            int finalI = i;
                            elem.put(arr[col][i]+elem.firstKey(),new ArrayList<Integer>(){{add(finalI);}});
                        }
                    }
                }
            }

            if( elem.get(elem.firstKey()).size() > 1){
                elem.get(elem.firstKey()).remove(0);
            }else{
                elem.remove(elem.firstKey());
            }
        }


        return elem.firstKey();
    }
}
