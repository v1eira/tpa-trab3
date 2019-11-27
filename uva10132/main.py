# UVa 10132 - File Fragmentation
# Autores: Ewerson Vieira Nascimento e Icaro Gavazza

import operator

def main():
    testCases = int(input())

    for i in range(testCases+1):
        solutions = {}
        fragments = []

        fragment, output = "", ""
        size, minSize, maxSize = 0, 0, 0

        fragment = input().rstrip()
        while fragment != "":
            fragments.append(fragment)
            try:
                fragment = input().rstrip()
            except:
                break

        if (len(fragments) > 0):
            maxSize = minSize = len(fragments[0])
            for j in range(len(fragments)):
                for k in range(len(fragments)):
                    size = len(fragments[j])
                    if maxSize < size:
                        maxSize = size
                    if minSize > size:
                        minSize = size
            
            size = minSize + maxSize
            
            for x in range(len(fragments)):
                for y in range(len(fragments)):
                    if x != y:
                        output = fragments[x] + fragments[y]
                        if len(output) == size:
                            if output in solutions:
                                solutions[output] += 1
                            else:
                                solutions[output] = 1

            print(max(solutions.items(), key=operator.itemgetter(1))[0])
        
        if i > 0 and i != testCases:
            print()

main()