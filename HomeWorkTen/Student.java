package HomeWorkTen;

public class Student {
    private String name;
    private int chinese;
    private int math;
    private int english;
    public Student(){}
    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getChinese() {
        return chinese;
    }
    public void setChinese(int chinese) {
        this.chinese = chinese;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int sum(){
      int sumScore=chinese+math+english;
      return sumScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (chinese != student.chinese) return false;
        if (math != student.math) return false;
        if (english != student.english) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + chinese;
        result = 31 * result + math;
        result = 31 * result + english;
        return result;
    }
}
