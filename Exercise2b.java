
/**
 * Write a description of class ListDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exercise2b
{
    public static void main(String[] args)
    {
        //Test for 2b
        ListInterface aList = new ListReferenceBased();

        aList.add(1,20);
        aList.add(2,40);
        aList.add(3,50);

        Methods.addTail(aList,90);
        Methods.currentList(aList);
        System.out.println("The list adds 90 to the end");
        Methods.removeTail(aList);
        Methods.currentList(aList);

        System.out.println("The final list should have removed the 90 from the list, making 50 the" +
            "last number in the list");


    }

}
