package Google.Optimization;

import java.util.ArrayList;
import java.util.Random;
/*
https://leetcode.com/problems/guess-the-word/solutions/134087/elimination-histogram-by-votrubac-56tf/
*/
public class GuessTheWord {
    /*
     * Solution 1 - Using random
     * public void findSecretWord(String[] words, Master master) {
     * int n=words.length;
     * ArrayList<String> list=new ArrayList<>();
     * Random random = new Random();
     * for(int i=0; i<n; i++) list.add(words[i]);
     * while(!list.isEmpty()){
     * ArrayList<String> data=new ArrayList<>();
     * String s=list.get(random.nextInt(list.size()));
     * list.remove(s);
     * int temp=master.guess(s);
     * if(temp==6) break;
     * if(temp==0) notMatch(s,data,list);
     * else isMatch(s,temp,data, list);
     * list=data;
     * 
     * }
     * 
     * }
     * void notMatch(String str,ArrayList<String> data, ArrayList<String> list){
     * for(int i=0; i<list.size(); i++){
     * String temp=list.get(i);
     * boolean check=true;
     * for(int j=0; j<6; j++){
     * if(temp.charAt(j)==str.charAt(j)) {
     * check=false;
     * break;
     * }
     * }
     * if(check==true) data.add(temp);
     * }
     * }
     * void isMatch(String str, int temp,ArrayList<String> data, ArrayList<String>
     * list){
     * for(int i=0; i<list.size(); i++){
     * String word=list.get(i);
     * int count=0;
     * for(int j=0; j<6; j++){
     * if(word.charAt(j)==str.charAt(j)) count++;
     * }
     * if(count==temp) data.add(word) ;
     * }
     * }
     */

    /*
     * Solution 2- Using probability matrix
     * The basic idea is to get a similarity score between secret and a guess. Say,
     * it's 3. Then, we compute a similarity score between guess and all candidates.
     * If a similarity between guess and some other candidate is not 3, this
     * candidate can be eliminated as it cannot be a secret.
     * 
     * An improvement to this idea is to pick a candidate guess in a certain way, so
     * that we maximize the number of candidates we can eliminate each turn. For
     * that, we use the elimination histogram.
     * 
     * Solution
     * We compute a position/character histogram for remaining candidates and use it
     * to select the next word to guess (O(n)). After each guess, we eliminate all
     * words with different similarity and update the histogram.
     * 
     * In order to reduce the number of guesses, the strategy is to pick such a word
     * that would maximize the amount of information we can get per each guess. For
     * example, if 30 words start with 'a', and a guess for "a*****" returned 0,
     * this single turn eliminates 30 words. So, we can build a histogram of how
     * often each character appears for each position. For example, if our words
     * only contain characters from 'a' to 'e', we can get something like this:
     * image
     * According to this histogram, the word that would give us maximum information
     * is "bdaced" - if this word exists in the list, of course. We need to score
     * each word according to this histogram (in my case, multiply count of each
     * character), and use the one with the highest score.
     * 
     * While writing this, I got an idea to use synthetic words ("bdaced" in our
     * example) to maximize the initial elimination. According to my tests, using a
     * synthetic word for the very first turn gives the best result.
     * int res = 0;
     * int[][] probs = new int[6][26];
     * 
     * int match(String w1, String w2) {
     * int count = 0;
     * for (int i = 0; i < 6; i++) {
     * if (w1.charAt(i) == w2.charAt(i))
     * count++;
     * }
     * return count;
     * }
     * 
     * String bestCandidate(List<String> words) {
     * String best = "";
     * int maxScore = -1;
     * 
     * for (String word : words) {
     * int score = 1;
     * 
     * for (int i = 0; i < 6; i++) {
     * score *= probs[i][word.charAt(i) - 'a'];
     * }
     * 
     * if (score > maxScore) {
     * maxScore = score;
     * best = word;
     * }
     * }
     * 
     * return best;
     * }
     * 
     * void updateProb(String word, int delta) {
     * for (int i = 0; i < 6; i++) {
     * probs[i][word.charAt(i) - 'a'] += delta;
     * }
     * }
     * 
     * public void findSecretWord(String[] wordlist, Master master) {
     * 
     * List<String> remaining = new LinkedList<>();
     * 
     * for (String word : wordlist) {
     * remaining.add(word);
     * updateProb(word, 1);
     * }
     * 
     * while (res < 6) {
     * 
     * String candidate = bestCandidate(remaining);
     * 
     * res = master.guess(candidate);
     * 
     * Iterator<String> it = remaining.iterator();
     * 
     * while (it.hasNext()) {
     * 
     * String word = it.next();
     * 
     * if (match(word, candidate) != res) {
     * updateProb(word, -1);
     * it.remove();
     * }
     * }
     * }
     * }
     */
}