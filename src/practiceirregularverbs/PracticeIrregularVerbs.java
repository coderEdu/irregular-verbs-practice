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
        ArrayList<IrregularVerb> verbs = new ArrayList<>();

        addVerbsPartI(verbs);
        addVerbsPartII(verbs);

        mainLogic(mainMenu(), verbs);
    }
	
    private static int mainMenu() {
        System.out.println("Welcome to *** Irregular Verbs Practice ***\n".toUpperCase());
        System.out.println("[1]  Write the past simple of the verb");
        System.out.println("[2]  Write the past participle of the verb");
        System.out.println("[3]  Write the infinitive form of the verb");
        System.out.println("[4]  Exit");
        System.out.print("\nEnter your choose => ");

        Scanner scan = new Scanner(System.in);
        int menu_opc = scan.nextInt();

        while(menu_opc < 1 || menu_opc > 4) {
            System.out.print("Wrong! Enter a valid option => ");
            menu_opc = scan.nextInt();
        }

        return menu_opc;
    }
	
    private static void mainLogic(int menu_opc, ArrayList<IrregularVerb> verbs) {
        Scanner scan = new Scanner(System.in);	
        
        if (menu_opc == 4) System.exit(0);

        System.out.print("✔️\nEnter the number of verbs you want to try (up to 82) => ");
        int laps = scan.nextInt();
        if (laps <= 0) laps = 1;
        if (laps > 82) laps = 10;

        System.out.print("Enforce you to write the right verb spelling. (Y/N) => ");
        String enforce = scan.next();
        
        System.out.print("The random number can repeat verbs. (Y/N) => ");
        String repeat = scan.next();

        System.out.println();

        verbalTenseLogic(laps, scan, enforce, repeat, verbs, menu_opc);
    }

    private static String tenseSwitcher(ArrayList<IrregularVerb> verbs, int idx, int menu_opc) {        
        String str = "";
        switch (menu_opc) {
            case 1 -> str = verbs.get(idx).getPastSimple();
            case 2 -> str = verbs.get(idx).getPastParticiple();
            case 3 -> str = verbs.get(idx).getInfinitive();
        }
        return str;
    }
	
    private static void verbalTenseLogic(int laps, Scanner scan, String enforce, String repeat, ArrayList<IrregularVerb> verbs, int menu_opc) {
        Random random = new Random();                
        int r, successes = 0;
        String tense = ""; //(menu_opc == 1) ? "simple" : "participle";
        
        switch (menu_opc) {
            case 1 -> tense = "simple";
            case 2 -> tense = "participle";
            case 3 -> tense = "infinitive";
        }

        for (int i = 0; i < laps; i++) {
            r = verbs.size() - 1;
            boolean match = false;
            int idx = random.nextInt(r), attemp = 2;
            
            if (!tense.equals("infinitive")) {
                System.out.print(((repeat.equalsIgnoreCase("y")) ? "\nCR" : "\nNR") + " (" + (i+1) + "/" + laps + ")" + " Write the past " + tense 
                    +" of the verb '" + verbs.get(idx).getInfinitive().toUpperCase() + "' ==>  ");
            } else {                
                Random rand = new Random(); 
                String vbTense;

                vbTense = rand.nextInt(1, 3) == 1 ? verbs.get(idx).getPastSimple() : verbs.get(idx).getPastParticiple();                
                
                System.out.print(((repeat.equalsIgnoreCase("y")) ? "\nCR" : "\nNR") + " (" + (i+1) + "/" + laps + ")" + " Write the " + tense 
                    +" form of the verb '" + vbTense.toUpperCase() + "' ==>  ");
            }

            String input = scan.next();	

            if (enforce.equalsIgnoreCase("y")) {		
                if (tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                    match = true;
                }                       
                                        
                while (attemp <= 3 && !match) {
                    System.out.print("  Try again (" + attemp + "/3 - [Press 'D' for verb definition]) ==>  ");
                    input = scan.next();
                    
                    if (input.equalsIgnoreCase("d")) {
                        System.out.println("    def. ⇨ " + verbs.get(idx).getDefinition());
                        System.out.println("    ex.  ⇨ " + verbs.get(idx).getExample());
                    } else {
                        attemp++;
                    }
                    
                    if (tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                        match = true;
                    }
                }
                
                if (match) {
                    System.out.println("Correct 👍");
                    ++successes;
                } else {
                    System.out.println("Wrong ❌! Right Answer: '" + tenseSwitcher(verbs, idx, menu_opc) + "'");
                }  
            } else {                                                    
                if (!tenseSwitcher(verbs, idx, menu_opc).equals(input)) {
                    System.out.println("Wrong ❌!");				
                } else {
                    System.out.println("Correct 👍");
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
        
        if (successes == laps) 
            System.out.println("Woow, you're amazing!!! 🏆");
        else if (successes + 1 == laps)
            System.out.println("¡Great, good job bro!!!");
        else
            System.out.println("Well, keep practicing!");
    }

    private static void addVerbsPartI(ArrayList<IrregularVerb> verbs) {
        verbs.add( new IrregularVerb("be", "was/were", "been", "exist", "\"there are no easy answers\""));
        verbs.add( new IrregularVerb("beat", "beat", "beaten", 
                "strike (a person or an animal) repeatedly and violently so as to hurt or injure them, typically with an implement such as a club or whip.", 
                "\"if we were caught we were beaten\""));
        verbs.add( new IrregularVerb("become", "became", "become", "begin to be.", "\"she became angry and sulked all day\""));
        verbs.add( new IrregularVerb("begin", "began", "begun", "perform or undergo the first part of (an action or activity).", 
                "\"Peter had just begun a life sentence for murder\""));
        verbs.add( new IrregularVerb("bite", "bit", "bitten", "(of a person or animal) use the teeth to cut into or through something.", 
                "\"he bit off a piece of cheese\""));
        verbs.add( new IrregularVerb("blow", "blew", "blown", "(of wind) move creating an air current.", "\"a cold breeze was blowing in off the sea\""));
        verbs.add( new IrregularVerb("break", "broke", "broken", 
                "separate or cause to separate into pieces as a result of a blow, shock, or strain.", "\"the branch broke with a loud snap\""));
        verbs.add( new IrregularVerb("bring", "brought", "brought", "take or go with (someone or something) to a place.", 
                "\"she brought Luke home from hospital\""));
        verbs.add( new IrregularVerb("build", "built", "built", "construct (something) by putting parts or material together.", 
                "\"the ironworks were built in 1736\""));
        verbs.add( new IrregularVerb("buy", "bought", "bought", "obtain in exchange for payment.", "\"she bought six first-class stamps\""));		
        verbs.add( new IrregularVerb("catch", "caught", "caught", 
                "intercept and hold (something which has been thrown, propelled, or dropped).", 
                "\"she threw the bottle into the air and caught it again\""));
        verbs.add( new IrregularVerb("choose", "chose", "chosen", 
                "pick out (someone or something) as being the best or most appropriate of two or more alternatives.", 
                "\"he chose a seat facing the door\""));
        verbs.add( new IrregularVerb("come", "came", "come", 
                "move or travel towards or into a place thought of as near or familiar to the speaker.", 
                "\"Jessica came into the kitchen\""));
        verbs.add( new IrregularVerb("cost", "cost", "cost", 
                "(of an object or action) require the payment of (a specified sum of money) before it can be acquired or done.", 
                "\"each issue of the magazine costs £1\""));
        verbs.add( new IrregularVerb("cut", "cut", "cut", 
                "make an opening, incision, or wound in (something) with a sharp-edged tool or object.", 
                "\"he cut his toe on a sharp stone\""));
        verbs.add( new IrregularVerb("do", "did", "done", "perform (an action, the precise nature of which is often unspecified).", 
                "\"very little work has been done in this field\""));
        verbs.add( new IrregularVerb("draw", "drew", "drawn", "produce (a picture or diagram) by making lines and marks on paper with a pencil, pen, etc.", 
                "\"he drew a map\""));
        verbs.add( new IrregularVerb("drink", "drank", "drunk", "take (a liquid) into the mouth and swallow.", "\"we sat by the fire, drinking our tea\""));
        verbs.add( new IrregularVerb("drive", "drove", "driven", "operate and control the direction and speed of a motor vehicle.", 
                "\"he got into his car and drove off\""));
        verbs.add( new IrregularVerb("eat", "ate", "eaten", "put (food) into the mouth and chew and swallow it.", "\"he was eating a hot dog\""));		
        verbs.add( new IrregularVerb("fall", "fell", "fallen", "move from a higher to a lower level, typically rapidly and without control.", 
                "\"five inches of snow fell through the night\""));
        verbs.add( new IrregularVerb("feel", "felt", "felt", "be aware of (a person or object) through touching or being touched.", 
                "\"she felt someone touch her shoulder\""));
        verbs.add( new IrregularVerb("fight", "fought", "fought", "take part in a violent struggle involving the exchange of physical blows or the use of weapons.", 
                "\"the men were fighting\""));
        verbs.add( new IrregularVerb("find", "found", "found", "discover or perceive by chance or unexpectedly.", "\"Lindsey looked up to find Neil watching her\""));
        verbs.add( new IrregularVerb("fly", "flew", "flown", "(of a bird, bat, or insect) move through the air using wings.", "\"close the door or the moths will fly in\""));
        verbs.add( new IrregularVerb("forget", "forgot", "forgotten", "fail to remember.", "\"he had forgotten his lines\""));
        verbs.add( new IrregularVerb("get", "got", "got", "come to have (something); receive.", "\"I got a letter from him the other day\""));
        verbs.add( new IrregularVerb("give", "gave", "given", "freely transfer the possession of (something) to (someone).", 
                "\"she gave him presents and clothes\""));
        verbs.add( new IrregularVerb("go", "went", "gone", "move from one place to another; travel.", "\"he went out to the shops\""));
        verbs.add( new IrregularVerb("grow", "grew", "grown", "(of a living thing) undergo natural development by increasing in size and changing physically.", 
                "\"he would watch Nick grow to manhood\""));		
        verbs.add( new IrregularVerb("hang", "hung", "hung", "suspend or be suspended from above with the lower part dangling free.", 
                "\"that's where people are supposed to hang their washing\""));
        verbs.add( new IrregularVerb("have", "had", "had", "possess, own, or hold.", "\"he had a new car and a boat\""));
        verbs.add( new IrregularVerb("hear", "heard", "heard", "perceive with the ear the sound made by (someone or something).", "\"behind her she could hear men's voices\""));
        verbs.add( new IrregularVerb("hide", "hid", "hidden", "put or keep out of sight.", "\"he hid the money in the house\""));
        verbs.add( new IrregularVerb("hit", "hit", "hit", "bring one's hand or a tool or weapon into contact with (someone or something) quickly and forcefully.", 
                "\"the woman hit the mugger with her umbrella\""));
        verbs.add( new IrregularVerb("hold", "held", "held", "grasp, carry, or support with one's hands.", "\"she was holding a brown leather suitcase\""));
        verbs.add( new IrregularVerb("hurt", "hurt", "hurt", "cause pain or injury to.", "\"Ow! You're hurting me!\""));
        verbs.add( new IrregularVerb("keep", "kept", "kept", "have or retain possession of.", "\"return one copy to me, keeping the other for your files\""));
        verbs.add( new IrregularVerb("know", "knew", "known", "be aware of through observation, inquiry, or information.", "\"most people know that CFCs can damage the ozone layer\""));
        verbs.add( new IrregularVerb("leave", "left", "left", "go away from.", "\"she left London on June 6\""));
        verbs.add( new IrregularVerb("lend", "lent", "lent", "grant to (someone) the use of (something) on the understanding that it will be returned.", "\"Stewart asked me to lend him my car\""));
    }
	
    private static void addVerbsPartII(ArrayList<IrregularVerb> verbs) {
        verbs.add( new IrregularVerb("let", "let", "let", "D", "E"));
        verbs.add( new IrregularVerb("lie", "lay", "lain", "D", "E"));
        verbs.add( new IrregularVerb("light", "lit", "lit", "D", "E"));
        verbs.add( new IrregularVerb("lose", "lost", "lost", "D", "E"));
        verbs.add( new IrregularVerb("make", "made", "made", "D", "E"));
        verbs.add( new IrregularVerb("mean", "meant", "meant", "D", "E"));
        verbs.add( new IrregularVerb("meet", "met", "met", "D", "E"));
        verbs.add( new IrregularVerb("pay", "paid", "paid", "D", "E"));
        verbs.add( new IrregularVerb("put", "put", "put", "D", "E"));
        verbs.add( new IrregularVerb("read", "read", "read", "D", "E"));		
        verbs.add( new IrregularVerb("ride", "rode", "ridden", "D", "E"));
        verbs.add( new IrregularVerb("ring", "rang", "rung", "D", "E"));
        verbs.add( new IrregularVerb("rise", "rose", "risen", "D", "E"));
        verbs.add( new IrregularVerb("run", "ran", "run", "D", "E"));
        verbs.add( new IrregularVerb("say", "said", "said", "D", "E"));
        verbs.add( new IrregularVerb("see", "saw", "seen", "D", "E"));
        verbs.add( new IrregularVerb("sell", "sold", "sold", "D", "E"));
        verbs.add( new IrregularVerb("send", "sent", "sent", "D", "E"));
        verbs.add( new IrregularVerb("shine", "shone", "shone", "D", "E"));
        verbs.add( new IrregularVerb("shoot", "shot", "shot", "D", "E"));		
        verbs.add( new IrregularVerb("show", "showed", "shown", "D", "E"));
        verbs.add( new IrregularVerb("shut", "shut", "shut", "D", "E"));
        verbs.add( new IrregularVerb("sing", "sang", "sung", "D", "E"));
        verbs.add( new IrregularVerb("sit", "sat", "sat", "D", "E"));
        verbs.add( new IrregularVerb("sleep", "slept", "slept", "D", "E"));
        verbs.add( new IrregularVerb("speak", "spoke", "spoken", "D", "E"));
        verbs.add( new IrregularVerb("spend", "spent", "spent", "D", "E"));
        verbs.add( new IrregularVerb("stand", "stood", "stood", "D", "E"));
        verbs.add( new IrregularVerb("steal", "stole", "stolen", "D", "E"));
        verbs.add( new IrregularVerb("swim", "swam", "swum", "D", "E"));		
        verbs.add( new IrregularVerb("take", "took", "taken", "D", "E"));
        verbs.add( new IrregularVerb("teach", "taught", "taught", "D", "E"));
        verbs.add( new IrregularVerb("tear", "tore", "torn", "D", "E"));
        verbs.add( new IrregularVerb("tell", "told", "told", "D", "E"));
        verbs.add( new IrregularVerb("think", "thought", "thought", "D", "E"));
        verbs.add( new IrregularVerb("throw", "threw", "thrown", "D", "E"));
        verbs.add( new IrregularVerb("understand", "understood", "understood", "D", "E"));
        verbs.add( new IrregularVerb("wake", "woke", "woken", "D", "E"));
        verbs.add( new IrregularVerb("wear", "wore", "worn", "D", "E"));
        verbs.add( new IrregularVerb("win", "won", "won", "D", "E"));
        verbs.add( new IrregularVerb("write", "wrote", "written", "D", "E"));
    }  
}
