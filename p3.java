class Solution {
    public int trap(int[] height) {
        
        int n =height.length;
		
		//calc left max boundary
        int leftmax[] = new int[n];  //BARS IN LEFTAMAX
        leftmax[0] = height[0];   
        
        for (int i=1; i<n; i++) {							// 1 isliye kyo ki 0 ke liye upar calc kar lia
            leftmax[i]= Math.max(height[i], leftmax[i-1]); //purane wale ele ke pass max left boun jitni thi usko curr height se compare kr lia
        }													//currheight ko leftmax height se compare kr lia
        
        //calc right max boundary
        int rightmax[]= new int[n];
        rightmax[n-1] = height[n-1];			//rightmax last se shuru krna h isliye n-1
        for (int i=n-2; i>=0; i--) {
            rightmax[i]= Math.max(height[i], rightmax[i+1]);
        }