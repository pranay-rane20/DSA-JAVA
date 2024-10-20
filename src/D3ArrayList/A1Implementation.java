package D3ArrayList;


public class A1Implementation {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        MyArrayList list = new MyArrayList();
        System.out.println(list);
        list.add(54);
        list.add(74);
        list.add(96);
        System.out.println(list);
        System.out.println(list.size());
        list.add(1, 24);
        System.out.println(list);
        System.out.println(list.size());
        list.add(4, 100);
        System.out.println(list);
        System.out.println(list.size());
        list.add(0, 42);
        System.out.println(list);
        System.out.println(list.size());
        list.add(2, 100);
        System.out.println(list);
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list);
//        System.out.println(list.size());
    }
}
