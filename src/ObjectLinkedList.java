import java.util.Objects;

public class ObjectLinkedList{
    Element firstElement;

    public ObjectLinkedList() {

    }

    public void insertFirst(Object obj) {
        Element newElement = new Element(obj);
        newElement.setNext(firstElement);
        firstElement = newElement;
    }

    private Object getFirstObject() {
        return firstElement;
    }


    public void insertLast(Object obj) {
        if (!isEmpty()) {
            Element element = firstElement;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            element.setNext(new Element(obj));
        }
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void remove(Object obj) {
        int indexOfObject = findIndexOf(obj);
        if (indexOfObject < 0) return;
        Element element = elementAt(indexOfObject);
        Element nextElement = element.getNext();
        if (element == firstElement) {
            firstElement = firstElement.getNext();
        } else {
            Element previousElement = elementAt(indexOfObject - 1);
            previousElement.setNext(nextElement);
        }
        element.delete();
    }

    private int findIndexOf(Object object) {
        int index = -1;
        Element element = firstElement;
        while (element != null) {
            index++;
            if (element.getObject() == object)
                break;
            element = element.getNext();
        }
        return index;
    }

    private Element elementAt(int index) {
        int currentIndex = 0;
        Element element = firstElement;
        while (element != null) {
            if (currentIndex == index)
                return element;
            currentIndex++;
            element = element.getNext();
        }
        return null;
    }

    public Object getObjectAtPosition(int i) {
        if (!isEmpty()) {
            int contador = 0;
            Element element = firstElement;
            while (element.getNext() != null) {
                contador++;
                element = element.getNext();
                if (i == contador) {
                    return element;
                }
            }
        }
        return null;
    }

    private Object getLastObject() {
        Element element = firstElement;
        while (element.getNext() != null) {
            element = element.getNext();
        }
        return element;
    }

    @Override
    public String toString() {
        Element element = firstElement;
        String cadena = "[";
        cadena += element;
        while (element.getNext() != null) {
            cadena+=",";
            element = element.getNext();
            cadena += element;
        }
        cadena += "]";
        return cadena;
    }
}

class Element<T> {
    private T newObject;
    private Element<T> next;
    private Element<T> prev;

    public T getObject() {
        return newObject;
    }

    public void setObject(T newObject) {
        this.newObject = newObject;
    }

    public Element<T> getNext() {
        return next;
    }

    public Element(T newObject) {
        this.newObject = newObject;
    }

    public void setNext(Element<T> newElement) {
        next = newElement;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }

    public void delete() {
        this.newObject = null;
        this.next = null;
        this.prev=null;
    }


    @Override
    public String toString() {
        return "" + newObject;
    }
}
