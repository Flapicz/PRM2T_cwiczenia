package prm2t.lab5;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Osobnik realizujący strategię " przy pierwszym spotkaniu z danym osobnikiem podejmij losową decyzję;
 * zapamiętuj decyzje każdego osobnika podczas wszystkich spotkań; przy drugim i kolejnych spotkaniach z danym
 * osobnikiem wybierz to, co ten osobnik wybierał częściej, a jeśli wybrał
 * „zdradę” tyle samo razy co „współpracę”, to wybierz „współpracę”.
 */
public class IndividualRandomThenMost extends Individual {

    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, Integer> memory = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {
        if(!memory.containsKey(other.id)) {return ThreadLocalRandom.current().nextBoolean();}
        else {
            if (memory.get(other.id) >= 0) {return true;}
            else {return false;}
        }
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        if (otherAction) {memory.put(other.id, memory.getOrDefault(other.id,0)+1);}
        else {memory.put(other.id, memory.getOrDefault(other.id,0)-1);}
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Random once then most";
    }
}
