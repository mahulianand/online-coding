package com.anand.projecteular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* A riffle shuffle is executed as follows: a deck of cards is split into two equal halves, with the top half taken in the left hand and the bottom half taken in the right hand.
* Next, the cards are interleaved exactly, with the top card in the right half inserted just after the top card in the left half,
* the 2nd card in the right half just after the 2nd card in the left half, etc. (Note that this process preserves the location of the top and bottom card of the deck)

Let s(n) be the minimum number of consecutive riffle shuffles needed to restore a deck of size n to its original configuration, where n is a positive even number.

Amazingly, a standard deck of 52 cards will first return to its original configuration after only 8 perfect shuffles, so s(52)=8. It can be verified that a deck of 86 cards will also return to its original configuration after exactly 8 shuffles, and the sum of all values of n that satisfy s(n)=8 is 412.

Find the sum of all values of n that satisfy s(n)=60.
* */
public class Problem622_RiffleShuffles {
    static List<Integer> orgDeck = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {

        int sum = 0;
        for(int i=1; i< 53; i++){
            count = 0;
            orgDeck = getDeck(i);

            double log = Math.log(i)/Math.log(2);
            System.out.println(log);
            System.out.println(i + " --> " + (log*3)/2);
            //riffleShuffles(orgDeck);

            if(count == 60){
                sum += i;
                //System.out.println("i : "+i+", Sum : " + sum);
            }
        }

        //System.out.println("Sum : " + sum);


    }



    private static void riffleShuffles(List<Integer> deck) {
        count++;

        if(count >= 61){
            return;
        }

        List<Integer> shuffledDeck = new ArrayList<>(deck.size());
        int leftIndex = 0;
        int rightIndex = deck.size() / 2;
        boolean left = true;
        for(int index = 0; index < deck.size(); index++){
            if(left){
                shuffledDeck.add(deck.get(leftIndex++));
            }else {
                shuffledDeck.add(deck.get(rightIndex++));
            }
            left = !left;
           // System.out.println(shuffledDeck.indexOf(1));
        }
//        System.out.println("Count : " + count);
//        System.out.println("shuffledDeck.size() : " + shuffledDeck.size());
//        System.out.println("shuffledDeck.toString() : " +shuffledDeck.toString());

        if(!shuffledDeck.equals(orgDeck)){
            riffleShuffles(shuffledDeck);
        }

    }

    private static List<Integer> getDeck(int n) {
        List<Integer> deck = new ArrayList<>(n);
        for(int i=1; i<= n; i++){
            deck.add(i);
        }
        return deck;
    }
}
