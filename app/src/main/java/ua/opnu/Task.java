package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            stack.push(val);
            queue.add(val);
        }

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            int fromStack = stack.pop();
            if (val != fromStack) isPalindrome = false;
            queue.add(val);
        }

        return isPalindrome;
    }

    public static void reorder(Queue<Integer> q) {
        if (q == null || q.size() <= 1) {
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int initialSize = q.size();

        for (int i = 0; i < initialSize; i++) {
            int current = q.remove();
            if (current < 0) {
                stack.push(current);
            } else {
                q.add(current);
            }
        }

        int negativeCount = stack.size();
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        int positiveCount = initialSize - negativeCount;
        for (int i = 0; i < positiveCount; i++) {
            q.add(q.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue.isEmpty()) return;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.add(num);
            } else {
                stack.push(num);
            }
        }

        ArrayDeque<Integer> tempStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            queue.add(tempStack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
            Set<Integer> set1 = new HashSet<>(list1);
            Set<Integer> set2 = new HashSet<>(list2);
            set1.retainAll(set2);
            return set1.size();
        }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String v : map.values()) {
            if (!values.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : map.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        int minFreq = Integer.MAX_VALUE;
        int rareVal = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int f = e.getValue();
            if (f < minFreq || (f == minFreq && val < rareVal)) {
                minFreq = f;
                rareVal = val;
            }
        }
        return rareVal;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int n : list) {
            int f = freq.getOrDefault(n, 0) + 1;
            freq.put(n, f);
            if (f > maxFreq) maxFreq = f;
        }
        return maxFreq;
    }

}
