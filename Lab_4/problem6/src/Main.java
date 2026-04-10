public class Main {
    public static void main(String[] args){
        Child c = new Child("Rares",new Date(20,3,2005));
        c.sayHello();
        c.sayGoodbye();
        c.ageCalc();
        c.addNumbers(4, 7);
        c.alphabet();
        c.chessBoard(4, 3);
        c.XOGame(3, 3);
    }
}
