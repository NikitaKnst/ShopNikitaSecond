/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Goods;
import entity.Owner;
import java.util.List;
import entity.Sale;
import entity.ProductShop;


public interface Keeping {
    
    public void saveGoods(List<Goods> product);
    public List<Goods> loadGoods();
    
    public void saveOwners(List<Owner> owners);
    public List<Owner> loadOwner();
    
      public void saveSale(List<Sale> sales);
    public List<Sale> loadSale();
    
      public void saveShop(List<ProductShop> shops);
    public List<ProductShop> loadShop();

    
}
