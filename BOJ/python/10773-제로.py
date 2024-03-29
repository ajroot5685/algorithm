from collections import deque

stack = deque()

n = int(input())

for i in range(n):
    tmp = int(input())
    if tmp == 0:
        stack.pop()
    else:
        stack.append(tmp)

total = sum(stack)

print(total)