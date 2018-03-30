package design_pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 并不觉得这样写是"优雅的"
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class OrderBuilder {

    public static Order prepareVegetableOrder() {
        Order order = new Order();
        order.addItem(new VegetableBurgerItem());
        order.addItem(new CokeDrinkItem());
        return order;
    }

    public static Order prepareMeatOrder() {
        Order order = new Order();
        order.addItem(new ChickenBurgerItem());
        order.addItem(new PepsiDrinkItem());
        return order;
    }


    static class Order {
        private List<IItem> mItems;

        public Order() {
            this.mItems = new ArrayList<>();
        }

        public void addItem(IItem item) {
            mItems.add(item);
        }

        public void printCost() {
            float sum = 0f;
            for (int i = 0, n = mItems.size(); i < n; i++) {
                sum += mItems.get(i).getPrice();
            }
            System.out.println(String.format("Cost:%f", sum));
        }

        public void printOrder() {
            for (int i = 0, n = mItems.size(); i < n; i++) {
                IItem item = mItems.get(i);
                System.out.println(String.format("Item:%s, Packing:%s, Price:%f", item.getName(), item.getPacking().getName(), item.getPrice()));
            }
        }

    }
}
