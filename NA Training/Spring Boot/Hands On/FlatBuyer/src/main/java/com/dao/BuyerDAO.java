package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Buyer;
import com.bean.Flat;
import com.repository.BuyerRepository;
import com.repository.FlatRepository;

@Repository
public class BuyerDAO {

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private FlatRepository flatRepository;

	public void addBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}

	public void addFlat(String buyer_id, Flat flat){
		Buyer buyer = buyerRepository.findById(buyer_id)
				.orElseThrow(() -> new RuntimeException("Buyer not found with ID: " + buyer_id));
		flat.setBuyer(buyer);
//		buyer.getFlatList().add(flat);
		flatRepository.save(flat);
	}

	public List<Flat> flatWithMinPriceMaxRooms() {
//		List<Flat> flats = flatRepository.findAll();
//
//		double minPrice = flats.stream()
//				.mapToDouble(Flat::getFlatPrice)
//				.min()
//				.orElse(Double.MAX_VALUE);
//		int maxNoOfRooms = flats.stream()
//				.mapToInt(Flat::getNumberOfRooms)
//				.max()
//				.orElse(Integer.MIN_VALUE);
//
//		return flats.stream()
//				.filter(flat -> flat.getFlatPrice() <= minPrice && flat.getNumberOfRooms() >= maxNoOfRooms)
//				.collect(Collectors.toList());

		return flatRepository.findFlatWithMinPriceAndMaxRooms();
	}
}