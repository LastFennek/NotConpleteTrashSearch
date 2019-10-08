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
        ArrayList<ArrayList<Integer>> start1 = new ArrayList<>();
        ArrayList<Integer> toAdd1 = new ArrayList<>();
        toAdd1.add(origin);
        start1.add(toAdd1);
        elem.put(0,start1);

        int col;
        while(true){

            col = elem.get(elem.firstKey()).get(0).get(elem.get(elem.firstKey()).get(0).size()-1);
            already[col] = true;

            if(col == destination){
                break;
            }

                for(int i = 0; i < arr.length; i++){
                    if(!already[i]){
                        if(arr[col][i] > 0){

                            if(elem.containsKey(arr[col][i]+elem.firstKey())){
                                ArrayList<Integer> temp = new ArrayList<>();
                                temp.addAll(elem.get(elem.firstKey()).get(0));
                                temp.add(i);
                                elem.get(arr[col][i]+elem.firstKey()).add(temp);
                                temp = null;
                            }else{
                                ArrayList<ArrayList<Integer>> start = new ArrayList<>();
                                ArrayList<Integer> toAdd = new ArrayList<>();
                                toAdd.addAll(elem.get(elem.firstKey()).get(0));
                                toAdd.add(i);
                                start.add(toAdd);
                                elem.put(arr[col][i]+elem.firstKey(),start);
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
