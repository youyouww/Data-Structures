public class Array<E> {
    private E[] data;
    private int size;

    Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add is failed, Required index >=0 || index <= size");
        if(size == data.length)
            resize(2*data.length);
        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
     }

     public E get(int index){
         if(index < 0 || index >= size)
             throw new IllegalArgumentException("Get failed, Index is illegal");
         return data[index];
     }

     public void set(int index, E e){
         if(index < 0 || index >= size)
             throw new IllegalArgumentException("Set failed, Index is illegal");
         data[index] = e;
     }

     public boolean contains(E e){
        for(int i=0 ; i < size ; i++){
            if(data[i] == e)
                return true;
        }
        return false;
     }

    public int find(E e){
        for(int i=0 ; i < size ; i++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

     public E remove(int index){
         if(index < 0 || index >= size)
             throw new IllegalArgumentException("Remove failed, Index is illegal");
         E rn = data[index];
         for(int i = index ; i < size ; i++){
             data[i] = data[i+1];
         }
         size--;
         if(size == data.length/4 && data.length/2 != 0)
             resize(data.length/2);
         return rn;
     }

     public  void removeElement(E e){
         int index = find(e);
         if(index != -1)
             remove(index);
     }

     public E removeFirst(){
        return remove(0);
     }

     public E removeLast(){
        return remove(size);
     }

     @Override
     public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size ; i++){
            res.append(data[i]);
            if(i != size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
     }

     private void resize(int newCapacity){
        E newData[] = (E[])new Object[newCapacity];
        for(int i=0 ;i < size ; i++)
            newData[i] = data[i];
        data = newData;
     }

}



