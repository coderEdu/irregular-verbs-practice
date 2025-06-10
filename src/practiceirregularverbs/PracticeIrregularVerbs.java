/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practiceirregularverbs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author educ
 */
public class PracticeIrregularVerbs {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub	
        //IrregularVerb[] verbs = new IrregularVerb[82];
        ArrayList<IrregularVerb> verbs = new ArrayList<>();

        addVerbsPartI(verbs);
        addVerbsPartII(verbs);

        mainLogic(mainMenu(), verbs);
    }
    
    private static int mainMenu() {
        System.out.println("Welcome to *** Irregular Verbs Practice ***\n".toUpperCase());
        System.out.println("[1]  Write the past simple of the verb");
        System.out.println("[2]  Write the past participle of the verb");
        System.out.println("[3]  Exit");
        System.out.print("\nEnter your choose => ");

        Scanner scan = new Scanner(System.in);
        int menu_opc = scan.nextInt();

        while(menu_opc < 1 || menu_opc > 3) {
            System.out.print("Wrong! Enter a valid option => ");
            menu_opc = scan.nextInt();
        }

        return menu_opc;
    }
    
    private static void mainLogic(int menu_opc, ArrayList<IrregularVerb> verbs) {
        Scanner scan = new Scanner(System.in);	
        
        if (menu_opc == 3) System.exit(0);

        System.out.print("√\nEnter the number of verbs you want to try (up to 82) => ");
        int laps = scan.nextInt();
        if (laps <= 0) laps = 1;

        System.out.print("Enforce you to write the right verb spelling. (Y/N) => ");
        String enforce = scan.next();
        
        System.out.print("The random number can repeat verbs. (Y/N) => ");
        String repeat = scan.next();

        System.out.println();

        tenseLogic(laps, scan, enforce, repeat, verbs, menu_opc);
    }
    
    private static String tenseSwitcher(ArrayList<IrregularVerb> verbs, int idx, int menu_opc) {
        return (menu_opc == 1) ? verbs.get(idx).getPastSimple() : verbs.get(idx).getPastParticiple();
    }
    
    private static void tenseLogic(int laps, Scanner scan, String enforce, String repeat, ArrayList<IrregularVerb> verbs, int menu_opc) {
        Random random = new Random();                
        int r, successes = 0;
        String tense1 = (menu_opc == 1) ? "simple" : "participle";

        for (int i = 0; i < laps; i++) {
            r = verbs.size() - 1;
            boolean match = false;
            int idx = random.nextInt(r), attemp = 2;
            
            System.out.print(((repeat.equalsIgnoreCase("y")) ? "CR" : "NR") + " (" + (i+1) + "/" + laps + ")" + " Write the past " + tense1 
                    +" of the verb '" + verbs.get(idx).getInfinitive() + "' ==>  ");
            String input = scan.next();	

            if (enforce.equalsIgnoreCase("y")) {		// ************************** (begin) last working sector
                if (tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                    match = true;
                }                       
                                        
                while (attemp <= 3 && !match) {
                    System.out.print("Try again (" + attemp + "/3) ==>  ");
                    input = scan.next();
                    attemp++;
                    
                    if (tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                        match = true;
                    }
                }
                
                if (match) {
                    System.out.println("Correct!");
                    ++successes;
                } else {
                    System.out.println("Wrong! Right answer: '" + tenseSwitcher(verbs, idx, menu_opc) + "'");
                }  
            } else {                                                    // ************************** (finish) last working sector
                if (!tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                    System.out.println("Wrong!");				
                } else {
                    System.out.println("Correct!");
                    ++successes;
                }
            }	
            if (repeat.equalsIgnoreCase("n")) verbs.remove(idx);
        }		
        showResults(laps, successes);
    }
    
    private static void showResults(int laps, int successes) {
        System.out.println("\nAttempts:  " + laps);
        System.out.println("Successes:  " + successes);
        System.out.println((successes == laps) ? "¡Great, good job!" : "Well, keep practicing!");
    }
    
        private static void addVerbsPartI(ArrayList<IrregularVerb> verbs) {
        verbs.add( new IrregularVerb("be", "was/were", "been"));
        verbs.add( new IrregularVerb("beat", "beat", "beaten"));
        verbs.add( new IrregularVerb("become", "became", "become"));
        verbs.add( new IrregularVerb("begin", "began", "begun"));
        verbs.add( new IrregularVerb("bite", "bit", "bitten"));
        verbs.add( new IrregularVerb("blow", "blew", "blown"));
        verbs.add( new IrregularVerb("break", "broke", "broken"));
        verbs.add( new IrregularVerb("bring", "brought", "brought"));
        verbs.add( new IrregularVerb("build", "built", "built"));
        verbs.add( new IrregularVerb("buy", "bought", "bought"));		
        verbs.add( new IrregularVerb("catch", "caught", "caught"));
        verbs.add( new IrregularVerb("choose", "chose", "chosen"));
        verbs.add( new IrregularVerb("come", "came", "come"));
        verbs.add( new IrregularVerb("cost", "cost", "cost"));
        verbs.add( new IrregularVerb("cut", "cut", "cut"));
        verbs.add( new IrregularVerb("do", "did", "done"));
        verbs.add( new IrregularVerb("draw", "drew", "drawn"));
        verbs.add( new IrregularVerb("drink", "drank", "drunk"));
        verbs.add( new IrregularVerb("drive", "drove", "driven"));
        verbs.add( new IrregularVerb("eat", "ate", "eaten"));		
        verbs.add( new IrregularVerb("fall", "fell", "fallen"));
        verbs.add( new IrregularVerb("feel", "felt", "felt"));
        verbs.add( new IrregularVerb("fight", "fought", "fought"));
        verbs.add( new IrregularVerb("find", "found", "found"));
        verbs.add( new IrregularVerb("fly", "flew", "flown"));
        verbs.add( new IrregularVerb("forget", "forgot", "forgotten"));
        verbs.add( new IrregularVerb("get", "got", "got"));
        verbs.add( new IrregularVerb("give", "gave", "given"));
        verbs.add( new IrregularVerb("go", "went", "gone"));
        verbs.add( new IrregularVerb("grow", "grew", "grown"));		
        verbs.add( new IrregularVerb("hang", "hung", "hung"));
        verbs.add( new IrregularVerb("have", "had", "had"));
        verbs.add( new IrregularVerb("hear", "heard", "heard"));
        verbs.add( new IrregularVerb("hide", "hid", "hidden"));
        verbs.add( new IrregularVerb("hit", "hit", "hit"));
        verbs.add( new IrregularVerb("hold", "held", "held"));
        verbs.add( new IrregularVerb("hurt", "hurt", "hurt"));
        verbs.add( new IrregularVerb("keep", "kept", "kept"));
        verbs.add( new IrregularVerb("know", "knew", "known"));
        verbs.add( new IrregularVerb("leave", "left", "left"));
        verbs.add( new IrregularVerb("lend", "lent", "lent"));
    }
        
    private static void addVerbsPartII(ArrayList<IrregularVerb> verbs) {
        verbs.add( new IrregularVerb("let", "let", "let"));
        verbs.add( new IrregularVerb("lie", "lay", "lain"));
        verbs.add( new IrregularVerb("light", "lit", "lit"));
        verbs.add( new IrregularVerb("lose", "lost", "lost"));
        verbs.add( new IrregularVerb("make", "made", "made"));
        verbs.add( new IrregularVerb("mean", "meant", "meant"));
        verbs.add( new IrregularVerb("meet", "met", "met"));
        verbs.add( new IrregularVerb("pay", "paid", "paid"));
        verbs.add( new IrregularVerb("put", "put", "put"));
        verbs.add( new IrregularVerb("read", "read", "read"));		
        verbs.add( new IrregularVerb("ride", "rode", "ridden"));
        verbs.add( new IrregularVerb("ring", "rang", "rung"));
        verbs.add( new IrregularVerb("rise", "rose", "risen"));
        verbs.add( new IrregularVerb("run", "ran", "run"));
        verbs.add( new IrregularVerb("say", "said", "said"));
        verbs.add( new IrregularVerb("see", "saw", "seen"));
        verbs.add( new IrregularVerb("sell", "sold", "sold"));
        verbs.add( new IrregularVerb("send", "sent", "sent"));
        verbs.add( new IrregularVerb("shine", "shone", "shone"));
        verbs.add( new IrregularVerb("shoot", "shot", "shot"));		
        verbs.add( new IrregularVerb("show", "showed", "shown"));
        verbs.add( new IrregularVerb("shut", "shut", "shut"));
        verbs.add( new IrregularVerb("sing", "sang", "sung"));
        verbs.add( new IrregularVerb("sit", "sat", "sat"));
        verbs.add( new IrregularVerb("sleep", "slept", "slept"));
        verbs.add( new IrregularVerb("speak", "spoke", "spoken"));
        verbs.add( new IrregularVerb("spend", "spent", "spent"));
        verbs.add( new IrregularVerb("stand", "stood", "stood"));
        verbs.add( new IrregularVerb("steal", "stole", "stolen"));
        verbs.add( new IrregularVerb("swim", "swam", "swum"));		
        verbs.add( new IrregularVerb("take", "took", "taken"));
        verbs.add( new IrregularVerb("teach", "taught", "taught"));
        verbs.add( new IrregularVerb("tear", "tore", "torn"));
        verbs.add( new IrregularVerb("tell", "told", "told"));
        verbs.add( new IrregularVerb("think", "thought", "thought"));
        verbs.add( new IrregularVerb("throw", "threw", "thrown"));
        verbs.add( new IrregularVerb("understand", "understood", "understood"));
        verbs.add( new IrregularVerb("wake", "woke", "woken"));
        verbs.add( new IrregularVerb("wear", "wore", "worn"));
        verbs.add( new IrregularVerb("win", "won", "won"));
        verbs.add( new IrregularVerb("write", "wrote", "written"));
    }    
}
