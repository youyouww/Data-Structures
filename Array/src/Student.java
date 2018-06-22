public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }
    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Tom", 92));
        arr.addLast(new Student("Lacy", 92));
        arr.addLast(new Student("Charlie", 88));
        System.out.println(arr);
    }
}
