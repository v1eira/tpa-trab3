def getline():
    return input()

def main():
    lista = []

    linha = getline()
    while(linha):
        cursor = 0
        for i in linha:
            if i == '[':
                cursor = 0
            if i == ']':
                cursor = len(lista)
            if i != '[' and i != ']' and i != '\n':
                lista.insert(cursor, i)
                cursor += 1
        print(''.join(lista))
        lista = []
        try:
            linha = getline()
        except EOFError:
            break

main()