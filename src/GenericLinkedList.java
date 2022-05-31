public class GenericLinkedList<TGeneric> {
    Element<TGeneric> firstElement;
    public GenericLinkedList() {

    }

    public void insertFirst(TGeneric obj) {
        Element <TGeneric> newElement = new Element<>(obj);
        newElement.setNext(firstElement);
        firstElement = newElement;
    }

    private Element<TGeneric> getFirstObject() {
        return firstElement;
    }


    public void insertLast(TGeneric obj) {
        if (!isEmpty()) {
            Element<TGeneric> element = firstElement;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            element.setNext(new Element<>(obj));
        }
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void remove(TGeneric obj) {
        int indexOfObject = findIndexOf(obj);
        if (indexOfObject < 0) return;
        Element<TGeneric> element = elementAt(indexOfObject);
        Element<TGeneric> nextElement = element.getNext();
        if (element == firstElement) {
            firstElement = firstElement.getNext();
        } else {
            Element<TGeneric> previousElement = elementAt(indexOfObject - 1);
            previousElement.setNext(nextElement);
        }
        element.delete();
    }

    private int findIndexOf(TGeneric object) {
        int index = -1;
        Element <TGeneric> element = firstElement;
        while (element != null) {
            index++;
            if (element.getObject() == object)
                break;
            element = element.getNext();
        }
        return index;
    }

    private Element<TGeneric> elementAt(int index) {
        int currentIndex = 0;
        Element <TGeneric>element = firstElement;
        while (element != null) {
            if (currentIndex == index)
                return element;
            currentIndex++;
            element = element.getNext();
        }
        return null;
    }

    public TGeneric getObjectAtPosition(int i) {
        if (!isEmpty()) {
            int contador = 0;
            Element<TGeneric> element = firstElement;
            while (element.getNext() != null) {
                contador++;
                element = element.getNext();
                if (i == contador) {
                    return element.getObject();
                }
            }
        }
        return null;
    }

    private TGeneric getLastObject() {
        Element<TGeneric> element = firstElement;
        while (element.getNext() != null) {
            element = element.getNext();
        }
        return element.getObject();
    }

    @Override
    public String toString() {
        Element<TGeneric> element = firstElement;
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

