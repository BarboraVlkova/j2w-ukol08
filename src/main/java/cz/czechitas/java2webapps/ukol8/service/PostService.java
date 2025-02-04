package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * vytvor PostService s anotaci @Autowired -> bude ziskavat PostRepository
 * metoda list(), vraci seznam všech postů
 * metoda singlePost(String slug) <- najde jeden post podle zadaného slug a vrátí ho
 * (vytvorila jsem pro singlePost metodu v PostRepository)
 * metoda pro zobrazeni 20 zaznamu s pouzitim metody PageRequest.of(0, 20)
 */

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list(){
        return postRepository.findByPublishedBefore(LocalDate.now(), PageRequest.of(0, 20));
    }

    public Post singlePost(String slug){
        return postRepository.findBySlug(slug);
    }

}

