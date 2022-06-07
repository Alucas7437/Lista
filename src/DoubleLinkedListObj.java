public class DoubleLinkedListObj<T> {
    Element<T> firstElement;


    public DoubleLinkedListObj() {

    }

    public void insertFirst(T obj) {
        Element<T> newElement = new Element<>(obj);
        newElement.setNext(firstElement);

        if(firstElement == null)
            firstElement = newElement;

        if (newElement != firstElement) {
            firstElement.setPrev(newElement);
            firstElement = newElement;
        }
    }


    public void insertLast(T obj) {
      Element<T> element = firstElement;
      Element<T> newElement = new Element<>(obj);
        while (element.getNext() != null) {
            element = element.getNext();
        }
        element.setNext(newElement);
        newElement.setPrev(element);

    }

    private Element<T> getLast() {
        Element<T> element = firstElement;
        while (element.getNext() != null) {
            element = element.getNext();
        }
        return element;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public T getObjectAtPosition(int i) {
        int counter = -1;
        Element<T> element = firstElement;
        while (element != null) {
            counter++;
            if (counter == i) {
                return element.getObject();
            }
            element = element.getNext();
        }
        return null;
    }

    public T getObjectFromLast(int i) {
        int counter = -1;
        Element<T> lastElement = getLast();
        while (lastElement != null) {
            counter++;
            if (counter == i) {
                return lastElement.getObject();
            }
            lastElement = lastElement.getPrev();
        }
        return null;
    }


    public void remove(T obj) {
    if(isEmpty()){
        System.out.println("Lista vacia");
    }
    Element<T> element=elementAt(findIndexOf(obj));

    if(element==firstElement){
        firstElement=firstElement.getNext();
    } else if(element==getLast()){
        Element<T>previous=element.getPrev();
        previous.setNext(null);
    } else {
        Element<T>nextElement=element.getNext();
        Element<T> previous=element.getPrev();
        previous.setNext(nextElement);
        nextElement.setPrev(previous);
    }
    element.delete();

    }

    private int findIndexOf(T object) {
        int index = -1;
        Element<T> element = firstElement;
        while (element != null) {
            index++;
            if (element.getObject() == object)
                break;
            element = element.getNext();
        }
        return index;
    }

    private Element<T> elementAt(int index) {
        int currentIndex = 0;
        Element<T> element = firstElement;
        while (element != null) {
            if (currentIndex == index)
                return element;
            currentIndex++;
            element = element.getNext();
        }
        return null;
    }


    public Element<T> getFirstElement() {
        return firstElement;
    }

    public String toString() {
        Element<T> element = firstElement;
        String cadena = "[";
        while (element != null) {
            cadena += element;
            element = element.getNext();
            cadena += ", ";
        }
        cadena += "]";
        return cadena;
    }
}
