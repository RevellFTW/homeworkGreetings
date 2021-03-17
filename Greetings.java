import java.io.StringWriter;
import java.util.Arrays;

public class Greetings {

    public static String greet(String[] args){
        boolean coma = false;                              // quick coma check
        for(int j = 0; j < args.length -1; j++){           //, except last element.
            if (args[j].contains(",")) {                   //
                coma = true;
                break;
            }
        }
        StringBuilder multipleNames = new StringBuilder(args.length);
        if(coma){
             multipleNames = new StringBuilder(args.length * 3);   // if it has comas in it, let the StringBuilder be bigger.
        }
        String[] splitter;          //default splitter for arg elements with comas.
        String[] splitter2 = null;  //for the last element if it has comas in it.
        if(args.length == 0){
                return "Hello my friend.";
            } else {
            if (args.length > 1) {                                                  //more than 1 arg
                for (int i = 0; i < args.length; i++){
                    if(i == args.length - 1 && args[i].contains(",") ){            //handling the last element if it has coma(s).
                        splitter2 = args[i].split(",");                      //
                        for (int k = 0; k < splitter2.length - 1; k++) {          //
                            multipleNames.append(splitter2[k]).append(", ");      //
                        }                                                         //
                    } else if (coma && args[i].contains(",") && i < args.length-1) { //checking comas from first, to before last element.
                        splitter = args[i].split(",");
                        for (int k = 0; k < splitter.length; k++)
                            multipleNames.append(splitter[k]).append(", ");
                    }
                    else if(i < args.length-1) {
                        multipleNames.append(args[i]).append(", ");
                    }
                }
                if(splitter2 == null){                                            //determining if the last element has comas in it, and return value in connection to that.
                return "Hello, " + multipleNames + "and " + args[args.length - 1] + ".";
                } else {
                    return "Hello, " + multipleNames + "and " + splitter2[splitter2.length - 1] + ".";
                }
            } else {                                                                // only one arg
                if(args[0].contains(",")){
                    splitter = args[0].split(",");
                    for (int k = 0; k < splitter.length - 1; k++) {
                        multipleNames.append(splitter[k]).append(", ");
                    }
                    return "Hello, " + multipleNames + "and " + splitter[splitter.length - 1] + ".";
                } else {
                    return "Hello, " + args[0] + ".";
                }
            }

        }

    }

    public static void main(String[] args){     //only for testing
        System.out.println(greet(args));
    }
}

//todo: ordítás
