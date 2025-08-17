package br.com.guerreirosdosertao.GuerreirosDoSertao.Embeddable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;

@Embeddable
public class Atributo {

    @Min(0)
    private int strength;

    @Min(0)
    private int intelligence;

    @Min(0)
    private int dexterity;

    @Min(0)
    private int stamina;

    @Min(0)
    private int level;

}
