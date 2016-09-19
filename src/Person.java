public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        boolean isMarried = false;
        if (man != person.isMan()) {
            divorce();
            person.divorce();
            spouse = person;
            person.setSpouse(this);
            isMarried = true;
        }
        return isMarried;
    }

    public boolean divorce() {
        boolean isDivorced = false;
        if (spouse != null) {
            spouse.setSpouse(null);
            setSpouse(null);
            isDivorced = true;
        }
        return isDivorced;
    }

    public boolean isMan() {
        return man;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}
