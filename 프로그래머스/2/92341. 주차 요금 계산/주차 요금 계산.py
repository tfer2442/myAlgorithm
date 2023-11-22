import math

carTimes = {}
carFees = {}
cars = {}


def hourToMinute(time):
    hour, minute = map(int, time.split(':'))
    return hour * 60 + minute


def calTime(carNumber, time):
    parkingTime = time - cars[carNumber]
    del cars[carNumber]
        
    if carNumber not in carTimes:
        carTimes[carNumber] = parkingTime
        return
    carTimes[carNumber] += parkingTime
    return


def calFee(fees):
    for carNumber in carTimes:
        if carTimes[carNumber] <= fees[0]:
            carFees[carNumber] = fees[1]
        else:
            carFees[carNumber] = int(fees[1] + math.ceil((carTimes[carNumber] - fees[0])/fees[2]) * fees[3])
    
    
    
def solution(fees, records):
    answer = []
    
    for record in records:
        time, carNumber, status = record.split(' ')
        time = hourToMinute(time)
        
        if carNumber in cars:
            calTime(carNumber, time)
        elif carNumber not in cars:
            cars[carNumber] = time
    
    temp = {}
    for car in cars:
        temp[car] = cars[car]
    for t in temp:
        calTime(t, hourToMinute('23:59'))
    
    calFee(fees)
    
    result = []
    for carNumber in carFees:
        result.append((carNumber, carFees[carNumber]))
    result.sort()
    for r in result:
        answer.append(r[1])
    
    return answer

# fees[0] 기본시간(분), fees[1]: 기본요금(원), 
# fees[2]: 단위시간(분), fees[3]: 단위요금(원)
# records: 시각(HH:MM) 차량번호('0000') 내역('IN' 'OUT')