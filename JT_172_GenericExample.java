public class JT_172_GenericExample {
    // Basically Generic means it is a class which deals with different datatype when we create object.
    // For different object we can pass different datatype that performs operation according to our need.
    // Best example HashMap because we can create hashmap which has different datatype
    static class MyGeneric<T1,T2>{
        private T1 key;
        private T2 value;
        MyGeneric(T1 key, T2 value){
            this.key = key;
            this.value = value;
        }
        public T1 getKey() {
            return key;
        }

        public T2 getValue() {
            return value;
        }

        public void setValue(T2 value) {
            this.value = value;
        }

        public void setKey(T1 key) {
            this.key = key;
        }
    }
    public static void main(String[] args) {
        MyGeneric<Integer,String> gen = new MyGeneric<>(1,"Prince");
        int a = gen.getKey();
        String b = gen.getValue();
        System.out.println(a+":"+b);

        MyGeneric<String,String>gen1 = new MyGeneric<>("A","Apple");
        String x = gen1.getKey();
        String y = gen1.getValue();
        System.out.println(x+":"+y);


    }
}
