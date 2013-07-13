import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: chenjishi
 * Date: 13-7-5
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
public class XiaMi {

    public static void main(String[] args) {
        String url = "5h3%..i%5426512_1%_3tA2fx.2%1F6778165lt%FiicF2812%76%%E.p2mlao1F541211558m%F1emm85%67F85EE4p";
        getLink(url);
    }

    //get xiami's real mp3 path
    private static String getLink(String location) {
        int loc_2 = Integer.valueOf(location.substring(0, 1));
        String loc_3 = location.substring(1);
        int loc_4 = (int) Math.floor(Double.valueOf(loc_3.length()) / loc_2);
        int loc_5 = loc_3.length() % loc_2;
        ArrayList<String> loc_6 = new ArrayList<String>();
        int loc_7 = 0;
        StringBuilder loc_8 = new StringBuilder();
        String loc_9 = "";
        int loc_10;

        while (loc_7 < loc_5) {
            int start = (loc_4 + 1) * loc_7;
            int end = start + loc_4 + 1;
            String str = loc_3.substring(start, end);
            loc_6.add(str);
            loc_7++;
        }

        loc_7 = loc_5;
        while (loc_7 < loc_2) {
            int start = loc_4 * (loc_7 - loc_5) + (loc_4 + 1) * loc_5;
            int end = start + loc_4;
            String str = loc_3.substring(start, end);
            loc_6.add(str);
            loc_7++;
        }

        loc_7 = 0;
        while (loc_7 < loc_6.get(0).length()) {
            loc_10 = 0;
            while (loc_10 < loc_6.size()) {
                String str = loc_6.get(loc_10);
                int len = str.length();
                if (loc_7 < len) {
                    loc_8.append(str.toCharArray()[loc_7]);
                }
                loc_10++;
            }
            loc_7++;
        }

        try {
            loc_9 = URLDecoder.decode(loc_8.toString(), "UTF-8");
            loc_9 = loc_9.replace('^', '0');
        } catch (UnsupportedEncodingException e) {
        }

        System.out.println(loc_9);
        //result --> http://m1.file.xiami.com/185/54185/1466621757/1771828615_10160084_l.mp3

        return loc_9;
    }
}
