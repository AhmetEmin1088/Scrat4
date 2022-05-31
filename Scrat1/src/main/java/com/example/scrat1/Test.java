package com.example.scrat1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Java program to print all valid words that
// are possible using character of array
public class Test {

//        // Alphabet size
//        static final int SIZE = 29;
//
//        // trie Node
//        static class TrieNode
//        {
//            TrieNode[] Child = new TrieNode[SIZE];
//
//            // isLeaf is true if the node represents
//            // end of a word
//            boolean leaf;
//
//            // Constructor
//            public TrieNode() {
//                leaf = false;
//                for (int i =0 ; i< SIZE ; i++)
//                    Child[i] = null;
//            }
//        }
//
//        // If not present, inserts key into trie
//        // If the key is prefix of trie node, just
//        // marks leaf node
//        static void insert(TrieNode root, String Key)
//        {
//            int n = Key.length();
//            TrieNode pChild = root;
//
//            for (int i=0; i<n; i++)
//            {
//                int index = Key.charAt(i) - 'a';
//
//                if (pChild.Child[index] == null)
//                    pChild.Child[index] = new TrieNode();
//
//                pChild = pChild.Child[index];
//            }
//
//            // make last node as leaf node
//            pChild.leaf = true;
//        }
//
//        // A recursive function to print all possible valid
//        // words present in array
//        static void searchWord(TrieNode root, boolean Hash[],
//                               String str)
//        {
//            // if we found word in trie / dictionary
//            if (root.leaf == true)
//                System.out.println(str);
//
//            // traverse all child's of current root
//            for (int K =0; K < SIZE; K++)
//            {
//                if (Hash[K] == true && root.Child[K] != null )
//                {
//                    // add current character
//                    char c = (char) (K + 'a');
//
//                    // Recursively search reaming character
//                    // of word in trie
//                    searchWord(root.Child[K], Hash, str + c);
//                }
//            }
//        }
//
//        // Prints all words present in dictionary.
//        static void PrintAllWords(char Arr[], TrieNode root,
//                                  int n)
//        {
//            // create a 'has' array that will store all
//            // present character in Arr[]
//            boolean[] Hash = new boolean[SIZE];
//
//            for (int i = 0 ; i < n; i++)
//                Hash[Arr[i] - 'a'] = true;
//
//            // temporary node
//            TrieNode pChild = root ;
//
//            // string to hold output words
//            String str = "";
//
//            // Traverse all matrix elements. There are only
//            // 26 character possible in char array
//            for (int i = 0 ; i < SIZE ; i++)
//            {
//                // we start searching for word in dictionary
//                // if we found a character which is child
//                // of Trie root
//                if (Hash[i] == true && pChild.Child[i] != null )
//                {
//                    str = str+(char)(i + 'a');
//                    searchWord(pChild.Child[i], Hash, str);
//                    str = "";
//                }
//
//            }
//
//        }
//
//        //Driver program to test above function
//        public static void main(String args[]) throws IOException {
//
//            Scanner scanner = new Scanner(System.in);
//            char[] letterArray = new char[7];
//
//            for (int a = 0; a<7; a++) {
//                System.out.println("Please enter a letter : " );
//                char letter = scanner.next().charAt(0);
//                letterArray[a] = letter;
//
//            }
//
//
//            // Root Node of Trie
//            TrieNode root = new TrieNode();
//
//            // insert all words of dictionary into trie
//            int n = listOfStrings.size();
//            for (int i=0; i<n; i++)
//                insert(root, listOfStrings.get(i));
//
//            //char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;
//            int N = letterArray.length;
//
//            PrintAllWords(letterArray, root, N);
//
//        }

    // Function to print the words
    public static void printWord(String str, String s) {
        for (int i = 0; i < str.length(); i++) {
            if (s.indexOf(str.charAt(i)) < 0) {
                return;
            }
        }
        if(str.length()>=4) {
            System.out.println(str);
        }
    }

    // Function to find the words
    public static void findWord(String[] str1, char[] str2) {
        String s = "";
        for (int i = 0; i < str2.length; i++) {
            s += str2[i];
        }
        for (int i = 0; i < str1.length; i++) {
            printWord(str1[i], s);
        }
    }

    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        char[] letterArray = new char[7];
        char letter = ' ';
        char temp = ' ';
        for (int a = 0; a < letterArray.length; a++) {
            System.out.println("Please enter a letter : ");
            letter = scanner.next().charAt(0);
            if(letter != 'w' && letter != 'q' && letter != 'x' && letter != temp){
                letterArray[a] = letter;
                temp = letter;
            }else{
                System.out.println("Invalid letter!");
                a--;
            }

        }

        // Let the given dictionary be following
        //String Dict[] = {"go", "bat", "me", "eat", "goal", "boy", "run"};
        File file = new File("src/main/resources/sozluk.txt");

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader(file));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        // closing bufferreader object
        bf.close();

        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);

        //String[] str1 = {"go", "bat", "me", "eat", "goal", "boy", "run"};
        //char[] str2 = {'e', 'o', 'b', 'a', 'm', 'g', 'l'};
        findWord(array, letterArray);

//        // Given string str
//        String str = "abcdefg";
//        int len = str.length();
//
//        // Function Call
//        if (allLetter(str, len))
//            System.out.println("Yes");
//        else
//            System.out.println("No");


    }

//    static int size = 7;
//
//    // Function to check if ch is a letter
//    static boolean isLetter(char ch)
//    {
//        if (!Character.isLetter(ch))
//            return false;
//
//        return true;
//    }
//
//    // Function to check if a string
//    // contains all the letters from
//    // a to z
//    static boolean allLetter(String str, int len)
//    {
//        // Convert the given string
//        // into lowercase
//        str = str.toLowerCase();
//
//        // Create a frequency array to
//        // mark the present letters
//        boolean[] present = new boolean[7];
//
//        // Traverse for each character
//        // of the string
//        for (int i = 0; i < len; i++) {
//
//            // If the current character
//            // is a letter
//            if (isLetter(str.charAt(i))) {
//
//                // Mark current letter as present
//                int letter = str.charAt(i) - 'a';
//                present[letter] = true;
//            }
//        }
//
//        // Traverse for every letter
//        // from a to z
//        for (int i = 0; i < size; i++) {
//
//            // If the current character
//            // is not present in string
//            // then return false,
//            // otherwise return true
//            if (!present[i])
//                return false;
//        }
//        return true;
//    }





}


