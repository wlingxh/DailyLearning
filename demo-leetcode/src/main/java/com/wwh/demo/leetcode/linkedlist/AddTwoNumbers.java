package com.wwh.demo.leetcode.linkedlist;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    /**
     * 题目解题思路：其实就是：两个数的相加，而且题目中值的顺序，其实就是我们个，十，百...位的顺序，
     * 只要遍历相加就行。
     * 注意点：
     *      1、相加大于10的值的判断；
     *      2、当两个链表的数值个数不一样时；
     *
     * 第一版: 自己想的方法：low
     * 执行结果：通过
     * 显示详情
     * 执行用时：9 ms, 在所有 Java 提交中击败了21.68%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了5.02%的用户
     *
     * 缺点：res = Integer.valueOf((res + "").substring(1)); 这个方法的时间执行太慢，用取模，进行了修改
     *
     * 第二版：
     * 执行结果：通过
     * 显示详情
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了45.50%的用户
     *
     * 还可以改进：
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode result = new ListNode(-1);
        int res = 0;
        while (l1 != null && l2 != null) {
            if (temp == 1) {
                res = l1.val + l2.val + temp;
                temp = 0;
            } else {
                res = l1.val + l2.val;
            }
            if (res >= 10) {
                //改进：res = Integer.valueOf((res + "").substring(1));
                res = res % 10;
                temp = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (result.val < 0) {
                result.val = res;
                continue;
            }
            //还可以改进：
            ListNode tempNode = result;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            ListNode listNode = new ListNode(res);
            tempNode.next = listNode;
        }
        while (l1 != null) {
            if (temp == 1) {
                res = l1.val + temp;
                temp = 0;
            } else {
                res = l1.val;
            }
            if (res >= 10) {
                res = res % 10;
                temp = 1;
            }
            l1 = l1.next;
            ListNode tempNode = result;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            ListNode listNode = new ListNode(res);
            tempNode.next = listNode;

        }
        while (l2 != null) {
            if (temp == 1) {
                res = l2.val + temp;
                temp = 0;
            } else {
                res = l2.val;
            }
            if (res >= 10) {
                res = res % 10;
                temp = 1;
            }
            l2 = l2.next;
            ListNode tempNode = result;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            ListNode listNode = new ListNode(res);
            tempNode.next = listNode;

        }
        if (temp == 1) {
            ListNode tempNode = result;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            ListNode listNode = new ListNode(temp);
            tempNode.next = listNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        addTwoNumbers(a, b);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}