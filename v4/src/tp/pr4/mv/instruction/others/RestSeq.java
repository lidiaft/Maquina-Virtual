package tp.pr4.mv.instruction.others;

import tp.pr4.mv.CPU;
import tp.pr4.mv.instruction.Instruction;
import tp.pr4.mv.instruction.exceptionIns.InstructionExecutionException;

/**
 * Clase abstracta que tiene metodos comunes a las instrucciones de otros tipos distintos
 * a la de salto, comparacion, aritmeticas o booleanas.
 * @author Lidia Flores, David Bolanios
 */
public abstract class RestSeq implements Instruction {	
	
	protected int result;
	
	/**
	 * Metodo auxiliar implementado por las subclases las cuales implementara la 
	 * accion correspondiente.
	 * @param CPU La CPU a modificar.
	 * @throws InstructionExecutionException si hay algun error durante la ejecucion.
	 */
	abstract protected void executeAux (CPU cpu) throws InstructionExecutionException;
	
	/**
	 * Metodo que ejecuta una instruccion de tipo other.
	 * @param cpu La CPU a modificar.
	 * @throws InstructionExecutionException si hay algun error durante la ejecucion.
	 */
	@Override
	public void execute(CPU cpu) throws InstructionExecutionException {
		this.executeAux(cpu);
		cpu.increaseProgramCounter();
	}
}
