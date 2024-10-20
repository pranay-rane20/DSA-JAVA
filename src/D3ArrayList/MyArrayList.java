package D3ArrayList;



import static java.lang.StringTemplate.STR;

public class MyArrayList {

    private int data[]; //Array in which the data will be stored
    private int last =0; //for the index at which the data is to be stored


    public MyArrayList(){ //default constructor
        data = new int[10];
    }
    public MyArrayList(int initialCapacity){ //parameterized constructor
        data = new int[initialCapacity];
    }

    public int size(){ //size of the array
        return last;
    }

    public void ensureCapacity(){ //if overflow makeing new array
        if(last == data.length){
            int temp[] = new int[data.length *2];
            for(int i=0; i<data.length ; i++) temp[i] = data[i];

            data = temp; //pointing the old array to the new one
        }
    }

    public void add(int value){ //adding at last available position
        ensureCapacity();
        data[last++]=value;
    }

    public void add(int index , int value){//adding at a particular index
        if(index<0 || index>last)
            throw new IndexOutOfBoundsException(STR."\{index} out of bound for \{last}");
        ensureCapacity();
        for(int i=last ; i>index ; i--){
            data[i] = data[i-1];
        }
        data[index] = value;
        last++;
    }


    public int remove(int index) { //removeing the element
        if(index < 0 || index > last)
            throw new IndexOutOfBoundsException(STR."\{index} out of bounds for \{last}");
        ensureCapacity();
        int temp = data[index];
        for (int i = index; i < last ; i++) {
            data[i] = data[i+1];
        }
        last--;
        return temp;
    }

    public String toString(){ //printing the arraylist
        if(last ==0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<last ; i++){
            sb.append(STR."\{data[i]}, ");
        }
        sb.delete(sb.length()-2,sb.length());
        return sb+"]";
    }
}
