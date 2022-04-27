package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //В строке есть правильный ip-адрес. Необходимо написать приложение, которое его выведет на консоль.
        System.out.println("введите ip: ");
        Scanner in = new Scanner(System.in);
        String wuw = in.nextLine();

        Pattern p = Pattern.compile("\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b");
        //установка шаблона

        Matcher m = p.matcher(wuw);
        //проводит поиск в строке

        //матчер проводит тока поиск, а гроуп уже получает строку
        String rur = null;

        if (m.find()) { //если есть подстрока, совпадающая с шаблоном
            System.out.println("ip найден: " + m.group());//получ нач последоват,сопоставленной с предыдущим результатом сопоставления.
            rur = m.group();
        }
        else {
            rur = "нет ip";
            System.out.println("ip не найден");
        }


        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Ip.txt")))
        {
            String text = rur;

            bw.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    }
