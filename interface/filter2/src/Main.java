import data.Product;
import filter.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // オリジナル商品リスト
        List<Product> products = createProducts();
        showProducts("オリジナル商品リスト", products);

        // 絞り込み後商品リスト定義
        List<Product> filteredProducts;

        // 100円ちょうどの商品に絞り込み
        filteredProducts = applyFilter(products, new ProductFilter() {
            @Override
            public boolean isMatches(Product target) {
                return (target.getPrice() == 100);
            }
        });
        showProducts("100円", filteredProducts);

        // 1000円以上、2000円以下
        ProductFilter filter1 = new ProductFilter() {
            @Override
            public boolean isMatches(Product target) {
                int price = target.getPrice();
                return (price >= 1000 && price <= 2000);
            }
        };
        filteredProducts = applyFilter(products, filter1);
        showProducts("1000円以上、2000円以下", filteredProducts);
    }

    private static List<Product> createProducts()
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("テントウムシ 1,500匹", 780, 453));
        products.add(new Product("５億ジンバブエドル", 3_000, 1));
        products.add(new Product("100円硬貨", 100, 5));
        products.add(new Product("ユニコーン缶詰肉", 1_240, 100));
        products.add(new Product("豚の胎児【研究用】", 1_950, 996));
        products.add(new Product("エマニエル・チェア", 1_880, 2_880));
        products.add(new Product("18金製 黄金風呂", 150_000_000, 80_000));

        return products;
    }

    private static void showProducts(String title, List<Product> products)
    {
        System.out.println("─────────────────────────────");
        System.out.println("# " + title);
        System.out.println("─────────────────────────────");
        for(Product product : products)
        {
            System.out.println(product);
        }
        System.out.println("─────────────────────────────");
    }

    private static List<Product> applyFilter(List<Product> products, ProductFilter filter)
    {
        List<Product> list = new ArrayList<>();
        for(Product product : products)
        {
            if(filter.isMatches(product))
            {
                list.add(product);
            }
        }

        return list;
    }
}
