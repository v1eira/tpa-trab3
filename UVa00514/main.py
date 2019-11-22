#
# UVa 00514
# Autores: Ewerson Vieira Nascimento e Icaro Gavazza
#

def main():
    while True:
        N = int(input())
        if N == 0:
            break
        
        coach = []
        for i in range(N):
            coach.append(0)
        
        while True:
            line = input().split(" ")

            coach[0] = int(line[0])
            if coach[0] == 0:
                print()
                break
            
            for i in range(1, N):
                coach[i] = int(line[i])
            
            train = []
            presentCoach = 1
            index = 0

            while presentCoach <= N:
                train.append(presentCoach)

                while len(train) != 0 and train[-1] == coach[index]:
                    train.pop()
                    index += 1
                    if index >= N:
                        break
                
                presentCoach += 1
            
            if len(train) == 0:
                print("Yes")    
            else:
                print("No")


main()