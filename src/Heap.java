import java.util.ArrayList;

public class Heap{

    private ArrayList<Double> heap;
    private int size;

    public Heap(){
        heap = new ArrayList<>();
        heap.add(0.0);
        size = 0;
    }

    public double getRoot() throws Exception {
        if(size == 0){
            throw new Exception("Heap is empty");
        }

        return heap.get(1);
    }

    public double getParent(int i) throws Exception{
        if(size <= 1 || i >= heap.size()){
            throw new Exception("Heap is too small");
        }

        return heap.get((i / 2));
    }

    public int getParentIndex(int i) throws Exception{
        if(size <= 1 || i >= heap.size()){
            throw new Exception("Heap is too small");
        }

        return i / 2;
    }

    public double getLeft(int i) throws Exception{
        if(size <= 1 || i >= heap.size() || i * 2 >= heap.size()){
            throw new Exception("Heap is too small");
        }

        return heap.get(i * 2);
    }

    public int getLeftIndex(int i) throws Exception{
        return i * 2;
    }

    public double getRight(int i) throws Exception{
        if(size <= 1 || i >= heap.size() || i * 2 >= heap.size()){
            throw new Exception("Heap is too small");
        }

        return heap.get(i * 2 + 1);
    }

    public int getRightIndex(int i) throws Exception{


        return (i * 2) + 1;
    }

    public void addValue(Double value) throws Exception {
        heap.add(value);

        int index = heap.size() - 1;

        size++;

        while(size > 1 && index > 1 && value < getParent(index)){
            double temp = heap.get(getParentIndex(index));
            heap.set(getParentIndex(index), value);
            heap.set(index, temp);

            index = getParentIndex(index);
        }
    }

    public double remove() throws Exception{
        double smallest = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        size--;

        if(size == 0){
            return smallest;
        }

        int index = 1;
        double value = heap.get(1);

        while (size > 1 && index < heap.size() && (index * 2) < heap.size() && value > getLeft(index) || ((index * 2 )+1) < heap.size() && value > getRight(index)){

            if(getLeftIndex(index) < heap.size() && value > getLeft(index) && getLeft(index) <= getRight(index)){
                double temp = heap.get(getLeftIndex(index));
                heap.set(getLeftIndex(index), value);
                heap.set(index, temp);

                index = getLeftIndex(index);
            }

            else if(getRightIndex(index) < heap.size() && value > getRight(index) && getLeft(index) > getRight(index)){
                double temp = heap.get(getRightIndex(index));
                heap.set(getRightIndex(index), value);
                heap.set(index, temp);

                index = getRightIndex(index);
            }

        }


        return smallest;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + heap +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Heap heap = new Heap();

        for (double i = 10.0; i > 0; i--) {

            heap.addValue(i);
            System.out.println(heap);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(heap.remove());
        }
    }
}
