from collections import deque


def solution(begin, target, words):
    answer = 0

    if target not in words:
        return answer
    words.insert(0, begin)
    graph = [[] for _ in range(len(words))]
    for i in range(len(words)):
        for j in range(i+1, len(words)):
            if abcCompare(words[i], words[j]):
                graph[i].append(j)
                graph[j].append(i)
    d1 = deque()
    visited = [0] * len(words)
    d1.append(0)
    visited[0] = 0

    while True:
        if not d1:
            answer = 0
            break
        a = d1.popleft()

        if words[a] == target:
            answer = visited[a]
            break

        for i in graph[a]:
            if not visited[i]:
                d1.append(i)
                visited[i] = visited[a] + 1

    return answer


def abcCompare(a, b):
    cnt = 0
    for i in range(len(a)):
        if a[i] == b[i]:
            cnt = cnt + 1
    if cnt == len(a) - 1:
        return True
    else:
        return False