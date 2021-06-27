import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Array<Integer> intArray = new Array<>();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            intArray.add(random.nextInt(100));
        }

        System.out.println(intArray.toString());
        System.out.println("The size of the current Array is "+intArray.size());

        for (int i = 0; i < 7; i++) {
            intArray.add(random.nextInt(100));
        }

        System.out.println(intArray.toString());
        System.out.println("The size of the current Array is "+intArray.size());

        //Uncomment this to observe the null elements at the end.

/*        for (int i = 0; i < 32; i++) {
            System.out.print(intArray.get(i)+ " ");
        }*/
    }
}
