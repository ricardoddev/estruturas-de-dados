class FilaDinamica {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public FilaDinamica() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void enqueue(Object item) {
        No novo = new No(item);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    public Object dequeue() {
        if (primeiro != null) {
            No item = primeiro;

            primeiro = primeiro.proximo;
            item.proximo = null;
            tamanho--;

            return item.dados;
        }

        return null;
    }

    public void exibir() {
        No atual = primeiro;

        while (atual != null) {
            System.out.print(atual.dados.toString() + ", ");
            atual = atual.proximo;
        }

        System.out.println();
    }
  
  public boolean estaVazio() {
    return (primeiro==null);
  }

  public Object frente() {
    if (estaVazio()) {
      System.out.println("Fila Vazia!");
      return null;
    }
    return primeiro.dados;
  }

  public int tamanho() {
     return tamanho;
  }
}