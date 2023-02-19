def solution(s):
    d1 = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 
         'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    str1 = ""
    visited = [False] * len(s)

    for i in range(len(s)):
        if not visited[i]:
            if ord('0') <= ord(s[i]) <= ord('9'):
                str1 += s[i]
                visited[i] = True
            else:
                str2 = ""
                for j in range(i, len(s)):
                    if ord('a') <= ord(s[j]) <= ord('z'):
                        str2 += s[j]
                        visited[j] = True
                    if str2 in d1:
                        str1 += d1[str2]
                        break
    answer = int(str1)
    return answer