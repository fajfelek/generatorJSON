import java.util.ArrayList;

public class Types {


    ArrayList<String> types = new ArrayList<>();
    ArrayList<String> funcTypes = new ArrayList<>();
    ArrayList<String> priviliges = new ArrayList<>();

//    public Types() {
//        types.add("bool");
//        types.add("char");
//        types.add("short");
//        types.add("int");
//        types.add("long");
//        types.add("long long");
//        types.add("float");
//        types.add("double");
//        types.add("long double");
//        //types.add("void");
//
//        types.add("std::vector");
//        types.add("std::string");
//        types.add("std::fstream");
//
//        priviliges.add("public");
//        priviliges.add("private");
//        priviliges.add("protected");
//        priviliges.add("");
//    }

    public Types(ArrayList<String> classNames){
        types.add("bool");
        types.add("char");
        types.add("short");
        types.add("int");
        types.add("long");
        types.add("long long");
        types.add("float");
        types.add("double");
        types.add("long double");
        //types.add("void");

        types.add("std::vector");
        types.add("std::string");
        types.add("std::fstream");

        funcTypes.add("bool");
        funcTypes.add("char");
        funcTypes.add("short");
        funcTypes.add("int");
        funcTypes.add("long");
        funcTypes.add("long long");
        funcTypes.add("float");
        funcTypes.add("double");
        funcTypes.add("long double");
        funcTypes.add("void");
        funcTypes.add("std::vector");
        funcTypes.add("std::string");

        priviliges.add("public");
        priviliges.add("private");
        priviliges.add("protected");
        priviliges.add("");
        types.addAll(classNames);
    }

}
