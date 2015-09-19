//quick union with weighting and path compression
public class QUWPC {
    public static void main(String[] args){
        QU qu = new QU(10);
        qu.union(0, 4);
        qu.union(5, 6);
        qu.union(7, 3);
        qu.union(9, 4);
        qu.union(0, 7);
        qu.union(6, 9);
        for (int x : qu.id){
            System.out.println(x);
        }
    }
}
class QU {

    int[] id;
    int[] sz;

    public QU(int N){
        N = N + 1;
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while(i != id[i]){
            //path compression
            id[i]= id[id[i]];
            /*
            sets root to grandparent (so it is the same level as the parent)
            and if it does not have one (reached root), the root will be the parent
            because index and id match.
            */
            i = id[i]; // next
        }
        return i;
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        if(sz[rootP] > sz[rootQ]){
            id[rootQ] = id[rootP];
            sz[rootP] += sz[rootQ];
        }else{
            id[rootP] = id[rootQ];
            sz[rootQ] += sz[rootP];
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

}
