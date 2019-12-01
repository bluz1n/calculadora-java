import java.util.Scanner;
public class caluculadora {
	public static void main(String[] args) {		
		int aux = 0;
		boolean numdouble = false;
		double a, b, c, d = 0, pot = 0;
		char sinal;
		String npr = "";
		Pilha<Character> p = new Pilha<Character>();
		Pilha<Double> operando = new Pilha<Double>();
		
		Scanner teclado = new Scanner(System.in);	
		
		
		System.out.println("informe a equacao -> ");
		String equacao = teclado.nextLine();	
		
		while (aux < equacao.length()) {
			sinal = equacao.charAt(aux);
			if (sinal == '0' || sinal == '1' || sinal == '2' || sinal == '3' || sinal == '4' || sinal == '5' || sinal == '6' || sinal == '7' || sinal == '8' || sinal == '9') {
				while (aux+1 < equacao.length() && (equacao.charAt(aux+1) == '0' || equacao.charAt(aux+1) == '1' || equacao.charAt(aux+1) == '2' || equacao.charAt(aux+1) == '3' || equacao.charAt(aux+1) == '4' || equacao.charAt(aux+1) == '5' || equacao.charAt(aux+1) == '6' || equacao.charAt(aux+1) == '7' || equacao.charAt(aux+1) == '8' || equacao.charAt(aux+1) == '9')) {
					npr += sinal;
					aux++;
					sinal = equacao.charAt(aux);
				}
				
				npr += sinal;
				npr += '.';
			}
			
			else if (sinal == '(') {
				p.push(sinal);
			}
			
			else if (sinal == '+' || sinal == '-') {
				
				while (!p.isEmpty() && (p.top() == '*' || p.top() == '/' || p.top() == '^' || p.top() == '+' || p.top() == '-')) {
					npr += p.pop();
				}
				
				p.push(sinal);
			}
			
			else if (sinal == '*' || sinal == '/') {
				
				while (!p.isEmpty() && (p.top() == '*' || p.top() == '/' || p.top() == '^')) {
					npr += p.pop();
				}
				p.push(sinal);
			}
			
			else if (sinal == '^') {
				
				while (!p.isEmpty() && p.top() == '^') {
					npr += p.pop();
				}
				p.push(sinal);
			}
			
			else if (sinal == ')') {
				while (!p.isEmpty() && p.top() != '(') {
					npr += p.pop();
				}
				if (p.top() == '(') {
					p.pop();
				}
			}
			aux++;
		}
		
		while (p.isEmpty() == false) {
			npr += p.pop();
		}
		
		aux = 0;
		while (aux < npr.length()) {
			sinal = npr.charAt(aux);
			if (sinal == '0' || sinal == '1' || sinal == '2' || sinal == '3' || sinal == '4' || sinal == '5' || sinal == '6' || sinal == '7' || sinal == '8' || sinal == '9') {
				while (aux+1 < npr.length() && (npr.charAt(aux+1) == '0' || npr.charAt(aux+1) == '1' || npr.charAt(aux+1) == '2' || npr.charAt(aux+1) == '3' || npr.charAt(aux+1) == '4' || npr.charAt(aux+1) == '5' || npr.charAt(aux+1) == '6' || npr.charAt(aux+1) == '7' || npr.charAt(aux+1) == '8' || npr.charAt(aux+1) == '9')) {
					p.push(sinal);
					aux++;
					sinal = npr.charAt(aux);
					numdouble = true;
				}
				
				if (numdouble) {
					p.push(sinal);
					while (!p.isEmpty()) {
						a = (double) (p.pop() - '0');
						d += a * Math.pow(10, pot);
						pot++;
					}
					operando.push(d);
					pot = 0;
					d = 0;
					numdouble = false;
				}
				
				else {
					a = (double) (sinal - '0');
					operando.push(a);
				}
			}
			else if (sinal == '+' || sinal == '-' || sinal == '/' || sinal == '*' || sinal == '^') {
				
				c = operando.pop();
				b = operando.pop();
				if (sinal == '+') {
				b = b+c;
				}				
				
				else if (sinal == '-') {b = b-c;}				
				else if (sinal == '/') {b = b/c;}				
				else if (sinal == '*') {b = b*c;}				
				else if (sinal == '^') {b = Math.pow(b, c);}
				operando.push(b);
			}
			
			aux++;
		}
		
		
		teclado.close();
		
		
		System.out.println(operando.pop());
	}
}