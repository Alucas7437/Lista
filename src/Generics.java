public class Generics <T>{
    T element;
    public Generics(T element){
        this.element=element;
    }
    public void print(){
        System.out.println(element);
    }

}
