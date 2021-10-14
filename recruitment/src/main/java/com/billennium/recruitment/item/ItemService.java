package com.billennium.recruitment.item;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    
    public ItemDto findById(Long id) {
    	Item item1 =  itemRepository.findById(id).orElse(new Item());
    	if(item1.getName() != null)
    	{
    		ItemDto itemDto1= new ItemDto(item1.getName(), item1.getPrice());
    		return itemDto1;
    	}
    	else
    		new ItemDto();
    	
		return null;
    	
    }
    
    public List<Item> getItemsWithPrice() {
    	List<Item> list=  itemRepository.findAll();
    	Comparator<Item> comparator = Comparator.comparing(Item::getPrice);
    	List<Item> listItem = list.stream().filter(i -> i.getCount() > 0).sorted(comparator.reversed()).collect(Collectors.toList());
    	return listItem;
    }
    

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
