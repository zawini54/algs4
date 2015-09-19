class QuickFind:

    id = []

    def __init__(self, N):
        for x in range(0, N):
            self.id.append(x)  # initialize array

    def union(self, p, q):
        pval = self.id[p]  # value of p
        qval = self.id[q]  # value of q

        for i in range(0, len(self.id)-1):  # loops through id[]
            if self.id[i] == pval:  # if the value at that index is equal to the value of p
                self.id[i] = qval  # change the value at that index to q

    def connected(self, p, q):
        return self.id[p] == self.id[q]

if __name__ == '__main__':
    qf = QuickFind(10)
    qf.union(1, 3)
    qf.union(3, 4)
    qf.union(4, 9)
    print(qf.connected(1, 9))
