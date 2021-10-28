/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import entity.Manufacturer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Goods implements Serializable{//Сериализовать объект означает преобразовать его состояние в поток байтов, чтобы поток байтов можно было вернуть обратно в копию объекта.
    private String caption;//Название
  private int quantity;//Количество
    private int price;//Цена
    
    public Goods() {
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getProductprice() {
        return price;
    }
    public void setProductprice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" 
                + "caption=" + caption 
                + ",\n Price=" + price   
                + ",\n Quantity=" + quantity  
                + "\n}";
    }
    
    
}
