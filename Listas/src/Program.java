import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add("Julia");

        //Comando para adicionar outra String na posição 2
        list.add(2, "Marco");

        //Imprimir tamanho da lista
        System.out.println(list.size());

        for (String x : list){
            System.out.println(x);
        }

        System.out.println("-------------------------------------------------------");

        //Remover elemento da lista
        //list.remove("Anna");
        //list.remove(1);

        //Remover por predicado (letra) - função lambda
        list.removeIf(x -> x.charAt(0) == 'M');
        for (String x : list){
            System.out.println(x);
        }

        System.out.println("--------------------------------------------------");

        //Pesquisar a posição de um elemento
        System.out.println("Posição de Bob: " + list.indexOf("Bob"));

        System.out.println("------------------------------------------------------");

        //Para criar uma lista somente com os dados solicitados

        List<String> result = list.stream().filter(x -> x.charAt(0) =='A').collect(Collectors.toList());

        for (String x : result){
            System.out.println(x);
        }


        System.out.println("---------------------------------------------");

        //Comando para encontrar primeiro elemento

        String name = list.stream().filter(x -> x.charAt(0) =='A').findFirst().orElse(null);
        System.out.println(name);

    }
}
