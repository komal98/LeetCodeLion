class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
          if(targetCapacity > jug1Capacity + jug2Capacity){
            return false;
        }

        if(jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity+jug2Capacity == targetCapacity) return true;

        return targetCapacity % GCD(jug1Capacity,jug2Capacity)==0;
    }

    public int GCD(int number1, int number2){
        while(number2!=0){
            int temp = number2;
            number2= number1%number2;
            number1=temp;
        }
        return number1;
    }
}