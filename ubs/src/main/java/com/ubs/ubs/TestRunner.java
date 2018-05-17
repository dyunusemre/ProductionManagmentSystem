/*ackage com.ubs.ubs;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ubs.ubs.model.Inventory;
import com.ubs.ubs.model.Product;
import com.ubs.ubs.model.Warehouse;
import com.ubs.ubs.repository.ProductRepository;
import com.ubs.ubs.repository.WarehouseRepository;

@SpringBootApplication
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired 
	private WarehouseRepository warehouseRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(TestRunner.class,args);
	}
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setName("KEYBOARD");
		
		Warehouse w = warehouseRepository.findById(1);
		
		Inventory i = new Inventory();
		i.setProduct(p);
		i.setWarehouse(w);
		i.setQty(1000);
		p.getInventory().add(i);
		productRepository.save(p);
		
		
	}

}*/
