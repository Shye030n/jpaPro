package org.sh.jpapro.repository;

import lombok.extern.log4j.Log4j2;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.jupiter.api.Test;
import org.sh.jpapro.domain.Board;
import org.sh.jpapro.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testInsert() {
        // 내용 생성
        Item item = new Item();
        item.setItemNn("과자");
        item.setPrice(1000);
        item.setStockNumber(10);
        item.setItemDetail("세부사항");
        // itemRepository.save(item);
    }

    @Test
     public void testUpdate() {
        // 내용 수정
        Item item1=Item.builder()
                .itemNn("사탕")
                .price(2000)
                .stockNumber(20)
                .itemDetail("세부사항 2")
                .build();
        itemRepository.save(item1);
    }
    @Test
    public void findAllTest(){
        // 데이터 리스트 갖고오기
        List<Item> items=itemRepository.findAll();
        for(Item item:items){
            log.info(item.toString());
        }
    }

    @Test
    public void updateTest(){
        Item item=itemRepository.findById(1l).get();
        item.setItemNn("라면");
        item.setStockNumber(19);
        itemRepository.save(item);
        log.info(item.toString());
    }
    public void deleteTest(){
        itemRepository.deleteById(1l);
    }

}
