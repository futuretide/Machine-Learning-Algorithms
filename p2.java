
anwer's avatar
anwer
8
October 2, 2022 2:31 AM

211 VIEWS

 public String convert(String s, int numRows) {
        
        if(numRows == 1 || s.length() <= numRows ) return s;

		String result = "";

		for (int i = 1; i <= numRows; i++) {
			// first row

			if (i == 1) {
				int jump = 0;

				while (jump < s.length()) {
					result = result + s.charAt(jump);
					int next = (numRows - 2) * 2 + 1;
					jump = jump + next + 1; // nextelement
				}
			} else if (i != numRows) {

				boolean isJump = true;
				int jump = i - 1;
				result = result + s.charAt(jump);
				while (jump < s.length()) {
					if (isJump) {
						jump = jump + (numRows - i - 1) * 2 + 1 + 1;

						if (jump < s.length())
							result = result + s.charAt(jump);
						isJump = false;
					} else {
						jump = jump + (i - 1 - 1) * 2 + 1 + 1;

						if (jump < s.length())
							result = result + s.charAt(jump);
						isJump = true;
					}
				}
			}