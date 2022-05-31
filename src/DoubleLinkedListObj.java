public class DoubleLinkedListObj <T>{
    Element<T> firstElement;
    Element<T> lastElement;
    public DoubleLinkedListObj(){

    }
    public void insertFirst(T obj){
        Element<T>newElement=new Element<>(obj);
        if(firstElement!=null){
            newElement.setNext(firstElement);
            firstElement.setPrev(newElement);
            firstElement=newElement;
        }else {
            firstElement=newElement;
        }


    }

    public void insertLast(T obj){
        Element<T>newElement=new Element<>(obj);
            lastElement.setNext(newElement);
            newElement.setPrev(lastElement);
            lastElement=newElement;
    }

    public boolean isEmpty(){
        return firstElement==null;
    }

    public T getObjectAtPosition(int i){
        int counter=0;
        Element<T> element=firstElement;
        while (element!=null){
            element=element.getNext();
            counter++;
            if(counter==i){
                return element.getObject();
            }
        }
        return null;
    }

    public T getObjectFromLast(int i){
        int counter=0;
        Element<T>last=lastElement;
        while (last!=null){
            last=last.getPrev();
            counter++;
            if(counter==i){
                return last.getObject();
            }
        }
        return null;
    }

    public void remove(T obj){
        int indexObject=findIndexOf(obj);
        Element<T>element=elementAt(indexObject);
        Element<T>nextElement=element.getNext();
        if(element==firstElement){
            firstElement=firstElement.getNext();
        }else if(element==lastElement) {
            lastElement=lastElement.getPrev();
        }else {
            Element<T> previous=element.getPrev();
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
        Element<T> element = firstElement;
        Element<T>last=lastElement;
        String cadena = "[";
        cadena+=element+", ";
        while (element.getNext()!=null){
            element=element.getNext();
            cadena+=element;
            cadena+=", ";
        }
        cadena+=last;
        cadena += "]";
        return cadena;
    }
}
