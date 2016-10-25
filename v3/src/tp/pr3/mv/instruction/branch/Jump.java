package tp.pr3.mv.instruction.branch;


import tp.pr3.mv.CPU;
import tp.pr3.mv.Constants;
import tp.pr3.mv.instruction.Instruction;
import tp.pr3.mv.instruction.exceptionIns.InstructionExecutionException;
import tp.pr3.mv.instruction.exceptionIns.WrongInstructionFormatException;

/**
 * Clase que crea una instruccion de tipo Jump, y sirve para cambiar el
 * contador de programa.
 * @author Lidia Flores, David Bolanios
 */
public class Jump extends Jumps {
	
	/**
	 * Constructora por defecto.
	 */
	public Jump() {
		
	}
	
	/**
	 * Constructora que crea una instruccion Jump con el nuevo contador
	 * de programa.
	 * @param number El nuevo contador de programa.
	 */
	public Jump(int number) {
		super();
		this.number = number;
	}

	/**
	 * Metodo que ejecuta la instruccion Jump, es decir, cambia el contador de programa
	 * al indicado.
	 * @param CPU El CPU a cambiar el contador de programa.
	 * @throws InstructionExecutionException si hay error en el cambio del PC.
	 */
	@Override
	protected void executeBranch(CPU cpu) throws InstructionExecutionException {
		if(!cpu.changePC(this.number))	
			throw new InstructionExecutionException
				("Error ejecutando " + this.toString() + ": PC fuera de rango");
	}

	/**
	 * Parsea la instruccion segun el String pasado por parametro.
	 * @throws WrongInstructionFormatException si hay error en el parseo.
	 */
	@Override
	public Instruction parse(String[] s) throws WrongInstructionFormatException {
		if(s.length == 2 && s[0].equalsIgnoreCase("jump") && Constants.isNumber(s[1]))
			return new Jump(Integer.parseInt(s[1]));
		else throw new WrongInstructionFormatException();
	}

	/**
	 * Devuelve la instruccion Jump en forma de cadena.
	 */
	@Override
	public String toString() {
		return "JUMP " + this.number;
	}
}
