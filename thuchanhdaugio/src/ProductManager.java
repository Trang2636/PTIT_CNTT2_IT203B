import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    public List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream().anyMatch(p->p.getId()==product.getId());
        if(exists){
            throw new InvalidProductException("id đã tồn tại ");
        }
        products.add(product);
    }

    public void displayProducts(){
        System.out.println("%-3s ID %-17s Name %-10s Price %-5s Quantity %-15s Category\n");
        products.forEach((p->System.out.printf("%-5s %-15s %-10.2f %-10s %-15s\n",p.getId(),p.getName(),p.getPrice(),p.getQuantity(),p.getCategory())));
    }

    // cap nhat so luong
    public void updateQuantity(int id, int quantity) throws InvalidProductException {
        Optional<Product> product=products.stream().filter(p->p.getId()==id).findFirst();
        if(product.isPresent()){
            product.get().setQuantity(quantity);
        }else{
            throw new InvalidProductException("khong tim thay san pahm");
        }
    }

    //xoa sp het hang
    public void deleteOutOfStock(){
        products.removeIf(p->p.getQuantity()==0);
        System.out.println("da xoa het san pham");
    }
    }




