// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
class Solution {
    fun average(salary: IntArray): Double {
        var minSalary = Int.MAX_VALUE
        var maxSalary = Int.MIN_VALUE
        var total = 0
        for (s in salary){
            if (s < minSalary)
                minSalary = s
            if (s > maxSalary)
                maxSalary = s
            total += s
        }
        return (total - maxSalary - minSalary) / (salary.size - 2).toDouble()
    }
}