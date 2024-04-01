import sys
input = sys.stdin.readline

n = int(input())

cards = list(map(int, input().split(' ')))
cards.sort()

count = {}
for card in cards:
    if card in count:
        count[card] += 1
    else:
        count[card] = 1

m = int(input())

arr = list(map(int, input().split(' ')))

for ind in arr:
    if ind in count:
        print(count[ind], end=" ")
    else:
        print(0, end=" ")