import java.util.Arrays;
import java.util.Scanner;

class SearchProduct implements Comparable<SearchProduct> {
    private String productId;
    private String productName;
    private String category;

    public SearchProduct(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public int compareTo(SearchProduct other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class E_commerce_Platform {
    public static int linearSearch(SearchProduct[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(SearchProduct[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
    	SearchProduct[] products = {
            new SearchProduct("101", "Laptop", "Electronics"),
            new SearchProduct("102", "Shoes", "Fashion"),
            new SearchProduct("103", "Mobile", "Electronics"),
            new SearchProduct("104", "Watch", "Accessories"),
            new SearchProduct("105", "Tshirt", "Fashion")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine();

        int indexLinear = linearSearch(products, name);
        if (indexLinear != -1) {
            System.out.println("Linear Search: Found -> " + products[indexLinear]);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        Arrays.sort(products);
        int indexBinary = binarySearch(products, name);
        if (indexBinary != -1) {
            System.out.println("Binary Search: Found -> " + products[indexBinary]);
        } else {
            System.out.println("Binary Search: Product not found");
        }

        sc.close();
    }
}

