// 20210702040 - Emir Devlet Ertörer - Assignment 9

import java.util.Comparator;

public class CostComparator implements Comparator<Services>{
	
	public int compare(Services o1, Services o2) {
		return (int) (o1.getCost() - o2.getCost()); // comparison using getCost of two objects of Services
	}
}