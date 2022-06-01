public class DoubleLinkedListObj<T> {
    Element<T> firstElement;
    Element<T> lastElement;


    public DoubleLinkedListObj() {

    }

    public void insertFirst(T obj) {
        Element<T> newElement = new Element<>(obj);
            newElement.setNext(firstElement);
            firstElement=newElement;
            firstElement.setPrev(null);
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
        Element<T> last = lastElement;
        while (last != null) {
            counter++;

            if (counter == i) {
                return last.getObject();
            }
            last = last.getPrev();
        }
        return null;
    }

    public void remove(T obj) {
        int indexObject = findIndexOf(obj);
        Element<T> element = elementAt(indexObject);
        Element<T> nextElement = element.getNext();
        if (element == firstElement) {
            firstElement = firstElement.getNext();
        } else if (element == lastElement) {
            lastElement = lastElement.getPrev();
        } else {
            Element<T> previous = element.getPrev();
            previous.setNext(nextElement);
        }
        element.delete();
    }

    private int findIndexOf(T object) {
        int index = 0;
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

    public Element<T> getLastElement() {
        return lastElement;
    }

    public Element<T> getFirstElement() {
        return firstElement;
    }

    public String toString() {
        Element<T> element = firstElement;;
        String cadena = "[";
        cadena+=firstElement;
        while (element.getNext() != null) {
            element = element.getNext();
            cadena += element;
            cadena += ", ";
        }
        cadena += "]";
        return cadena;
    }
}
