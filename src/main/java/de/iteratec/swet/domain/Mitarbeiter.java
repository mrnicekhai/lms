package de.iteratec.swet.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String kuerzel;

    @Column
    private String vorName;

    @Column
    private String nachName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    private List<Kompetenzeinstufung> kompetenzeinstufungList;

    private List<Laufbahnstufe> laufbahnstufeList;

    /**
     *
     * @return
     */
    public Mitarbeiter() {
    }

    public Mitarbeiter(Long id, String vorName, String nachName) {
        this.id = id;
        this.vorName = vorName;
        this.nachName = nachName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(final String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(final String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(final String nachName) {
        this.nachName = nachName;
    }

    public List<Kompetenzeinstufung> getKompetenzeinstufungList() {
        return kompetenzeinstufungList;
    }

    public void setKompetenzeinstufungList(final List<Kompetenzeinstufung> kompetenzeinstufungList) {
        this.kompetenzeinstufungList = kompetenzeinstufungList;
    }

    public List<Laufbahnstufe> getLaufbahnstufeList() {
        return laufbahnstufeList;
    }

    public void setLaufbahnstufeList(final List<Laufbahnstufe> laufbahnstufeList) {
        this.laufbahnstufeList = laufbahnstufeList;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" + "Kürzel = " + kuerzel + ", Vorname = " + vorName + ", Nachname = " + nachName +"}";
    }
}
