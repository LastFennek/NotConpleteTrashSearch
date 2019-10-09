package com.version2;

import com.controler.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FinderV2 {


    public Object[] findWay(int[][] arr, int origin, int destination){

        Boolean[] already = new Boolean[arr.length];
        for(int i = 0; i < already.length;i++){
            already[i] = false;
        }
        TreeMap<Integer, ArrayList<ArrayList<Integer>>> elem = new TreeMap<>();
        elem.put(0,new ArrayList<ArrayList<Integer>>(){{add(new ArrayList<Integer>(){{add(origin);}});}});

        int col;
        while(true){
            ArrayList<Integer> x = elem.get(elem.firstKey()).get(0);
            col = x.get(x.size()-1);


            already[col] = true;

            if(col == destination){
                break;
            }

                for(int i = 0; i < arr.length; i++){
                    if(!already[i]){
                        if(arr[col][i] > 0){

                            if(elem.containsKey(arr[col][i]+elem.firstKey())){
                                ArrayList<Integer> temp = new ArrayList<>(x);
                                temp.add(i);
                                elem.get(arr[col][i]+elem.firstKey()).add(temp);
                            }else{
                                int finalI = i;
                                elem.put(arr[col][i]+elem.firstKey(),new ArrayList<ArrayList<Integer>>(){{add(new ArrayList<Integer>(){{addAll(x); add(finalI);}});}});
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


        return new Object[]{elem.firstKey(),elem.get(elem.firstKey()).get(0)};
    }
}
