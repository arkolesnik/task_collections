import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by olena.kolesnyk on 12/04/2017.
 */
public class Task08Collections {

    static class Student {
        private String name;
        private List<String> languages;


        Student(String name, List<String> languages) {
            this.name = name;
            this.languages = languages;
        }

        public String getName() {
            return name;
        }

        public List<String> getLanguages() {
            return languages;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return name != null ? name.equals(student.name) : student.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(getStudentsByLanguage(students).toString());
        System.out.println(getAllLanguages(students).toString());
        System.out.println(removeDuplicates(students).toString());
    }

    // Data example
    static final List<Student> students = Arrays.asList(
            new Student("Doug Lea", Arrays.asList("Java", "C#", "JavaScript")),
            new Student("Bjarne Stroustrup", Arrays.asList("C", "C++", "Java")),
            new Student("Martin Odersky", Arrays.asList("Java", "Scala", "Smalltalk")),
            new Student("Doug Lea", Arrays.asList("Java", "C#", "JavaScript")) //add duplicated student
    );

    /**
     * Given list of students group them by language.
     */
    public static Map<String, List<Student>> getStudentsByLanguage(List<Student> students) {

        Map<String, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            for (String language : student.getLanguages()) {
                if (studentsMap.containsKey(language)) {
                    studentsMap.get(language).add(student);
                } else {
                    studentsMap.put(language, new ArrayList<>(Arrays.asList(student)));
                }
            }
        }
        return studentsMap;
    }

    /**
     * Given list of students with languages, return list of unique languages.
     */
    public static List<String> getAllLanguages(List<Student> students) {
        Set<String> uniqueLanguages = new HashSet<>();
        for (Student student : students) {
            uniqueLanguages.addAll(student.getLanguages());
        }
       return uniqueLanguages.stream().collect(Collectors.toList());
    }

    /**
     * Given list of students, remove duplicates by name.
     */
    public static List<Student> removeDuplicates(List<Student> students) {
        Set<Student> noDuplicateStudents = new HashSet<>(students);
        return new ArrayList<>(noDuplicateStudents);
    }

}
