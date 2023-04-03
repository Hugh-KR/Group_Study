NM=input().split()
start=input().split()
n,m=int(NM[0]),int(NM[1])
r,c,d=int(start[0]),int(start[1]),int(start[2])
room=[input().split() for _ in range(n)]
move=[(-1,0),(0,1),(1,0),(0,-1)]

while room[r][c]!='1':
    if room[r][c]=='0':
        room[r][c]='2'

    check=0

    for i in range(1,5):
        nd=d-i if d>=i else 4+(d-i)
        nr=r+move[nd][0]
        nc=c+move[nd][1]
        if 0<=nr<n and 0<=nc<m and room[nr][nc]=='0':
            check+=1
            r,c,d=nr,nc,nd
            break
    
    if check==0:
        td=(d+2)%4
        r=r+move[td][0]
        c=c+move[td][1]
        if not(0<=r<n and 0<=c<m):
            break



answer=0
for i in range(n):
    for j in range(m):
        if room[i][j]=='2':
            answer+=1

print(answer)
