package com.company;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
	    Graph graph = new Graph(200,50,5000);
	    //graph.printArr();
        System.out.println("Create Graph Time: "+ (System.nanoTime()-start)/1000000+"\n\n");

        start = System.nanoTime();
	    Finder finder = new Finder();
        RealTestAlgo dijk = new RealTestAlgo(graph.getArr());
        dijk.dijkstra_GetMinDistances(0,1);
        System.out.println("Find way Time (Tester): "+ (System.nanoTime()-start)/1000000);
        System.out.println("\n");


        start = System.nanoTime();
        Object[] test = finder.findWay(graph.getArr(),0,1);
        System.out.println("Weg: "+test[0]);
        //System.out.println(test[1]);
        System.out.println("Find way Time: "+ (System.nanoTime()-start)/1000000);
        //System.out.println("end");
    }
}
