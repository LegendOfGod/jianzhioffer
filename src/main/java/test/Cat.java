package test;

/**
 * @author lqb
 * @date 2022/1/25 11:26
 */
public class Cat extends Animal{
    
    private String sex;

    @Override
    public String getName() {
        return this.sex;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("张三");
        cat.setSex("男");
        System.out.println(cat.getName());
        Cat cat1 = new Cat();
        cat1.setName("张三");
        cat1.setSex("男");
        Animal a1 = cat1;
        System.out.println(a1.getName());

        Animal animal = new Animal();
        animal.setName("张三");
        System.out.println(animal.getName());
    }
}
