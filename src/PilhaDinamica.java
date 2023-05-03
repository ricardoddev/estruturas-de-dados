public class PilhaDinamica {
    private No topo;
    private int tam=0;
  
      public PilhaDinamica() {
          topo = null;
          tam = 0;
      }
  
      public void push(Object item) {
          No novo = new No(item);
  
          novo.proximo = topo;
          topo = novo;
          tam++;
      }
  
      public Object pop() {
        if (topo != null) {
            No item = topo;
    
            topo = topo.proximo;
            item.proximo = null;
            tam--;
    
            return item.dados;
        }
        return null;
    }
  
      public Object peek() {
          return topo.dados;
      }
  
      public void exibir() {
          No atual = topo;
  
          while (atual != null) {
              System.out.print(atual.dados.toString() + " ");
              atual = atual.proximo;
          }
  
          System.out.println();
      }
    
        public int size() {
        return tam;
    }
  
        public boolean isEmpty() {
        return tam==0;
    }

    public boolean expressaoMatematica(String expressao) {
        for (int i = 0; i < expressao.length(); i++) {
            switch(expressao.charAt(i)) {
                case '(':
                    push(')');
                    break;
                case '[':
                    push(']');
                    break;
                case '{':
                    push('}');
                    break;
                case ')':
                    if (isEmpty() || (char) pop() != ')')
                        return false;
                    break;
                case ']':
                    if (isEmpty() || (char) pop() != ']')
                        return false;
                    break;
                case '}':
                    if (isEmpty() || (char) pop() != '}')
                        return false;
                    break;
            }
        }
        return isEmpty();
    }
    
}
