package bitwise;

public class subtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(5,add(~2,1));
		System.out.println(~8);
		
	}

	static int add(int a, int b) {
        int partialSum, carry;
        do {
            partialSum = a ^ b;
            carry = (a & b) << 1;
            a = partialSum;
            b = carry;
        } while (carry != 0);
        
        System.out.println(partialSum);
        return partialSum;
        
}
}
