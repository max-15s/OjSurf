// https://leetcode.com/problems/design-parking-system/

class ParkingSystem(big: Int, medium: Int, small: Int) {
    var big = big
    var medium = medium
    var small = small

    fun addCar(carType: Int): Boolean {
        if (carType == 1){
            if (big > 0){
                big -= 1
                return true
            }
            return false
        }else if (carType == 2){
            if (medium > 0){
                medium -= 1
                return true
            }
            return false
        }else if (carType == 3){
            if (small > 0){
                small -= 1
                return true
            }
            return false
        }
        return false
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */