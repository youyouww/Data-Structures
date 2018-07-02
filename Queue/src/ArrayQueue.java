public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder rs = new StringBuilder();
        rs.append("Queue: ");
        rs.append("front [");
        for(int i = 0; i < array.getSize(); i++){
            rs.append(array.get(i));
            if(i != array.getSize() - 1)
                rs.append(", ");
        }
        rs.append("] tail");
        return rs.toString();
    }

}
