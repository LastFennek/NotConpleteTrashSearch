package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Finder {
    private int shame = Integer.MAX_VALUE;
    private HashMap<Integer,Integer> bestSoFar = new HashMap<>();

    public Object[] findWay(int[][] arr, int origin, int dest){
        Object[] ret = findWay(origin,dest,0,arr,new HashSet<>(), new ArrayList<Integer>());
        Collections.reverse((ArrayList)ret[1]);
        return ret;
    }

    private Object[] findWay(int self, int dest, int way, int[][] arr, HashSet<Integer> soFar, ArrayList<Integer> path){
        int thisWay = Integer.MAX_VALUE;
        if(bestSoFar.containsKey(self)){
            if(bestSoFar.get(self) < way){
                return new Object[]{Integer.MAX_VALUE};
            }
        }
        if(way > shame){
            bestSoFar.put(self,Integer.MAX_VALUE);
            return new Object[]{Integer.MAX_VALUE};
        }
        if(self == dest){
            this.shame = way;
            path = new ArrayList<>();
            path.add(self);
            return new Object[]{way,path};
        }else{
            for(int col = 0; col < arr[self].length; col++){
                if(arr[self][col] > 0){
                    if(!soFar.contains(self)){
                        soFar.add(self);
                        Object[] ret = findWay(col,dest,way + arr[self][col],arr, soFar, path);
                        soFar.remove(self);
                        if(thisWay > (int)ret[0] && (int)ret[0] > 0){
                            thisWay = (int)ret[0];
                            path = (ArrayList<Integer>) ret[1];
                            path.add(self);
                        }
                    }
                }
                bestSoFar.put(self,way);
            }
            return new Object[]{thisWay,path};
        }
    }
}
