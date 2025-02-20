package com.enzomendez.preppit.stockItem;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemLocation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StockItemConfig {

    @Bean
    CommandLineRunner commandLineRunnerStockItem(StockItemRepository repository) {
        return args -> {
            StockItem tomato = new StockItem(
                    "tomato",
                    ItemCategory.FOOD,
                    LocalDate.of(2025, 2, 17),
                    LocalDate.of(2025, 2, 23),
                    ItemLocation.KITCHEN
            );

            StockItem banana = new StockItem(
                    "banana",
                    ItemCategory.FOOD,
                    LocalDate.of(2025, 2, 18),
                    LocalDate.of(2025, 2, 27),
                    ItemLocation.KITCHEN
            );

            repository.saveAll(
                    List.of(tomato, banana)
            );
        };
    }
}
