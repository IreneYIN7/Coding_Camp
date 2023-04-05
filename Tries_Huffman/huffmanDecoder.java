package Tries_Huffman;
import java.util.*;

import java.util.*;;

public class huffmanDecoder {
    //Given an array of Huffman code mappings and a Huffman-encoded string, find the decoded string. Each mapping will be a string
    // consisting of a tab-separated(t') character and its encoded value:'c encoded value'where the whitespace is a tab character.The newline character is represented as the character[newlinein the codes list, but should translate to In when decoded.

    // For example, given codes=('a 100100'b 100101[newline]111111) and the string encoded=100100111111100101 we do the following Break encodedinto its constituent encodings.
    // 100100111111100101
    // Now map them to their characters and return the string:anb.This will print as:
    // a
    // b
    // Note: While all code mappings in the example are 6 digits long mappings can be different lengths.The algorithm creates the
    // shortest length mapping for the most frequent character encoded.
    public class huffmanNode{
        huffmanNode lchild = null;
        huffmanNode rchild = null;
        String value = " ";
        // public huffmanNode(String value){
        //     this.value = value;
        //     lchild = null;
        //     rchild = null;
        // }
        
    }

    
    public String decode(String[] codes, String encode){
        Map<String, String> huffMap = new HashMap<>();
        for (int i = 0; i < codes.length; i++){
            String[] tokens = codes[i].split("\t");
            huffMap.put(tokens[0], tokens[1]);
        }
        huffmanNode huffTree = constructHuffmanTree(codes);

        //encode:
        huffmanNode currentTree = huffTree;
        String encodedString = "";
        for (int i = 0; i < encode.length(); i ++ ){
            if (encode.charAt(i) == '1'){
                if(currentTree.value != " "){
                    String value = currentTree.value;
                    if(value.equals("[newline]")) value = "\n";
                    encodedString += value;
                    currentTree = huffTree;
                }
                currentTree = currentTree.rchild;
            }
            else{
                if(currentTree.value != " "){
                    String value = currentTree.value;
                    if(value.equals("[newline]")) value = "\n";
                    encodedString += value;
                    currentTree = huffTree;
                }
                currentTree = currentTree.lchild;

            }
        }
        if (currentTree.value != " ") encodedString += currentTree.value;
        return encodedString;

    }

    private huffmanNode constructHuffmanTree(String[] codes){
        
        huffmanNode root = new huffmanNode();
        for (int i = 0; i < codes.length; i++){
            String strVal = codes[i].split("\t")[0];
            String encodeVal = codes[i].split("\t")[1];
            System.out.println(encodeVal);
            huffmanNode current = root;
            for(int j = 0; j < encodeVal.length(); j ++){
                if(encodeVal.charAt(j) == '0' ){
                    if (current.lchild == null) current.lchild = new huffmanNode();
                    current = current.lchild;
                }
                else{
                    if (current.rchild == null) current.rchild = new huffmanNode();
                    current = current.rchild;
                }
            }
            current.value = strVal;
        }
        return root;
    }

    public static void main(String arg[]){
        String[] codes = new String[]{"a\t100100", "b\t100101", "[newline]\t111111"};
        String encode = "100100111111100101";
        huffmanDecoder test = new huffmanDecoder();
        System.out.println("result is: \n"+ test.decode(codes, encode));
    }
}


