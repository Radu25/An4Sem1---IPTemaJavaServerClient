package Profesor;


public class Profesor implements Comparable<Profesor> {
    /**
     * @author Radu
     * @link http://www.docjar.net/html/api/java/util/Collections.java.html
     */
    protected String titlu;
    protected String nume;
    protected String prenume;
    protected String facultate;
    FACULTATE acronim_f;
    protected Integer varsta;
    protected String materie;


    public void doWork() {
        System.out.println("Este timpul sa predau. Sunt domnul profesor " + this.nume + ".");
    }


    public void greeting() {
        System.out.println("Salutare studenti.");
    }

    public Profesor(String fullName) {
        String[] names = fullName.split(" ");
        this.titlu = names[0];
        this.nume = names[1];
        this.prenume = names[2];
        this.acronim_f = FACULTATE.valueOf(names[3]);
        this.varsta = Integer.parseInt(names[4]);
        this.materie = names[5];

    }

    public Integer getVarsta() {
        return this.varsta;
    }

    @Override
    public String toString() {
        return "[Prof. " + nume + prenume + ", Fac. " + acronim_f + ", Varsta " + varsta + ", Materie predata - " + materie + "]";
    }

    @Override
    public int compareTo(Profesor o) {
        return this.getVarsta().compareTo(o.getVarsta());
    }
}