class QuickUnion:

    id = []

    def __init__(self, N):
        for x in range(0, N):
            self.id.append(x)

    def root(self, i):
        # i is index
        # self.id[i] is value
        while i != self.id[i]:  # while index is not equal to value
            i = self.id[i]  # set index equal to the value

        return i

    """
    i   0   1   2
    v   1   1   0

    Checks index zero first. It sees 1. Then, it sets i to be one and then checks again if it is equal to v.
    It sees that it's equal. So, it stops there and return the index, i.
    """

    def union(self, p, q):  # sets the root of the root of p to be the root of q. Now p and q share the same root
        # self.id[self.root(p)] = value at root of p
        self.id[self.root(p)] = self.root(q)  # or self.id[self.root(q)] does the same thing because it is root

    def connected(self, p, q):
        return self.root(p) == self.root(q)

if __name__ == '__main__':
    qu = QuickUnion(10)
    qu.union(1, 4)
    qu.union(4, 9)
    qu.union(4, 5)
    qu.union(6, 1)
    print(qu.connected(1, 9))  # prints true