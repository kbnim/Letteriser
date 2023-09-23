import java.util.ArrayList;
import java.util.HashSet;

public class Letteriser {
    HashSet<String> alphabet;
    HashSet<String> doubleLetters;

    public Letteriser() {
        alphabet = new HashSet<>();
        doubleLetters = new HashSet<>();
        String[] vowels = {"a", "á", "e", "é", "i", "í", "o", "ó", "ö", "ő", "u", "ú", "ü", "ű"};

        for (String v: vowels) alphabet.add(v);

        String[] consonants = { "b", "c", "cs", "d", "dz", "dzs", 
                                "f", "g", "gy", "h", "j", "k", "l", 
                                "ly", "m", "n", "ny", "p", "q", "r", 
                                "s", "sz", "t", "ty", "v", "w", 
                                "x", "y", "z", "zs" };

        for (String c: consonants) alphabet.add(c);

        String[] doubles = { "cc", "ccs", "dd", "ddz", "ddzs", 
                             "gg", "ggy", "ll", "lly", "nn", "nny",
                             "ss", "ssz", "tt", "tty", "zz", "zzs" };

        for (String d: doubles) {
            alphabet.add(d);
            doubleLetters.add(d);
        }
    }

    public ArrayList<String> letterise(String word) {
        ArrayList<String> letters = new ArrayList<>(word.length());
        StringBuilder builder = new StringBuilder();
        char character;
        int iterator = 0;

        while (iterator < word.length()) {
            character = Character.toLowerCase(word.charAt(iterator));
            builder.append(character);

            if (!alphabet.contains(builder.toString())) {
                builder.deleteCharAt(builder.length() - 1);
                letters.add(builder.toString());
                builder.delete(0, builder.length());
                builder.append(character);
            }

            if (iterator == word.length() - 1) {
                letters.add(builder.toString());
            }

            iterator++;
        }

        for (int i = 0; i < letters.size(); i++) {
            if (doubleLetters.contains(letters.get(i))) {
                letters.add(i+1, convertDoubleLetters(letters.get(i)));
                letters.add(i+1, convertDoubleLetters(letters.get(i)));
                letters.remove(i);
                i += 2;
            }
        }

        return letters;
    }

    private String convertDoubleLetters(String dl) {
        switch(dl) {
            case "cc": return "c";
            case "ccs": return "cs";
            case "dd": return "d";
            case "ddz": return "dz";
            case "ddzs": return "dzs";
            case "gg": return "g";
            case "ggy": return "gy";
            case "ll": return "l";
            case "lly": return "ly";
            case "nn": return "n";
            case "nny": return "ny";
            case "ss": return "s";
            case "ssz": return "sz";
            case "tt": return "t";
            case "tty": return "ty";
            case "zz": return "z";
            case "zzs": return "zs";
            default: return dl;
        }
    }    
}