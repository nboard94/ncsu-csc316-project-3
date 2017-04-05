package edu.ncsu.csc316.transportation_manager.util;

import edu.ncsu.csc316.transportation_manager.heap.MinHighwayHeap;
import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.set.UpTree;

public class MinimumHighwayFinder {
	
	AdjacencyList MST = new AdjacencyList();
	
	public MinimumHighwayFinder(ArrayBasedList<Highway> highways, AdjacencyList initList, String type) {
		
		// insert the edges into the heap, partially ordered according to edge weight
		MinHighwayHeap heap = new MinHighwayHeap(type);
		for(int i = 0; i < highways.size(); i++) {
			
			heap.insert(highways.lookUp(i));
		}
		
		// initially, each vertex is in a component by itself
		UpTree upTree = new UpTree(initList.getVertexCount());
		
		// process edges in order of increasing weight
		Highway currentMin;
		int c1;
		int c2;
		while(upTree.size > 1) {
			
			currentMin = heap.deleteMin();
			c1 = currentMin.getCity1();
			c2 = currentMin.getCity2();
			
			if(upTree.find(c1) != upTree.find(c2)) {
				
				upTree.union(c1, c2);
			}
		}
	}
	
	public AdjacencyList getMST() {
		
		return MST;
	}

}