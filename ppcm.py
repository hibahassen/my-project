def saisie1():
    n=int(input("n="))
    while not n>0:
        n=int(input("n="))
    return n
def saisie2():
    m=int(input("m="))
    while not m>0:
        m=int(input("m="))
    return m
def ppcm(m,n):
    p=m
    while not p%n==0:
        p=p+m
    return p








n=saisie1()
m=saisie2()
if m==n:
    print(m)
else:
    p=ppcm(m,n)
    print(p)
