package br.com.prova.dataprev.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long taxid;

    public Client() {
    }

    public Client(String name, long taxid) {
        this.name = name;
        this.taxid = taxid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTaxid() {
        return taxid;
    }

    public void setTaxid(long taxid) {
        this.taxid = taxid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return taxid == client.taxid &&
                Objects.equals(id, client.id) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taxid);
    }
}
