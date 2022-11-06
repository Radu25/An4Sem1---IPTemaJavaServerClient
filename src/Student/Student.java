
package Student;

public class Student implements Comparable<Student> {

    protected String titlu;
    protected String nume;
    protected String prenume;
    FACULTATE acronim_f;
    protected Integer varsta;
    protected Integer an_studiu;


    public void doWork() {
        System.out.println("It's time to do some sectoare, I'm so excited!");
    }

    public void greeting() {
        System.out.println("Sa traiti, sunt student" + nume);
    }

    public Student(String fullName) {
        String[] names = fullName.split(" ");
        this.titlu = names[0];
        this.nume = names[1];
        this.prenume = names[2];
        this.acronim_f = FACULTATE.valueOf(names[3]);
        this.varsta = Integer.parseInt(names[4]);
        this.an_studiu = Integer.parseInt(names[5]);
        ;

    }

    public Integer getVarsta() {
        return this.varsta;
    }

    @Override
    public String toString() {
        return "[Sd. " + nume + prenume + ", Anul " + an_studiu + ", Fac. " + acronim_f + ", Varsta" + varsta + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.getVarsta().compareTo(o.getVarsta());
    }
}
