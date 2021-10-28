/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
public class ProductShop implements Serializable{//Сериализовать объект означает преобразовать его состояние в поток байтов, чтобы поток байтов можно было вернуть обратно в копию объекта.
    private int money;
    
    public ProductShop(){
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Shop money: " + money/100;
    }
    
    
}