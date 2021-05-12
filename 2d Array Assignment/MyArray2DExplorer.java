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

        System.out.print("Test minRow: ");
        exp.printArray(exp.minRow(array));


        System.out.print("Test colMaxs: ");
        exp.printArray(exp.colMaxs(array));

        System.out.print("Test allRowSums: ");
        exp.printArray(exp.allRowSums(array));

        System.out.print("Test averageCol: ");
        exp.printArray(exp.averageCol(array));

        System.out.print("Test smallEven: ");
        System.out.println(exp.smallEven(array));

        System.out.print("Test biggestRow: ");
        System.out.println(exp.biggestRow(array));


    }

    public void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    public void printArray(double[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
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

    public int[] colMaxs(int[][] matrix)
    {
        int[] toReturn = new int[matrix[0].length];
        
        for(int i = 0; i < matrix[0].length; i++) //starts by going through each first value of column
        {
            int max = matrix[0][i];
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[j][i] > max)
                {
                    max = matrix[j][i];
                }
            }

            if( i < toReturn.length)
            {
                toReturn[i] = max;
            }
        }
        return toReturn;
    }

    public int[] allRowSums(int[][] data)
    {
        int[] toReturn = new int[data.length];
        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data[i].length; j++)
            {
                toReturn[i] += data[i][j];
            }
        }
        return toReturn;
    }

    public double[] averageCol(int[][] nums)
    {
        double[] toReturn = new double[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums[i].length; j++)
            {
                toReturn[i] += nums[i][j];
            }
            toReturn[i]/=nums[i].length;
        }
        return toReturn;
    }

    public int smallEven(int[][] matrix)
    {
        int smallEven = matrix[0][0];
        for(int[] row : matrix)
        {
            for(int i : row)
            {
                if(i < smallEven && i %2 == 0)
                {
                    smallEven = i;
                }
            }
        }
        return smallEven;
    }

    public int biggestRow(int[][] nums)
    {
        int[] rowSums = allRowSums(nums);

        int greatestSumIndex = 0;
        for(int i = 1; i < rowSums.length; i++)
        {
            if(rowSums[i] > rowSums[greatestSumIndex])
            {
                greatestSumIndex = i;
            }
        }

        return greatestSumIndex;
    }
}
