class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] helper = new int[10];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(helper[ch - '0'] == 1){
                        return false;
                    } 
                    else{
                        helper[ch - '0'] = 1;
                    }
                }
            }
            Arrays.fill(helper , 0);
        }

        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(helper[ch - '0'] == 1){
                        return false;
                    } 
                    else{
                        helper[ch - '0'] = 1;
                    }
                }
            }
            Arrays.fill(helper , 0);
        }
        
        Arrays.fill(helper , 0);
        
        for(int r=0; r<9; r+=3){
            for(int c=0; c<9; c+=3){
                for(int i=r; i<r+3; i++){
                    for(int j=c; j<c+3; j++){
                        char ch = board[i][j];
                        if(ch != '.'){
                            if(helper[ch - '0'] == 1){
                                return false;
                            } 
                            else{
                                helper[ch - '0'] = 1;
                            }
                        }
                    }
                }
                Arrays.fill(helper , 0);
            }
        }
        
        return true;
    }
}