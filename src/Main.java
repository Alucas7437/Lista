public class Main {
    public static void main(String[] args) {
        Contacto contacto=new Contacto("Pepe");
        Contacto contacto1=new Contacto("Jose Alfonso");
        Contacto contacto2=new Contacto("Paco");
        DoubleLinkedListObj<Contacto> linkedList=new DoubleLinkedListObj<>();
        linkedList.insertFirst(contacto1);
        linkedList.insertFirst(contacto2);
       linkedList.insertLast(contacto);
        System.out.println(linkedList.getObjectAtPosition(2));
    }
}
