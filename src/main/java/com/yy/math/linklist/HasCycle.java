package com.yy.math.linklist;

/**
 * Created by Administrator on 2020/6/11.
 */
public class HasCycle {
    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        int[] reverse = hasCycle.reverse(new int[]{1, 2, 3, 4});
        for(int temp : reverse){
            System.out.println(temp);
        }

    }

    /**
     * 判断链表内部是否有环
     * 一个跑得快，一个跑得慢。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；
     * 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环
     * @param head
     * @return
     */
    public boolean hasCycle(Node head){
        Node slow, fast;
        fast = slow = head;
        while(fast != null && slow != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 已知链表中含有环， 找出环的起点位置
     * 第一次相遇时，假设慢指针 slow 走了 k 步，那么快指针 fast 一定走了 2k 步，也就是说比 slow 多走了 k 步（也就是环的长度）
     * 设相遇点距环的起点的距离为 m，那么环的起点距头结点 head 的距离为 k - m，也就是说如果从 head 前进 k - m 步就能到达环起点。
     * 巧的是，如果从相遇点继续前进 k - m 步，也恰好到达环起点
     * 只要我们把快慢指针中的任一个重新指向 head，然后两个指针同速前进，k - m 步后就会相遇，相遇之处就是环的起点了。
     * @param head
     * @return
     */
    public Node detectCycle(Node head){
       Node slow, fast;
       slow = fast = head;
       while(fast != null && slow != null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast){
               break;
           }
       }
       slow = head;
       while(slow != fast){
           slow = slow.next;
           fast = fast.next;
       }
       return slow;
    }

    /**
     * 找到链表的中间节点
     * 快指针一次前进两步，慢指针一次前进一步，当快指针到达链表尽头时，慢指针就处于链表的中间位置。
     * @param head
     * @return
     */
    public Node findMidNode(Node head){
        Node fast, slow;
        fast = slow = head;
        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 寻找链表倒数第k个节点
     * 让快指针先走k步， 然后快慢指针同时前进，快指针走到结尾时，慢指针所在的位置就是倒数第k个节点的位置
     * @param head
     * @param k
     * @return
     */
    public Node findLastNNode(Node head, int k){
        Node fast, slow;
        fast = slow = head;
        while(k-- > 0){
            fast = fast.next;
        }
        while(fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 实现数组反转
     * 交换左右两个指针的值
     * @param nums
     * @return
     */
    public int[] reverse(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
