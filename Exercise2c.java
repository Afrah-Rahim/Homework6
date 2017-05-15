
/**
 * Write a description of class ListDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exercise2c
{
    public static void main(String[] args)
    {
        ListInterface aList = new ListReferenceBased();

        aList.add(1,20);
        aList.add(2,40);
        aList.add(3,50);
        aList.add(4,60);

        // checks the items in the list
        Methods.addHead(aList, 10);
        Methods.addTail(aList, 90);
        Methods.currentList(aList);
        System.out.println("adds a head and a tail to the list");
        Methods.removeTail(aList);
        Methods.currentList(aList);
        System.out.println("Removes the 90 from the end of the list making 60 the new tail");
        
    }

    
}
