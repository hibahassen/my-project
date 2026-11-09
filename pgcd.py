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
def pgcd(m,n):
    while n!=0:
        r=m%n
        m=n
        n=r
    return m
n=saisie1()
m=saisie2()
if m==n:
    print(m)
else:
    p=pgcd(m,n)
    print(p)

