package com.wwh.demo.data.structure.hashtab;

public class HashTab {
    private EmpLinkedList[] empLinkedListArray ;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public int hash(Emp res) {
        return res.getId() % size;
    }

    public void add(Emp res) {
        int index = hash(res);
        if (empLinkedListArray[index] == null) {
            empLinkedListArray[index] = new EmpLinkedList();
        }
        empLinkedListArray[index].add(res);
    }

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        Emp emp = new Emp(1, "小明");
        hashTab.add(emp);
        for (int i = 0; i < hashTab.empLinkedListArray.length; i++) {
            hashTab.empLinkedListArray[i].list();
        }

    }
}
