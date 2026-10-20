/**
 * Write a description of class Speeches here.
 *
 * Kyle and Ivana
 * 10/14/2026
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Speeches
{
    public static String extractJsonValue(String json, String key) {
        /**
         * Extracts the String value associated with a JSON key.
         * Example: extractJsonValue(jsonString, "president") returns "George Washington"
         */
        
        String keyTarget = "\"" + key + "\":";
        int keyIndex = json.indexOf(keyTarget);
        if (keyIndex == -1) {
            return "";
        }
        
        // Locate the first opening quote after the key
        int startQuote = json.indexOf("\"", keyIndex + keyTarget.length());
        if (startQuote == -1) {
            return "";
        }
        
        // Locate the matching closing quote
        int endQuote = json.indexOf("\"", startQuote + 1);
        
        // Handle escaped quotes inside the speech text (e.g., \")
        while (endQuote != -1 && json.charAt(endQuote - 1) == '\\') {
            endQuote = json.indexOf("\"", endQuote + 1);
        }
        
        
        if (endQuote == -1) {
            return "";
        }
        
        return json.substring(startQuote + 1, endQuote);
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("First Speech");
        File speechFile1 = new File("speeches/firstSpeech.json");
        String jsonContent1 = "";
        Scanner fileScan1 = new Scanner(speechFile1); 
        
        while (fileScan1.hasNextLine()) {
            jsonContent1 += fileScan1.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName1 = extractJsonValue(jsonContent1, "president");
        String date1 = extractJsonValue(jsonContent1, "date");
        System.out.println(presidentName1 + " " + date1);
        // getting the speech only
        String speech1 = extractJsonValue(jsonContent1, "transcript");
        String cleanedJson1 = speech1.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson1);
        
        // getting length
        int lengthSpeech1 = cleanedJson1.length();
        System.out.println("Word length #" + lengthSpeech1);
        
        // getting total words and average word length
        int count1 = 1;
        int iterator1 = 0;
        while (iterator1 < lengthSpeech1) {
            if (cleanedJson1.substring(iterator1, iterator1 + 1).equals(" ")) {
                count1++;
            }
            iterator1++;
        }
        double wordLength1 = (double) lengthSpeech1 / count1;
        System.out.println("Average word length #" + wordLength1);
        
        // using the cleaned json to count occurenences of people united and government
        String peopleFinder1 = cleanedJson1;
        int countP1 = 0;
        while (peopleFinder1.toLowerCase().indexOf("people") != -1) {
            peopleFinder1 = peopleFinder1.substring(peopleFinder1.toLowerCase().indexOf("people") + 6);
            countP1++;
        }
        double percentageP1 = (double) countP1 / (double) count1;
        System.out.println("People percentage #" + percentageP1);
        
        // did the same thing as above but to find the word government
        String gov1 = cleanedJson1;
        int countG1 = 0;
        while (gov1.toLowerCase().indexOf("government") != -1) {
            gov1 = gov1.substring(gov1.toLowerCase().indexOf("government") + 10);
            countG1++;
        }
        double percentageG1 = (double) countG1 / (double) count1;
        System.out.println("Government percentage #" + percentageG1);
        
        // did the same thing as above but to find the word united
        String united1 = cleanedJson1;
        int countU1 = 0;
        while (united1.toLowerCase().indexOf("united") != -1) {
            united1 = united1.substring(united1.toLowerCase().indexOf("united") + 6);
            countU1++;
        }
        double percentageU1 = (double) countU1 / (double) count1;
        System.out.println("United percentage #" + percentageU1);
        
        // did the same thing as above but to find the word percentage
        String our1 = cleanedJson1;
        int countO1 = 0;
        while (our1.toLowerCase().indexOf("our") != -1) {
            our1 = our1.substring(our1.toLowerCase().indexOf("our") + 3);
            countO1++;
        }
        double percentageO1 = (double) countO1 / (double) count1;
        System.out.println("Our percentage #" + percentageO1);
        
        //closes the file
        fileScan1.close();
        
        /////////////////////////////////////////////////////////////////////////////////////////
        //CODE/COMMENTS IS THE SAME AS ABOVE - WE USED COPY AND PASTE. It is the same comment reasoning above for the 2nd, 3rd, 4th, 5th, and 6th speech
        
        System.out.println("\n\nSecond Speech");
        
        File speechFile2 = new File("speeches/secondSpeech.json");
        String jsonContent2 = "";
        Scanner fileScan2 = new Scanner(speechFile2); 
        
        while (fileScan2.hasNextLine()) {
            jsonContent2 += fileScan2.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName2 = extractJsonValue(jsonContent2, "president");
        String date2 = extractJsonValue(jsonContent2, "date");
        System.out.println(presidentName2 + " " + date2);
        
        String speech2 = extractJsonValue(jsonContent2, "transcript");
        String cleanedJson2 = speech2.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson2);
        
        // getting length
        int lengthSpeech2 = cleanedJson2.length();
        System.out.println("Word length #" + lengthSpeech2);
        
        // getting total words and average word length
        int count2 = 1;
        int iterator2 = 0;
        while (iterator2 < lengthSpeech2) {
            if (cleanedJson2.substring(iterator2, iterator2 + 1).equals(" ")) {
                count2++;
            }
            iterator2++;
        }
        double wordLength2 = (double) lengthSpeech2 / count2;
        System.out.println("Average word length #" + wordLength2);
        
        String peopleFinder2 = cleanedJson2;
        int countP2 = 0;
        while (peopleFinder2.toLowerCase().indexOf("people") != -1) {
            peopleFinder2 = peopleFinder2.substring(peopleFinder2.toLowerCase().indexOf("people") + 6);
            countP2++;
        }
        double percentageP2 = (double) countP2 / (double) count2;
        System.out.println("People percentage #" + percentageP2);
        
        String gov2 = cleanedJson2;
        int countG2 = 0;
        while (gov2.toLowerCase().indexOf("government") != -1) {
            gov2 = gov2.substring(gov2.toLowerCase().indexOf("government") + 10);
            countG2++;
        }
        double percentageG2 = (double) countG2 / (double) count2;
        System.out.println("Government percentage #" + percentageG2);
        
        String united2 = cleanedJson2;
        int countU2 = 0;
        while (united2.toLowerCase().indexOf("united") != -1) {
            united2 = united2.substring(united2.toLowerCase().indexOf("united") + 6);
            countU2++;
        }
        double percentageU2 = (double) countU2 / (double) count2;
        System.out.println("United percentage #" + percentageU2);
        
        String our2 = cleanedJson2;
        int countO2 = 0;
        while (our2.toLowerCase().indexOf("our") != -1) {
            our2 = our2.substring(our2.toLowerCase().indexOf("our") + 3);
            countO2++;
        }
        double percentageO2 = (double) countO2 / (double) count2;
        System.out.println("Our percentage #" + percentageO2);
        
        fileScan2.close();
        
        /////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\nThird Speech");
        
        File speechFile3 = new File("speeches/thirdSpeech.json");
        String jsonContent3 = "";
        Scanner fileScan3 = new Scanner(speechFile3); 
        
        while (fileScan3.hasNextLine()) {
            jsonContent3 += fileScan3.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName3 = extractJsonValue(jsonContent3, "president");
        String date3 = extractJsonValue(jsonContent3, "date");
        System.out.println(presidentName3 + " " + date3);
        
        String speech3 = extractJsonValue(jsonContent3, "transcript");
        String cleanedJson3 = speech3.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson3);
        
        // getting length
        int lengthSpeech3 = cleanedJson3.length();
        System.out.println("Word length #" + lengthSpeech3);
        
        // getting total words and average word length
        int count3 = 1;
        int iterator3 = 0;
        while (iterator3 < lengthSpeech3) {
            if (cleanedJson3.substring(iterator3, iterator3 + 1).equals(" ")) {
                count3++;
            }
            iterator3++;
        }
        double wordLength3 = (double) lengthSpeech3 / count3;
        System.out.println("Average word length #" + wordLength3);
        
        String peopleFinder3 = cleanedJson3;
        int countP3 = 0;
        while (peopleFinder3.toLowerCase().indexOf("people") != -1) {
            peopleFinder3 = peopleFinder3.substring(peopleFinder3.toLowerCase().indexOf("people") + 6);
            countP3++;
        }
        double percentageP3 = (double) countP3 / (double) count3;
        System.out.println("People percentage #" + percentageP3);
        
        String gov3 = cleanedJson3;
        int countG3 = 0;
        while (gov3.toLowerCase().indexOf("government") != -1) {
            gov3 = gov3.substring(gov3.toLowerCase().indexOf("government") + 10);
            countG3++;
        }
        double percentageG3 = (double) countG3 / (double) count3;
        System.out.println("Government percentage #" + percentageG3);
        
        String united3 = cleanedJson3;
        int countU3 = 0;
        while (united3.toLowerCase().indexOf("united") != -1) {
            united3 = united3.substring(united3.toLowerCase().indexOf("united") + 6);
            countU3++;
        }
        double percentageU3 = (double) countU3 / (double) count3;
        System.out.println("United percentage #" + percentageU3);
        
        String our3 = cleanedJson3;
        int countO3 = 0;
        while (our3.toLowerCase().indexOf("our") != -1) {
            our3 = our3.substring(our3.toLowerCase().indexOf("our") + 3);
            countO3++;
        }
        double percentageO3 = (double) countO3 / (double) count3;
        System.out.println("Our percentage #" + percentageO3);
        
        fileScan3.close();
        
        //////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\nFourth Speech");
            
        File speechFile4 = new File("speeches/fourthSpeech.json");
        String jsonContent4 = "";
        Scanner fileScan4 = new Scanner(speechFile4); 
        
        while (fileScan4.hasNextLine()) {
            jsonContent4 += fileScan4.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName4 = extractJsonValue(jsonContent4, "president");
        String date4 = extractJsonValue(jsonContent4, "date");
        System.out.println(presidentName4 + " " + date4);
        
        String speech4 = extractJsonValue(jsonContent4, "transcript");
        String cleanedJson4 = speech4.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson4);
        
        // getting length
        int lengthSpeech4 = cleanedJson4.length();
        System.out.println("Word length #" + lengthSpeech4);
        
        // getting total words and average word length
        int count4 = 1;
        int iterator4 = 0;
        while (iterator4 < lengthSpeech4) {
            if (cleanedJson4.substring(iterator4, iterator4 + 1).equals(" ")) {
                count4++;
            }
            iterator4++;
        }
        double wordLength4 = (double) lengthSpeech4 / count4;
        System.out.println("Average word length #" + wordLength4);
        
        String peopleFinder4 = cleanedJson4;
        int countP4 = 0;
        while (peopleFinder4.toLowerCase().indexOf("people") != -1) {
            peopleFinder4 = peopleFinder4.substring(peopleFinder4.toLowerCase().indexOf("people") + 6);
            countP4++;
        }
        double percentageP4 = (double) countP4 / (double) count4;
        System.out.println("People percentage #" + percentageP4);
        
        String gov4 = cleanedJson4;
        int countG4 = 0;
        while (gov4.toLowerCase().indexOf("government") != -1) {
            gov4 = gov4.substring(gov4.toLowerCase().indexOf("government") + 10);
            countG4++;
        }
        double percentageG4 = (double) countG4 / (double) count4;
        System.out.println("Government percentage #" + percentageG4);
        
        String united4 = cleanedJson4;
        int countU4 = 0;
        while (united4.toLowerCase().indexOf("united") != -1) {
            united4 = united4.substring(united4.toLowerCase().indexOf("united") + 6);
            countU4++;
        }
        double percentageU4 = (double) countU4 / (double) count4;
        System.out.println("United percentage #" + percentageU4);
        
        String our4 = cleanedJson4;
        int countO4 = 0;
        while (our4.toLowerCase().indexOf("our") != -1) {
            our4 = our4.substring(our4.toLowerCase().indexOf("our") + 3);
            countO4++;
        }
        double percentageO4 = (double) countO4 / (double) count4;
        System.out.println("Our percentage #" + percentageO4);
        
        fileScan4.close();
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\nFifth Speech");
        
        File speechFile5 = new File("speeches/fifthSpeech.json");
        String jsonContent5 = "";
        Scanner fileScan5 = new Scanner(speechFile5); 
        
        while (fileScan5.hasNextLine()) {
            jsonContent5 += fileScan5.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName5 = extractJsonValue(jsonContent5, "president");
        String date5 = extractJsonValue(jsonContent5, "date");
        System.out.println(presidentName5 + " " + date5);
        
        String speech5 = extractJsonValue(jsonContent5, "transcript");
        String cleanedJson5 = speech5.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson5);
        
        // getting length
        int lengthSpeech5 = cleanedJson5.length();
        System.out.println("Word length #" + lengthSpeech5);
        
        // getting total words and average word length
        int count5 = 1;
        int iterator5 = 0;
        while (iterator5 < lengthSpeech5) {
            if (cleanedJson5.substring(iterator5, iterator5 + 1).equals(" ")) {
                count5++;
            }
            iterator5++;
        }
        double wordLength5 = (double) lengthSpeech5 / count5;
        System.out.println("Average word length #" + wordLength5);
        
        String peopleFinder5 = cleanedJson5;
        int countP5 = 0;
        while (peopleFinder5.toLowerCase().indexOf("people") != -1) {
            peopleFinder5 = peopleFinder5.substring(peopleFinder5.toLowerCase().indexOf("people") + 6);
            countP5++;
        }
        double percentageP5 = (double) countP5 / (double) count5;
        System.out.println("People percentage #" + percentageP5);
        
        String gov5 = cleanedJson5;
        int countG5 = 0;
        while (gov5.toLowerCase().indexOf("government") != -1) {
            gov5 = gov5.substring(gov5.toLowerCase().indexOf("government") + 10);
            countG5++;
        }
        double percentageG5 = (double) countG5 / (double) count5;
        System.out.println("Government percentage #" + percentageG5);
        
        String united5 = cleanedJson5;
        int countU5 = 0;
        while (united5.toLowerCase().indexOf("united") != -1) {
            united5 = united5.substring(united5.toLowerCase().indexOf("united") + 6);
            countU5++;
        }
        double percentageU5 = (double) countU5 / (double) count5;
        System.out.println("United percentage #" + percentageU5);
        
        String our5 = cleanedJson5;
        int countO5 = 0;
        while (our5.toLowerCase().indexOf("our") != -1) {
            our5 = our5.substring(our5.toLowerCase().indexOf("our") + 3);
            countO5++;
        }
        double percentageO5 = (double) countO5 / (double) count5;
        System.out.println("Our percentage #" + percentageO5);
        
        fileScan5.close();
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\nSixth Speech");
        
        File speechFile6 = new File("speeches/sixthSpeech.json");
        String jsonContent6 = "";
        Scanner fileScan6 = new Scanner(speechFile6); 
        
        while (fileScan6.hasNextLine()) {
            jsonContent6 += fileScan6.nextLine() + " ";
        }
        
        // getting name and date
        String presidentName6 = extractJsonValue(jsonContent6, "president");
        String date6 = extractJsonValue(jsonContent6, "date");
        System.out.println(presidentName6 + " " + date6);
        
        String speech6 = extractJsonValue(jsonContent6, "transcript");
        String cleanedJson6 = speech6.replaceAll("[.,?;]", "");
        System.out.println(cleanedJson6);
        
        // getting length
        int lengthSpeech6 = cleanedJson6.length();
        System.out.println("Word length #" + lengthSpeech6);
        
        // getting total words and average word length
        int count6 = 1;
        int iterator6 = 0;
        while (iterator6 < lengthSpeech6) {
            if (cleanedJson6.substring(iterator6, iterator6 + 1).equals(" ")) {
                count6++;
            }
            iterator6++;
        }
        double wordLength6 = (double) lengthSpeech6 / count6;
        System.out.println("Average word length #" + wordLength6);
        
        String peopleFinder6 = cleanedJson6;
        int countP6 = 0;
        while (peopleFinder6.toLowerCase().indexOf("people") != -1) {
            peopleFinder6 = peopleFinder6.substring(peopleFinder6.toLowerCase().indexOf("people") + 6);
            countP6++;
        }
        double percentageP6 = (double) countP6 / (double) count6;
        System.out.println("People percentage #" + percentageP6);
        
        String gov6 = cleanedJson6;
        int countG6 = 0;
        while (gov6.toLowerCase().indexOf("government") != -1) {
            gov6 = gov6.substring(gov6.toLowerCase().indexOf("government") + 10);
            countG6++;
        }
        double percentageG6 = (double) countG6 / (double) count6;
        System.out.println("Government percentage #" + percentageG6);
        
        String united6 = cleanedJson6;
        int countU6 = 0;
        while (united6.toLowerCase().indexOf("united") != -1) {
            united6 = united6.substring(united6.toLowerCase().indexOf("united") + 6);
            countU6++;
        }
        double percentageU6 = (double) countU6 / (double) count6;
        System.out.println("United percentage #" + percentageU6);
        
        String our6 = cleanedJson6;
        int countO6 = 0;
        while (our6.toLowerCase().indexOf("our") != -1) {
            our6 = our6.substring(our6.toLowerCase().indexOf("our") + 3);
            countO6++;
        }
        double percentageO6 = (double) countO6 / (double) count6;
        System.out.println("Our percentage #" + percentageO6);
        
        fileScan6.close();
    }
}