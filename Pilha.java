
public class Pilha<E> {

	No<E> topo;
	int elementos;
	
	public Pilha() {
		this.topo = null;
		this.elementos = 0;
	}
	
	public void push (E elemento) {
		
		No<E> aux = new No<>(elemento);
		
		if (elementos != 0) {
			aux.prox = topo;
		}
		
		topo = aux;
		elementos++;
		
	}
	
	public E pop() {
		
		No<E> aux = topo;
		E elemento = null;
		
		if (!isEmpty()) {
			elemento = aux.elemento;
			topo = aux.prox;
			aux.prox = null;
			elementos--;
		}
		
		return elemento;
		}

	public boolean isEmpty() {
		
		if (elementos == 0) {
			return true;
		}
		return false;
	
	}
	
	
	public E top() {
		
		E elemento = null;
		
		if (!isEmpty()) {
			elemento = topo.elemento;
		}
		
		return elemento ;
		
	}
	
}
