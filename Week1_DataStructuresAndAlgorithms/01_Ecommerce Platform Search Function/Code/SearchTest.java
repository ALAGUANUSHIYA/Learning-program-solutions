public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Book", "Education"),
            new Product(105, "Shoes", "Footwear")
        };

        System.out.println("Linear Search ");
        Product result1 = ProductSearch.linearSearch(products, "Book");
        if (result1 != null) {
            System.out.println("Product Found : \n" + result1);
        } else {
            System.out.println("Product Not Found ");
        }

       
        System.out.println("\nBinary Search ");
        ProductSearch.sortByName(products); 
        Product result2 = ProductSearch.binarySearch(products, "Book");
        if (result2 != null) {
            System.out.println("Product Found : \n" + result2);
        } else {
            System.out.println("Product Not Found ");
        }
    }
}
