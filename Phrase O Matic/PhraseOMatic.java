import java.util.Random;

class PhraseOMatic
{
    public static void main(String[] args)
    {
        Random random = new Random();

        String[] wordListOne = {"24,7", "multiTier", "30,000 foot", "win-win", "frontend", "web-based", "pervasive", "smart", "critical-path", "dynamic", "Mr. ", "help", "conjoined"};
        String[] wordListTwo = {"12", "is", "strange", "had", "should", "yesterday", "shower", "IQ", "critical", "hostile", "we", "us", "remember", "trust", "learn"};
        String[] wordListThree = {"orange", "struggled", "tiring", "tire", "embark", "you", "me", "us", "utill", "forever", "create", "befriend", "host", "compell"};
        String[] wordListFour = {"purple", "scratch", "evoke", "personality", "yucky", "mean", "taleneted", "registered", "love", "help", "inspire", "denounce", "lack", "30"};
        String[] wordListFive = {"elastic", "legislate", "smoked", "punish", "injure", "remove", "stop", "egg", "milk", "remove", "one's", "own", "hate", "people"};

        String myString = "What we need is a ";
        myString += wordListOne[random.nextInt(wordListOne.length)] + " ";
        myString += wordListTwo[random.nextInt(wordListTwo.length)] + " ";
        myString += wordListThree[random.nextInt(wordListThree.length)] + " ";
        myString += wordListFour[random.nextInt(wordListFour.length)] + " ";
        myString += wordListFive[random.nextInt(wordListFive.length)] + " ";

        System.out.println(myString);        
    }
}