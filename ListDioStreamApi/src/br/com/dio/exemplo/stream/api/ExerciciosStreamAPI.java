package br.com.dio.exemplo.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
	
	public static void main(String[] args) {
		
		List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
		
		System.out.println("\n" + "Imprima todos os numeros desta lista de String: " + "\n");
		
		// Imprimindo com o metodo forEach normal:
		
//		numerosAleatorios.stream().forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		});
		
		// Imprimindo com LAMBDA:
		
//		numerosAleatorios.stream().forEach(t -> System.out.println(t));
//		
		// Imprimindo com reference method:
		
		numerosAleatorios.forEach(System.out::println);
		
		System.out.println("\n" + "Pegue os 5 primeiros números e coloque dentro de um SET: " + "\n");
		
		numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);
		
		System.out.println("\n" + "Transforme essa list de Strings em uma lista de números inteiros: " + "\n");
		
		List<Integer> numerosInteger = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());
		
		numerosInteger.forEach(System.out::println);
		
		System.out.println("\n" + "Pegue os números pares e maiores que 2 e coloque em uma lista: " + "\n");
		
		numerosInteger.stream().filter(t -> (t %2 == 0 && t >2)).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("\n" + "Mostre a média dos números: " + "\n");
		
		numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);
		
		
		System.out.println("\n" + "Remova os números ímpares: " + "\n");

//		METODO NORMAL:
		
//		NUMEROSINTEGER.REMOVEIF(NEW PREDICATE<INTEGER>() {
//			@OVERRIDE
//			PUBLIC BOOLEAN TEST(INTEGER T) {
//				IF (T %2 != 0) RETURN TRUE;
//				RETURN FALSE;
//			}
//		});
		
		numerosInteger.removeIf(t -> t %2 != 0);
//		
		System.out.println(numerosInteger);
		
		System.out.println("\n" + "Ignore os 03 primeiros números da lista: " + "\n");
		
		numerosAleatorios.stream().skip(3).forEach(System.out::println);
		
		System.out.println("\n" + "Removendo os números repetidos, quantos elementos ficam? " + "\n");
				
		Set<String> numerosAleatoriosSet = numerosAleatorios.stream().collect(Collectors.toSet());
		
		System.out.println(numerosAleatoriosSet.size());
		
		System.out.println("\n" + "Imprima os números que ficaram: " + "\n");
		
		for (String string : numerosAleatoriosSet) System.out.println(string);
		
		System.out.println("\n" + "Mostre o menor valor da lista: " + "\n");
		
		Optional<String> menorValor = numerosAleatorios.stream().collect(Collectors.minBy((String o1, String o2) -> o1.compareTo(o2)));
		
		System.out.println(menorValor);
		
		System.out.println("\n" + "Mostre o maior valor da lista: " + "\n");
		
		Optional<String> maiorValor = numerosAleatorios.stream().collect(Collectors.maxBy((String o1, String o2) -> o1.compareTo(o2)));
		
		System.out.println(maiorValor);
		
		System.out.println("\n" + "Pegue apenas os números pares e some: " + "\n");
		

		List<Integer> numerosPares = numerosInteger.stream().filter(t -> t %2 == 0).collect(Collectors.toList());
		
		int soma = numerosPares.stream().mapToInt(Integer::intValue).sum();
		
		System.out.println("Soma = "+ soma);
		
		
	}
}
