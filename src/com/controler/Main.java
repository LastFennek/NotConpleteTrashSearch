package com.controler;

import com.version1.Finder;
import com.version2.FinderV2;
import com.version2.FinderV2O1WithoutPath;
import com.version2.FinderV2WithoutPath;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        int max = 5000;
	    Graph graph = new Graph(15000,80,max);
	    //graph.printArr();
        System.out.println("Create Graph Time: "+ (System.nanoTime()-start)/1000000+"\n\n");

        start = System.nanoTime();
        RealTestAlgo dijk = new RealTestAlgo(graph.getArr());
        dijk.dijkstra_GetMinDistances(0,1);
        System.out.println("Find way Time (Tester): "+ (System.nanoTime()-start)/1000000);
        System.out.println("\n");


        //Finder finder = new Finder();
        //start = System.nanoTime();
        //Object[] test = finder.findWay(graph.getArr(),0,1);
        //System.out.println("Weg: "+test[0]);
        //System.out.println("Path: "+test[1]);
        //System.out.println("Find way Time: "+ (System.nanoTime()-start)/1000000);
        //System.out.println("\n");


        //start = System.nanoTime();
        //FinderV2 FinderV2 = new FinderV2();
        //graph.printArr();
        //Object[] ret = FinderV2.findWay(graph.getArr(),0,1);
        //System.out.println("FinderV2: "+ret[0]);
        //System.out.println("FinderV2: "+ret[1]);
        //System.out.println("Find way V2 Time: "+ (System.nanoTime()-start)/1000000);
/*
        System.out.println("\n");

        start = System.nanoTime();
        FinderV2WithoutPath FinderV2W = new FinderV2WithoutPath();
        //graph.printArr();
        int[][] test = new int[graph.getArr().length][graph.getArr().length];
        for (int i = 0; i < graph.getArr().length; i++) {
            System.arraycopy(graph.getArr()[i], 0, test[i], 0, graph.getArr()[0].length);
        }
        int ret1 = FinderV2W.findWay(test,0,1);
        System.out.println("FinderV2W: "+ret1);
        System.out.println("Find way V2W Time: "+ (System.nanoTime()-start)/1000000);

        System.out.println("\n");
*/
        start = System.nanoTime();
        FinderV2O1WithoutPath FinderV2O1W = new FinderV2O1WithoutPath();
        //graph.printArr();
        int ret2 = FinderV2O1W.findWay(graph.getArr(),0,1, max);
        System.out.println("FinderV2O1W: "+ret2);
        System.out.println("Find way V2O1W Time: "+ (System.nanoTime()-start)/1000000);



        //int i = 0;
        //int j = 0;

        //int counter = 5;
        //while (i == j){
            //Graph graph1 = new Graph(counter,100,5);
            //Object[] test1 = finder.findWay(graph1.getArr(),0,1);
            //i = (int)test1[0];
            //j = (int)FinderV2.findWay(graph.getArr(),0,1)[0];
            //counter++;
        //}
        //System.out.println(counter);
    }
}
