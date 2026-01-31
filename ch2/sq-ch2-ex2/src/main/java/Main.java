import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        String s = context.getBean(String.class);
        Integer i = context.getBean(Integer.class);

        System.out.println(p.getName());
        System.out.println(s);
        System.out.println(i);
    }


}
