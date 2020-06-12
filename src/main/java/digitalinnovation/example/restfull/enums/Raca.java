package digitalinnovation.example.restfull.enums;

public enum Raca {
    HUMANO("humano"),
    elfo("elfo"),
    orc("orc"),
    anao("anao");


    private String value;
    Raca(String value) {
        this.value = value;
    }
}
