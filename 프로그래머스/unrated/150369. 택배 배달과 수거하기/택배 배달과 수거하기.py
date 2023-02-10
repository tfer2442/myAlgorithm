def solution(cap, n, deliveries, pickups):
    dSum = 0
    a = n
    b = n

    Sbox = sum(deliveries)
    Sebox = sum(pickups)

    while True:
        dist_count = 0
        Ddist = 0
        Pdist = 0
        box = min(Sbox, cap)
        ebox = min(Sebox, cap)
        Sbox = Sbox - box
        Sebox = Sebox - ebox

        if box == 0 and ebox == 0:
            break

        for i in range(a - 1, -1, -1):
            if box == 0:
                break
            if deliveries[i] == 0:
                continue

            if deliveries[i] - box > 0:
                deliveries[i] = deliveries[i] - box
                box = 0
                dist_count += 1
            else:
                box = box - deliveries[i]
                deliveries[i] = 0
                dist_count += 1
                a = i

            if dist_count == 1:
                Ddist = (i + 1) * 2

        dist_count = 0
        for i in range(b - 1, -1, -1):
            if ebox == 0:
                break
            if pickups[i] == 0:
                continue
            if pickups[i] - ebox > 0:
                pickups[i] = pickups[i] - ebox
                ebox = 0
                dist_count += 1
            else:
                ebox = ebox - pickups[i]
                pickups[i] = 0
                dist_count += 1
                b = i

            if dist_count == 1:
                Pdist = (i + 1) * 2

        dSum += max(Ddist, Pdist)
    return dSum
