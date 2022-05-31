public class Main {
    public static void main(String[] args) {
        ObjectLinkedList list=new ObjectLinkedList();
        Object object2=new Object();
        Contacto contacto=new Contacto("Pepe");
        Contacto contacto1=new Contacto("Jose Alfonso");
        Contacto contacto2=new Contacto("Paco");
        DoubleLinkedListObj<Contacto> linkedList=new DoubleLinkedListObj<>();
        linkedList.insertFirst(contacto);
        linkedList.insertFirst(contacto1);
        linkedList.insertLast(contacto2);
        System.out.println(linkedList.getObjectFromLast(0));

    }
}
