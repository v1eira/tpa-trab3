#
# UVa 11849 - CD
# Autores: Ewerson Vieira Nascimento e Icaro Gavazza
#

def getline():
    return input()

class NodoArvore:
    def __init__(self, chave=None, esquerda=None, direita=None):
        self.chave = chave
        self.esquerda = esquerda
        self.direita = direita
        self.lista = []

    def __repr__(self):
        return '%s <- %s -> %s' % (self.esquerda and self.esquerda.chave,
                                    self.chave,
                                    self.direita and self.direita.chave)

    def insere(self, nodo):
        """Insere um nodo em uma árvore binária de pesquisa."""
        # Nodo deve ser inserido na raiz.
        if self.chave is None:
            self.chave = nodo.chave

        # Nodo deve ser inserido na subárvore direita.
        elif self.chave < nodo.chave:
            if self.direita is None:
                self.direita = nodo
            else:
                self.direita.insere(nodo)

        # Nodo deve ser inserido na subárvore esquerda.
        else:
            if self.esquerda is None:
                self.esquerda = nodo
            else:
                self.esquerda.insere(self.esquerda, nodo)


    def busca(self,raiz, chave):
        """Procura por uma chave em uma árvore binária de pesquisa."""
        # Trata o caso em que a chave procurada não está presente.
        if raiz is None:
            return None

        # A chave procurada está na raiz da árvore.
        if raiz.chave == chave:
            return raiz

        # A chave procurada é maior que a da raiz.
        if raiz.chave < chave:
            return raiz.busca(raiz.direita, chave)

        # A chave procurada é menor que a da raiz.
        return raiz.busca(raiz.esquerda, chave)

    def em_ordem(self,raiz, lista=[]):
        if not raiz:
            return lista
        # Visita filho da esquerda.
        raiz.em_ordem(raiz.esquerda,lista)
        # Visita nodo corrente.
        lista.append(raiz.chave)
        # Visita filho da direita.
        raiz.em_ordem(raiz.direita,lista)



def main():
    qt_k,qt_l = getline().split()
    qt_k = int(qt_k)
    qt_l = int(qt_l)
    cd_k = NodoArvore(None)
    cd_l = NodoArvore(None)
    while qt_k != 0 and qt_l != 0:
        cont = 0
        for i in range(qt_k):
            nodo = NodoArvore(int(getline()))
            cd_k.insere(nodo)
        for i in range(qt_l):
            nodo = NodoArvore(int(getline()))
            cd_l.insere(nodo)
        LIST = []
        LIST = cd_l.em_ordem(cd_l, LIST)
        for k in LIST:
            if cd_l.busca(k) == k:
                cont +=1
        LIST = []
        print(cont)
        cd_k = []
        cd_l = []
        qt_k, qt_l = getline().split()
        qt_k = int(qt_k)
        qt_l = int(qt_l)


main()

