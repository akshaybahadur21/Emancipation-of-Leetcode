/*

1507. Reformat Date
Easy

Given a date string in the form Day Month Year, where:

    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    Year is in the range [1900, 2100].

Convert the date string to the format YYYY-MM-DD, where:

    YYYY denotes the 4 digit year.
    MM denotes the 2 digit month.
    DD denotes the 2 digit day.

Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"

Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"

Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"

 

Constraints:

    The given dates are guaranteed to be valid, so no error handling is necessary.

*/

class Solution {
    public String reformatDate(String date) {
        Map<String, String> day = new HashMap<>();
        day.put("1st", "01");
        day.put("2nd", "02");
        day.put("3rd", "03");
        day.put("4th", "04");
        day.put("5th", "05");
        day.put("6th", "06");
        day.put("7th", "07");
        day.put("8th", "08");
        day.put("9th", "09");
        day.put("10th", "10");
        day.put("11th", "11");
        day.put("12th", "12");
        day.put("13th", "13");
        day.put("14th", "14");
        day.put("15th", "15");
        day.put("16th", "16");
        day.put("17th", "17");
        day.put("18th", "18");
        day.put("19th", "19");
        day.put("20th", "20");
        day.put("21st", "21");
        day.put("22nd", "22");
        day.put("23rd", "23");
        day.put("24th", "24");
        day.put("25th", "25");
        day.put("26th", "26");
        day.put("27th", "27");
        day.put("28th", "28");
        day.put("29th", "29");
        day.put("30th", "30");
        day.put("31st", "31");   
        
        Map<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
        
        String[] dArr = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(dArr[2]).append("-");
        sb.append(month.get(dArr[1])).append("-");
        sb.append(day.get(dArr[0]));
        return sb.toString();
    }
}
