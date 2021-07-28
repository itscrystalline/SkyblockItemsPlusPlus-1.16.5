package com.iwant2tryhard.skyblockitemsplusplus.nonexd;

import java.util.HashMap;
import java.util.Map;

public class HackerRank {
    void Java_String_Reverse()
    {
        String A = "thisiht";
        String[] separated = A.split("");
        String reversed = "";
        for (int i = 0; i < separated.length; i++)
        {
            reversed += separated[(separated.length - 1) - i];
        }
        System.out.println(A.equalsIgnoreCase(reversed) ? "Yes" : "No");
    }

    boolean Java_Anagrams(String a, String b)
    {
        // test for invalid input
        if( a == null || b == null || a.equals("") || b.equals("") )
            throw new IllegalArgumentException();

// initial quick test for non-anagrams
        if ( a.length() != b.length() )
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

// populate a map with letters and frequencies of String b
        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < b.length(); k++){
            char letter = b.charAt(k);

            if( ! map.containsKey(letter)){
                map.put( letter, 1 );
            } else {
                Integer frequency = map.get( letter );
                map.put( letter, ++frequency );
            }
        }

// test each letter in String a against data in the map
// return if letter is absent in the map or its  frequency is 0
// otherwise decrease the frequency by 1

        for (int k = 0; k < a.length(); k++){
            char letter = a.charAt(k);

            if( ! map.containsKey( letter ) )
                return false;

            Integer frequency = map.get( letter );

            if( frequency == 0 )
                return false;
            else
                map.put( letter, --frequency);
        }
// if the code got that far it is an anagram
        return true;
    }

    void Java_1D_Array()
    {
        /*int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i]=scan.nextInt();
        }*/

    }
}
