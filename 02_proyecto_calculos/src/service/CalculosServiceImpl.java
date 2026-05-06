package service;

import java.util.List;

public class CalculosServiceImpl implements CalculosService {

	@Override
	public int totalMayores(int n, List<Integer> numeros) {
		//Devuelve el total de números mayores que n. Utiliza programación funcional
		return (int) numeros.stream().filter(numero -> numero > n).count();
		
	}

	@Override
	public List<Integer> menores(int n, List<Integer> numeros) {
		//Devuelve una lista con los números menores que n. Utiliza programación funcional
		return numeros.stream().filter(numero -> numero < n).toList();
		
	}

}
