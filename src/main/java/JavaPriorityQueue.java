import java.util.*;

class Student implements Comparable<Student>{
    private final String name;
    private final double cgpa;
    private final int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Student s) {
        if(cgpa == s.cgpa) {
            if(name.compareTo(s.name) == 0) {
                return Integer.compare(id, s.id);
            } else {
                return name.compareTo(s.name);
            }
        } else if(cgpa > s.cgpa) {
            return -1;
        }
        else {
            return 1;
        }
    }
}



class Priorities{

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        for(String str : events) {
            String[] s = str.split("\\s");
            if(s.length > 1) {
                pq.add(new Student(s[1],Double.parseDouble(s[2]),Integer.parseInt(s[3])));
            } else {
                pq.poll();
            }
        }

        while(pq.size()>1) {
            System.out.println(pq.poll().getName());
        }

        return new ArrayList<>(pq);
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}