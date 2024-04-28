for t in range(10):
    dump = int(input())
    boxes = list(map(int, input().split()))
    boxes.sort(reverse=True)
    
    for i in range(dump):
        if boxes[0] - boxes[-1] == 0 or boxes[0] - boxes[-1] == 1:
            break
        boxes[0] -= 1
        boxes[-1] += 1
        boxes.sort(reverse=True)

    print('#%d' %(t+1), boxes[0] - boxes[-1])
    