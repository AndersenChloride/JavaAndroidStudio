abstract class workingStaff implements Comparable<workingStaff>{
    double salary;
    String post;
    String name;
    abstract double getSalary();

    public workingStaff(double salary, String post, String name) {
        this.salary = salary;
        this.post = post;
        this.name = name;
    }

    @Override
    public int compareTo(workingStaff w){
        return (int) (this.salary - w.salary);
    }

    public String toString(){
        return "Сотрудник: "+ name +"\nДолжность: "+post +"\nСтандартная ставка: "+ salary;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        workingStaff staff = (workingStaff) o;
        return Double.compare(staff.salary, salary) == 0 &&
                post.equals(staff.post) &&
                name.equals(staff.name);
    }

}

class clerk extends workingStaff {
    double overtime;
    public clerk(int overtime, int Salary, String post, String name) {
        super(Salary, post, name);
        this.overtime = overtime;

    }

    @Override
    double getSalary() {
        return salary + overtime;
    }
}

class director extends workingStaff {
    double stocks;
    public director(int stocks, int Salary, String post, String name) {
        super(Salary, post, name);
        this.stocks = stocks;
    }



    @Override
    double getSalary() {
        return salary+stocks*(1.1);
    }


}

class viceDirector extends workingStaff {
    double overtime;
    double directorSupport;
    public viceDirector(int directorSupport, int Salary, String post, String name) {
        super(Salary, post, name);
        this.directorSupport = directorSupport;
    }



    @Override
    double getSalary() {
        return salary+directorSupport+overtime;
    }


}



