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
    private String past_simple;
    private String past_participle;

    public IrregularVerb(String infinitive, String past_simple, String past_participle) {
        // TODO Auto-generated constructor stub
        this.infinitive = infinitive;
        this.past_simple = past_simple;
        this.past_participle = past_participle;
    }

    public String  getInfinitive() {
        return this.infinitive;
    }

    public String getPastSimple() {
        return this.past_simple;
    }

    public String getPastParticiple() {
        return this.past_participle;
    }
}
