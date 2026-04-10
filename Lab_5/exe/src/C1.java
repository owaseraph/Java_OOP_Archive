public abstract class C1 implements Shape{
    protected String name;
    public C1(String name){
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }
}

