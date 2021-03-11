import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void testingo(){

        String password = "abvsdsd@gmail.com";
        StringBuilder sb = new StringBuilder();
        Boolean atPosition = false;
        for(int i = 0; i < password.length(); i++) {
            String current =String.valueOf(password.charAt(i));
            if (i == 0 || current.equals("@") || (!atPosition && i < password.length() && String.valueOf(password.charAt(i + 1)).equals("@")) ||
                    atPosition ) {
                atPosition = atPosition || current.equals("@") ? true : false;
                sb.append(current);
            } else {
                sb.append("*");
            }
        }
        System.out.println(sb.toString());
    }
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @org.junit.Test
    public void testIndexOutOfBoundsException()  throws Exception{

        Integer i = null;
        Assert.assertNull("The object you enter return null", i);
    }


    @org.junit.Test
    public void exam(){
//        System.out.print(testttttt(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
        System.out.print(solution("aabbcc"));
    }


    public Integer testttttt(int[] ranks){
        Integer rankCount = 0;
        Integer tmp = 1;
        Arrays.sort(ranks);
        for(int i = 0; i < ranks.length -1; i++){
            if (ranks[i] != ranks[i+1] && (ranks[i] + 1) == ranks[i+1]) {
                rankCount = tmp > 1 ? tmp+rankCount : rankCount+1;
                tmp = 1;
            } else if (ranks[i] == ranks[i+1]) {
                tmp++;
            } else {
                tmp = 1;
            }
        }
        return rankCount;
    }

    @org.junit.Test
    public void invert(){
        try {
            String val = new StringBuilder(null).reverse().toString();
            Assert.fail();
        }  catch (Exception ex) {

        }
    }

    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;
        for (int i = 25; i >= 0 ; i--) {
//        for (int i = 1; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public String tesstooo(String s){
        StringBuilder init = new StringBuilder();
        init.append(s.substring(0, 2));
        String temp = "";
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) ||
                    s.charAt(i) != s.charAt(i - 2)) {
                init.append(s.charAt(i));
            } else {
                temp = temp.length() > init.toString().length() ? temp : init.toString();
                init = new StringBuilder();
                init.append(s.charAt(i-1));
                init.append(s.charAt(i));
            }
        }
        return temp.length() > init.toString().length() ? temp : init.toString();
    }
}
