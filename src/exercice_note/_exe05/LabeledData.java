package exercice_note._exe05;

import java.util.Arrays;

/**
 * Classe wrapper pour des données + étiquette
 */
public class LabeledData {

    private String label;
    private String[] fields;

    public LabeledData(String[] fields, String label) {
        this.fields = Arrays.copyOf(fields, fields.length);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String[] getFields() {
        return Arrays.copyOf(fields, fields.length);
    }
}
