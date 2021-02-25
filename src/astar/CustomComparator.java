package astar;

import java.util.Comparator;

public class CustomComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getF() < o2.getF()) {
            return -1;
        } else if(o1.getF() == o2.getF()) {
            return 0;
        }
        return 1;
     }
    
    
}
