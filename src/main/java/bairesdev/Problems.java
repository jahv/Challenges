package bairesdev;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problems {

    public static double distancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2-x1)^2 + (y2-y1)^2);
    }

    public static double distanciaPromedio3Puntos(int x1, int y1, int x2, int y2, int x3, int y3) {
        double d1 = distancia(x1, y1, x2, y2);
        double d2 = distancia(x1, y1, x3, y3);
        double d3 = distancia(x2, y2, x3, y3);

        return (d1 + d2 + d3) / 3;
    }

    public static boolean isCasiPalindromo(String palabra) {
        char original[] = palabra.toCharArray();
        char inverso[] = new StringBuilder(palabra).reverse().toString().toCharArray();

        int cambios = 0;

        for(int i=0; i<original.length; i++) {
            if(original[i] != inverso[i]) {
                cambios++;
            }

            if(cambios > 2) {
                return false;
            }
        }
        return true;
    }

    public static int menorMasPopular(int[] numeros, int longitud) {
        Map<Integer, Integer> contador = new HashMap<>();
        contador.put(numeros[0], 1);

        int menorMasPopular = numeros[0];
        int veces = 1;

        for(int i=1; i<longitud; i++) {
            Integer auxContador = contador.get(numeros[i]);
            if(auxContador != null) {
                auxContador++;
                contador.put(numeros[i], auxContador);
                if(auxContador > veces) {
                    veces = auxContador;
                    menorMasPopular = numeros[i];
                } else if(auxContador == veces && numeros[i] < menorMasPopular ) {
                    menorMasPopular = numeros[i];
                }
            } else {
                contador.put(numeros[i], 1);
            }
        }

        return menorMasPopular;
    }


    public static boolean balanced(String input) {
        char chars[] = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        char pop;
        boolean result = true;

        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        //(a[0]+b[2c[6]]) {24 + 53}"
        for(int i=0; i<chars.length; i++) {
            Character chari = map.get(chars[i]);

            if(chari != null) {
                stack.push(chari);
            }

            else if(map.containsValue((chars[i])) && !stack.empty() && chars[i] != stack.pop()) {
                result = false;
                break;
            }

        }

        if(!stack.empty()) {
            result = false;
        }
        return result;
    }



}
