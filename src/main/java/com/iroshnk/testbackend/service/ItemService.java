package com.iroshnk.testbackend.service;

import com.iroshnk.testbackend.api.response.CreationResponse;
import com.iroshnk.testbackend.api.response.SearchResponse;
import com.iroshnk.testbackend.model.Item;

public interface ItemService {
    CreationResponse create(Item api);

    SearchResponse getAll();
}
