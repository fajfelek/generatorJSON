import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Generator {
    static ArrayList<String> klasy = new ArrayList();
    static HashMap<String, HashMap<String, ArrayList<String>>> classes = new HashMap<>();
    ////static HashMap<String, String> variables = new HashMap<>();

    static private Random randomGenerator = new Random();

    private static ArrayList<String> nameGenerator(String name, int number) {
        ArrayList<String> names = new ArrayList();

        for (int i = 0; i < number; i++){
            names.add(name + String.valueOf(i+1));
        }

        return names;
    }

    private static void nameVariableGenerator(String variableName, Types var){
        int index;
        for (int i = 0; i<klasy.size();i++){
            HashMap<String, ArrayList<String>> variables = new HashMap<>();
            variables.clear();
            var.types.remove(klasy.get(i));
            index = randomGenerator.nextInt(10)+1;
            ArrayList<String> zmienne = nameGenerator(variableName, index); //random
            for (int j = 0; j < zmienne.size() ; j++){
                ArrayList<String> list = new ArrayList();
                list.clear();
                index = randomGenerator.nextInt(var.types.size());
                list.add(var.types.get(index));
                index = randomGenerator.nextInt(10);
                if (index <= 1) {
                    list.add("ptr");
                }
                if (index > 2 && index < 5){
                    list.add("tab");
                    index = randomGenerator.nextInt(28)+2;
                    list.add(String.valueOf(index));
                }
                variables.put(zmienne.get(j), list);
            }
            classes.put(klasy.get(i), variables);
            //System.out.println(classes.get("klasa2"));  <--- tu funkcje
            var.types.add(klasy.get(i));
        }
    }



    public static void main(String[] args) throws FileNotFoundException {

        klasy = nameGenerator("struct", 5);

        Types varSettings = new Types(klasy);

        System.out.println(varSettings.types.size());

        nameVariableGenerator("var", varSettings);


//        for (String aKlasy : klasy) {
//            System.out.println(aKlasy);
//        }

        PrintWriter zapis = new PrintWriter("JSON.txt");
        zapis.print("{\n\"JSON\": [\n{");
        for (Map.Entry<String,HashMap<String,ArrayList<String>>> name: classes.entrySet()){
            zapis.print("\n\"" + name.getKey() + "\":\n{\n");
            int d = 1;
            for(Map.Entry<String,ArrayList<String>> name2: name.getValue().entrySet()){
                if (d != name.getValue().size()) {
                    zapis.print("\"" + name2.getKey() + "\": " + name2.getValue() + ",\n");
                } else {
                    zapis.print("\"" + name2.getKey() + "\": " + name2.getValue() + "\n");
                }
                d++;
            }
            zapis.print("},");;
        }
        zapis.print("\n}");
        zapis.close();
//        for (int i = 0 ; i < classes.size(); i++){
//            HashMap<String, String> klasa = classes.get("klasa1");
//            System.out.println("Klucz:" + classes.keySet());
//            for(Map.Entry<String, String> entry : klasa.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                System.out.println(key + " + " + value);
//            }
//        }
//        System.out.println(classes.get("klasa1"));
    }



}
