package com.enzomendez.preppit.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StockItemConfiguration {

//    @Bean
//    CommandLineRunner commandLineRunnerStockItem(StockItemRepository repository) {
//        return args -> {
//            StockItem tomato = new StockItem(
//                    new Item("tomato", ItemCategory.FOOD),
//                    LocalDate.of(2025, 2, 17),
//                    LocalDate.of(2025, 2, 23),
//                    ItemLocation.KITCHEN
//            );
//
//            StockItem banana = new StockItem(
//                    new Item("banana", ItemCategory.FOOD),
//                    LocalDate.of(2025, 2, 18),
//                    LocalDate.of(2025, 2, 27),
//                    ItemLocation.KITCHEN
//            );
//
//            repository.saveAll(
//                    List.of(tomato, banana)
//            );
//        };
//    }
}
