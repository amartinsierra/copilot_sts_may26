package com.capgemini.microtypi.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microtypi.api.TypiApi;
import com.capgemini.microtypi.api.domain.Comment;
import com.capgemini.microtypi.api.domain.Post;
import com.caixaba.absis.microtypi.service.TypiService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class TypiController implements TypiApi {

	private TypiService typiService;

	public TypiController(TypiService typiService) {
		this.typiService = typiService;
	}

	@Override
	public ResponseEntity<List<Comment>> getCommentsByPost(@NotNull @Valid Integer postId) {
		return ResponseEntity.ok(typiService.getCommentsByPost(postId));
	}

	@Override
	public ResponseEntity<List<Post>> getPosts() {
		return ResponseEntity.ok(typiService.getPosts());
	}

	@Override
	public ResponseEntity<Void> createPost(@Valid Post post) {
		try {
			typiService.createPost(post);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

}