package com.controler;

import com.version1.Finder;
import com.version2.FinderV2;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
	    Graph graph = new Graph(20,100,50);
	    //graph.printArr();
        System.out.println("Create Graph Time: "+ (System.nanoTime()-start)/1000000+"\n\n");

        start = System.nanoTime();
        RealTestAlgo dijk = new RealTestAlgo(graph.getArr());
        dijk.dijkstra_GetMinDistances(0,1);
        System.out.println("Find way Time (Tester): "+ (System.nanoTime()-start)/1000000);
        System.out.println("\n");


        Finder finder = new Finder();
        start = System.nanoTime();
        Object[] test = finder.findWay(graph.getArr(),0,1);
        System.out.println("Weg: "+test[0]);
        System.out.println("Path: "+test[1]);
        System.out.println("Find way Time: "+ (System.nanoTime()-start)/1000000);
        System.out.println("\n");



        FinderV2 FinderV2 = new FinderV2();
        graph.printArr();
        System.out.println("FinderV2: "+FinderV2.findWay(graph.getArr(),0,1)[0]);
        System.out.println("FinderV2: "+FinderV2.findWay(graph.getArr(),0,1)[1]);


    }
}
