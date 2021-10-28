package myclasses;
////Импорт классов/////////////////////////////
import entity.Owner;          /////////////////
import entity.Goods;         //  ЭТО НУЖНО!////
import entity.ProductShop;  //////////////////
import entity.Sale;        // ОБЯЗАТЕЛЬНО////
////////////////////////////////////////////
import java.util.ArrayList;//Нужно
import java.util.Calendar;//Не нужно
import java.util.GregorianCalendar;//Не нужно
import java.util.List;//Нужно для переменных
import java.util.Scanner;//Нужно для ввода
import keeper.FileKeeper;//Для сохранение файлов

public class App {//Называем переменные в клавном классе (List делаем чтоб вывести все значения)
    Scanner scanner = new Scanner(System.in);
    List<Goods> product = new ArrayList<>();
    List<Owner> owners = new ArrayList<>();
    List <Sale> sales = new ArrayList<>();
    List <ProductShop> productShop = new ArrayList<>();
    FileKeeper fileKeeper = new FileKeeper();
    public App() {//ТУТ ЗАГРУЖАЕМ ФАЙЛЫ !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        product = fileKeeper.loadGoods();
        owners = fileKeeper.loadOwner();
        sales=fileKeeper.loadSale();
        productShop=fileKeeper.loadShop();
        
    }    
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Закончить программу");
            System.out.println("1: Добавить товар");
            System.out.println("2: Список товаров");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список покупателей");
            System.out.println("5: Продажа товара");
            System.out.println("6: Список проданных товаров");
            System.out.println("7: Доход магазина(Get Money)");
            System.out.println("8: Добавить деньги Owner(Покупатель)");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0: 
                    repeat="q";
                    System.out.println("Программа закончена");
                    break;
                case 1: 
                    System.out.println("Добавление товаров: ");
                    product.add(addProduct());
                    fileKeeper.saveGoods(product);
                    break;
                case 2: 
                    System.out.println("Список товаров: ");
                    for (int i = 0; i < product.size(); i++) {
                        if(product.get(i) != null){
                            System.out.println(product.get(i).toString());
                        }
                    }
                    break;
                case 3: 
                    System.out.println("Добавление покупателя: ");
                    owners.add(addOwner());
                    fileKeeper.saveOwners(owners);
                    break;
                case 4: 
                    System.out.println("Список покупателей: ");
                    for (int i = 0; i < owners.size(); i++) {
                        if(owners.get(i) != null){
                            System.out.println(owners.get(i).toString());
                        }
                    }
                    break;
                case 5: 
                    System.out.println("Продажа модели");
                    sales.add(addsales());
                    fileKeeper.saveSale(sales);
                    fileKeeper.saveShop(productShop);
                    fileKeeper.saveOwners(owners);//Сохраняем и достаём модели
                    fileKeeper.saveGoods(product);
                    break;
                case 6: 
                     System.out.println("История продажи товаров");
                    int n = 0;
                    for (int i = 0; i < sales.size(); i++) {
                        if (sales.get(i)!=null){
                            System.out.printf("%d. Модель %s купил %s, покупка %s%n",
                                        (i+1),
                                        sales.get(i).getGodsi().getCaption(), 
                                        sales.get(i).getOwner().getFirstname(),///Вызываем кто что купил и тд (false-true)
                                        sales.get(i).isCanceled());
                            n++;
                        }
                    }
                    if (n<1){
                        System.out.println("Нет проданных товаров");
                    }
                    break;                                    
                case 7:           
                       System.out.print("Доход магазина:");
                    productShop.add(getAllShopMoney());
                    System.out.println(productShop.get(0).getMoney()/100);//Делим деньги потому что у нас всё изначально в центах
                    break;
                case 8:
                    System.out.println("Добавление денег покупателю");//Добавляем деньги
                    printOwners();//Принтуем всех покупателей (Отдельная функция) 
                    System.out.print("Выберите покупателя впишите номер: ");
                    int ownersNum = scanner.nextInt();scanner.nextLine();
                    if(owners.contains(ownersNum-1)==true){ //Если нет покупателя выдаём ошибку
                        System.out.println("Нет такого покупателя");
                    }else{
                        System.out.print("Напишите cколько добавить денег: ");
                        int moneyAdd = scanner.nextInt(); scanner.nextLine();//Вписываем сколько денег добавляем
                        owners.get(ownersNum-1).setMoney(owners.get(ownersNum-1).getMoney()+ moneyAdd);//Определяем кому прибавить деньги и в класс добавляем деньги 
                        fileKeeper.saveOwners(owners);//Сохраняем кол-во деняг
            }
                    break;
            }
        }while("y".equals(repeat));
    }    
     private Owner addOwner(){//Просто добавляем покупателя
        Owner owner = new Owner();
        System.out.print("Введите имя покупателя: ");
        owner.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        owner.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона покупателя: ");
        owner.setPhone(scanner.nextInt());
         System.out.print("Введите кол-во денег у покупателя: ");
        owner.setMoney(scanner.nextInt());
        return owner;
    }
     private Goods addProduct(){//Просто добавляем продукт например гучи тапки
        Goods product = new Goods();
        System.out.print("Введите название товара: ");
        product.setCaption(scanner.nextLine());
        System.out.print("Введите цену товара: ");
        product.setProductprice(scanner.nextInt());
        System.out.print("Введите кол-во товара: ");
        product.setQuantity(scanner.nextInt());
        scanner.nextLine();        
        return product;
    }     
      private Sale addsales(){//Продаём товар 
        Sale saleProduct = new Sale();//вызываем класс и создаём переменную
        ProductShop shop = new ProductShop();//вызываем класс и создаём переменную
        shop.setMoney(0);
        printOwners();//Выводим покупателей
        System.out.print("Номер покупателя: ");
        int ownerNumber = scanner.nextInt();scanner.nextLine();       
        printPrdouct();//Выводим продукты
        System.out.print("Номер модели: ");
        int productNumber = scanner.nextInt(); scanner.nextLine();       
        if(owners.get(ownerNumber-1).getMoney()>product.get(productNumber-1).getProductprice() && product.get(productNumber-1).getQuantity()>0){//Уменьшаем кол-во продукта при покупке его(так же работает тут с покупателя и с продуктом)
                saleProduct.setOwner(owners.get(ownerNumber-1));//Если всё ок тратим деньги
                saleProduct.setGodsi(product.get(productNumber-1));//Если всё ок тратим кол-во
                saleProduct.setCanceled(true);//Если денег хватало пишим True
                owners.get(ownerNumber-1).setMoney(owners.get(ownerNumber-1).getMoney()-product.get(productNumber-1).getProductprice());//Убираем деньги у покупателя Силой конечно же. Так же работает с продуктом и с покупателем
                product.get(productNumber-1).setQuantity(product.get(productNumber-1).getQuantity()-1);
                productShop.get(0).setMoney(productShop.get(0).getMoney()+product.get(productNumber-1).getProductprice());
        }else{
            saleProduct.setOwner(owners.get(ownerNumber-1));
            saleProduct.setGodsi(product.get(productNumber-1));
            saleProduct.setCanceled(false);
        }
        return saleProduct;
    }  
    private ProductShop getAllShopMoney(){//Записываем и запоминаем кол-во денег
        ProductShop shopmoney = new ProductShop();
        shopmoney.setMoney(0);
        return shopmoney;
    }   
    private void printOwners(){//Выводим покупателей чтоб не писать каждый раз эту всю функцию 
        System.out.println("Список покупателей");
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), owners.get(i).toString()); 
            }
        }
    }  
    private void printPrdouct(){//Выводим продукты чтоб не писать каждый раз эту всю функцию 
        System.out.println("Список моделей обуви:");
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i)!=null){
                System.out.println((i+1)+ " " + product.get(i).toString()); 
            }
        }
    }
}
