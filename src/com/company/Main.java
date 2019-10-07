package com.company;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
	    Graph graph = new Graph(100,100,50);
	    graph.printArr();
        System.out.println("Create Graph Time: "+ (System.nanoTime()-start)/1000000);

	    Finder finder = new Finder();

        System.out.println(graph.getArr()[1][1]);
        Object[] test = finder.findWay(graph.getArr(),2,3);
        System.out.println("Weg: "+test[0]);
        System.out.println(test[1]);
        System.out.println("end");
    }
}
