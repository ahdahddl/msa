package per.msa.mining.arm;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
/**
 * This class holds an association rule and its confidence.
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Apr 10, 2016)
 * @param <I> the actual item type.
 */
public class AssociationRule<I> {

    private final Set<I> antecedent = new HashSet<>();
    private final Set<I> consequent = new HashSet<>();
    private double confidence;

    public AssociationRule(Set<I> antecedent,
                           Set<I> consequent,
                           double confidence) {
        Objects.requireNonNull(antecedent, "The rule antecedent is null.");
        Objects.requireNonNull(consequent, "The rule consequent is null.");
        this.antecedent.addAll(antecedent);
        this.consequent.addAll(consequent);
        this.confidence = confidence;
    }

    public AssociationRule(Set<I> antecedent, Set<I> consequent) {
        this(antecedent, consequent, Double.NaN);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.toString(antecedent.toArray()));
        sb.append(" -> ");
        sb.append(Arrays.toString(consequent.toArray()));
        sb.append(": ");
        sb.append(confidence);

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return antecedent.hashCode() ^ consequent.hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof AssociationRule)) {
            return false;
        }
        AssociationRule<I> otherAssociationRule = (AssociationRule<I>) otherObject;
        if (otherAssociationRule.getAntecedent().size() != antecedent.size() ||
                otherAssociationRule.getConsequent().size() != consequent.size()) {
            return false;
        }
        for (I i : antecedent) {
            if (!otherAssociationRule.getAntecedent().contains(i)) {
                return false;
            }
        }
        for (I i : consequent) {
            if (!otherAssociationRule.getConsequent().contains(i)) {
                return false;
            }
        }
        return true;
    }
}
