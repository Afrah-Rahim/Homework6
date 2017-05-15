
/**
 * Write a description of class Methods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Methods
{
    /**
     * Max: Finds the maximum value in a list
     * Precondition: a list of integer values
     * Postcondition: returns the maximum value
     * @Param: the list
     */
    public static int max(ListInterface aList) 
    {
        int maxNum = (int)aList.get(1);
        for(int i = 1; i<=aList.size();i++)
        {
            int current = (int)aList.get(i);
            if( current > maxNum)
            {
                maxNum = current;
            }
        }
        return maxNum;
    }

    /**
     * swap: Swaps two values within a list
     * Precondition: a list of integers
     * Postcondition: prints statements stating change
     * @Params: two indexes as well as the list they are in
     */
    public static void swap(ListInterface aList, int i, int j)
    {
        Object x = aList.get(i);
        Object y = aList.get(j);
        if(i>j)
        {
            aList.remove(i);
            aList.remove(j);
        }
        else
        {
            aList.remove(j);
            aList.remove(i);
        }
        aList.add(i, y);
        aList.add(j, x);

    }

    /**
     * reverse: reverses the list
     * Precondition: a list of integer values
     * Postcondition: none
     * @Param: The list
     */
    public static void reverse(ListInterface aList)
    {
        for(int i=1, j = aList.size() ; i<=((aList.size())/2); i++, j--)
        {
            swap(aList, i, j);
            System.out.println();
        }
    }

    /**
     * currentList: prints the current values of the list
     * Precondition: a list of integers
     * @Param: a list
     */
    public static void currentList(ListInterface aList)
    {
        int i;
        if(aList.size() == 0)
        {
            System.out.print("The list is empty");
        }
        else
        {
            System.out.print("The current list contains: ");
            for(i = 1; i<=aList.size(); i++)
            {
                System.out.print(aList.get(i) + " ");
            }

        }
        System.out.println();
    }

    /**
     * addHead: adds a number to the front of the list making that number the new head
     * @Param: the list and the integer to add
     */
    public static void addHead(ListInterface aList, int a)
    {
        aList.add(1,a);

    }

    /**
     * removeHead: Removes the number from the front of the list, making the next number the new head
     * @Param: the list
     */
    public static void removeHead(ListInterface aList)
    {
        aList.remove(1);
    }

    /**
     * addTail: adds a number to the back of the list making that number the new tail
     * @Param: the list and the int to add
     */
    public static void addTail(ListInterface aList, int a)
    {
        aList.add(aList.size()+1,a);

    }

    /**
     * removeTail: Removes the number from the back of the list, making the next number the new tail
     * @Param: the list
     */
    public static void removeTail(ListInterface aList)
    {
        aList.remove(aList.size());

    }
}
