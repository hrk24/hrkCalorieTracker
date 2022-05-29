package com.springboot.hrk.calorietracker.util;

import com.springboot.hrk.calorietracker.model.Fruit;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProblemsUtil {
    public static void main(String[] args) {

        //Find the first occurence of duplicate in a string
        String firstDup = ProblemsUtil.findDuplicateString("HEMEM");
        System.out.println("FIRST DUPLICATE STRING :: " +firstDup);

        //Filter the duplicate elements in a string //Caps and Small Letter are different ascii value
        List<Character> testResult = ProblemsUtil.filterDuplicateCharactersInString("ABHytrBH");
        System.out.println("Duplicate Elements List :: " +testResult.toString());

        //String Rotation Left
        String op = ProblemsUtil.rotateString("CODE",4);
        System.out.println("Rotated String :: "+op);

        //String Rotating right //To find if a string is rotated or not, use contains..
        // String opString = IpString + IpString. The rotated string should be an substring of this.
        String opRight = ProblemsUtil.rotateStringRight("DECODE",2);
        System.out.println("Rotated String From Right:: "+opRight);
    }

    //String Rotation
    static String rotateString (String instr, int rotFac){
        if(rotFac < instr.length()) {
            String appendStr = instr.substring(0, rotFac);
            String interStr = instr.substring(rotFac, instr.length());
            String op = interStr.concat(appendStr);
            return op;
        } else {
            return "";
        }

    }

    //String Rotation //CODE
    static String rotateStringRight (String instr, int rotFac){
        StringBuffer revString = new StringBuffer();
        int count=0;
        for(int i=instr.length()-rotFac;i<instr.length();i++) {
            if(count==rotFac) break;
            revString.append(instr.charAt(i));
            count++;
        }

        String interString = instr.substring(0,instr.length()-rotFac);
        return revString.toString().concat(interString);


    }


    //Find Duplicates in String
    static String findDuplicateString(String inputString) {
        char[] ipArr = inputString.toCharArray();
        //Hashset does not maintain insertion order
        //using linked hash set to maintain the insertion order
        HashSet<Character> hashSet = new LinkedHashSet<>();
        int index = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (hashSet.contains(ipArr[i])) {
                index = i;
                break;
            } else {
                hashSet.add(ipArr[i]);
            }
        }
        return   String.valueOf(ipArr[index]);
    }

    //Filter Duplicates in a String //just use same logic and add ==1 to get non-dup elements
    static List<Character> filterDuplicateCharactersInString(String inputString){
        char[] ipArr = inputString.toCharArray();
        int count=1;
        HashMap<Character,Integer> supportMap = new HashMap<>();
        List<Character> opList = new ArrayList<Character>();
        for(int i=0;i< inputString.length();i++) { //Time complexity O(n)
            if(supportMap.containsKey(ipArr[i])){
                supportMap.put(ipArr[i],supportMap.get(ipArr[i]).intValue()+1);
            } else {
                supportMap.put(ipArr[i],Integer.valueOf(count));
            }
        }
        for(Map.Entry<Character,Integer> entry : supportMap.entrySet()){ //Time complexity O(n)
            if((int) entry.getValue() > 1) {
                opList.add( (char) entry.getKey());
            }
        }
        //Total time complexity of O(2n)
        return opList;
    }

    static List<Integer> findDuplicateElementsInList(List<Integer> ipList){
        Set<Integer> tempSet = new HashSet<>();
        List<Integer> finalList = new ArrayList<>();
        //finalList = ipList.stream().filter(x->tempSet.add(x)).collect(Collectors.toSet()).stream().collect(Collectors.toList());
        finalList = ipList.stream().filter(x->!tempSet.add(x)).collect(Collectors.toSet()).stream().collect(Collectors.toList());
        return finalList;
    }

    static Map<String,Long> findWordCountInString(String str){
        Map<String,Long> opMap = null;
        List<String> ipList = Arrays.asList(str.split(" "));
        opMap = ipList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return opMap;
    }

    private static void implementComparator() {
        List<Fruit> fruitList = new ArrayList<Fruit>();
        Fruit f1 = new Fruit();
        f1.setFruitName("Apple");
        f1.setCaloriesPerServing("200");

        Fruit f2 = new Fruit();
        f2.setFruitName("Banana");
        f2.setCaloriesPerServing("125");

        Fruit f3 = new Fruit();
        f3.setFruitName("mango");
        f3.setCaloriesPerServing("150");

        fruitList.add(f1);
        fruitList.add(f2);
        fruitList.add(f3);

        System.out.println("List Before Sort :: " +fruitList.toString());

        Collections.sort(fruitList, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if(o1.getCaloriesPerServing() ==null || o2.getCaloriesPerServing() ==null)
                    return 0;
                return o1.getCaloriesPerServing().compareTo(o2.getCaloriesPerServing());
                //return o1.getFruitName().compareTo(o2.getFruitName());
            }
        });

        System.out.println("List After Sort :: " +fruitList.toString());
    }

}


