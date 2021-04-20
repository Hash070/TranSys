package EXPECTIONS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo_a {
    public static void main(String[] args) {
        FileReader reader=null;
        try{
            reader=new FileReader("a.txt");
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally{
            if(reader==null)
                try {
                    reader.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
}
