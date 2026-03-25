/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practiceirregularverbs;

/**
 *
 * @author educ
 */
public class IrregularVerb {
    
    private String infinitive;
    private String pastSimple;
    private String pastParticiple;
    private String definition;
    private String example;

    public IrregularVerb(String infinitive, String pastSimple, String pastParticiple, String definition, String example) {
        // TODO Auto-generated constructor stub
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.definition = definition;
        this.example = example;
    }

    public String getInfinitive() {
        return this.infinitive;
    }

    public String getPastSimple() {
        return this.pastSimple;
    }

    public String getPastParticiple() {
        return this.pastParticiple;
    } 
    
    public String getDefinition() {
        return this.definition;
    }
    
    public String getExample() {
        return this.example;
    }
}
