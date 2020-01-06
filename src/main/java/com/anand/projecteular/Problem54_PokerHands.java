package com.anand.projecteular;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/*
* In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

1 High Card: Highest value card.
2 One Pair: Two cards of the same value.
3 Two Pairs: Two different pairs.
4 Three of a Kind: Three cards of the same value.
5 Straight: All cards are consecutive values.
6 Flush: All cards of the same suit.
7 Full House: Three of a kind and a pair.
8 Four of a Kind: Four cards of the same value.
9 Straight Flush: All cards are consecutive values of same suit.
10 Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:

Hand    Player 1            Player 2            Winner
1	 	5H 5C 6S 7S KD      2C 3S 8S 8D TD      Player 2
        Pair of Fives       Pair of Eights

2	 	5D 8C 9S JS AC      2C 5C 7D 8S QH      Player 1
        Highest card Ace    Highest card Queen

3	 	2D 9C AS AH AC      3D 6D 7D TD QD      Player 2
        Three Aces          Flush with Diamonds

4	 	4D 6S 9H QH QC      3D 6D 7H QD QS      Player 1
        Pair of Queens      Pair of Queens
        Highest card Nine   Highest card Seven

5	 	2H 2D 4C 4D 4S      3C 3D 3S 9S 9D      Player 1
        Full House          Full House
        With Three Fours    with Three Threes


The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?
* */
public class Problem54_PokerHands {

    private static Map<String, Integer> cardToNumber = new HashMap<>();

    public static void main(String[] args) {

        String[] cards = new String[]{"S", "H", "C", "D"};
        String[] card2 = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < card2.length; j++) {

                cardToNumber.put(card2[j] + cards[i], count++);
                System.out.println("cardToNumber.put(\""+card2[j]+cards[i]+"\", "+count +");");
            }
        }

        String path = "D:\\SVN Checkouts\\Other\\Coding\\src\\main\\resources\\com.anand.projecteular\\p054_poker.txt";
        File file = new File(path);
        int player1Won=0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();
            String[] split = line.split(" ");

            List<String> player1 = Arrays.asList("5H", "5C","6S","7S", "KD");
            List<String> player2 = Arrays.asList("2C", "3S","8S","8D", "TD");
//
//            List<String> player1 = Arrays.asList(split[0], split[1],split[2],split[3]);
//            List<String> player2 = Arrays.asList(split[4], split[5],split[6],split[7]);

            int player = computeWinner(player1, player2);

            if(player == 1){
                player1Won++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(player1Won);

    }

    private static int computeWinner(List<String> player1, List<String> player2) {
        int player1Weight =calculateWeight(player1);
        int player2Weight =calculateWeight(player2);

        System.out.println("Player 1 : " + player1Weight + ", Player 2 : " + player2Weight);

        if(calculateWeight(player1) > calculateWeight((player2))){
            return 1;
        } else if (calculateWeight(player1) < calculateWeight((player2))){
            return 2;
        }else {
            int player1HighCard =getHighCard(player1);
            int player2HighCard =getHighCard(player2);

            System.out.println("Player 1 High Card : " + player1HighCard + ", Player 2 High Card : " + player2HighCard);
            if(getHighCard(player1) > getHighCard(player2)){
                return 1;
            }else {
                return 2;
            }
        }

    }


    private static int calculateWeight(List<String> cards) {
        if(isRoyalFlush(cards)){
            System.out.println("Royal Flush");
            return 100;
        }

        if (isStraightFlush(cards)){
            System.out.println("Straight Flush");
            return 9;
        }

        if(isFourOfAKind(cards)){
            System.out.println("Four of a Kind");
            return 8;
        }

        if(isFullHouse(cards)){
            System.out.println("Full House");
            return 7;
        }

        if(isFlush(cards)){
            System.out.println("Flush");
            return 6;
        }

        if(isStraight(cards)){
            System.out.println("Straight");
            return 5;
        }

        if(isThreeOfAKind(cards)){
            System.out.println("Three of a Kind");
            return 4;
        }

        if(isTwoPair(cards)){
            System.out.println("Two Pair");
            return 3;
        }

        if(isOnePair(cards)){
            System.out.println("One Pair");
            return 2;
        }

//        if(isHighCard(cards)){
//            return 1;
//        }

        return 0;
    }

    /* High Card:Highest value card. */
    private static int getHighCard(List<String> cards) {
        List<Integer> cardNums = new ArrayList<>();
        cards.forEach(a -> {
            char val = a.charAt(0);
            if(val == 'A'){
                cardNums.add(1);
            }else if (val == 'T'){
                cardNums.add(10);
            }else if (val == 'J'){
                cardNums.add(11);
            }else if (val == 'Q'){
                cardNums.add(12);
            }else if (val == 'K'){
                cardNums.add(13);
            }else {
                cardNums.add(Integer.valueOf(val));
            }
        });
        Collections.sort(cards);

        return cardNums.get(cardNums.size() - 1);
    }

    /*One Pair: Two cards of the same value.*/
    private static boolean isOnePair(List<String> cards) {
        Map<String, Integer> valueCount = new HashMap<>();
        for (String card: cards){
            String value = card.charAt(0) + "";
            if(valueCount.containsKey(value)){
                valueCount.put(value, valueCount.get(value) + 1);
            }else{
                valueCount.put(value, 1);
            }
        }
        if(valueCount.containsValue(2) ||valueCount.containsValue(3) ||valueCount.containsValue(4) || valueCount.containsValue(5)){
            return true;
        }

        return false;
    }

    /*Two Pairs: Two different pairs.*/
    private static boolean isTwoPair(List<String> cards) {
        Map<String, Integer> valueCount = new HashMap<>();
        for (String card: cards){
            String value = card.charAt(0) + "";
            if(valueCount.containsKey(value)){
                valueCount.put(value, valueCount.get(value) + 1);
            }else{
                valueCount.put(value, 1);
            }
        }
        if(valueCount.containsValue(2) ||valueCount.containsValue(3) ||valueCount.containsValue(4) || valueCount.containsValue(5)){
            return true;
        }

        return false;
    }

    /*Three of a Kind: Three cards of the same value.*/
    private static boolean isThreeOfAKind(List<String> cards) {
        Map<String, Integer> valueCount = new HashMap<>();
        for (String card: cards){
            String value = card.charAt(0) + "";
            if(valueCount.containsKey(value)){
                valueCount.put(value, valueCount.get(value) + 1);
            }else{
                valueCount.put(value, 1);
            }
        }
        if(valueCount.containsValue(3) ||valueCount.containsValue(4) || valueCount.containsValue(5)){
            return true;
        }

        return false;
    }

    /*Straight: All cards are consecutive values.*/
    private static boolean isStraight(List<String> cards) {
        List<Integer> cardNums = new ArrayList<>();
        cards.forEach(a -> {
            char val = a.charAt(0);
            if(val == 'A'){
                cardNums.add(1);
            }else if (val == 'T'){
                cardNums.add(10);
            }else if (val == 'J'){
                cardNums.add(11);
            }else if (val == 'Q'){
                cardNums.add(12);
            }else if (val == 'K'){
                cardNums.add(13);
            }else {
                cardNums.add(Integer.valueOf(val));
            }
        });
        Collections.sort(cards);

        int n = cardNums.get(0);
        for (int i = 1; i < cardNums.size(); i++) {
            n = n + 1;
            if (n != cardNums.get(i)) {
                return false;
            }
        }

        return true;
    }

    /*Flush: All cards of the same suit.*/
    private static boolean isFlush(List<String> cards) {
        char suit = cards.get(0).charAt(1);
        for (String card: cards){
            if(card.charAt(1) != suit){
                return false;
            }
        }
        return true;
    }

    /*Full House:Three of a kind and a pair.*/
    private static boolean isFullHouse(List<String> cards) {
        Map<String, Integer> kindCount = new HashMap<>();
        for (String card: cards){
            String value = card.charAt(1) + "";
            if(kindCount.containsKey(value)){
                kindCount.put(value, kindCount.get(value) + 1);
            }else{
                kindCount.put(value, 1);
            }
        }
        if(kindCount.containsValue(3) || kindCount.containsValue(4) || kindCount.containsValue(5)){

            for(int i=0; i< cards.size(); i++){
                for(int j=i+1; j< cards.size(); j++){
                    if (Math.abs(cardToNumber.get(cards.get(i)) - cardToNumber.get(cards.get(j))) == 1){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*Four of a Kind: Four cards of the same value.*/
    private static boolean isFourOfAKind(List<String> cards) {

        Map<String, Integer> valueCount = new HashMap<>();
        for (String card: cards){
            String value = card.charAt(0) + "";
            if(valueCount.containsKey(value)){
                valueCount.put(value, valueCount.get(value) + 1);
            }else{
                valueCount.put(value, 1);
            }
        }
        if(valueCount.containsValue(4) || valueCount.containsValue(5)){
            return true;
        }

        return false;
    }

    /*Straight Flush:All cards are consecutive values of same suit.*/
    private static boolean isStraightFlush(List<String> cards) {
        List<Integer> cardNums = new ArrayList<>();
        cards.forEach(a -> cardNums.add(cardToNumber.get(a)));
        Collections.sort(cards);

        int low = cardNums.get(0);
        int high = cardNums.get(3);
        if((low >= 1 && high <= 13) || (low >= 14 && high <= 26) || (low >= 27 && high <= 39) || (low >= 40 && high <= 52)) {
            int n = cardNums.get(0);
            for (int i = 1; i < cardNums.size(); i++) {
                n = n + 1;
                if (n != cardNums.get(i)) {
                    return false;
                }
            }
        }
        return false;
    }

    /* Royal Flush:Ten, Jack, Queen, King, Ace, in same suit.*/
    private static boolean isRoyalFlush(List<String> cards) {
        if(cards.contains("AS") && cards.contains("TS") && cards.contains("JS") && cards.contains("QS") && cards.contains("KS")){
            return true;
        }

        if(cards.contains("AH") && cards.contains("TH") && cards.contains("JH") && cards.contains("QH") && cards.contains("KH")){
            return true;
        }

        if(cards.contains("AC") && cards.contains("TC") && cards.contains("JC") && cards.contains("QC") && cards.contains("KC")){
            return true;
        }

        if(cards.contains("AD") && cards.contains("TD") && cards.contains("JD") && cards.contains("QD") && cards.contains("KD")){
            return true;
        }


        return false;
    }


}


