package service;

import java.util.List;

public interface CalculosService {
	int totalMayores(int n,List<Integer> numeros);
	List<Integer> menores(int n,List<Integer> numeros);
}
