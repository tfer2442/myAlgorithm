from itertools import combinations, permutations


resultSet = set()


def isSameId(c_id, b_id):
    for i in range(len(c_id)):
        if c_id[i] != b_id[i] and b_id[i] != '*':
            return False
    return True

    
def compareIds(choice_id, banned_id):

    for i in range(len(choice_id)):
        if len(choice_id[i]) != len(banned_id[i]):
            return;
        if not isSameId(choice_id[i], banned_id[i]):
            return;
    resultSet.add(choice_id)
    return;


def solution(user_id, banned_id):
    answer = 0
    banned_set = set()
    
    for b_id in permutations(banned_id):
        banned_set.add(b_id)
    
    for choice_ids in combinations(user_id, len(banned_id)):
        for b_id in banned_set:
            compareIds(choice_ids, b_id)
    answer = len(resultSet)
    return answer