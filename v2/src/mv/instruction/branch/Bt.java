package tp.pr2.mv.instruction.branch;

import tp.pr2.mv.CPU;
import tp.pr2.mv.instruction.Instruction;

/**
 * Clase que crea una instruccion de tipo Jump, y sirve para cambiar el
 * contador de programa si la cima de la pila es positiva.
 * @author Lidia Flores, David Bolanios
 */
public class Bt extends Jumps {
	
	/**
	 * Constructora que crea una instruccion Bt con el nuevo contador
	 * de programa.
	 * @param number El nuevo contador de programa.
	 */
	public Bt(int number) {
		super();
		this.number = number;
	}

	/**
	 * Constructora pro defecto.
	 */
	public Bt() {
	
	}

	/**
	 * Metodo que ejecuta la instruccion Bt, es decir, cambia el contador de programa
	 * al indicado si la cima es positiva.
	 * @param CPU El CPU a cambiar el contador de programa.
	 * @return exito true si el salto ha tenido exito, false en caso contrario.
	 */
	@Override
	protected boolean executeBranch(CPU cpu) {
		boolean exito = false;
		if(cpu.getNumElem() > 0 && this.number <= cpu.getSizeProgram()){
			int aux = cpu.pop();
			if(aux > 0){
				exito = cpu.changePC(this.number) && cpu.step();
			}
			else {
				//cpu.push(aux);
				exito = true;
				cpu.increaseProgramCounter();
			}
		}
	
		return exito;
	}


	/**
	 * Parsea la instruccion segun el String pasado por parametro.
	 */
	@Override
	public Instruction parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("bt") && Instruction.isNumber(s[1]))
			return new Bt(Integer.parseInt(s[1]));
		
		else
			return null;
	}

	/**
	 * Devuelve la instruccion Bt en forma de cadena.
	 */
	@Override
	public String toString() {
		return "BRANCH-TRUE " + this.number;
	}

}
