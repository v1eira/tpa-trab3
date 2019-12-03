import math
RIGHT = False
LEFT = True


def main():

    loop = int(input())
    while(loop):
        loop -= 1
        tempoTot = 0
        fila_left = []
        fila_right = []
        resposta = []
        posicao = LEFT

        n, t, m = input().split()
        n = int(n)
        t = int(t)
        m = int(m)

        for i in range(m):
            carro = input().split()
            carro[0] = int(carro[0])
            if carro[1] == 'left':
                fila_left.append([i,carro[0]])
            else:
                fila_right.append([i,carro[0]])

        proximo_carro = 0

        while len(fila_left)+len(fila_right) != 0:


            balca = 0
            fila_atual = []
            fila_outra = []
            if posicao == LEFT:
                fila_atual = fila_left
                fila_outra = fila_right
            else:
                fila_atual = fila_right
                fila_outra = fila_left

            while balca < n and len(fila_atual) != 0 and fila_atual[0][1] <= tempoTot:
                fila_atual[0][1] = t + tempoTot
                resposta.append((fila_atual[0]))
                balca += 1
                fila_atual.pop(0)

            if balca != 0 or (len(fila_outra) != 0 and fila_outra[0][1] <= tempoTot):
                tempoTot += t
                posicao = not posicao
            else:
                if len(fila_atual) == 0 or (len(fila_outra) > 0 and fila_outra[0][1] < fila_atual[0][1]):
                    tempoTot = fila_outra[0][1] + t
                    posicao = not posicao
                else:
                    tempoTot = fila_atual[0][1]


        resposta.sort(key = sorte)
        for tmp in resposta:
            print(tmp[1])
        resposta = []
        print()


def sorte(val):
    return val[0]


main()
