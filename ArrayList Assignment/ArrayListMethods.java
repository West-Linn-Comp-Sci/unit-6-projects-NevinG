import java.util.ArrayList;

class ArrayListMethods
{
    static public void removeZeros(ArrayList<Integer> list) 
    {
        while(list.remove(Integer.valueOf(0))){};
    }

    static public int countLetters(ArrayList<String> list) 
    {
        int letters =0;
        for(String s : list)
        {
            letters += s.length();
        }

        return letters;
    }

    static public int findPosition(int keyValue, ArrayList<Integer> list)
    {
        return list.indexOf(Integer.valueOf(keyValue));
    }

    static public ArrayList<String> parseIntoArrayList(String input)
    {
        ArrayList<String> parsed = new ArrayList<String>(input.length());
        for(int i = 0; i < input.length(); i++)
        {
            parsed.add(input.substring(i, i+1));
        }
        return parsed;
    }

    static public String findMin(ArrayList<Person> list)
    {
        Person youngestP = list.get(0);
        for(Person p : list)
        {
            if(p.getAge() < youngestP.getAge())
            {
                youngestP = p;
            }
        }
        return youngestP.getName();
    }

}