package _a_java_model_.design._3_.action.Iterator;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/15  14:52
 * @description :
 */
public class NameRepository implements Container {

    public String[] names = {"A" , "B" , "C" , "D" , "E"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return this.hasNext()? names[index++] : null;
        }
    }
}
