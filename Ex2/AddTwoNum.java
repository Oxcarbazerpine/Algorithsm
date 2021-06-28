package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.FlavorException;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode nowNode = l1;
        int sum1 = 0;
        int i = 0;
    while(nowNode != null){
        sum1+= nowNode.val*Math.pow(10,i);
        nowNode = nowNode.next;
        i++;
    }

    nowNode = l2;
    int sum2 = 0;
    i = 0;
    while(nowNode != null){
        sum2+= nowNode.val*Math.pow(10,i);
        nowNode = nowNode.next;
        i++;
    }
        int rest = sum1+sum2;
        ListNode resultNode = new ListNode();
        ListNode returnNode = resultNode;
        while(true){
            resultNode.val = rest%10;
            rest = rest/10;
            if(rest == 0) break;
            resultNode.next = new ListNode();
            resultNode = resultNode.next;
        }
        return returnNode;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int i = 0;
        ListNode resultNode = new ListNode();
        ListNode nowNode = resultNode;
        while(l1 != null || l2!=null || i > 0){
            int val1 = l1==null? 0: l1.val;
            int val2 = l2==null? 0: l2.val;
            
            i = val1 + val2 + i;
            nowNode.next = new ListNode(i%10);
            nowNode = nowNode.next;
            
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
            
            i= i/10;
        }
        
      return resultNode.next;   
    }

        
}

public class AddTwoNum {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // String line;
        // while ((line = in.readLine()) != null) {
        //     ListNode l1 = stringToListNode(line);
        //     line = in.readLine();
        //     ListNode l2 = stringToListNode(line);
            
        //     ListNode ret = new Solution().addTwoNumbers(l1, l2);
            
        //     String out = listNodeToString(ret);
            
        //     System.out.print(out);
        // }

        ListNode l1 = stringToListNode("[2,4,3]");
        ListNode l2 = stringToListNode("[5,6,4]");
        
        ListNode ret = new Solution().addTwoNumbers2(l1, l2);
        
        String out = listNodeToString(ret);
        
        System.out.print(out);
    }
}