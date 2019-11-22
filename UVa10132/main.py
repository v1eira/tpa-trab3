#
# UVa 11988
# Autores: Ewerson Vieira Nascimento e Icaro Gavazza
#

import operator

def main():
    testCases = int(input())

    for i in range(testCases):
        input()
        solutions = {}
        fragments = []

        fragment, output = "", ""
        size, minSize, maxSize = 0, 0, 0

        if i > 0:
            print()
        
        fragment = input()
        while fragment != "":
            fragments.append(fragment)
            fragment = input()
        
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


main()