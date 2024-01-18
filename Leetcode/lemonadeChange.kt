// https://leetcode.com/problems/lemonade-change/
class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fives = 0
        var tens = 0
        var twenties = 0
        for (b in bills){
            if (b == 5)
                fives++
            else if (b == 10){
                if (fives > 0) {
                    fives -= 1
                    tens += 1
                }else return false
            }
            else if (b == 20){
                if (tens > 0 && fives > 0){
                    fives -= 1
                    tens -= 1
                }else if(tens == 0 && fives >= 3)
                    fives -= 3
                else return false
            }
        }
        return true
    }
}