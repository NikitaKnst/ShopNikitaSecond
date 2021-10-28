package keeper;
/////////////////////////////
import entity.Goods;         ///
import entity.Owner;         ///
import interfaces.Keeping;   ///
import entity.Sale;          ///
import entity.ProductShop;
/////////////////////////////
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileKeeper implements Keeping{

    @Override
    public void saveGoods(List<Goods> product) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("product");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла product", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }
    @Override
    public List<Goods> loadGoods() {
        List<Goods> listProduct = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Product");
            ois = new ObjectInputStream(fis);
            listProduct = (List<Goods>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла Product", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return listProduct;
    }
    @Override
    public void saveOwners(List<Owner> owner) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("owners");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(owner);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла owners", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }
    @Override
    public List<Owner> loadOwner() {
        List<Owner> listOwner = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("owners");
            ois = new ObjectInputStream(fis);
            listOwner = (List<Owner>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла Owners", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return listOwner;
    }
     @Override
    public void saveSale(List<Sale> sales) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("sales");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sales);
            oos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла sales", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }
    @Override
    public List<Sale> loadSale() {
        List<Sale> listSale = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("sales");
            ois = new ObjectInputStream(fis);
            listSale = (List<Sale>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла sales", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return listSale;
    }
   @Override
    public void saveShop(List<ProductShop> shop) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("productShop");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(shop);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла productShop", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<ProductShop> loadShop() {
        List <ProductShop> listShops = new ArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("productShop");
            ois = new ObjectInputStream(fis);
            listShops = (List<ProductShop>) ois.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет файла productShop", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileKeeper.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        
       return listShops;
    }

    

}