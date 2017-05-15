
/**
 * Write a description of class Exercise7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exercise7
{
    public static void main(String[] args)
    {
        ListInterface aList = new ListReferenceBased();
        ListInterface aList2 = new ListReferenceBased();

        aList.add(1,60);
        aList.add(2,50);
        aList.add(3,40);
        aList.add(4,20);

        aList2.add(1,90);
        aList2.add(2,45);
        aList2.add(3,30);
        aList2.add(4,15);

        ListInterface aList3 = new ListReferenceBased();

        aList3 = Combine(aList, aList2);

        Methods.currentList(aList3);
    }

    public static ListInterface Combine(ListInterface a, ListInterface b)
    {
        ListInterface aList3 = new ListReferenceBased();

        int i = 1;
        int j = 1;
        int pos = 1;

        while(!(j-1 == b.size()) && !(i-1 == a.size()))
        {
            Object current1 = a.get(i);
            Object current2 = b.get(j);
            if((int) current1 < (int) current2)
            {
                aList3.add(pos, current2);
                j++;
                pos++;
            }
            else 
            {
                aList3.add(pos, current1);
                i++;
                pos++;
            }
        }

        if(i-1 == a.size())
        {
            while(!(j-1 == b.size()))
            {
                aList3.add(pos, (b.get(j)));
                j++;
                pos++;
            }
        }

        if(j-1 == b.size())
        {
            while(!(i-1 == a.size()))
            {
                aList3.add(pos, (a.get(i)));
                i++;
                pos++;
            }
        }

        return aList3;
    }

}
