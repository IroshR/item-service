package com.iroshnk.testbackend.service;

import com.iroshnk.testbackend.api.response.CreationResponse;
import com.iroshnk.testbackend.api.response.SearchResponse;
import com.iroshnk.testbackend.model.Item;
import com.iroshnk.testbackend.repository.ItemRepository;
import com.iroshnk.testbackend.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    public CreationResponse create(Item api) {
        CreationResponse response = new CreationResponse();

        try {
            Item item = itemRepository.save(api);

            response.setStatus(Status.RESPONSE_STATUS_SUCCESS);
            response.setData(item);
            logger.info("Create item successful. id : {}", item.getItemId());
        } catch (Exception e) {
            response.setStatus(Status.RESPONSE_STATUS_FAIL);
            logger.info("Create item not successful. error : {}", e.getMessage());
        }

        return response;
    }

    public SearchResponse getAll() {
        SearchResponse response = new SearchResponse();

        try {
            List<Item> items = itemRepository.findAll();

            if (items != null && !items.isEmpty()) {
                response.setStatus(Status.RESPONSE_STATUS_SUCCESS);
                response.setData(items);
            } else {
                response.setStatus(Status.RESPONSE_STATUS_NO_DATA);
            }

            logger.info("Get item successful.");
        } catch (Exception e) {
            response.setStatus(Status.RESPONSE_STATUS_FAIL);
            logger.info("Get item not successful. error : {}", e.getMessage());
        }

        return response;
    }
}
