import java.util.LinkedList;
/**
 * Write a description of class ListDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exercise2a
{
    public static void main(String[] args)
    {
        //Test for 2a
        ListInterface aList = new ListReferenceBased();

        aList.add(1,20);
        aList.add(2,40);
        aList.add(3,50);


        Methods.addHead(aList,10);
        Methods.currentList(aList);
        System.out.println("The list adds 10 to the front");
        Methods.removeHead(aList);
        Methods.currentList(aList);
        System.out.println("The final list should have removed  the head, 10, making the new head 20");
        
    }

}
