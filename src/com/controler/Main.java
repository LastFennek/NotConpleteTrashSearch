package com.controler;

import com.version1.Finder;
import com.version2.FinderV2;
import com.version2.FinderV2O1WithoutPath;
import com.version2.FinderV2WithoutPath;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        int max = 10000;
	    Graph graph = new Graph(15000,1,max);
	    //graph.printArr();
        System.out.println("Create Graph Time: "+ (System.nanoTime()-start)/1000000+"\n\n");

        start = System.nanoTime();
        RealTestAlgo dijk = new RealTestAlgo(graph.getArr());
        dijk.dijkstra_GetMinDistances(0,1);
        System.out.println("Find way Time (Tester): "+ (System.nanoTime()-start)/1000000);
        System.out.println("\n");


        start = System.nanoTime();
        FinderV2O1WithoutPath FinderV2O1W = new FinderV2O1WithoutPath();
        //graph.printArr();
        int ret2 = FinderV2O1W.findWay(graph.getArr(),0,1, max);
        System.out.println("FinderV2O1W: "+ret2);
        System.out.println("Find way V2O1W Time: "+ (System.nanoTime()-start)/1000000);



    }
}
