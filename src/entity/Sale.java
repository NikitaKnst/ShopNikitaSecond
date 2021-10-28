/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

public class Sale implements Serializable{//Сериализовать объект означает преобразовать его состояние в поток байтов, чтобы поток байтов можно было вернуть обратно в копию объекта.
    Goods godsShous;
    Owner ownerbui;//Соединям классы чтоб можно было показать покупателя прошла покупка или нет
    private boolean canceled;
    
    public Sale(){     
    }
    public Goods getGodsi() {
        return godsShous;
    }
    public void setGodsi(Goods godsShous) {
        this.godsShous = godsShous;
    }
    public Owner getOwner() {
        return ownerbui;
    }
    public void setOwner(Owner ownerbui) {
        this.ownerbui = ownerbui;
    }
    public boolean isCanceled() {
        return canceled;
    }
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
    @Override
    public String toString() {
        return "Покупка: " + 
                "Обувь: " + godsShous + 
                ", покупатель: " + ownerbui + 
                ", покупка прошла: " + canceled;
    }      
}
