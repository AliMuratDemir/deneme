package help;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class regex {

    public static String reg(String pattern1 ,String resp) {
        String sonuc="";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(resp);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            sonuc = matcher.group(1);
        }
        return sonuc;
    }

    public static ArrayList<String> regArray(String pattern1 ,String resp) {
        ArrayList<String> sonuc=new ArrayList<String>();
        int i=0;
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(resp);
        while (matcher.find()) {
           System.out.println(matcher.group(1));
            sonuc.add(matcher.group(1));
        }
        return sonuc;
    }


    public static Integer regNumber(String pattern1 ,String resp) {
        int sonuc=0;
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(resp);
        while (matcher.find()) {
            sonuc++;
        }
        return sonuc;
    }

    public  static void   jsonFormatter(String response)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response);
        String prettyJsonString = gson.toJson(je);

        System.out.println("Response"+prettyJsonString);

    }


    public  static String   urlAscii(String url)
    {String [] pattern={" ","$","'"};
        String [] replace={"%20","%24","%27"};

        for(int i=0;i<pattern.length;i++) {
            url = url.replace(pattern[i], replace[i]);
        }

        return url;

    }

}
