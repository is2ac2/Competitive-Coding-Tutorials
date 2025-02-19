class UnionFind:
    def __init__(self, n):
        self.parents = []
        self.sz = []
        for i in range(n):
            self.parents.append(i)
            self.sz.append(1)

    def find(self, a):
        while (a != self.parents[a]):
            a = self.parents[a]
        return a

    def union(self, a, b):
        a_root, b_root = self.find(a), self.find(b)
        if a_root == b_root:
            return
        if self.sz[a_root] < self.sz[b_root]:
            temp = a_root
            a_root = b_root
            b_root = temp
        self.parents[b_root] = a_root
        self.sz[a_root] += self.sz[b_root]
        
    def size(self, a):
        return self.sz[self.find(a)]
        
def main():
    n = 5
    uf = UnionFind(n)
    uf.union(0,1)
    uf.union(2,1)
    uf.union(3,4)
    uf.union(4,1)
    print(uf.find(0))
    print(uf.size(0))
    
if __name__ == "__main__":
    main()