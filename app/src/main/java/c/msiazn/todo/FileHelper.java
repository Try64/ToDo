package c.msiazn.todo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {

    public static final String FILE_NAME = "MyFILE.dat";

    public static void writeData(ArrayList<String> stringArrayList , Context context){

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME,Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stringArrayList);
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }



    public static ArrayList<String> readData(Context context){

        ArrayList<String> itemList = null;

        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            itemList = (ArrayList<String>) objectInputStream.readObject();
        } catch (java.io.IOException e) {
            itemList = new ArrayList<String>();
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        return itemList;

    }


}
