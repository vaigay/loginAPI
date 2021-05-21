package com.vaigay.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.vaigay.DTO.BillDTO;
import com.vaigay.DTO.ProductHasSoldDTO;
import com.vaigay.Entity.Bill;
import com.vaigay.Entity.Cart;
import com.vaigay.Entity.Product;
import com.vaigay.Entity.ProductInCart;
import com.vaigay.converter.ProductInCartConverter;
import com.vaigay.repository.BillRepository;
import com.vaigay.repository.CartRepository;
import com.vaigay.repository.ProductInCartRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ProductInCartRepository pInCartRes;
	
	@Autowired
	private ProductInCartService productInCartService;
	
	@Autowired
	private ProductInCartRepository productInCartRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductInCartConverter pInCartConverter;
	
	
	
	public boolean isCartHasAnyProduct(Cart cart) {
		if(pInCartRes.countByCart_Id(cart.getId()) > 0)
			return true;
		return false;
	}
	
	public BillDTO createBill(Cart cart, String adrress) {
		Bill b = new Bill();
		b.setAddress(adrress);
		b.setCart(cart);
		long time = System.currentTimeMillis();
		b.setCrateDate(new Date(time));
		BillDTO billDTO = new BillDTO();
		billDTO.setAddress(adrress);
		List<ProductInCart> lCarts = cart.getProductInCarts();
		List<ProductHasSoldDTO> lDtos = new ArrayList<ProductHasSoldDTO>();
		
		double totalMoney = 0;
		for(ProductInCart p : lCarts) {
			double amountOfProduct = p.getPrice() * p.getQuantity();
			totalMoney += amountOfProduct;
			Product tmp = p.getProduct();
			saveProductInCart(tmp, p);
			ProductHasSoldDTO pDto = new ProductHasSoldDTO(p);
			lDtos.add(pDto);
		}
		
		b.setTotalProductAmount(totalMoney);
		billRepository.save(b);
		cart.setStatus(true);
		cartRepository.save(cart);
		billDTO.setTotalProductAmount(totalMoney);
		billDTO.setListProductHasSoldDTOs(lDtos);
		billDTO.setCrateDate(b.getCrateDate());
		return billDTO;
	}
	
	public void saveProductInCart(Product tmp, ProductInCart p) {
		p.setBrand(tmp.getBrand());
		p.setImageURL(tmp.getImageURL());
		p.setMadein(tmp.getMadein());
		p.setName(tmp.getName());
		p.setPrice(tmp.getPrice());
		productInCartRepository.save(p);
	}
	
	public BillDTO getOneBillOfUser(long id,long idUser) {
		Bill bill = billRepository.findByIdAndCart_User_Id(id, idUser).orElse(null);
		if(bill == null)
			return null;
		else 
			return toBillDTO(bill);
	}
	
	private BillDTO toBillDTO(Bill bill) {
		BillDTO billDTO= new BillDTO();
		billDTO.setId(bill.getId());
		billDTO.setAddress(bill.getAddress());
		billDTO.setCrateDate(bill.getCrateDate());
		billDTO.setTotalProductAmount(bill.getTotalProductAmount());
		
		List<ProductInCart> liProductInCarts = bill.getCart().getProductInCarts();
		List<ProductHasSoldDTO> lHasSoldDTOs = new ArrayList<ProductHasSoldDTO>();
		for(ProductInCart productInCart : liProductInCarts) {
			lHasSoldDTOs.add(new ProductHasSoldDTO(productInCart));
		}
		billDTO.setListProductHasSoldDTOs(lHasSoldDTOs);
		return billDTO;
	}
	

	public List<BillDTO> getAllBillOfUser(long idUser) {
		List<Bill> listBills = billRepository.findAllByCart_User_Id(idUser);
		System.out.println(listBills.size());
		List<BillDTO> listDTOs = new ArrayList<BillDTO>();
		for(Bill bill : listBills )
			listDTOs.add(toBillDTO(bill));
		return listDTOs;
	}
	
	public List<BillDTO> getAllBillByAdmin(){
		List<Bill> listBills = billRepository.findAll();
		System.out.println(listBills.size());
		List<BillDTO> listDTOs = new ArrayList<BillDTO>();
		for(Bill bill : listBills )
			listDTOs.add(toBillDTO(bill));
		return listDTOs;
	}
	
	public BillDTO getOneBillById(long id) {
		Bill bill = billRepository.findById(id).orElse(null);
		if(bill == null)
			return null;
		return toBillDTO(bill);
	}
	

	
	
}
