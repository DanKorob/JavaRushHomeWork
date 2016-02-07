package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null)
            return false;

        if (!n.getClass().equals(this.getClass()))
            return false;

        Solution nn = (Solution) n;

        if ((nn.first == null && first == null) && (nn.last == null && last == null))
            return true;
        else if (nn.first == null && first == null)
            return nn.last.equals(last);
        else if (nn.last == null && last == null)
            return nn.first.equals(first);

        return nn.first.equals(first) && nn.last.equals(last);
    }

    public int hashCode() {
        if (first == null && last == null)
            return 0;
        else if (first == null)
            return last.hashCode();
        else if (last == null)
            return 31 * first.hashCode();

        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
