package program;

import org.junit.jupiter.api.Test;

class ScoreTEST {
    @Test
    public void t(){
        Person person = new Person();
        Decorator decorator = new Decorator_zero(new Decorator_first(
                new Decorator_two(person)));
        decorator.report();
    }
}
interface Reportor{
    void report();
}
abstract class Decorator implements Reportor{
    private Reportor reportor;
    public Decorator(Reportor reportor){
        this.reportor = reportor;
    }
    @Override
    public void report() {
        reportor.report();
    }
}


class Decorator_zero extends Decorator {

    public Decorator_zero(Reportor reportor) {
        super(reportor);
    }
    @Override
    public void report() {
        System.out.println("这次考试比上次增加了几分");
        super.report();
    }
}

class Decorator_first extends Decorator {

    public Decorator_first(Reportor reportor) {
        super(reportor);
    }
    @Override
    public void report() {
        System.out.println("这次考试最高成绩比我只高一点");
        super.report();
    }
}

class Decorator_two extends Decorator {

    public Decorator_two(Reportor reportor) {
        super(reportor);
    }
    @Override
    public void report() {
        System.out.println("这次考试班级排名前列");
        super.report();
    }
}



class Person implements Reportor {
    @Override
    public void report() {
        System.out.println("这次考试成绩是65");
    }
}