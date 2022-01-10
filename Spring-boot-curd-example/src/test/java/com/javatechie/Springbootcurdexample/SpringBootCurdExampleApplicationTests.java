package com.javatechie.Springbootcurdexample;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.javatechie.Springbootcurdexample.entity.Product;
import com.javatechie.Springbootcurdexample.repository.ProductRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringBootCurdExampleApplicationTests {
	@Autowired
	ProductRepository pr;

	@Test
	@Order(1)
	void CreateTest() {
		Product p = new Product();
		p.setId(1);
		p.setName("Laptop");
		p.setPrice(250000);
		p.setQuantity(3);
		pr.save(p);
		assertNotNull(pr.getById(1));
	}

	@Test
	@Order(2)
	public void testRead() {
		Product product = pr.findById(1).get();
		assertEquals("Laptop", product.getName());
	}

	@Test
	@Order(3)
	public void testUpdate() {
		Product p = pr.findById(1).get();
		p.setPrice(277800.00);
		pr.save(p);
		assertNotEquals(250000, pr.findById(1).get().getPrice());
	}

	@Test
	@Order(4)
	public void testDelete() {
		pr.deleteById(1);
		assertThat(pr.existsById(1)).isFalse();
	}
}
