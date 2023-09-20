abstract class Person {
    int id;
    String name;
    String address;
    int phone;
    String profession;

    public Person(int id, String name, String address, int phone, String profession) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.profession = profession;
    }

    abstract void Register(String id);

    abstract void Perform(String duty);

    void include(String service) {
        System.out.println(name + " includes " + service);
    }

    void like(String item) {
        System.out.println(name + " likes " + item);
    }
}

class Student extends Person {
    String studentId;
    String major;
    int year;
    int semester;
    String college;
    int grade;

    public Student(int id, String name, String address, int phone, String profession,
                   String studentId, String major, int year, int semester, String college) {
        super(id, name, address, phone, profession);
        this.studentId = studentId;
        this.major = major;
        this.year = year;
        this.semester = semester;
        this.college = college;
    }

    @Override
    void Register(String course) {
        System.out.println(name + " has registered " + course);
    }

    @Override
    void Perform(String duty) {
        System.out.println(name + " has performed: " + duty);
    }

    int getGrade(String course) {
        return (int) (Math.random() * 100);
    }

    void Attend(String className) {
        System.out.println(name + " attends " + className);
    }

    void Learn() {
        System.out.println(name + " is learning efficiently");
    }
}

class Staff extends Person {
    String empID;
    String empRole;
    String empDepartment;
    String empExperience;
    float empSalary;

    public Staff(int id, String name, String address, int phone, String profession,
                 String empID, String empRole, String empDepartment, String empExperience, float empSalary) {
        super(id, name, address, phone, profession);
        this.empID = empID;
        this.empRole = empRole;
        this.empDepartment = empDepartment;
        this.empExperience = empExperience;
        this.empSalary = empSalary;
    }

    @Override
    void Register(String id) {
        System.out.println(name + " has been registered with ID: " + id);
    }

    @Override
    void Perform(String duty) {
        System.out.println(name + " is performing: " + duty);
    }

    void getPromotion() {
        System.out.println(name + " is requesting a promotion");
    }

    float getSalary() {
        System.out.println(name + " is receiving the salary which is Rs. " + empSalary);
        return empSalary;
    }
}

class PGStudent extends Student {
    String rollNo;
    String specialization;

    public PGStudent(int id, String name, String address, int phone, String profession,
                     String studentId, String major, int year, int semester, String college,
                     String rollNo, String specialization) {
        super(id, name, address, phone, profession, studentId, major, year, semester, college);
        this.rollNo = rollNo;
        this.specialization = specialization;
    }

    void submitThesis() {
        System.out.println(name + " have submitted thesis");
    }
}

class Faculty extends Staff {
    String specialization;
    String section;
    int totalStudents;
    String qualification;

    public Faculty(int id, String name, String address, int phone, String profession,
                   String empID, String empRole, String empDepartment, String empExperience, float empSalary,
                   String specialization, String section, int totalStudents, String qualification) {
        super(id, name, address, phone, profession, empID, empRole, empDepartment, empExperience, empSalary);
        this.specialization = specialization;
        this.section = section;
        this.totalStudents = totalStudents;
        this.qualification = qualification;
    }

    void teach(String course) {
        System.out.println(name + " is teaching " + course);
    }

    void accessStudentGrade(String studentGrade) {
        System.out.println(name + " accesses student's grade: " + studentGrade);
    }
}

class Technician extends Staff {
    String techType;

    public Technician(int id, String name, String address, int phone, String profession,
                      String empID, String empRole, String empDepartment, String empExperience, float empSalary,
                      String techType) {
        super(id, name, address, phone, profession, empID, empRole, empDepartment, empExperience, empSalary);
        this.techType = techType;
    }

    void maintainLab(String lab) {
        System.out.println(name + " is maintaining lab: " + lab);
    }

    void installSystem(String system) {
        System.out.println(name + " is installing system: " + system);
    }

    public static void main(String[] args) {
        Person person = new Student(1, "Junaid", "Farooqabad", 1234567890, "Student",
                "20L-2131", "Computer Science", 4, 7, "Govt");

        Person student = new PGStudent(2, "Daud", "DG Khan", 987654321, "Student",
                "6212", "Physics", 2, 3, "KIPS", "1234", "Quantum Mechanics");

        Person staff = new Faculty(3, "Suleman", "Dera Ghazi Khan", 555555555, "Faculty",
                "F789", "Professor", "Civil Department", "10 years", 60000,
                "Physics", "A", 50, "Ph.D.");

        Person technician = new Technician(4, "Muaaz", "Lahore", 999999999, "Technician",
                "T101", "Lab Technician", "Computer Lab", "5 years", 40000, "Hardware");

        Person[] people = {person, student, staff, technician};
        for (Person p : people) {
            System.out.println("\n\n" + p.name + " - " + p.profession);
            p.Register("\nCourse 101");
            p.Perform("\nDuty A");
            p.include("\nService X");
            p.like("\nItem Y");

            if (p instanceof Student) {
                Student s = (Student) p;
                s.Attend("Math Class");
                s.Learn();
                int grade = s.getGrade("Math");
                System.out.println("Grade in Math: " + grade);
            } else if (p instanceof Staff) {
                Staff s = (Staff) p;
                s.getPromotion();
                float salary = s.getSalary();
                System.out.println("Salary: $" + salary);
            } else if (p instanceof PGStudent) {
                PGStudent pgStudent = (PGStudent) p;
                pgStudent.submitThesis();
            } else if (p instanceof Faculty) {
                Faculty faculty = (Faculty) p;
                faculty.teach("Physics");
                faculty.accessStudentGrade("A+");
            } else if (p instanceof Technician) {
                Technician technician2 = (Technician) p;
                technician2.maintainLab("Computer Lab");
                technician2.installSystem("Operating System");
            }
 }
}
}