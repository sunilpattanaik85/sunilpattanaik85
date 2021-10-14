package com.billennium.recruitment;


import com.billennium.recruitment.item.Item;
import com.billennium.recruitment.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ApplicationLoader implements ApplicationRunner {

    private final Logger log = LoggerFactory.getLogger(ApplicationLoader.class);
    private final ItemService itemService;

    public ApplicationLoader(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application Loader starts his job.");
        itemService.save(buildItem("PC", BigDecimal.valueOf(100), 5));
        itemService.save(buildItem("Keyboard", BigDecimal.valueOf(15), 20));
        itemService.save(buildItem("Camera", BigDecimal.valueOf(24), 0));
        itemService.save(buildItem("Mouse", BigDecimal.valueOf(3), 13));
        log.info("Application Loader finish his job.");
    }

    private Item buildItem(String name, BigDecimal price, int count) {
        return new Item(
            name,
            count,
            price
        );
    }
}
