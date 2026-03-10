import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        System.out.println("Original Input: " + input);
        System.out.println();

        // Normalize input
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("1. Two Pointer Method: " + TwoPointerMethod.check(normalized));
        System.out.println("2. Reverse String Method: " + ReverseStringMethod.check(normalized));
        System.out.println("3. Char Array Method: " + CharArrayMethod.check(normalized));
        System.out.println("4. Stack Method: " + StackMethod.check(normalized));
        System.out.println("5. Queue + Stack Method: " + QueueStackMethod.check(normalized));
        System.out.println("6. Deque Method: " + DequeMethod.check(normalized));
        System.out.println("7. LinkedList Method: " + LinkedListMethod.check(normalized));
        System.out.println("8. Recursion Method: " + RecursionMethod.check(normalized,0,normalized.length()-1));

        PalindromeService service = new PalindromeService();
        System.out.println("9. Service Class Method: " + service.checkPalindrome(normalized));

        PalindromeStrategy strategy = new StackStrategy();
        System.out.println("10. Strategy Pattern (Stack): " + strategy.check(normalized));

        PalindromeStrategy strategy2 = new TwoPointerStrategy();
        System.out.println("11. Strategy Pattern (Two Pointer): " + strategy2.check(normalized));
    }
}

/* 1. Two Pointer Method */
class TwoPointerMethod {

    public static boolean check(String input){

        int start = 0;
        int end = input.length() - 1;

        while(start < end){

            if(input.charAt(start) != input.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

/* 2. Reverse String Method */
class ReverseStringMethod {

    public static boolean check(String input){

        String reversed = "";

        for(int i=input.length()-1;i>=0;i--){
            reversed += input.charAt(i);
        }

        return input.equals(reversed);
    }
}

/* 3. Character Array Method */
class CharArrayMethod {

    public static boolean check(String input){

        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length-1;

        while(start < end){

            if(chars[start] != chars[end]){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

/* 4. Stack Method */
class StackMethod {

    public static boolean check(String input){

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            stack.push(c);
        }

        for(char c : input.toCharArray()){

            if(c != stack.pop()){
                return false;
            }
        }

        return true;
    }
}

/* 5. Queue + Stack Method */
class QueueStackMethod {

    public static boolean check(String input){

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            queue.add(c);
            stack.push(c);
        }

        while(!queue.isEmpty()){

            if(queue.remove() != stack.pop()){
                return false;
            }
        }

        return true;
    }
}

/* 6. Deque Method */
class DequeMethod {

    public static boolean check(String input){

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : input.toCharArray()){
            deque.addLast(c);
        }

        while(deque.size() > 1){

            if(deque.removeFirst() != deque.removeLast()){
                return false;
            }
        }

        return true;
    }
}

/* 7. LinkedList Method */
class LinkedListMethod {

    public static boolean check(String input){

        LinkedList<Character> list = new LinkedList<>();

        for(char c : input.toCharArray()){
            list.add(c);
        }

        while(list.size() > 1){

            if(list.removeFirst() != list.removeLast()){
                return false;
            }
        }

        return true;
    }
}

/* 8. Recursion Method */
class RecursionMethod {

    public static boolean check(String s, int start, int end){

        if(start >= end){
            return true;
        }

        if(s.charAt(start) != s.charAt(end)){
            return false;
        }

        return check(s,start+1,end-1);
    }
}

/* 9. Service Class (OOP) */
class PalindromeService {

    public boolean checkPalindrome(String input){

        int start = 0;
        int end = input.length()-1;

        while(start < end){

            if(input.charAt(start) != input.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

/* 10. Strategy Pattern */
interface PalindromeStrategy {

    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input){

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            stack.push(c);
        }

        for(char c : input.toCharArray()){

            if(c != stack.pop()){
                return false;
            }
        }

        return true;
    }
}

/* 11. Two Pointer Strategy */
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean check(String input){

        int start = 0;
        int end = input.length()-1;

        while(start < end){

            if(input.charAt(start) != input.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
