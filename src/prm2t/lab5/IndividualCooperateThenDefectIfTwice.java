package prm2t.lab5;

import java.util.HashMap;

/**
 * Osobnik realizujący strategię "przy pierwszym spotkaniu z danym osobnikiem wybierz „współpracę”; potem
 * wybieraj „zdradę” tylko wtedy, gdy ten osobnik wybrał „zdradę” podczas dwóch ostatnich
 * spotkań; w przeciwnym przypadku wybieraj „współpracę”."
 */
public class IndividualCooperateThenDefectIfTwice extends Individual {

    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, Integer> memory = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {
        if(memory.getOrDefault(other.id, 0) >= 2){return false;}
        else{return true;}
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        if (otherAction) {memory.put(other.id, 0);}
        else {memory.put(other.id, memory.getOrDefault(other.id,0)+1);}
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Cooperate once then defect if defected twice";
    }
}
