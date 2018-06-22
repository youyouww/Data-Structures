public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> array = new Array<>(10);
        for(int i=0 ; i < 10; i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.addLast(21);
        System.out.println(array);

        array.remove(5);
        System.out.println(array);
        array.removeElement(1996);
        System.out.println(array);
    }
}
