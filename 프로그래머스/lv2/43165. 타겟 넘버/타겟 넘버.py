def solution(numbers, target):
    answer = 0
    numbers.insert(0, 0)
    l1 = [0, 0]
    s = []

    for i in range(1, len(numbers)):
        for j in range(2**(i-1)):
            l1.append(numbers[i])
            l1.append(-numbers[i])
    for i in range(len(l1)):
        l1.append(0)

    count = 0
    cur = 1
    s.append(l1[cur])
    while True:
        if len(s) == 0:
            answer = count
            break

        if l1[cur*2] != 0:
            cur = cur*2
            s.append(l1[cur])
        elif l1[cur*2 + 1] != 0:
            cur = cur*2 + 1
            s.append(l1[cur])
        else:
            if len(s) == len(numbers):
                s_sum = sum(s)
                if s_sum == target:
                    count = count + 1
            l1[cur] = 0
            cur = cur//2
            s.pop()

    return answer