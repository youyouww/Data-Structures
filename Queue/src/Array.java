public class Array<E> {
    private E[] data;
    private int size;

    //传参构造函数
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数，默认capacity为10
    public Array(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //获取数组中指定index的元素
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed, Required index >= 0 || index < size");
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    //修改数组中指定index的元素
    public void set(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed, Required index >= 0 || index < size");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //数组resize动态扩容方法
    public void resize(int newcapacity){
        E[]newData = (E[])new Object[newcapacity];
        for(int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    //向数组中指定index位置添加一个元素
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed, Required index >= 0 || index < size");
        if(size == data.length)
            resize(2*data.length);
        for(int i = size-1; i >= index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }

    //向数组末尾添加元素
    public void addLast(E e){
        add(size, e);
    }

    //向数组头添加元素
    public void addFirst(E e){
        add(0, e);
    }

    //删除指定index位置的元素
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove Failed, Required index >= 0 || index < size");
        E rn = data[index];
        for(int i = index; i < size ; i++)
            data[i] = data[i+1];
        size--;
        if(size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);
        return rn;
    }

    //删除指定的元素
    public E removeElement(E e){
        int index = find(e);
        if(index == -1)
            throw new IllegalArgumentException("RemoveElement Failed! Not Exist!");
        return remove(index);
    }

    //删除数组末尾的元素
    public E removeLast(){
        return remove(size);
    }

    //删除数组中的第一个元素
    public E removeFirst(){
        return remove(0);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
