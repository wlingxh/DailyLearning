package com.wwh.demo.data.structure.hashtab;

public class EmpLinkedList {

    private Emp head;

    /**
     * 添加元素
     *
     * @param res
     */
    public void add(Emp res) {
        //如果head.next为空，赋值
        if (head == null) {
            head = res;
            return;
        }
        Emp temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(res);
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            System.out.print("id: " + head.getId() + " name :" + head.getName());
            System.out.println();
            if (head.getNext() == null) {
                break;
            }
            head = head.getNext();
        }
    }
}
