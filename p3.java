class Solution {
    public int trap(int[] height) {
        
        int n =height.length;
		
		//calc left max boundary
        int leftmax[] = new int[n];  //BARS IN LEFTAMAX
        leftmax[0] = height[0];   
        
        for (int i=1; i<n; i++) {							
            leftmax[i]= Math.max(height[i], leftmax[i-1]); 
        }													
        
        //calc right max boundary
        int rightmax[]= new int[n];
        rightmax[n-1] = height[n-1];			//rightmax last se shuru krna h isliye n-1
        for (int i=n-2; i>=0; i--) {
            rightmax[i]= Math.max(height[i], rightmax[i+1]);
        }
	     int trapwater=0;
        for (int i=0; i<n; i++) {
            //waterlevel=min(leftboun,right boun)
            int waterlevel=Math.min(leftmax[i], rightmax[i]);
            
           
            trapwater += waterlevel - height[i]; //
        }
        return trapwater;
    }
}
