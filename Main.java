import java.util.*;
public class Main{
    //属性
    private int[] array;
    private int size; //用来保存数组中已有的数据个数

    //构造方法
    public Main(){
        //初始化
        array = new int[10];
        size = 0;
    }
    //插入
    public void pushfront(int element){
        ensurecapacity();
        for(int i = size - 1;i >= 0;i--){
            array[i+1] = array[i];
        }
        array[0] = element;
        size++;
    }

    public void pushback(int element){
        ensurecapacity();
        array[size++] = element;
        size++;
    }

    public void insert(int index,int element){
        ensurecapacity();
        for(int i = size - 1;i >= index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }
    //删除
    public void popfront(){
        for(int i = 0;i < size-1;i++){
            array[i] = array[i+1];
        }
        size--;
    }

    public void popback(){
        array[--size] = 0;
    }

    public void erase(int index){
        for(int i = index;i < size-1;i++){
            array[i] = array[i+1];
        }
        size--;
    }

    public int indexof(int element){
        int i;
        for(i = 0;i < array.length;i++){
            if(array[i] == element){
                break;
            }
        }
        return i;
    }

    public String set(int[] array){
        return Arrays.toString(array);
    }

    private void ensurecapacity(){
        if(size < array.length){
            return;
        }
        else{
            int size = array.length+array.length/2;
            int[] newarray = new int[size];
            for(int i = 0;i<array.length;i++){
                newarray[i] = array[i];
            }
            this.array = newarray;
        }
    }

    public static void main(String[] args){

    }
}
