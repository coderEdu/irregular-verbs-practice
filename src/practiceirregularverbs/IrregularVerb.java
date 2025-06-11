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

    public IrregularVerb(String infinitive, String pastSimple, String pastParticiple) {
        // TODO Auto-generated constructor stub
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
    }

    public String  getInfinitive() {
        return this.infinitive;
    }

    public String getPastSimple() {
        return this.pastSimple;
    }

    public String getPastParticiple() {
        return this.pastParticiple;
    }
}
