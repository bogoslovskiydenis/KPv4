import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) throws Exception
    {
        try(FileWriter writer = new FileWriter("Контрольная.txt" ,false)) // создаем текстовый текстовый файл Контрольная
        {
            String s1 = "Тестирование контрольной работы";
            writer.write(s1); //записывает в текст
            StringBuffer s2 = new StringBuffer();
            char c;
            for (int i=0, pos = 0; i<s1.length(); i++,pos++)
            {
                c = s1.charAt(i);
                if (c != ' ') s2.insert(pos,c);
                else {
                    s2.insert(0,c);
                    pos = -1;
                }
            }
            s1=s2.toString();
            System.out.println(s1);
            writer.write(s1);
            writer.flush();
        }
        catch (IOException ex) {
            //e.printStackTrace();
            System.out.println(ex.getMessage());
        }

        ArrayList<File> fileList = new ArrayList<>(); //список файлов куда будем записовать найденно
        searchF(new File("C:\\Users\\bogos\\Desktop\\KP4v"), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }
    private static void searchF(File rootFile, List<File> fileList) //функция корневая папка ,и список
    {
        if (rootFile.isDirectory()) // проверка в корне ли папка
        {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchF(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".txt")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}