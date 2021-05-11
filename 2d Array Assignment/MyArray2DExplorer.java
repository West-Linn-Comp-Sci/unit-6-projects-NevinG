public class MyArray2DExplorer
{
    public static void main(String[] args) {
        int array [][] = {  {4,1,8,5},
                            {0,2,3,4},
                            {6,6,2,2} };
        MyArray2DExplorer exp = new MyArray2DExplorer();

        System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array,0));
        System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array,2));

        System.out.println();

        System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array,1));
        System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array,0));

        System.out.println();


        System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
        int [] row = exp.minRow(array);
        for(int i = 0; i < row.length; i++){
            System.out.print(row[i] + " ");
        }
        System.out.print("}");

    }

    public boolean evenRow(int[][] mat, int row)
    {
        for(int i : mat[row])
        {
            if(i%2 == 1)
            {
                return false;
            }
        }
        return true;
    }

    public boolean oddColSum(int[][] nums, int col)
    {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i][col];
        }
        if(sum %2 == 1)
        {
            return true;
        }
        return false;
    }

    public int[] minRow(int[][] nums)
    {
        int index = 0;
        int minInt = nums[0][0];
        for(int x = 0; x < nums.length; x++)
        {
            for(int y = 0; y < nums[x].length; y++)
            {
                if(nums[x][y] < minInt)
                {
                    minInt = nums[x][y];
                    index = x;
                }
            }
        }
        return nums[index];
    }
}
