public class QuickFind{

    public static void main(String[] args){
        QF qf = new QF(10);
        qf.union(3,4);
        qf.union(6,9);
        qf.union(2,1);
        System.out.println("6 and 9 connected? " + qf.connected(6,9));
    }

}

class QF {

    private int[] id;

    public QF(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public void union(int p, int q){
        int pval = id[p];
        int qval = id[q];
        for(int i = 0; i < id.length; i++){
            if (id[i] == pval) id[i] = qval;
        }
    }

    public boolean connected(int p, int q){
        return (id[p] == id[q]);
    }

}
