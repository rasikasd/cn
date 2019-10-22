import socket

print('Welcome to DNS lookup')
print('Enter option: 1. URL to IP, 2. IP to URL')
op=input('enter option')

if op=='1':
 var1=input('Enter URL')
 addr1 = socket.gethostbyname(var1)
 print(addr1)
else:
 var2=input('Enter IP')
 addr2 = socket.gethostbyaddr(var2)
 print(addr2)

