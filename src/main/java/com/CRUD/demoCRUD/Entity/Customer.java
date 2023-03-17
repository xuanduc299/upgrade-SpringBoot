package com.CRUD.demoCRUD.Entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_customer")
@XmlRootElement
public class Customer extends BaseObject {
    @Column
    private String makh;
    @Column
    private String name;
    @Column
    private String quantity;
    @Column
    private String sectors;//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
