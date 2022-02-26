import java.util.*;
import java.io.*;


public class DFSGraph
{
    private int v;
    private LinkedList<Integer> adj[];
    boolean [] visited;

    @SuppressWarnings("unchecked") public DFSGraph(int vertices)
    {
        this.v=vertices;
        visited = new boolean[this.v];
        adj= new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]= new LinkedList();    
    }

    public void addEdge(int s, int d)
    {
        adj[s].add(d);
    }

    public void doDFS(int source)
    {       
        visited[source]=true;
        System.out.print(source+ " ");

        Iterator<Integer> itr = adj[source].iterator();
        while(itr.hasNext())
        {
            int temp=itr.next();
            if(!visited[temp])
                doDFS(temp);    
        }
    }

    public static void main(String[] args) {
        
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);


        g.doDFS(2);
    }


}