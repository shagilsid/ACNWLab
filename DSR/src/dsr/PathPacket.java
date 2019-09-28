package dsr;

import java.util.ArrayList;
import java.util.List;

public class PathPacket {
    int dest;
    List<Node> nodeList;

    PathPacket(){
        nodeList=new ArrayList<>();
    }
}
