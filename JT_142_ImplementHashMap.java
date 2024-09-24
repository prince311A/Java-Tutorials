import com.sun.jdi.Value;

import java.security.Key;
import java.util.LinkedList;
import java.util.SplittableRandom;

public class JT_142_ImplementHashMap {
    public static class MyHashMap<K,V>{ // Here we use generic
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node { // this used to store the key value in linked list in form of nodes
            K Key;
            V Value;

            Node(K Key, V Value) { // its constructor
                this.Key = Key;
                this.Value = Value;
            }
        }
             private int n; // use to calculate length of hashmap
            private LinkedList<Node>[] buckets ;
            // method to make array of given size
            private void initBuckets(int N){
                buckets = new LinkedList[N];
                for(int i = 0;i<buckets.length;i++){
                    buckets[i] = new LinkedList<>();
                }
            }
            // make constructor which is used to initialize the array of linked list
           public MyHashMap(){
                initBuckets(DEFAULT_CAPACITY);
            }
             public int size(){ // return no of pairs present in hashmap
                return n;
            }
            private int hashFunction(K Key){ // calculating BI
                return (Math.abs(Key.hashCode()))%buckets.length;
            }
            private int searchKeyInLL(K Key,LinkedList<Node> llist){// traversing the list to find KEY is present already or not if present returns index else -1
                for(int i =0;i<llist.size();i++){
                    if(Key==llist.get(i).Key){
                        return i;
                    }
                }
                return -1;
            }
            private void rehash(){   // Rehashing by Chaining Technique (Open Hashing)
                LinkedList<Node>[] oldBuckets = buckets; // this is for we doesn't want to lost old buckets
                initBuckets(buckets.length*2);
                n = 0;
                for(var buckets:oldBuckets){
                    for(var node:buckets){
                        put(node.Key,node.Value);
                    }
                }
            }

            // Method() 1
            public void put(K Key, V Value){
                int bi =  hashFunction(Key);// bi is a bucket index which is calculated by hash function, where the pairs going to store
            LinkedList<Node> currBucket = buckets[bi];
            int node_in_bi = searchKeyInLL(Key,currBucket);
            if(node_in_bi==-1){ // key doesn't exist
                Node temp = new Node(Key,Value);
                currBucket.add(temp);
                n++;
            }
            else{
                Node currNode = currBucket.get(node_in_bi);
                currNode.Value = Value;
            }
            // Rehashing by Chaining Technique (Open Hashing)
                if(n>= buckets.length*DEFAULT_LOAD_FACTOR){
                    rehash();
                }
                }
        // Method() 2
            public V remove(K Key){
                int bi =  hashFunction(Key);// bi is a bucket index which is calculated by hash function, where the pairs going to store
                LinkedList<Node> currBucket = buckets[bi];
                int node_in_bi = searchKeyInLL(Key,currBucket);
                if(node_in_bi==-1){ // key doesn't exist
                    return null;
                }
                else{
                    Node currNode = currBucket.get(node_in_bi);
                    V val = currNode.Value;
                    currBucket.remove(node_in_bi);
                    n--;
                    return val;
                }
            }
        // Method() 3
            public V get(K Key){
                int bi =  hashFunction(Key);// bi is a bucket index which is calculated by hash function, where the pairs going to store
                LinkedList<Node> currBucket = buckets[bi];
                int node_in_bi = searchKeyInLL(Key,currBucket);
                if(node_in_bi!=-1){ // key doesn't exist
                    Node currNode = currBucket.get(node_in_bi);
                    return currNode.Value;
                }
                else{
                    return null;
                }
            }
        }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        System.out.println(map.size());//3
        System.out.println(map.get(2));//b
        System.out.println(map.remove(3));//c
        System.out.println(map.remove(3));//null
        System.out.println(map.size());//2
        map.put(8,"pri");
        System.out.println(map.size());//3
        System.out.println(map.get(8));//pri
    }
}
