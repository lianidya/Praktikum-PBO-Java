/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

public abstract class AbstractItem implements Serializable {
    protected String id;
    protected String judul;
    protected String penulis;
    
    public AbstractItem(String id, String judul, String penulis) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
    }
    
    // Abstract Method
    public abstract String getJenis();
    
    // Getter
    public String getId() { return id; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
}
