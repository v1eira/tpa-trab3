#
# UVa 01062
# Autores: Ewerson Vieira Nascimento e Icaro Gavazza
#

def main():
    pilhas = []
    line = getline()
    i = 1
    while line != 'end':
        empilha(line,pilhas)
        print('Case %d: %d' % (i,len(pilhas)))
        pilhas = []
        line = getline()
        i+=1


def getline():
    return input()


def empilha(containers, pilhas: list):

    for container in containers:
        isPushed = False
        for pilha in pilhas:
            if pilha[-1] >= container:
                isPushed = True
                pilha.append(container)
                break
        if not isPushed:
           pilhas.append([container])


main()