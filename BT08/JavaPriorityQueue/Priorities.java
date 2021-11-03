import java.util.*;

public class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
        List<Student> students = new ArrayList<Student>();
        for (String event : events) {
            Scanner scanner = new Scanner(event);
            String e = scanner.next();
            if (e.equals("ENTER")) {
                String name = scanner.next();
                double CGPA = scanner.nextDouble();
                int ID = scanner.nextInt();
                Student student = new Student(ID, name, CGPA);
                priorityQueue.add(student);
            }
            else if (e.equals("SERVED")) priorityQueue.poll();
        }
        while (priorityQueue.size() > 0) students.add(priorityQueue.poll());
        return students;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String event = scanner.nextLine();
            events.add(event);
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        for (Student student : students) System.out.println(student.getName());
    }
}
